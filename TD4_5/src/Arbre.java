import java.util.ArrayList;
import java.util.Collections;

public class Arbre {

    private ArrayList<Noeud> listeNoeud;
    private Noeud noeudRacine;

    public Arbre(Noeud noeudRacine)
    {
        listeNoeud = new ArrayList<>();

        listeNoeud.add(noeudRacine);

        this.noeudRacine=noeudRacine;

        noeudRacine.setRacine(true);
        noeudRacine.setFeuille(true);
    }

    public void insertionNoeudVal(int entier)
    {
        System.out.println("entier : "+entier);


        if(noeudRacine.getFeuille()==true) {
            System.out.println("noeudR + : "+entier);
           insererNouvelleVal(noeudRacine,entier);
       }
       else
       {
           Noeud noeudCourant = noeudRacine;
           boolean estFeuille = false;

           while(estFeuille==false)
           {
               /*System.out.println("size : "+noeudCourant.getValeurs().size());*/
               //On regarde à gauche si notre entier < à la val du noeud
               if(noeudCourant.getValeurs().get(0)<entier)
               {
                   System.out.println(noeudCourant.getValeurs().get(0)+" < "+entier);
                   if(noeudCourant.getFilsGauche() !=null)
                   {
                       //On regarde si ce noeud a un enfant
                       noeudCourant=noeudCourant.getFilsGauche();
                       noeudCourant.setFeuille(false);
                   }
                   else
                   {
                       noeudCourant.setFeuille(true);
                   }

               }
               //regarde à droite
               else if(noeudCourant.getValeurs().get(0)>entier && noeudCourant.getValeurs().size()<2)
               {
                   System.out.println("coucou");
                   if(noeudCourant.getFilsDroit()!=null)
                   {
                       noeudCourant=noeudCourant.getFilsDroit();
                       noeudCourant.setFeuille(false);
                   }
                   else
                   {
                       noeudCourant.setFeuille(true);
                   }

               }
               //regarde à droit pour placer au milieu ou à l';extrême droite
               else if(noeudCourant.getValeurs().get(0)>entier && noeudCourant.getValeurs().size()==2)
               {
                   if(noeudCourant.getFilsDroit()!=null)
                   {
                       if(noeudCourant.getValeurs().get(1) < entier)
                       {
                           noeudCourant=noeudCourant.getFilsMilieu();
                           noeudCourant.setFeuille(false);
                       }
                       else
                       {
                           noeudCourant=noeudCourant.getFilsDroit();
                           noeudCourant.setFeuille(false);
                       }
                   }

                   else
                   {
                       noeudCourant.setFeuille(true);
                   }
               }
               else
               {

                   noeudCourant=noeudCourant.getFilsMilieu();
                   noeudCourant.setFeuille(false);
               }




               if(noeudCourant.getFeuille()==true)
               {

                   estFeuille=true;
               }



           }
           insererNouvelleVal(noeudCourant,entier);

       }
    }


    public boolean estDansArbre(Noeud n)
    {
        boolean estContenuDansArbre = false;

        if(listeNoeud.contains(n))
        {
            estContenuDansArbre=true;
        }

        return estContenuDansArbre;
    }

    private void troisValsDansNoeud(Noeud n,int entier)
    {

        n.ajouterValeur(entier);
        Collections.sort(n.getValeurs());

        int valeurRemontee = n.getValeurs().get(1);
        ArrayList<Integer> newVal=new ArrayList<>();
        newVal.add(valeurRemontee);
        Noeud gauche = new Noeud(n.getValeurs().get(0));
        Noeud droite = new Noeud(n.getValeurs().get(2));

        gauche.setFeuille(true);
        gauche.setRacine(false);
        droite.setFeuille(true);
        droite.setRacine(false);

        n.setValeurs(newVal);
        n.setFilsGauche(gauche);
        n.setFilsDroit(droite);

        n.setFeuille(false);
    }

    private void insererNouvelleVal(Noeud n, int entier)
    {
        if(n.retournerTailleNoeud()==1)
        {
            n.ajouterValeur(entier);
            Collections.sort(n.getValeurs());
        }
        else if(n.retournerTailleNoeud()==2)
        {
            troisValsDansNoeud(n, entier);
        }
    }

    public void afficherArbre(int niveau, Noeud noeud)
    {

        System.out.println("Niveau : "+ niveau+" ");

        for(int i=0; i<noeud.getValeurs().size(); i++)
        {
            System.out.println(noeud.getValeurs().get(i)+" ");
        }
        niveau++;
        if(noeud.getFilsGauche()!=null)
        {
            ArrayList<Noeud> listeEnfants = new ArrayList<>();

            listeEnfants.add(noeud.getFilsGauche());
            listeEnfants.add(noeud.getFilsDroit());

            if(noeud.getFilsMilieu()!=null)
            {
                listeEnfants.add(noeud.getFilsMilieu());
            }
            for(int i=0; i<listeEnfants.size();i++)
            {

                this.afficherArbre(niveau,listeEnfants.get(i));
            }
        }


    }
}
