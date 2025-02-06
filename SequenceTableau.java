public class SequenceTableau<T> implements Sequence<T> {
    Object[] elements;
    int len, start;

    public SequenceTableau() {
        this.elements = new Object[1];
        len = 0;
        start = 0;
    }

    @Override
    public Iterateur<T> iterateur() {
        return new IterateurSequenceTableau<>(this);
    }

    private void redimensionne() {
        if (this.len >= this.elements.length) {
            int newLen = this.len * 2;
            Object[] newElements;

            newElements = new Object[newLen];
            int aCopier = this.len;
            for (int i = 0; i < aCopier; i++) {
                newElements[i] = extraitTete();
            }
            this.start = 0;
            this.len = aCopier;
            this.elements = newElements;
        }
    }

    @Override
    public void insereTete(T element) {
        redimensionne();
        start -= 1;
        if (start < 0) {
            start = elements.length - 1;
        }
        elements[start] = element; 
        this.len++;
    }

    @Override
    public void insereQueue(T element) {
        redimensionne();
        this.elements[(start + this.len) % this.elements.length] = element;
        this.len++;
    }

    @Override
    public T extraitTete() {
        if (estVide()) 
            throw new RuntimeException("Sequence vide !");
        
        @SuppressWarnings("unchecked")
        T result = (T) elements[start];
        start = (start + 1) % elements.length;
        this.len--;
        return result;
    }

    @Override
    public boolean estVide() {
        return this.len == 0;
    }

    @Override
	public String toString() {
		String resultat = "SequenceTable [ ";
		int pos = this.start;
		for (int i = 0; i < this.len; i++) {
			if (i > 0)
				resultat += ", ";
			resultat += elements[pos];
			pos = (pos + 1) % elements.length;
		}
		resultat += " ]";
		return resultat;
	}
}
