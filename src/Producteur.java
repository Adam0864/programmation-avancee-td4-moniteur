public class Producteur extends Thread{
    private String lettre;
    private MonitorBAL chMonitor;

    public Producteur(String parLettre,MonitorBAL parMonitor){
        lettre = parLettre;
        chMonitor = parMonitor;
    }

    public void run(){
        chMonitor.deposer(lettre);
    }
}
