public class MainApp {
    public static void main(String[] args) {

        Bank b = new SBI();
        b.welcome();
        b.rateOfInterest();

        System.out.println();
        
        Payment p = new UPI();
        p.pay(500);
    }
}
