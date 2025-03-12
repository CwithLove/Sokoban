package Structures;

public class SequenceListe<T> implements Sequence<T> {
    Noeud<T> tete, queue;

    public Iterateur<T> iterateur() {
        return new IterateurSequenceListe<>(this);
    }

    @Override
    public void insereTete(T element) {

        Noeud<T> newElement = new Noeud<>(element, tete);
        if (this.tete == null) {
            this.queue = newElement;
            this.tete = newElement;
        } else {
            this.tete = newElement;
        }
    }

    @Override
    public void insereQueue(T element) {
        Noeud<T> newElement = new Noeud<T>(element, null);
        if (this.queue == null || this.tete == null) {
            this.queue = newElement;
            this.tete = newElement;
        } else {
            this.queue.suiv = newElement;
            this.queue = newElement;
        }
        
    }

    @Override
    public T extraitTete() {
        if (estVide()) 
            throw new RuntimeException("Sequence vide !");
        
        T result = this.tete.val;
        this.tete = this.tete.suiv;
        if (this.tete == null) {
            this.queue = null;
        }
        return result;
    }

    @Override
    public boolean estVide() {
        return this.tete == null;
    }

    public String toString() {
        String resultat = "SequenceListe [ ";
        boolean premier = true;
        Noeud<T> m = tete;
        while (m != null) {
            if (!premier)
                resultat += ", ";
            resultat += m.val;
            m = m.suiv;
            premier = false;
        }
        resultat += " ]";
        return resultat;
    }

}