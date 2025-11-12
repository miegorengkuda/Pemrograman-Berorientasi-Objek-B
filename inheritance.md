Dokumentasi Tugas atau Project mata kuliah Pemrograman Berorientasi Objek (B)

Dafa Kumara Sahasika (5025241112)

## Inheritance
Inheritance (pewarisan) adalah mekanisme dalam pemrograman berorientasi objek (OOP) yang memungkinkan sebuah kelas (child class) untuk mewarisi atribut dan metode dari kelas lain (parent class). 
Tujuannya adalah untuk meningkatkan struktur program, menghindari pengulangan kode, dan meningkatkan keterbacaan serta pemeliharaan kode.

Sistem manajemen rental untuk berbagai jenis kendaraan. Semua kendaraan memiliki merk, model, dan tahunProduksi. 
Khusus untuk Mobil dan Motor, ditambahkan atribut jumlahRoda. Sementara untuk Sepeda, ditambah atribut jenis Sepeda (misalnya BMX, balap).
Memuat rancangan class diagram dengan menggunakan inheritance.
Memuat aplikasi yang bisa menampilkan list kendaraan yang tersedia, dan juga daftar nama penyewa beserta informasi detail kendaraan yang disewa.

Membuat class yang terdiri dari `Kendaraan.java`, `Mobil.java`, `Motor.java`, `Sepeda.java`, `Penyewa.java`, dan `Main.java`

<img width="2080" height="1041" alt="Screenshot 2025-11-12 231732" src="https://github.com/user-attachments/assets/5f537164-1cf4-4885-8589-74ff6defff64" />


Alur kerjanya:
1. Kelas Dasar dan Turunan
   - Kendaraan adalah kelas induk yang menyimpan atribut umum: merk, model, dan tahunProduksi.
   - Mobil, Motor, dan Sepeda merupakan turunan Kendaraan yang menambahkan atribut khusus (misalnya jumlahRoda untuk mobil/motor dan jenisSepeda untuk sepeda).
   - Masing-masing override fungsi displayInfo() untuk menampilkan detail sesuai jenis kendaraan.
2. Kelas Penyewa
   - Menyimpan nama penyewa dan pointer ke kendaraan yang disewa (Kendaraan* kendaraanDisewa).
3. Proses Input di main()
   - User memasukkan daftar kendaraan (bisa mobil, motor, atau sepeda).
   - Program menyimpannya ke dalam vector<Kendaraan*> listKendaraan.
   - User lalu memilih kendaraan mana yang ingin disewa.
4. Mekanisme Penyewaan
   - Saat kendaraan dipilih untuk disewa, program membuat objek Penyewa baru dan menghapus kendaraan tersebut dari listKendaraan.
   - Artinya, kendaraan itu tidak akan muncul lagi dalam daftar kendaraan yang tersedia, sehingga tidak bisa disewa dua kali.
5. Output Akhir
   - Program menampilkan dua daftar:
   - Kendaraan yang masih tersedia.
   - Penyewa beserta detail kendaraan yang mereka sewa.



`Kendaraan.java`
```java
import java.util.*;

class Kendaraan {
    String merk;
    String model;
    int tahunProduksi;

    public Kendaraan(String merk, String model, int tahunProduksi) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }

    public void tampilkanInfo() {
        System.out.println(merk + " " + model + " - Tahun " + tahunProduksi  );
    }
}
```

`Mobil.java`
```java
import java.util.*;

class Mobil extends Kendaraan {
    int jumlahRoda;

    public Mobil(String merk, String model, int tahunProduksi) {
        super(merk, model, tahunProduksi);
        this.jumlahRoda = 4;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Mobil: " + merk + " " + model + " - Tahun " + tahunProduksi + ", Roda: " + jumlahRoda);
    }
}

```

`Motor.java`
```java
import java.util.*;

class Motor extends Kendaraan {
    int jumlahRoda;

    public Motor(String merk, String model, int tahunProduksi) {
        super(merk, model, tahunProduksi);
        this.jumlahRoda = 2;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Motor: " + merk + " " + model + " - Tahun " + tahunProduksi + ", Roda: " + jumlahRoda);
    }
}
```

`Sepeda.java`
```java
import java.util.*;

class Sepeda extends Kendaraan {
    String jenisSepeda;

    public Sepeda(String merk, String model, int tahunProduksi, String jenisSepeda) {
        super(merk, model, tahunProduksi);
        this.jenisSepeda = jenisSepeda;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Sepeda: " + merk + " " + model + " - Tahun " + tahunProduksi + ", Jenis: " + jenisSepeda);
    }
}
```

`Penyewa.java`
```java
import java.util.*;

class Penyewa {
    String nama;
    Kendaraan kendaraan;

    public Penyewa(String nama, Kendaraan kendaraan) {
        this.nama = nama;
        this.kendaraan = kendaraan;
    }

    public void tampilkanData() {
        System.out.println("Nama Penyewa: " + nama);
        System.out.print("Menyewa: ");
        kendaraan.tampilkanInfo();
        System.out.println();
    }
}
```

`Main.java`
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Kendaraan> daftarKendaraan = new ArrayList<>();
        List<Penyewa> daftarPenyewa = new ArrayList<>();

        while (true) {
            System.out.println("\n=== MENU RENTAL KENDARAAN ===");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Lihat Daftar Kendaraan");
            System.out.println("3. Tambah Penyewa");
            System.out.println("4. Lihat Daftar Penyewa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = sc.nextInt();
            sc.nextLine(); // buang newline

            switch (pilih) {
                case 1:
                    System.out.println("\nJenis Kendaraan: 1.Mobil  2.Motor  3.Sepeda");
                    System.out.print("Pilih jenis: ");
                    int jenis = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Masukkan merk: ");
                    String merk = sc.nextLine();
                    System.out.print("Masukkan model: ");
                    String model = sc.nextLine();
                    System.out.print("Masukkan tahun produksi: ");
                    int tahun = sc.nextInt();
                    sc.nextLine();

                    if (jenis == 1) {
                        daftarKendaraan.add(new Mobil(merk, model, tahun));
                    } else if (jenis == 2) {
                        daftarKendaraan.add(new Motor(merk, model, tahun));
                    } else if (jenis == 3) {
                        System.out.print("Masukkan jenis sepeda (BMX/Balap/dll): ");
                        String jenisSepeda = sc.nextLine();
                        daftarKendaraan.add(new Sepeda(merk, model, tahun, jenisSepeda));
                    } else {
                        System.out.println("Jenis tidak valid.");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Daftar Kendaraan ===");
                    if (daftarKendaraan.isEmpty()) {
                        System.out.println("Belum ada kendaraan yang terdaftar.");
                    } else {
                        int i = 1;
                        for (Kendaraan k : daftarKendaraan) {
                            System.out.print(i++ + ". ");
                            k.tampilkanInfo();
                        }
                    }
                    break;

                case 3:
                    if (daftarKendaraan.isEmpty()) {
                        System.out.println("Belum ada kendaraan yang bisa disewa.");
                        break;
                    }
                    System.out.print("\nMasukkan nama penyewa: ");
                    String nama = sc.nextLine();

                    System.out.println("Pilih kendaraan yang akan disewa:");
                    for (int i = 0; i < daftarKendaraan.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        daftarKendaraan.get(i).tampilkanInfo();
                    }

                    System.out.print("Pilih nomor kendaraan: ");
                    int idx = sc.nextInt();
                    sc.nextLine();

                    if (idx > 0 && idx <= daftarKendaraan.size()) {
                        Penyewa p = new Penyewa(nama, daftarKendaraan.get(idx - 1));
                        daftarPenyewa.add(p);
                        daftarKendaraan.remove(idx - 1);
                        System.out.println("Penyewa berhasil ditambahkan!");
                    } else {
                        System.out.println("Nomor kendaraan tidak valid!");
                    }
                    break;

                case 4:
                    System.out.println("\n=== Daftar Penyewa ===");
                    if (daftarPenyewa.isEmpty()) {
                        System.out.println("Belum ada penyewa.");
                    } else {
                        for (Penyewa p : daftarPenyewa) {
                            p.tampilkanData();
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih!");
                    sc.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
```

Ini adalah hasil output programnya

<img width="1242" height="1131" alt="Screenshot 2025-11-12 231717" src="https://github.com/user-attachments/assets/c95d3506-0fae-4d54-a495-74b18d997382" />
