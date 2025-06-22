package com.praktikum.users;

public abstract class User {
    protected String nama;
    protected String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public abstract boolean login(String inputNama, String inputNim);
    public abstract void displayAppMenu();
}
