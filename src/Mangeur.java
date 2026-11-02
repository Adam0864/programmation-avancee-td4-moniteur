import java.util.Random;

public class Mangeur implements Runnable {
    private Boulangerie boulangerie;
    private Random rand;

    public Mangeur(Boulangerie parBoulangerie,Random parRand){
        boulangerie = parBoulangerie;
        rand = parRand;
    }

    public  void run() {

        try {

            while (true) {
                // nos mangeurs mangent de façon aléatoire...
                Thread.sleep(rand.nextInt(1000)) ;
                Pain pain = boulangerie.achete() ;
                if (pain != null) {

                    if (pain == Pain.PAIN_EMPOISONNE) {
                        System.out.println("Je meurs !") ;
                        Thread.currentThread().interrupt() ;
                    }  else {
                        System.out.println("[" + Thread.currentThread().getName() +  "]" +
                                "[" + boulangerie.getStock() +  "] miam miam") ;
                    }

                }  else {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" +
                            "[" + boulangerie.getStock() +  "] j'ai faim") ;
                }
            }

        }  catch (InterruptedException e) {
        }
    }
}

