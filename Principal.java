public class Principal {
    public static void main(String[] args) {

        Finder checkZipCode = new Finder();
       Address newAdress = checkZipCode.findAddress("09280510");
        System.out.println(newAdress);
    }
}
