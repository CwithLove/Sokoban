public class SequenceTableau {
    int[] elements;
    int len, start;

    public SequenceTableau() {
        elements = new int[1];
        len = 0;
        start = 0;

    }

    private void redimensionne() {
        if (this.len >= this.elements.length) {
            int[] newElements = new int[this.len * 2];
            for (int i = 0; i < this.len; i++) {
                newElements[i] = extraitTete();
            }
            this.elements = newElements;
        }
    }

    void insereTete(int element) {
        redimensionne();
        start -= 1;
        if (start < 0) {
            start = elements.length - 1;
        }
        elements[start] = element;
        this.len++;
    }

    void insereQueue(int element) {
        redimensionne();
        elements[(start + len) % elements.length] = element;
        this.len++;
    }

    int extraitTete() {
        if (estVide()) 
            throw new RuntimeException("Sequence vide !");
        
        int result = elements[start--];
        this.len--;
        return result;
    }

    boolean estVide() {
        return this.len == 0;
    }

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
