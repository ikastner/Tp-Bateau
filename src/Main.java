//package Tp-Bateau;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.EventQueue;

import java.sql.Wrapper;
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
                      String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage) {
            this.longueur = longueur;
            this.largeur = largeur;
            this.hauteur = hauteur;
            this.tirantEau = tirantEau;
            this.propulsion = propulsion;
            this.vitesse = vitesse;
            this.categorie = categorie;
            this.matiereTransportee = matiereTransportee;
            this.nbPassagers = nbPassagers;
            this.poidsMax = poidsMax;
            this.charge = charge;
            this.membreEquipage = membreEquipage;
            System.out.println("Constructeur bateau ok ");


        }

        public static int getLongueur() {
            return longueur;
        }

        public void setLongueur(int longueur) {
            this.longueur = longueur;
        }

        public static int getLargeur() {
            return largeur;
        }

        public void setLargeur(int largeur) {
            this.largeur = largeur;
        }

        public static int getHauteur() {
            return hauteur;
        }

        public void setHauteur(int hauteur) {
            this.hauteur = hauteur;
        }

        public static int getTirantEau() {
            return tirantEau;
        }

        public void setTirantEau(int tirantEau) {
            this.tirantEau = tirantEau;
        }

        public static int getPropulsion() {
            return propulsion;
        }

        public void setPropulsion(int propulsion) {
            this.propulsion = propulsion;
        }

        public static int getVitesse() {
            return vitesse;
        }

        public void setVitesse(int vitesse) {
            this.vitesse = vitesse;
        }

        public static int getCategorie() {
            return categorie;
        }

        public void setCategorie(char categorie) {
            this.categorie = categorie;
        }

        public static String getMatiereTransportee() {
            return matiereTransportee;
        }

        public void setMatiereTransportee(String matiereTransportee) {
            this.matiereTransportee = matiereTransportee;
        }

        public static int getNbPassagers() {
            return nbPassagers;
        }

        public void setnbPassagers(int nbPassagers) {
            this.nbPassagers = nbPassagers;
        }

        public static int getPoidsMax() {
            return poidsMax;
        }

        public void setPoidsMax(int poidsMax) {
            this.poidsMax = poidsMax;
        }

        public static int getCharge() {
            return charge;
        }

        public void setCharge(int charge) {
            this.charge = charge;
        }

        public static int getMembreEquipage() {
            return membreEquipage;
        }

        public void setMembreEquipage(int membreEquipage) {
            this.membreEquipage = membreEquipage;
        }


        public static void afficheCaracteristiquesBateau(Bateau unbateau) {
            System.out.println(" Longueur : " + getLongueur() +
                    " Largeur : " + getLargeur() +
                    " Hauteur : " + getHauteur() +
                    " Tirant Eau: " + getTirantEau() +
                    " Propulsion : " + getPropulsion() +
                    " Vitesse : " + getVitesse() +
                    " Categorie : " + getCategorie() +
                    " MatiereTransportee : " + getMatiereTransportee() +
                    " NbPassagers : " + getNbPassagers() +
                    " poidsMax : " + getPoidsMax() +
                    " charge : " + getCharge() +
                    " membreEquipage : " + getMembreEquipage()

            );
        }

        public static void afficheBateauPret(Bateau unbateau) {
            System.out.println("Le bateau est maintenant prêt à prendre la mer");
        }

        public static int chargeEnCoursBateau(Bateau unbateau) {
            charge = (int) (Math.random() * 100);
            return charge;
        }

        public static int trouverNbPassager(Bateau unbateau) {
            Random random = new Random();
            nbPassagers = random.nextInt(16);
            return nbPassagers;
        }

        public static int trouverUnEquipage(Bateau unbateau) {
            Random random = new Random();
            membreEquipage = random.nextInt(31);
            return membreEquipage;

        }


    }

    static class Tanker extends Bateau {

        public Tanker(int longueur, int largeur, int hauteur, int tirantEau, int propulsion, int vitesse, char categorie,
                      String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage) {
            super(longueur, largeur, hauteur, tirantEau, propulsion, vitesse, categorie, matiereTransportee, nbPassagers,
                    poidsMax, charge, membreEquipage);
        }

        public static void traiterEquipageTanker(Tanker tanker) {
            int nbEquipage = trouverUnEquipage(tanker);
            System.out.println(nbEquipage);
            switch (nbEquipage) {
                case 0:
                    System.out.println("absence d'équipage");
                    break;
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14:
                    System.out.println("Équipage insuffisant");
                    break;
                case 15, 16, 17, 18, 19, 20:
                    System.out.println("Les membres d'équipage sont composés de " + nbEquipage + " personnes");
                    break;
                default:
                    System.out.println("Nombre d'équipage supérieur au nombre requis : équipage refusé");
                    break;

            }

        }

        public static void traiterTanker(Tanker tanker) {
            double poidsMaxAutorise = tanker.getPoidsMax() * 0.95; // 5% de réduction
            double chargeTotale = 0;
            System.out.println("Tanker en cours de chargement");
            while (chargeTotale <= poidsMaxAutorise) {
                double charge = chargeEnCoursBateau(tanker);
                chargeTotale += charge;
            }
            System.out.println("La charge calculée est de " + chargeTotale + " tonnes");
            System.out.println("Le bateau a une charge finale de " + chargeTotale + " tonnes pour un poids maximum autorisé de " + tanker.getPoidsMax() + " tonnes");
            afficheBateauPret(tanker);
        }
    }

    static class Cargo extends Bateau {

        public Cargo(int longueur, int largeur, int hauteur, int tirantEau, int propulsion, int vitesse, char categorie,
                     String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage) {
            super(longueur, largeur, hauteur, tirantEau, propulsion, vitesse, categorie, matiereTransportee, nbPassagers,
                    poidsMax, charge, membreEquipage);
        }

        public static void traiterCargoFretMixte(Cargo cargo) {
            System.out.println("Cargo en cours de chargement");
            double difference = Cargo.getPoidsMax() * 0.05;
            double chargeMaxVrac = (difference * 0.6);
            double chargeMaxLiquide = (difference * 0.35);


            double ChargeEnCoursLiquide = 0;
            double ChargeEnCoursVrac = 0;

            while (ChargeEnCoursLiquide <= chargeMaxLiquide) {
                ChargeEnCoursLiquide += chargeEnCoursBateau(cargo) * 0.35;
                //System.out.println("Liquide: "+ChargeEnCoursLiquide);
            }

            while (ChargeEnCoursVrac <= chargeMaxVrac) {
                ChargeEnCoursVrac += chargeEnCoursBateau(cargo) * 0.60;
                // System.out.println("Vrac: "+ChargeEnCoursVrac);
            }

            double chargeTotal = ChargeEnCoursVrac + ChargeEnCoursLiquide;
            System.out.println("Charge Total: " + chargeTotal);

            if (chargeTotal <= difference) {
                System.out.println("Bateau chargé");
                afficheBateauPret(cargo);
            }


        }

        public static void traiterPassagersCargo(Cargo cargo) {
            int nbPassager = trouverNbPassager(cargo);
            if (nbPassager > 0 && nbPassager <= 12) {
                System.out.println(nbPassager + " Passagers participent au voyage");
            } else if (nbPassager > 12) {
                System.out.println("nombre passagers refusés, bateau complet");
            } else if (nbPassager == 0) {
                System.out.println("Pas de passager à transporter");
            }

        }

        public static void traiterEquipageCargo(Cargo cargo) {
            int nbEquipage = trouverUnEquipage(cargo);
            switch (nbEquipage) {
                case 0:
                    System.out.println("Absence d’équipage");
                    break;

                case 7, 8, 9, 10:
                    System.out.println("Les membres d’équipage sont composés de " + nbEquipage + " personnes");
                    break;

                default:
                    System.out.println("Nombre d’équipage supérieur au nombre requis : équipage refusé");
                    break;


            }

        }


    }

    static class Catamaran extends Bateau {

        public Catamaran(int longueur, int largeur, int hauteur, int tirantEau, int propulsion, int vitesse, char categorie,
                         String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage) {
            super(longueur, largeur, hauteur, tirantEau, propulsion, vitesse, categorie, matiereTransportee, nbPassagers,
                    poidsMax, charge, membreEquipage);
        }

        public static void traiterEquipageCatamaran(Catamaran catamaran) {
            int nbEquipage = trouverUnEquipage(catamaran);
            System.out.println(nbEquipage);
            switch (nbEquipage) {
                case 0:
                    System.out.print("Absence d'équipage");
                    break;
                case 1, 2, 3, 4, 5, 6, 7:
                    System.out.print("Les membres d’équipage sont composés de" + nbEquipage + " personnes");
                    break;
                default:
                    System.out.println("Nombre d'équipage supérieur au nombre requis : équipage refusé");
                    break;
            }
        }
    }

    static class Plaisance extends Bateau {

        public Plaisance(int longueur, int largeur, int hauteur, int tirantEau, int propulsion, int vitesse, char categorie,
                         String matiereTransportee, int nbPassagers, int poidsMax, int charge, int membreEquipage) {
            super(longueur, largeur, hauteur, tirantEau, propulsion, vitesse, categorie, matiereTransportee, nbPassagers,
                    poidsMax, charge, membreEquipage);
        }

        public static void traiterEquipagePlaisancier(Plaisance plaisance) {
            int membreEquipage = trouverUnEquipage(plaisance);
            switch (membreEquipage) {
                case 0:
                    System.out.print("Absence équipage");
                    break;
                case 1, 2, 3, 4, 5:
                    System.out.print("Les membres d’équipage sont composés de" + membreEquipage + " personnes");
                    break;
                default:
                    System.out.println("Trop de memebre");
                    break;
            }


        }

        public static void traiterPassagersPlaisanciers(Plaisance plaisance) {
            int nbPassager = trouverNbPassager(plaisance);
            switch (nbPassager) {
                case 0:
                    System.out.print("Pas de passager à transporter");
                    break;
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10:
                    System.out.print(nbPassager + " Passagers ont prix place à bord");
                    break;
                default:
                    System.out.println("Nombre passagers refusés, bateau complet");
                    break;
            }
        }
    }


    //Programme principal
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Rentrez un type de bateau");
        String output = scanner.next();
        switch (output) {

                case "catamaran":
                Catamaran catamaran = new Catamaran(17, 8, 20, 2, 15, 50,
                        'B', "", 10, 5000, 800, 7);
                Catamaran.afficheCaracteristiquesBateau(catamaran);
                Catamaran.traiterEquipageCatamaran(catamaran);
                Catamaran.afficheBateauPret(catamaran);
                Catamaran.afficheCaracteristiquesBateau(catamaran);
                break;

                case "tanker":
                Tanker tanker = new Tanker(366, 52, 20, 8, 96280, 24,
                        'A', "liquides en vrac", 0, 100000, 200000, 20);
                Tanker.afficheCaracteristiquesBateau(tanker);
                Tanker.traiterTanker(tanker);
                Tanker.traiterEquipageTanker(tanker);
                Tanker.afficheCaracteristiquesBateau(tanker);
                
                public void enregistrer(Tanker tanker){
                Connection conn = null;
                PreparedStatement stmt = null;
                    try {
                        // Établir la connexion à la base de données
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bateaux", "root", "root");

                        // Préparer la requête d'insertion
                        String sql = "INSERT INTO tanker (nom, longueur, largeur, tirant_eau, vitesse_max, tonnage, nombre_equipage, classe, type_cargo, niveau_cargo, capacite_cargo, voyage_en_cours, voyage_termine) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        stmt = conn.prepareStatement(sql);

                        // Remplir les paramètres de la requête avec les informations du tanker
                        stmt.setString(1, tanker.nom;
                        stmt.setDouble(2, tanker.longueur);
                        stmt.setDouble(3, tanker.largeur);
                        stmt.setDouble(4, tanker.tirantEau);
                        stmt.setDouble(5, tanker.vitesseMax);
                        stmt.setDouble(6, tanker.tonnage);
                        stmt.setInt(7, tanker.nombreEquipage);
                        stmt.setString(8, Character.toString(tanker.classe));
                        stmt.setString(9, tanker.typeCargo);
                        stmt.setDouble(10, tanker.niveauCargo);
                        stmt.setDouble(11, tanker.capaciteCargo);
                        stmt.setBoolean(12, tanker.voyageEnCours);
                        stmt.setBoolean(13, tanker.voyageTermine);

                        // Exécuter la requête
                        stmt.executeUpdate();

                    } 
                    catch (SQLException e) {
                        throw new RuntimeException(e);
                    } 
                    finally {
                        // Fermer les ressources
                        try {
                            if (stmt != null) {
                                stmt.close();
                            }
                        } catch (SQLException e) {
                            System.out.println(" Erreur");
                        }

                    }
                    }
                

                break;

                case "plaisance":
                Plaisance plaisance = new Plaisance(5, 3, 3, 2, 20, 8,
                        'D', "", 12, 1400, 400, 5);
                Plaisance.afficheCaracteristiquesBateau(plaisance);
                Plaisance.traiterEquipagePlaisancier(plaisance);
                Plaisance.traiterPassagersPlaisanciers(plaisance);
                Plaisance.afficheBateauPret(plaisance);
                Plaisance.afficheCaracteristiquesBateau(plaisance);
                break;

                case "cargo":
                Cargo cargo = new Cargo(150, 50, 20, 8, 50000, 8,
                        'C', "Conteneur", 12, 40000000, 15000000, 10);
                Cargo.afficheCaracteristiquesBateau(cargo);
                Cargo.chargeEnCoursBateau(cargo);
                Cargo.traiterCargoFretMixte(cargo);
                Cargo.traiterPassagersCargo(cargo);
                Cargo.traiterEquipageCargo(cargo);
                Cargo.afficheCaracteristiquesBateau(cargo);
                break;

                default:
                System.out.println("Nous ne possédons pas le bateau que vous voulez dans le magasin");




                            // System.out.println("Hello world!");
        }
    }
}



