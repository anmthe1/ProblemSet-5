public class EmailApp {
private static Email em1;
    public static void main(String[] args){
         em1 = new Email("John", "Smith");

        em1.setAlternateEmail("js@gmail.com");
        System.out.println(em1.showInfo());
        //System.out.println(em1.getAlternateEmail());
    }
}
