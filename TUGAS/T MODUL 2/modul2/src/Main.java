import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("=== SELAMAT DATANG DI SISTEM LOGIN ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih (1/2): ");
        String pilihan = input.nextLine();

        if (pilihan.equals("1")) {
            System.out.print("Masukkan username admin: ");
            String user = input.nextLine();
            System.out.print("Masukkan password admin: ");
            String pass = input.nextLine();

            if (admin.login(user, pass)) {
                System.out.println("Selamat datang, Admin!");
            } else {
                System.out.println("Akses ditolak. Username atau password salah.");
            }

        } else if (pilihan.equals("2")) {
            System.out.print("Masukkan nama mahasiswa: ");
            String nama = input.nextLine();
            System.out.print("Masukkan NIM mahasiswa: ");
            String nim = input.nextLine();

            if (mahasiswa.login(nama, nim)) {
                mahasiswa.displayInfo(nama);
            }

        } else {
            System.out.println("Pilihan tidak valid. Program dihentikan.");
        }

        input.close();
    }
}
