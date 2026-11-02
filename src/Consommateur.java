public class Consommateur extends Thread{
    private String lettre="";
    private MonitorBAL chMonitor;

    public Consommateur(MonitorBAL parMonitor){
        chMonitor = parMonitor;
    }

    public void run(){
        lettre = chMonitor.retirer();
    }
}
