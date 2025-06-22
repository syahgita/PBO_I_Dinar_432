package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions {

    public Admin(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return this.nama.equals(inputNama) && this.nim.equals(inputNim);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Pengguna Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> manageItems();
                    case 2 -> manageUsers();
                    case 0 -> System.out.println("Logout...");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        } while (choice != 0);
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\nKelola Barang:");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print("Pilihan: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        if (LoginSystem.reportedItems.isEmpty()) {
                            System.out.println("Belum ada laporan barang.");
                        } else {
                            for (Item item : LoginSystem.reportedItems) {
                                System.out.println("\nNama: " + item.getItemName());
                                System.out.println("Deskripsi: " + item.getDescription());
                                System.out.println("Lokasi: " + item.getLocation());
                                System.out.println("Status: " + item.getStatus());
                            }
                        }
                    }
                    case 2 -> {
                        int i = 0;
                        boolean anyReported = false;
                        for (Item item : LoginSystem.reportedItems) {
                            if (item.getStatus().equals("Reported")) {
                                System.out.println(i + ". " + item.getItemName() + " - " + item.getLocation());
                                anyReported = true;
                            }
                            i++;
                        }
                        if (!anyReported) {
                            System.out.println("Tidak ada barang yang perlu ditandai.");
                            break;
                        }

                        System.out.print("Masukkan indeks barang yang ingin ditandai: ");
                        try {
                            int idx = scanner.nextInt();
                            scanner.nextLine();
                            Item item = LoginSystem.reportedItems.get(idx);
                            if (item.getStatus().equals("Reported")) {
                                item.setStatus("Claimed");
                                System.out.println("Barang berhasil ditandai sebagai diambil.");
                            } else {
                                System.out.println("Barang sudah ditandai sebelumnya.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka!");
                            scanner.nextLine();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Indeks tidak valid!");
                        }
                    }
                    case 0 -> System.out.println("Kembali ke menu utama.");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        } while (choice != 0);
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\nKelola Mahasiswa:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilihan: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Nama Mahasiswa: ");
                        String nama = scanner.nextLine();
                        System.out.print("NIM: ");
                        String nim = scanner.nextLine();
                        LoginSystem.userList.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa berhasil ditambahkan.");
                    }
                    case 2 -> {
                        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
                        String targetNim = scanner.nextLine();
                        Iterator<User> iterator = LoginSystem.userList.iterator();
                        boolean removed = false;
                        while (iterator.hasNext()) {
                            User user = iterator.next();
                            if (user instanceof Mahasiswa && user.getNim().equals(targetNim)) {
                                iterator.remove();
                                removed = true;
                                break;
                            }
                        }
                        System.out.println(removed ? "Mahasiswa berhasil dihapus." : "Mahasiswa tidak ditemukan.");
                    }
                    case 0 -> System.out.println("Kembali ke menu utama.");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        } while (choice != 0);
    }
}
