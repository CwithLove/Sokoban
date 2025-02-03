public class TestIterateur {
    public static void main(String[] args) {
        interfaceSequence sL = new SequenceListe();
        interfaceSequence sT = new SequenceTableau();
        
        assert (sL.estVide());
        assert (sT.estVide());
        for (int i = 0; i < 1000; i++) {
            int code = i % 3;
            switch (i) {
                case 0:
                    sL.insereTete(i);
                    sT.insereTete(i);
                    assert (!sL.estVide());
                    assert (!sT.estVide());
                    break;
                case 1:
                    sL.insereQueue(0);
                    sT.insereQueue(0);
                    assert (sL.extraitTete() == sT.extraitTete());
                    break;
                case 2:
                    int l = sL.extraitTete();
                    int t = sT.extraitTete();
                    assert (l == t);
                    break;

                default:
                    throw new IllegalStateException();
            }

        }
        System.out.println("TestSequence OK");

        // Remplir les sequences
        for (int i = 0; i < 10; i++) {
            sL.insereTete(i);
            sT.insereTete(i);
        }
        
        

        System.out.println("TestIterateur OK");
    }
    
}
