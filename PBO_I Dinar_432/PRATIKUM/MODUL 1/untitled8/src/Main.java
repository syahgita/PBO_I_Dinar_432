import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan jenis  kelamin (P/L): ");
        char jenisKelamin = input.next().charAt(0);

        System.out.println("Masukkan tahun lahir: ");
        int tahunLahir = input.nextInt();

        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        String kelamin = (jenisKelamin == 'L' || jenisKelamin == 'l') ? "Laki-laki" : "Perempuan";

        System.out.println("\n--- Data Diri: ---");
        System.out.println("Nama         : " + nama);
        System.out.println("Jenis Kelamin: " + kelamin);
        System.out.println("Umur         : " + umur + " tahun");
    }
}



