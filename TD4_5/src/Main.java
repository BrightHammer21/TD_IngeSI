public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Noeud noeudRacine = new Noeud(5);
        noeudRacine.setFeuille(true);
        noeudRacine.setRacine(true);
        Arbre monArbre = new Arbre(noeudRacine);


        monArbre.insertionNoeudVal(4);
        monArbre.insertionNoeudVal(6);
        monArbre.insertionNoeudVal(7);
    }
}
