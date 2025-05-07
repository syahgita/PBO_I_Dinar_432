package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        System.out.println("=== Sistem Login ===");
        System.out.print("Masukkan peran (admin/mahasiswa): ");
        String role = scanner.nextLine();

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        if (role.equalsIgnoreCase("admin") && nama.equals("dinar") && nim.equals("432")) {
            currentUser = new Admin("dinar", "432", nama, nim);
        } else if (role.equalsIgnoreCase("mahasiswa") && nama.equals("syahgita") && nim.equals("mhs432")) {
            currentUser = new Mahasiswa(nama, nim);
        }

        if (currentUser != null && currentUser.login(nama, nim)) {
            System.out.println("Login berhasil!");
            currentUser.displayAppMenu();
        } else {
            System.out.println("Login gagal. Nama atau NIM salah.");
        }
    }
}
