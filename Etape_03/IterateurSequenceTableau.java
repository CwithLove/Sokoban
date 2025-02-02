public class IterateurSequenceTableau implements Iterateur {
    int[] elements;
    int precedant, courant;

    public IterateurSequenceTableau(SequenceTableau s) {
        this.elements = s.elements;
        this.courant = 0;
        this.precedant = -1;
    }

    public boolean aProchain() {
        return this.elements[this.courant] != -1;
    }

    public int prochain() {
        int result = this.elements[this.courant];
        this.precedant = this.courant;
        if (this.courant >= this.elements.length) {
            this.courant = 0;
        } else {
            this.courant++;
        }
        return result;
    }

    public void supprime() {
        this.elements[this.precedant] = -1;
    }
}
