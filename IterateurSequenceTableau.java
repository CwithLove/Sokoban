public class IterateurSequenceTableau implements Iterateur {
    SequenceTableau sequence;
    int precedant, courant, nbReste;

    public IterateurSequenceTableau(SequenceTableau s) {
        this.sequence = s;
        this.courant = 0;
        this.precedant = -1;
        this.nbReste = this.sequence.len;
    }

    @Override
    public boolean aProchain() {
        return this.nbReste > 0;
    }

    @Override
    public int prochain() {
        int res =  this.sequence.elements[this.courant];
        this.precedant = this.courant;
        this.nbReste--;
        if (this.courant <= this.sequence.len - 1) {
            this.courant++;
        } else {
            this.courant = 0;
        }
        return res;
    }

    @Override
    public void supprime() {
        System.out.println("precedant: " + this.precedant + " courant: " + this.courant);
        if (this.precedant == -1 || this.sequence.len == 0 || this.precedant == this.courant) {
            throw new IllegalStateException();
        }
        
        this.courant = this.precedant;
        int i = this.precedant;
        for (int count = this.nbReste; count > 0; count--) {
            this.sequence.elements[i] = this.sequence.elements[(i + 1) % this.sequence.len];
            i = (i + 1) % this.sequence.len;
        }   
        this.sequence.len--;
    }
}
