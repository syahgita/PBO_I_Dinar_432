package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

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
        int choice = -1;
        do {
            System.out.println("\nMenu Mahasiswa:");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Barang Terlapor");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> reportItem();
                    case 2 -> viewReportedItems();
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
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String name = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String desc = scanner.nextLine();
        System.out.print("Lokasi: ");
        String loc = scanner.nextLine();

        Item item = new Item(name, desc, loc);
        LoginSystem.reportedItems.add(item);
        System.out.println(">> Barang berhasil dilaporkan!");
    }

    @Override
    public void viewReportedItems() {
        boolean hasReport = false;
        for (Item item : LoginSystem.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println("\nNama: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                hasReport = true;
            }
        }
        if (!hasReport) {
            System.out.println(">> Belum ada barang yang dilaporkan.");
        }
    }
}
