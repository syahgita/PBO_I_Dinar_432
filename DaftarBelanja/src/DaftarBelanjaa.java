import java.util.ArrayList;

public class DaftarBelanjaa {
    private ArrayList<ItemBelanja> daftar;

    public DaftarBelanjaa() {
        daftar = new ArrayList<>();
    }

    public void tambahItem(ItemBelanja item) {
        daftar.add(item);
        System.out.println("Item berhasil ditambahkan.");
    }

    public void hapusItem(int index) {
        try {
            ItemBelanja removed = daftar.remove(index);
            System.out.println("Item '" + removed.getNamaItem() + "' berhasil dihapus.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index tidak valid. Gagal menghapus item.");
        }
    }

    public void tampilkanSemuaItem() {
        if (daftar.isEmpty()) {
            System.out.println("Daftar belanja kosong.");
        } else {
            System.out.println("Daftar Belanja:");
            for (int i = 0; i < daftar.size(); i++) {
                System.out.println(i + ". " + daftar.get(i));
            }
        }
    }
}
