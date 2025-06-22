public class ItemPrioritas extends ItemBelanja {
    private String prioritas;

    public ItemPrioritas(String namaItem, int jumlah, String prioritas) {
        super(namaItem, jumlah);
        this.prioritas = prioritas;
    }

    public String getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(String prioritas) {
        this.prioritas = prioritas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Prioritas: " + prioritas;
    }
}