import java.util.Scanner;

public class TUGAS1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nimAkhir = "432";
        String usernameAdmin = "dinar" + nimAkhir;
        String passwordAdmin = "sherani" + nimAkhir;
        String mahasiswaNama = "Dinar Syahgita Sherani";
        String mahasiswaNim = "202410370110432";

        System.out.println("Pilih jenis login anda:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih opsi login (1/2): ");

        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (username.equals(usernameAdmin) && password.equals(passwordAdmin)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (nama.equals(mahasiswaNama) && nim.equals(mahasiswaNim)) {
                System.out.println("Login Mahasiswa berhasil!");
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid. Silahkan pilih 1 atau 2.");
        }

        scanner.close();
    }
}