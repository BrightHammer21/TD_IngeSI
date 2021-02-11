import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        //ListePersonne listePersonne = new ListePersonne();
        ArrayList<Personne> liste = new ArrayList<>();

        int compteur =0;

        String nom="";
        String prenom="";
        int note = 0;

        int compteurNote=0;

        for(String ligne : Files.readAllLines(Paths.get("C:/Users/lucie/Documents/GitHub/TD_IngeSI/TD1_TD2/src/td1_txt.txt"))){
            for(String Chaine : ligne.split(";"))
            {
                //System.out.println(compteur+ " "+Chaine);
                if(compteurNote%2==0)
                {
                    for(String Chaine2 : Chaine.split(" ")) {
                     ///   System.out.println(compteur+ " "+Chaine2);
                        if(compteur%2==0)
                        {
                            prenom=Chaine2;
                        }
                        else {
                            nom=Chaine2;
                        }
                        compteur++;

                    }

                }
                else
                {
                    note=Integer.valueOf(Chaine);
                }
                  compteurNote++;

                Personne p = new Personne(nom,prenom,note);
                if (liste.size()>0)
                {
                    for(Personne perso: liste)
                    {
                        if(perso.getPrenom()==p.getPrenom()&&perso.getNom()==p.getNom()&&perso.getNote()!=p.getNote())
                        {
                            perso.setNote(p.getNote());
                        }
                        /*else
                        {
                            liste.add(p);
                        }*/
                    }
                } else
                {
                    liste.add(p);
                }





            }
        }

        ListePersonne listePersonne = new ListePersonne(liste);

        Personne margaret = listePersonne.rechercherPersonneNom("Smith","Margaret");

        System.out.println(margaret.getNom()+" "+margaret.getPrenom());
        for(int notes : margaret.getListeNote())
        {
            System.out.print(notes+" - ");
        }
    }
}
