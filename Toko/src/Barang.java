// Kelas utama untuk merepresentasikan barang elektronik
class Barang {
    String nama;
    long harga;
    String kode;

    public Barang(String kode, String nama, long harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.println(nama + " = Rp. " + harga);
    }

    public long hitungTotalBayar(long jumlahBeli) {
        return 0;
    }
}