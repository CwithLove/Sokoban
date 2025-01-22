import java.util.Scanner;
import java.util.InputMismatchException;


class Essai_Scanner {
    public static void main(String[] args) {
        Scanner my_scanner = new Scanner(System.in);
        int entier = 0;
        boolean saisieValide = false;

        while (!saisieValide) {
            try {
                System.out.println("Saisissez un entier :");
                entier = my_scanner.nextInt(); // Tentative de lire un entier
                saisieValide = true; // Si la lecture réussit, on sort de la boucle
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Vous devez saisir un entier valide.");
                my_scanner.next(); // Consommer l'entrée invalide pour éviter une boucle infinie
            }
        }

        System.out.println("Vous avez saisi l'entier : " + entier);
        my_scanner.close();
    }
}
