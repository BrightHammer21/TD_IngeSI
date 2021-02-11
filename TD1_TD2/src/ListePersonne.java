import java.util.ArrayList;

public class ListePersonne {

    ArrayList<Personne> personnes;

    public ListePersonne(ArrayList<Personne> p)
    {
       this.personnes=p;

    }

    public ListePersonne()
    {
        personnes = new ArrayList<>();
    }

    //////////////////////////////GETTER SETTER
    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(ArrayList<Personne> personnes) {
        this.personnes = personnes;
    }

    //////////////////////////METHODES
    public void ajouterPersonne(Personne p)
    {
        if(personnes.size()>0)
        {
            for(Personne perso:personnes)
            {
                if(perso.getPrenom()==p.getPrenom()&&perso.getNom()==p.getNom()&&perso.getNote()!=p.getNote())
                {
                    perso.setNote(p.getNote());
                }
                else
                {
                    personnes.add(p);
                }
            }
        }
        else
        {
            personnes.add(p);
        }

    }

    public void deletePersonne(Personne p)
    {
        personnes.remove(p);
    }

    public void daletePesonne(int index)
    {
        personnes.remove(index);
    }

    public Boolean rechercherPersonne(Personne p)
    {
        return true;
    }

    public Personne rechercherPersonneNom(String nom, String prenom)
    {
        Personne perso = new Personne();

        for(Personne p : personnes)
        {
            System.out.println(p.getNom());
            if(p.getNom()==nom && p.getPrenom()==prenom)
            {
                perso=p;
            }
        }
        return perso;
    }

}
