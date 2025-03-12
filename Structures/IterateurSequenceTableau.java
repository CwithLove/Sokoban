package Structures;

import java.util.NoSuchElementException;

public class IterateurSequenceTableau<T> implements Iterateur<T> {
    SequenceTableau<T> seq;
    int pred, courant, rang;

    public IterateurSequenceTableau(SequenceTableau<T> s) {
        this.seq = s;
        this.rang = 0;
        this.courant = s.start;
        this.pred = -1;
    }

    @Override
    public boolean aProchain() {
        return this.rang < this.seq.len;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T prochain() {
        if (aProchain()) {
            this.pred = this.courant;
            this.courant = (this.courant + 1) % this.seq.elements.length;
            this.rang++;
            return (T) this.seq.elements[this.pred];
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void supprime() {
        if (this.pred != -1) {
            this.courant = this.pred;
            int i = this.rang;
            while (i < this.seq.len) {
                int next = (this.pred + 1) % this.seq.elements.length;
                this.seq.elements[pred] = this.seq.elements[next];
                this.pred = next;
                i++;
            }
            this.pred = -1;
            this.rang--;
            this.seq.len--;
        } else {
            throw new IllegalStateException();
        }    
    }
}
