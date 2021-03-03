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
            System.out.println(listeNom.add(nom));
            if(listeNom.add(nom))
            {
                listePersonnes.add(new Personne(nom, note));
            }
            else
            {
                Personne perso = new Personne();

                for(Personne p : listePersonnes)
                {
                    if(p.getNom()==nom)
                    {
                        System.out.println("coucou");
                        perso=p;
                    }
                }

                perso.addNote(note);
            }

        }

       /* for(Personne p : listePersonnes)
        {
            System.out.println(p.getNom()+" - ");
        }*/
        Personne margaret = new Personne();

        for(Personne p : listePersonnes)
        {
            System.out.println(p.getNom());
            if(p.getNom() == "Margaret Smith")
            {
                margaret=p;
                System.out.println(p.getNom());
            }
        }

        System.out.println(margaret.getNom());
        for(int notes : margaret.getNotes())
        {
            System.out.print(notes+" - ");
        }

    }
}
