public class Main {
    public static void main(String[] args) {

        KarakterGame umum = new KarakterGame("Karakter umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        System.out.println("Status awal :");
        System.out.println("brimstone memiliki kesehatan : " + brimstone.getKesehatan());
        System.out.println("viper memiliki kesehatan : " + viper.getKesehatan());
        System.out.println();

        brimstone.serang(viper);
        System.out.println();
        viper.serang(brimstone);
    }
}
