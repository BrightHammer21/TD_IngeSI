import java.util.ArrayList;

public class Personne {

    private String nom;
    private ArrayList<Integer> notes;

    public Personne(String nom)
    {
        this.nom=nom;
        this.notes = new ArrayList<>();
    }

    public Personne(String nom, int note)
    {
        this.nom=nom;
        this.notes = new ArrayList<>();
        this.addNote(note);
    }

    public Personne()
    {
        this.nom="Inconnu";
        this.notes = new ArrayList<>();
    }

    /////////////////////////////////////////////////GETTER SETTER

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void addNote(int note) {
        notes.add(note);
    }




}
