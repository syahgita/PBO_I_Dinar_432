import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nimAkhir = "432";
        String usernameAdmin = "Admin" + nimAkhir;
        String passwordAdmin = "password" + nimAkhir;

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
            System.out.println("Fitur login Mahasiswa belum tersedia.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}