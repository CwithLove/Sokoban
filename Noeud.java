public class Noeud<T> {
    T val;
    Noeud<T> suiv;

    Noeud(T val, Noeud<T> suiv) {
        this.val = val;
        this.suiv = null;
    }
}
