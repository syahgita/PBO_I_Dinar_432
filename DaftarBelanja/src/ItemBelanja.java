public class ItemBelanja {
    private String namaItem;
    private int jumlah;

    public ItemBelanja(String namaItem, int jumlah) {
        this.namaItem = namaItem;
        this.jumlah = jumlah;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String toString() {
        return "Item: " + namaItem + ", Jumlah: " + jumlah;
    }
}
