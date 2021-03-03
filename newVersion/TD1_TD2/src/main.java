import com.android.aapt.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;

public class main {

    public static void main(String[] args) throws IOException {

        int compteur = 0;
        int note = -1 ;
        String nom = "";
        HashSet<String> listeNom = new HashSet<>();
        ArrayList<Personne> listePersonnes  = new ArrayList<>();

        for(String ligne : Files.readAllLines(Paths.get("src/td1_txt.txt"))){
            for(String Chaine : ligne.split(";"))
            {
                if(compteur%2==0)
                {
                    nom = Chaine;

                }
                else {
                    note = Integer.valueOf(Chaine);
                }
                compteur++;
            }
            if(listeNom.add(nom))
            {
                listePersonnes.add(new Personne(nom, note));
            }
            else
            {
                Personne perso = rechercherPersonneNom(nom, listePersonnes);
                perso.addNote(note);
            }

        }


        for(Personne p : listePersonnes)
        {
            System.out.println(p.getNom()+" - ");
        }

    }

    public static Personne rechercherPersonneNom(String nom, ArrayList<Personne> liste)
    {
        Personne perso = new Personne();

        for(Personne p : liste)
        {
            System.out.println(p.getNom());
            if(p.getNom()==nom)
            {
                perso=p;
            }
        }
        return perso;
    }

}
