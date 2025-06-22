package com.example.tugasmdl6;

import data.DataStore;
import data.Item;
import users.User;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== Daftar User ===");
        ArrayList<User> users = DataStore.getUsers();
        for (User user : users) {
            System.out.println("Nama: " + user.getNama());
            System.out.println("NIM/ID: " + user.getNim());
            System.out.println("Role: " + user.getRole());
            System.out.println();
        }

        System.out.println("=== Daftar Laporan ===");
        ArrayList<Item> laporan = DataStore.getLaporan();
        if (laporan.isEmpty()) {
            System.out.println("Belum ada laporan.");
        } else {
            for (Item item : laporan) {
                System.out.println("Nama Barang: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("Status: " + item.getStatus());
                System.out.println();
            }
        }
    }
}
