class SequenceListe {
    ListeChainee tete, queue;

    void insereTete(int element) {
        ListeChainee newElement = new ListeChainee(element, tete);
        if (this.queue == null) {
            this.queue = newElement;
        }
        newElement.suiv = this.tete;
        this.tete = newElement;
    }

    void insereQueue(int element) {
        ListeChainee newElement = new ListeChainee(element, null);
        if (this.tete == null) {
            this.tete = newElement;
        } else {
            this.queue.suiv = newElement;
            this.queue = newElement;
        }
    }

    int extraitTete() {
        if (estVide()) 
            throw new RuntimeException("Sequence vide !");
        
        int result;
        result = this.tete.val;
        this.tete = this.tete.suiv;
        if (this.tete == null) {
            this.queue = null;
        }
        return result;
    }

    boolean estVide() {
        return this.tete == null;
    }

    public String toString() {
        String resultat = "SequenceListe [ ";
        boolean premier = true;
        ListeChainee m = tete;
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