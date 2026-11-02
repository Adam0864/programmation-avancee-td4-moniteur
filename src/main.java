public class main {
    public static void main(String[] args) {
        MonitorBAL Bal = new MonitorBAL();
        Producteur prod = new Producteur("a",Bal);
        prod.start();
        Producteur prod2 = new Producteur("b",Bal);
        prod2.start();
        Consommateur cons = new Consommateur(Bal);
        cons.start();
        Consommateur cons2 = new Consommateur(Bal);
        cons2.start();
    }
}
