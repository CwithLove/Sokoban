import java.util.Arrays;

public class SequenceTableau implements interfaceSequence {
    int[] elements;
    int len, start;

    public SequenceTableau() {
        elements = new int[1];
        len = 0;
        start = 0;

    }

    @Override
    public Iterateur iterateur() {
        return new IterateurSequenceTableau(this);
    }

    private void redimensionne() {
        if (this.len >= this.elements.length) {
            int newLen = this.len * 2;
            int[] newElements = new int[newLen];
            int aCopier = this.len;
            for (int i = 0; i < this.len; i++) {
                newElements[i] = extraitTete();
            }
            this.elements = newElements;
            this.start = 0;
            this.len = aCopier;
        }
    }

    @Override
    public void insereTete(int element) {
        redimensionne();
        start -= 1;
        this.len++;
        if (start < 0) {
            start = elements.length - 1;
        }
        elements[start] = element; 
    }

    @Override
    public void insereQueue(int element) {
        redimensionne();
        this.elements[(start + this.len) % this.elements.length] = element;
        this.len++;
    }

    @Override
    public int extraitTete() {
        if (estVide()) 
            throw new RuntimeException("Sequence vide !");
        
        int result = elements[start++];
        if (start >= elements.length) {
            start = 0;
        }
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
