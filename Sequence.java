public interface Sequence<T> {
    public Iterateur<T> iterateur();

    public void insereTete(T element);

    public void insereQueue(T element);

    public T extraitTete();

    public boolean estVide();

    String toString();
}