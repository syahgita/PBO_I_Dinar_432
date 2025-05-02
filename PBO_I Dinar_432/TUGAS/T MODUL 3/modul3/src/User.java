public class User {
        private String nama;
        private String nim;

        // Constructor
        public User(String nama, String nim) {
            this.nama = nama;
            this.nim = nim;
        }

        // Getter and Setter
        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        // Method login (akan dioverride oleh subclass)
        public boolean login(String nama, String nim) {
            return false;  // Default login behavior, akan di-override
        }

        // Method displayInfo
        public void displayInfo() {
            System.out.println("Nama: " + nama);
            System.out.println("NIM: " + nim);
        }
}

