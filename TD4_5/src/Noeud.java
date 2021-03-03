import java.util.ArrayList;

public class Noeud {

    private boolean feuille;
    private boolean racine;
    private ArrayList<Integer>  valeurs;
    private Noeud filsGauche;
    private Noeud filsDroit;
    private Noeud filsMilieu;

    public Noeud()
    {
        valeurs = new ArrayList<>();
        feuille = false;
        racine = false;
    }
    public Noeud(int valeur)
    {
        valeurs = new ArrayList<>();
        valeurs.add(valeur);
        feuille = false;
        racine = false;
    }

    public void ajouterValeur(int valeur)
    {
        valeurs.add(valeur);
    }

    public int retournerTailleNoeud()
    {
        return this.valeurs.size();
    }



    //////////////////////////////////////METHODES
    public boolean getFeuille() {
        return feuille;
    }

    public void setFeuille(boolean feuille) {
        this.feuille = feuille;
    }

    public boolean getRacine() {
        return racine;
    }

    public void setRacine(boolean racine) {
        this.racine = racine;
    }

    public ArrayList<Integer> getValeurs() {
        return valeurs;
    }

    public void setValeurs(ArrayList<Integer> valeurs) {
        this.valeurs = valeurs;
    }

    public void setFilsGauche(Noeud n)
    {
        filsGauche=n;
    }

    public void setFilsDroit(Noeud n)
    {
        filsDroit=n;
    }

    public void setFilsMilieu(Noeud n)
    {
        filsMilieu=n;
    }

    public Noeud getFilsGauche() {
        return filsGauche;
    }

    public Noeud getFilsDroit() {
        return filsDroit;
    }

    public Noeud getFilsMilieu() {
        return filsMilieu;
    }

}
