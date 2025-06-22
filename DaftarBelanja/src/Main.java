import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DaftarBelanjaa daftar = new DaftarBelanjaa();
        int pilihan;

        do {
            System.out.println("\n--- Menu Daftar Belanja ---");
            System.out.println("1. Tambah Item Biasa");
            System.out.println("2. Tambah Item Prioritas");
            System.out.println("3. Tampilkan Semua Item");
            System.out.println("4. Hapus Item");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = input.nextInt();
            input.nextLine(); // konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Item: ");
                    String nama = input.nextLine();
                    System.out.print("Jumlah: ");
                    int jumlah = input.nextInt();
                    daftar.tambahItem(new ItemBelanja(nama, jumlah));
                    break;

                case 2:
                    System.out.print("Nama Item: ");
                    String n = input.nextLine();
                    System.out.print("Jumlah: ");
                    int j = input.nextInt();
                    input.nextLine(); // konsumsi newline
                    System.out.print("Prioritas (TINGGI/SEDANG/RENDAH): ");
                    String p = input.nextLine().toUpperCase();
                    daftar.tambahItem(new ItemPrioritas(n, j, p));
                    break;

                case 3:
                    daftar.tampilkanSemuaItem();
                    break;

                case 4:
                    System.out.print("Masukkan index item yang ingin dihapus: ");
                    int index = input.nextInt();
                    daftar.hapusItem(index);
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        input.close();
    }
}
