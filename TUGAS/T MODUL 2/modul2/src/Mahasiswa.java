import java.util.HashMap;

public class Mahasiswa {
    private HashMap<String, String> dataMahasiswa = new HashMap<>();

    public Mahasiswa() {
        dataMahasiswa.put("dinar", "432");
    }

    public boolean login(String nama, String nim) {
        if (dataMahasiswa.containsKey(nama) && dataMahasiswa.get(nama).equals(nim)) {
            System.out.println("Login Mahasiswa BERHASIL!\n");
            return true;
        } else {
            System.out.println("Login Mahasiswa GAGAL. Nama atau NIM salah.\n");
            return false;
        }
    }

    public void displayInfo(String nama) {
        System.out.println("=== Info Mahasiswa ===");
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + dataMahasiswa.get(nama));
        System.out.println("======================\n");
    }
}


