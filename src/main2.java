import java.util.Random;
public class main2 {
    public static void main(String[] args) {

        // on initialise une boulangerie, et une variable aléatoire pour nos client
        final Boulangerie boulangerie = new Boulangerie();
        final Random rand = new Random();

        // notre boulanger est un runnable
        Boulanger boulanger = new Boulanger(boulangerie);

        // notre mangeur est aussi un runnable
        Mangeur mangeur = new Mangeur(boulangerie,rand);

        Thread[] boulangers = new Thread[5];
        Thread[] mangeurs = new Thread[2];

        // préparation des boulangers
        for (int i = 0; i < boulangers.length; i++) {
            boulangers[i] = new Thread(boulanger);
        }

        // préparation des mangeurs
        for (int i = 0; i < mangeurs.length; i++) {
            mangeurs[i] = new Thread(mangeur);
        }

        // lancement des boulangers
        for (int i = 0; i < boulangers.length; i++) {
            boulangers[i].start();
        }

        // lancement des mangeurs
        for (int i = 0; i < mangeurs.length; i++) {
            mangeurs[i].start();
        }
        // temporisation pour stopper observer le système 20 secondes
        try {
            Thread.sleep(20000) ;
        }  catch (InterruptedException e) {
        }

        // arrêt de notre système
        for (int i =  0 ; i < boulangers.length ; i++) {
            // interruption des producteurs
            boulangers[i].interrupt() ;
        }

        // dépôt des pilules empoisonnées
        for (int i =  0 ; i < mangeurs.length ; i++) {
            boulangerie.deposePainEmpoisonne() ;
        }
    }

}