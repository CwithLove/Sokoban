import java.util.NoSuchElementException;

public class IterateurSequenceListe implements Iterateur {
    SequenceListe liste;
    ListeChainee prPrecedant, precedant, courant;
    boolean supprime;

    public IterateurSequenceListe(SequenceListe s) {
        this.liste = s;
        this.precedant = null;
        this.prPrecedant = null;
        this.courant = s.tete;
        this.supprime = false;
    }

    @Override
    public boolean aProchain() {
        return this.courant != null;
    }

    @Override
    public int prochain() {
        if (!aProchain()) 
            throw new NoSuchElementException();
        
        int result = this.courant.val;
        this.prPrecedant = this.precedant;
        this.precedant = this.courant; 
        this.courant = this.courant.suiv;
        this.supprime = true;
        return result;
    }

    @Override
    public void supprime() {
        if (!this.supprime) 
            throw new IllegalStateException("Appel de supprime sans appel préalable de prochain !");

        if (this.prPrecedant == null) {
            this.liste.tete = this.courant;
        } else {
            this.prPrecedant.suiv = this.courant;
        }
        if (this.precedant == this.liste.queue) {
            this.liste.queue = this.prPrecedant;
        }
        this.precedant = prPrecedant;
        this.supprime = false;
    }
}