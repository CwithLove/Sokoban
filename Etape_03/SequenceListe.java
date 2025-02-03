class SequenceListe implements interfaceSequence {
    ListeChainee tete, queue;

    public SequenceListe() {
        this.tete = null;
        this.queue = null;
    }

    public Iterateur iterateur() {
        return new IterateurSequenceListe(this);
    }

    @Override
    public void insereTete(int element) {
        ListeChainee newElement = new ListeChainee(element);
        if (this.queue == null) {
            this.queue = newElement;
        }
        newElement.suiv = this.tete;
        this.tete = newElement;
    }

    @Override
    public void insereQueue(int element) {
        ListeChainee newElement = new ListeChainee(element);
        if (this.queue == null || this.tete == null) {
            this.queue = newElement;
            this.tete = newElement;
        } else {
            this.queue.suiv = newElement;
            this.queue = newElement;
        }
        
    }

    @Override
    public int extraitTete() {
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

    @Override
    public boolean estVide() {
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