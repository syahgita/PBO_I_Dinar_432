public class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);  // Memanggil constructor User (superclass)
        this.username = username;
        this.password = password;
    }


    @Override
    public boolean login(String inputUsername, String inputPassword) {
        if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
            return true;
        }
        return false;
    }


    @Override
    public void displayInfo() {
        System.out.println("Login Sukses! Selamat datang, Admin " + getNama());
    }
}
