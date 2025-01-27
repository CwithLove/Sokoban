import java.util.Scanner;
import java.io.InputStream;

public class LecteurNiveaux {
    private Scanner my_scanner; // Vi sao phai can private? Vi my_scanner chi dung trong class nay

    public LecteurNiveaux(InputStream input) {
        my_scanner = new Scanner(input);
    }

    public Niveau lisProchainNiveau() {
        Niveau niveau = new Niveau();
        String ligne = null;
        int l = 0;
        
        try {
            ligne = my_scanner.nextLine();
        } catch (Exception e) {
            return null;
        }

        while (ligne.length() > 0) {
            // System.out.println(ligne);
            if (ligne.charAt(0) == ';') {
                int c=1;
                while (ligne.charAt(c) != ' ') {
                    c++;
                }
                niveau.fixeNom(ligne.substring(c));   
            } else {
                for (int c=0; c<ligne.length(); c++) {
                    switch (ligne.charAt(c)) {
                        case '#':
                            niveau.ajouteMur(l, c);
                            break;
                        case '@':
                            niveau.ajoutePousseur(l, c);
                            break;
                        case '$':
                            niveau.ajouteCaisse(l, c);
                            break;
                        case '*':
                            niveau.ajouteCaisse(l, c);
                            niveau.ajouteBut(l, c);
                            break;
                        case '+':
                            niveau.ajoutePousseur(l, c);
                            niveau.ajouteBut(l, c);
                            break;
                        case '.':
                            niveau.ajouteBut(l, c);
                            break;
                        case ' ':
                            break;
                        default:
                            System.err.println("Caractère inconnu : " + ligne.charAt(c));
                            System.exit(1);   
                    }   
                }
            }
            ligne = my_scanner.nextLine();
            l++;
        }
        return niveau;   
    }
}
