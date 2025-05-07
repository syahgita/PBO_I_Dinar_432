package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    private static class LaporanBarang {
        String nama, deskripsi, lokasi;

        LaporanBarang(String nama, String deskripsi, String lokasi) {
            this.nama = nama;
            this.deskripsi = deskripsi;
            this.lokasi = lokasi;
        }
    }

    private static List<LaporanBarang> laporanList = new ArrayList<>();

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return this.nama.equals(inputNama) && this.nim.equals(inputNim);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu Mahasiswa:");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> reportItem();
                case 2 -> viewReportedItems();
                case 0 -> System.out.println("Logout berhasil.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        laporanList.add(new LaporanBarang(nama, deskripsi, lokasi));
        System.out.println("\n>> Laporan berhasil disimpan <<");
    }

    public void viewReportedItems() {
        if (laporanList.isEmpty()) {
            System.out.println(">> Belum ada laporan yang tersedia <<");
        } else {
            System.out.println("\n== Daftar Laporan Barang ==");
            int i = 1;
            for (LaporanBarang laporan : laporanList) {
                System.out.println("Laporan " + (i++) + ":");
                System.out.println("Nama Barang: " + laporan.nama);
                System.out.println("Deskripsi: " + laporan.deskripsi);
                System.out.println("Lokasi: " + laporan.lokasi);
                System.out.println();
            }
        }
    }
}