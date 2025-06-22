package users;

public class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim, String password) {
        super(nama, nim, password);
    }

    @Override
    public String getRole() {
        return "mahasiswa";
    }
}
