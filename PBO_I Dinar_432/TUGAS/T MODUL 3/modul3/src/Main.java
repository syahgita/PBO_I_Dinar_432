import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Membuat instance Admin dan Mahasiswa
            Admin admin = new Admin("Dinar Syahgita", "432", "admin123", "admin1");
            Mahasiswa mahasiswa = new Mahasiswa("dinar", "432");

            // Menampilkan menu login
            System.out.println("=== SELAMAT DATANG DI SISTEM LOGIN ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.print("Pilih (1/2): ");
            String pilihan = input.nextLine();

            if (pilihan.equals("1")) {
                // Login Admin
                System.out.print("Masukkan username admin: ");
                String username = input.nextLine();
                System.out.print("Masukkan password admin: ");
                String password = input.nextLine();

                if (admin.login(username, password)) {
                    admin.displayInfo();  // Menampilkan informasi Admin
                } else {
                    System.out.println("Akses ditolak. Username atau password salah.");
                }

            } else if (pilihan.equals("2")) {
                // Login Mahasiswa
                System.out.print("Masukkan nama mahasiswa: ");
                String nama = input.nextLine();
                System.out.print("Masukkan NIM mahasiswa: ");
                String nim = input.nextLine();

                if (mahasiswa.login(nama, nim)) {
                    mahasiswa.displayInfo();  // Menampilkan informasi Mahasiswa
                } else {
                    System.out.println("Login gagal. Nama atau NIM salah.");
                }

            } else {
                System.out.println("Pilihan tidak valid. Program dihentikan.");
            }

            input.close();
        }
}
