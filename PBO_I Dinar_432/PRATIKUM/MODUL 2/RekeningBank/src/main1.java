public class main1 {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        rekening1.nomorRekening = "202410370110431";
        rekening1.namaPemilik = "Novan";
        rekening1.saldo = 700000;

        rekening2.nomorRekening = "202410370110432";
        rekening2.namaPemilik = "Dinar";
        rekening2.saldo = 1000000;

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        rekening1.setorUang(400000);
        rekening1.tarikUang(500000);

        rekening2.setorUang(500000);
        rekening2.tarikUang(350000);

        System.out.println();
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}