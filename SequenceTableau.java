

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
            int[] newElements = new int[elements.length * 2];
            for (int i = 0; i < this.len; i++) {
                newElements[i] = extraitTete();
            }
            this.elements = newElements;
        }
    }

    @Override
    public void insereTete(int element) {
        redimensionne();
        System.out.println("\nlen: " + len + " start: " + start + " elements.length: " + elements.length);
        start -= 1;
        if (start < 0) {
            start = elements.length - 1;
        }
        for (int i = 0; i < this.len; i++) {
            elements[(start + i + 1) % elements.length] = elements[(start + i) % elements.length];
        }
        elements[start] = element; 
        this.len++;
        System.out.println("len: " + len + " start: " + start + " elements.length: " + elements.length);
    }

    @Override
    public void insereQueue(int element) {
        redimensionne();
        System.out.println("len: " + len + " start: " + start + " elements.length: " + elements.length);
        if (start == 0) {
            this.start = elements.length - 1;
            elements[this.start] = element;
        } else {
            elements[(start + 1) % elements.length] = element;
            this.start = 0;
        }
        this.len++;
        System.out.println("\nlen: " + len + " start: " + start + " elements.length: " + elements.length);
    }

    @Override
    public int extraitTete() {
        if (estVide()) 
            throw new RuntimeException("Sequence vide !");
        
        System.out.println("\nlen: " + len + " start: " + start + " elements.length: " + elements.length);
        int result = elements[start--];
        this.len--;
        System.out.println("len: " + len + " start: " + start + " elements.length: " + elements.length);
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
