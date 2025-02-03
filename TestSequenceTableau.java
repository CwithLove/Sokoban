
import java.util.Random;

public class TestSequenceTableau {
    static int min, max, count;

    static int operation(SequenceTableau seq, int code) {
        int s;
        System.out.println("\n" + seq);
        System.out.println("code: " + code);
        switch (code) {
            case 0:
                s = min;
                System.out.println("Insertion en Tete de " + s);
                seq.insereTete(s);
                assert (!seq.estVide());
                break;
            case 1:
                s = max;
                System.out.println("Insertion en Queue de " + s);
                seq.insereQueue(s);
                assert (!seq.estVide());
                break;
            case 2:
            case 3:
                if (count > 0) {
                    s = seq.extraitTete();
                    System.out.println("Extraction en Tete de " + s);
                    assert (s == min + 1);
                    assert ((count == 1) == (seq.estVide()));
                    return s;
                }
                break;
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Random r = new Random();
        // Le test est spécifique à la classe SequenceTableau, nous factoriserons plus
        // tard
        SequenceTableau s = new SequenceTableau();

        assert (s.estVide());
        min = -1;
        max = 0;
        count = 0;
        for (int i = 0; i < 1000; i++) {
            int code = r.nextInt(4);
               
            int result = operation(s, code);
            if (code < 2) {
                count++;
                if (code < 1)
                    min--;
                else
                    max++;
            } else {
                if (count > 0) {
                    count--;
                    min++;
                }
            }
        }
    }
}
