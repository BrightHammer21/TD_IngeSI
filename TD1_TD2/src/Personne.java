import java.util.ArrayList;

public class Personne {

    private String nom;
    private String prenom;


    private int note;

    public ArrayList<Integer> getListeNote() {
        return listeNote;
    }

    public void setListeNote(ArrayList<Integer> listeNote) {
        this.listeNote = listeNote;
    }

    private ArrayList<Integer> listeNote;

    public Personne(String nom, String prenom, int note)
    {
        this.nom=nom;
        this.prenom=prenom;

        listeNote = new ArrayList<>();
        listeNote.add(note);


    }

    public Personne()
    {
        this.nom="Inconnu";
        this.prenom="Inconnu";
        this.note = 0;
        listeNote = new ArrayList<>();
    }

    /////////////////////////////////////////////////GETTER SETTER

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        listeNote.add(note);
    }



}
