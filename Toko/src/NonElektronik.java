// Kelas turunan dari Barang, menggunakan interface Harga
class NonElektronik extends Barang implements Harga {
    public NonElektronik() {
        super("NE001", "Gurita hp", 3000);
    }

    @Override
    public long hitungTotalBayar(long jumlah) {
        return (long) harga * jumlah;
    }
}