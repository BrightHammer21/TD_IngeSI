import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {

        //ListePersonne listePersonne = new ListePersonne();
        HashSet<Personne> liste = new HashSet<>();

        int compteur =0;

        String nom="";
        String prenom="";
        int note = 0;

        int compteurNote=0;

        for(String ligne : Files.readAllLines(Paths.get("src/td1_txt.txt"))){
            for(String Chaine : ligne.split(";"))
            {
                if(compteurNote%2==0)
                {
                    for(String Chaine2 : Chaine.split(" ")) {
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
                Boolean res = true;
                for(Personne perso: liste)
                    {
                        if(perso.getPrenom()==prenom && perso.getNom()==nom)
                        {
                            perso.addNote(note);
                            res = false;

                           //System.out.println("coucou");
                        }

                    }
                if (res == true)
                {
                    liste.add(p);
                }

            }
        }

       // ListePersonne listePersonne = new ListePersonne(liste);

       /* Personne margaret = listePersonne.rechercherPersonneNom("Smith","Margaret");

        System.out.println(margaret.getNom()+" "+margaret.getPrenom());
        for(int notes : margaret.getListeNote())
        {
            System.out.print(notes+" - ");
        }*/
    }
}
