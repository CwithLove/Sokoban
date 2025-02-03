import java.io.InputStream;

class Main {
	public static void main(String [] args) {
		try {
			InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("Original.txt");
			LecteurNiveaux lecteurNiveaux = new LecteurNiveaux(inputStream);
			RedacteurNiveau redacteurNiveau = new RedacteurNiveau(System.out);

			for (Niveau n = lecteurNiveaux.lisProchainNiveau(); n != null; n = lecteurNiveaux.lisProchainNiveau()) {
				redacteurNiveau.ecrisNiveau(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
