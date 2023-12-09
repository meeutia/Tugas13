import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final String SUPERMARKET_NAME = "TOKO ADA AJA";
    private static final String CORRECT_USERNAME = "user"; // username untuk login
    private static final String CORRECT_PASSWORD = "123456"; // password untuk login
    private static final String CAPTCHA = "iYaa"; // kode captcha yang benar untuk login
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        long totalBayar = 0;

        // Implementasi dari Login
        if (login(scanner)) {
            // Membuat daftar barang (Polimorphisme)
            ArrayList<Barang> daftarBarang = new ArrayList<>();
            daftarBarang.add(new Elektronik());
            daftarBarang.add(new NonElektronik());

            // Menginisialisasi keranjang belanja
            Map<Barang, Integer> keranjangBelanja = new HashMap<>();

            // Menampilkan list barang
            System.out.println(" ");
            System.out.println("=======List Barang======");
            for (Barang barang : daftarBarang) {
                barang.tampilkanInfo();
            }

            // Exception Handling
            try {
                // Additional fields for customer data
                System.out.print("\nNama Pelanggan: ");
                String namaPelanggan = scanner.nextLine();
                System.out.print("No. HP Pelanggan: ");
                String noHpPelanggan = scanner.nextLine();
                System.out.print("Alamat Pelanggan: ");
                String alamatPelanggan = scanner.nextLine();

                // Additional fields for purchase data
                System.out.println("\n-----------------------");
                System.out.println("TOKO APA AJA ADA");
                System.out.println(DateUtil.getCurrentDateTime());
                System.out.println("\n========================");
                System.out.println("DATA PELANGGAN");
                System.out.println("---------------------");
                System.out.println("Nama Pelanggan: " + namaPelanggan);
                System.out.println("No. HP         : " + noHpPelanggan);
                System.out.println("Alamat         : " + alamatPelanggan);
                System.out.println("++++++++++++++++++++++++");

                System.out.println("\nDATA PEMBELIAN BARANG");
                System.out.println("------------------------------");

                for (Barang barang : daftarBarang) {
                    System.out.print("Jumlah Beli " + barang.nama + ": ");
                    int jumlahBeli = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    keranjangBelanja.put(barang, jumlahBeli);
                }

                // Iterate over the shopping cart entries
                for (Map.Entry<Barang, Integer> entry : keranjangBelanja.entrySet()) {
                    Barang barang = entry.getKey();
                    int jumlahBeli = entry.getValue();

                    System.out.println("Kode Barang     : " + barang.kode); // Assuming a new field "kode" in Barang class
                    System.out.println("Nama Barang     : " + barang.nama);
                    System.out.println("Harga Barang    : Rp. " + barang.harga);
                    System.out.println("Jumlah Beli     : " + jumlahBeli);

                    long totalBayarBarang = barang.hitungTotalBayar(jumlahBeli);
                    System.out.println("Total Bayar     : Rp. " + totalBayarBarang);
                    System.out.println("++++++++++++++++++++++++");

                    totalBayar += totalBayarBarang;
                }

                System.out.println("\nTotal Bayar Keseluruhan: Rp. " + totalBayar);
                System.out.println("++++++++++++++++++++++++");

                // Additional fields for cashier data
                System.out.println("Kasir: " + getKasirInfo()); // Assuming a method to get cashier information

            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                scanner.close();
            }
        } else {
            System.out.println("Login failed. Exiting program.");
        }
    }

    // Method tambahan untuk mendapatkan informasi kasir
    private static String getKasirInfo() {
        return "Meutia"; 
    }

    // Mengimplementasi login
    private static boolean login(Scanner scanner) {
        System.out.println("SELAMAT DATANG DI " + SUPERMARKET_NAME);
        System.out.println("===== Login =====");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Kode Captcha: " + CAPTCHA);

        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) { //method equals()
            // CAPTCHA
            System.out.print("\nEnter the CAPTCHA (Case-insensitive): ");
            String captchaInput = scanner.nextLine();

            if (captchaInput.equalsIgnoreCase(CAPTCHA)) { //method equalsIgnoreCase()
                System.out.println("Login successful. Welcome, " + CORRECT_USERNAME + "!");
                return true;
            } else {
                System.out.println("CAPTCHA verification failed. Exiting program.");
                return false;
            }
        } else {
            System.out.println("Incorrect username or password. Exiting program.");
            return false;
        }
    }
}
