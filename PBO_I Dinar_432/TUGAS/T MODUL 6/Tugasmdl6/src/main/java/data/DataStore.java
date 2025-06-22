package data;

import users.User;
import users.Mahasiswa;
import users.Admin;
import data.Item;

import java.util.ArrayList;

public class DataStore {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> laporan = new ArrayList<>();

    static {
        userList.add(new Mahasiswa("Herdiana", "2023107311129", "1234"));
        userList.add(new Mahasiswa("Nisrina", "2023107311321", "1234"));
        userList.add(new Admin("admin", "admin", "admin123"));
    }

    public static ArrayList<Item> getLaporan() {
        return laporan;
    }

    public static ArrayList<User> getUsers() {
        return userList;
    }
}
