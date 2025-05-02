package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Buku nonFiksi = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku fiksi = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        nonFiksi.displayInfo();
        fiksi.displayInfo();

        System.out.println();

        Anggota anggota1 = new Anggota("Dinar ", "i432");
        Anggota anggota2 = new Anggota("Santun ", "i429");

        anggota1.tampilkanInfo();
        anggota2.tampilkanInfo();

        System.out.println();

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);

        System.out.println();

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}

