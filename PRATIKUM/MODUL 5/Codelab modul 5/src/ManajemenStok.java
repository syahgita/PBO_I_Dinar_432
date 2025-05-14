import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Data awal
        daftarBarang.add(new Barang("Buku", 10));
        daftarBarang.add(new Barang("Pulpen", 20));
        daftarBarang.add(new Barang("Penghapus", 15));

        boolean running = true;

        while (running) {
            System.out.println("\n=== Menu Manajemen Stok ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("4. Hapus Barang dari Daftar");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    try {
                        System.out.print("Masukkan nama barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan stok awal: ");
                        int stok = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine(); // clear buffer
                    }
                    break;

                case "2":
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\nDaftar Barang:");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                        }
                    }
                    break;

                case "3":
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dikurangi stoknya.");
                        break;
                    }

                    System.out.println("\nDaftar Barang:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                    }

                    try {
                        System.out.print("Masukkan indeks barang: ");
                        int indeks = scanner.nextInt();
                        System.out.print("Masukkan jumlah yang ingin diambil: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        Barang barang = daftarBarang.get(indeks);
                        if (jumlah > barang.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
                        }

                        barang.setStok(barang.getStok() - jumlah);
                        System.out.println("Stok berhasil dikurangi. Sisa stok: " + barang.getStok());

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine(); // clear buffer
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks barang tidak valid.");
                    } catch (StokTidakCukupException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "4":
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dihapus.");
                        break;
                    }

                    System.out.println("\nDaftar Barang:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                    }

                    try {
                        System.out.print("Masukkan indeks barang yang ingin dihapus: ");
                        int indeksHapus = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        Barang removed = daftarBarang.remove(indeksHapus);
                        System.out.println("Barang \"" + removed.getNama() + "\" telah dihapus dari daftar.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine(); // clear buffer
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid.");
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}


