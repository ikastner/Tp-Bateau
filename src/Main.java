//package Tp-Bateau;
import java.lang. *;

public class Main {
    static class Bateau {
        // Définition des attributs d'un bateau
        private static int longueur;
        private static int largeur;
        private static int hauteur;
        private static int tirantEau;
        private static int propulsion;
        private static int vitesse;
        private static char categorie;
        private static String matiereTransportee;
        private static int nbPassagers;
        private static int poidsMax;
        private static int charge;
        private static int membreEquipage;

       public Bateau(int longueur, int largeur, int hauteur, int tirantEau, int propulsion, int vitesse, char categorie,
                     String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage){
           this.longueur = longueur;
           this.largeur = largeur;
           this.hauteur = hauteur;
           this.tirantEau = tirantEau;
           this.propulsion = propulsion;
           this.vitesse = vitesse;
           this.categorie = categorie;
           this. matiereTransportee = matiereTransportee;
           this.nbPassagers = nbPassagers;
           this.poidsMax = poidsMax;
           this.charge = charge;
           this.membreEquipage = membreEquipage;
           System.out.println("Constructeur bateau ok ");


       }
       public static int getLongueur(){
            return longueur;
       }
       public void setLongueur(int longueur) {
                    this.longueur = longueur;
       }

       public static int getLargeur(){
           return largeur;
       }
       public void setLargeur(int largeur){
           this.largeur = largeur;
       }

        public static int getHauteur(){
            return hauteur;
        }
        public void setHauteur(int hauteur){
            this.hauteur = hauteur;
        }

        public static int getTirantEau(){
            return tirantEau;
        }
        public void setTirantEau(int tirantEau){
            this.tirantEau = tirantEau;
        }

        public static int getPropulsion(){
            return propulsion;
        }
        public void setPropulsion(int propulsion){
            this.propulsion = propulsion;
        }

        public static int getVitesse(){
            return vitesse;
        }
        public void setVitesse(int vitesse){
            this.vitesse = vitesse;
        }

        public static int getCategorie(){
            return categorie;
        }
        public void setCategorie(char categorie){
            this.categorie = categorie;
        }

        public static String getMatiereTransportee(){
            return matiereTransportee;
        }
        public void setMatiereTransportee(String matiereTransportee){
            this.matiereTransportee = matiereTransportee;
        }

        public static int getNbPassagers(){
            return nbPassagers;
        }
        public void setnbPassagers(int nbPassagers){
            this.nbPassagers = nbPassagers;
        }

        public static int getPoidsMax(){
            return poidsMax;
        }
        public void setNbPassagers(int poidsMax){
            this.poidsMax = poidsMax;
        }

        public static int getCharge(){
            return charge;
        }
        public void setCharge(int charge){
            this.charge = charge;
        }

        public static int getMembreEquipage(){
            return membreEquipage;
        }
        public void setMembreEquipage(int membreEquipage){
            this.membreEquipage = membreEquipage;
        }


    public static void afficheCaracteristiquesBateau(Bateau unbateau){
        System.out.println( " Longueur : "+getLongueur()+
                            " Largeur : "+getLargeur()+
                            " Hauteur : "+getHauteur()+
                            " Tirant Eau: "+getTirantEau()+
                            " Propulsion : "+getPropulsion()+
                            " Vitesse : "+ getVitesse()+
                            " Categorie : "+ getCategorie()+
                            " MatiereTransportee : "+ getMatiereTransportee()+
                            " NbPassagers : "+ getNbPassagers()+
                            " poidsMax : "+ getPoidsMax()+
                            " charge : "+ getCharge()+
                            " membreEquipage : "+ getMembreEquipage()

        );
    }



    }

    static class Tanker extends Bateau {

        public Tanker(int longueur, int largeur, int hauteur, int tirantEau, int propulsion, int vitesse, char categorie,
                      String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage) {
            super(longueur, largeur, hauteur, tirantEau, propulsion, vitesse, categorie, matiereTransportee, nbPassagers,
                    poidsMax, charge, membreEquipage);
        }
    }

    static class Cargo extends Bateau {

        public Cargo(int longueur, int largeur, int hauteur, int tirantEau, int propulsion, int vitesse, char categorie,
                     String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage) {
            super(longueur, largeur, hauteur, tirantEau, propulsion, vitesse, categorie, matiereTransportee, nbPassagers,
                    poidsMax, charge, membreEquipage);
        }
    }



    static class Catamaran extends Bateau{

        public Catamaran(int longueur, int largeur, int hauteur, int tirantEau, int propulsion, int vitesse, char categorie,
                         String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage) {
            super(longueur, largeur, hauteur, tirantEau, propulsion, vitesse, categorie, matiereTransportee, nbPassagers,
                    poidsMax, charge, membreEquipage);
        }
    }



    static class Plaisance extends Bateau{

        public Plaisance(int longueur, int largeur, int hauteur, int tirantEau, int propulsion, int vitesse, char categorie,
                         String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage) {
            super(longueur, largeur, hauteur, tirantEau, propulsion, vitesse, categorie, matiereTransportee, nbPassagers,
                    poidsMax, charge, membreEquipage);
        }
    }
    public static void main(String[] args) {

        Catamaran catamaran = new Catamaran(17,8,20,2,15,50,'B',"",14,5000,800,5);
        Catamaran.afficheCaracteristiquesBateau(catamaran);

        Plaisance plaisance = new Plaisance(5,3,3,2,20,8,'D',"",12,1400,400,2);
        Plaisance.afficheCaracteristiquesBateau(plaisance);

        Cargo cargo = new Cargo(150,50,60,12,100,8,'C',"Conteneur",6,40000000,15000000,40);
        Cargo.afficheCaracteristiquesBateau(cargo);









        // System.out.println("Hello world!");
    }
}


