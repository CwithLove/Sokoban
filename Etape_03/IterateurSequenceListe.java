import java.util.NoSuchElementException;

public class IterateurSequenceListe implements Iterateur {
    SequenceListe liste;
    ListeChainee prPrecedant, precedant, courant;

    public IterateurSequenceListe(SequenceListe s) {
        this.liste = s;
        this.precedant = null;
        this.prPrecedant = null;
        this.courant = s.tete;
    }

    public boolean aProchain() {
        return this.courant != null;
    }

    public int prochain() {
        if (!aProchain()) 
            throw new NoSuchElementException();
        
        int result = this.courant.val;
        if (this.precedant == null) {
           this.precedant = this.courant;
        } else {
            this.prPrecedant = this.precedant;
            this.precedant = this.courant;
        } 
        this.courant = this.courant.suiv;
        return result;
    }

    public void supprime() {
        if (this.precedant == null) 
            throw new IllegalStateException("Appel de supprime sans appel préalable de prochain !");

        this.precedant = null;

        if (this.prPrecedant == null) {
            this.liste.tete = this.courant;
        } else {
            this.prPrecedant.suiv = this.courant;
        }
        if (this.precedant == this.liste.queue) {
            this.liste.queue = this.prPrecedant;
        }
        this.precedant = null;
    }
}