public class Niveau {
    int[][] monTableau = new int[1][1];
    private String nom;
    int l = 0;
    int c = 0;
    final int MUR = 1;
    final int POUSSEUR = 2;
    final int BUT = 4;
    final int CAISSE = 8;

    int ajuste(int c, int i) {
		while (c <= i) {
			c *= 2;
		}
		return c;
	}

	void redimensionne(int l, int c) {
		int oldL = monTableau.length;
		int oldC = monTableau[0].length;
		if ((oldL <= l) || (oldC <= c)) {
			int newL = ajuste(oldL, l);
			int newC = ajuste(oldC, c);
			// System.err.println("Redimensionnement : " + newL + "*" + newC);
			int [][] newTab = new int[newL][newC];
			for (int i=0; i<oldL; i++)
				for (int j=0; j<oldC; j++)
					newTab[i][j] = monTableau[i][j];
			monTableau = newTab;
		}
	}
    
    void misAJourLC(int l, int c) {
        if (this.l <= l) {
            this.l++;
        }
        if (this.c <= c) {
            this.c++;
        }
    }

    void fixeNom(String nom) {
        this.nom = nom;
    }

    void videCase(int i, int j) {
        redimensionne(i, j);
        misAJourLC(i, j);
        monTableau[i][j] = 0;
    }

    void ajouteMur(int i, int j) {
        redimensionne(i, j);
        misAJourLC(i, j);
        monTableau[i][j] |= MUR;
    }

    void ajoutePousseur(int i, int j) {
        redimensionne(i, j);
        misAJourLC(i, j);
        monTableau[i][j] |= POUSSEUR;
    }

    void ajouteCaisse(int i, int j) {
        redimensionne(i, j);
        misAJourLC(i, j);
        monTableau[i][j] |= CAISSE;
    }

    void ajouteBut(int i, int j) {
        redimensionne(i, j);
        monTableau[i][j] |= BUT;
        misAJourLC(i, j);
    }


    boolean estVide(int i, int j) {
        return monTableau[i][j] == 0;
    }

    boolean aMur(int i, int j) {
        return (monTableau[i][j] & MUR) != 0;
    }

    boolean aBut(int i, int j) {
        return (monTableau[i][j] & BUT) != 0;
    }

    boolean aPousseur(int l, int c) {
        return (monTableau[l][c] & POUSSEUR) != 0;
    }

    boolean aCaisse(int l, int c) {
        return (monTableau[l][c] & CAISSE) != 0;
    }

    String nom() {
        return this.nom;
    }

    int c() {
        return this.c;
    }

    int l() {
        return this.l;
    }
}
