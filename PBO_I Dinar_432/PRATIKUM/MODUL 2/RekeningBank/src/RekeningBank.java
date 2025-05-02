 public class RekeningBank {
     String nomorRekening, namaPemilik;
     double saldo;

     public void tampilkanInfo() {
         System.out.println("nomor Rekening :" + nomorRekening);
         System.out.println("nama Pemilik :" + namaPemilik);
         System.out.println("Saldo :Rp" + saldo);

     }


     public void setorUang(double jumlah) {
         if (jumlah > 0) {
             saldo += jumlah;
             System.out.println(namaPemilik + " menyetor Rp " + jumlah + ". saldo sekarang : Rp" + saldo);
         } else {
             System.out.println("jumlah setoran harus lebih dari 0.");
         }

     }
         public void tarikUang (double jumlah){
             if (saldo >= jumlah) {
                 saldo -= jumlah;
                 System.out.println(namaPemilik + " menarik Rp " + jumlah + "(Berhasil) saldo sekarang : Rp " + saldo);
             } else if (jumlah > saldo) {
                 System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, saldo tidak mencukupi) saldo saat ini : Rp" + saldo);
             } else {
                 System.out.println("Saldo tidak cukup untuk menarik Rp " + jumlah);
             }
             System.out.println("Saldo sekarang: Rp " + saldo);
             System.out.println("-----------------------");
         }


 }
