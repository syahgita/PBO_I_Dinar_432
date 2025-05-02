public class Mahasiswa extends User {

        public Mahasiswa(String nama, String nim) {
            super(nama, nim);  // Memanggil constructor User (superclass)
        }


        @Override
        public boolean login(String inputNama, String inputNim) {
            if (this.getNama().equals(inputNama) && this.getNim().equals(inputNim)) {
                return true;
            }
            return false;
        }


        @Override
        public void displayInfo() {
            System.out.println("Login Sukses! Selamat datang, Mahasiswa " + getNama());
        }
}
