package com.praktikum.main;

import com.praktikum.models.Item;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initUsers();

        while (true) {
            System.out.println("\n=== Sistem Login ===");
            System.out.print("Masukkan nama (atau ketik 'exit' untuk keluar): ");
            String nama = scanner.nextLine();
            if (nama.equalsIgnoreCase("exit")) {
                System.out.println("Terima kasih, program selesai.");
                break;
            }
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            User currentUser = null;
            for (User user : userList) {
                if (user.login(nama, nim)) {
                    currentUser = user;
                    break;
                }
            }

            if (currentUser != null) {
                System.out.println("Login berhasil sebagai " + currentUser.getClass().getSimpleName());
                currentUser.displayAppMenu();
            } else {
                System.out.println("Login gagal. Nama atau NIM salah.");
            }
        }
    }

    private static void initUsers() {
        userList.add(new Admin("dinar", "432"));
        userList.add(new Mahasiswa("syahgita", "mhs432"));
    }
}
