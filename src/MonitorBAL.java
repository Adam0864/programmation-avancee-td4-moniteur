public class MonitorBAL {
    private String bufferLettre="";
    private boolean available=true;

    public MonitorBAL(){}

    public synchronized void deposer(String lettre){
        while (!available){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        available=false;
        bufferLettre = lettre;
        notifyAll();
    }

    public synchronized String retirer(){
        while (available){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        available=true;
        notifyAll();
        return bufferLettre;
    }
}
