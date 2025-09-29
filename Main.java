public class Main {
    public static void main(String[] args) {
        // INISIALISASI
        Dosen d1 = new Dosen("Pak Fajar Baskoro", "198001011");
        Dosen d2 = new Dosen("Pak Royanna", "197502022");
        
        Mahasiswa mhs1 = new Mahasiswa("Budi", "5025241258");
        Mahasiswa mhs2 = new Mahasiswa("Cintya", "5025241289");
        Mahasiswa mhs3 = new Mahasiswa("Dani", "5025241000");

        // Mata Kuliah
        MataKuliah mk1 = new MataKuliah("IF305", "Pemrograman Web", 3, d1, 2, "Senin 07.00");
        MataKuliah mk2 = new MataKuliah("IF105", "PBO", 3, d1, 5, "Selasa 13.30");
        MataKuliah mk3 = new MataKuliah("IF104", "Jaringan Komputer", 4, d2, 3, "Rabu 7.00");


        // --- PROSES FRS ---
        FRS frsBudi = new FRS(mhs1);
        frsBudi.tambahMatkul(mk1);
        frsBudi.tambahMatkul(mk2);
        
        FRS frsCintya = new FRS(mhs2);
        frsCintya.tambahMatkul(mk1); 
        frsCintya.tambahMatkul(mk3);


        // --- PROSES DAFTAR MAHASISWA KE KELAS ---
        mk1.daftarMahasiswa(mhs1); 
        mk1.daftarMahasiswa(mhs2); 
        mk1.daftarMahasiswa(mhs3); // Gagal

        mk2.daftarMahasiswa(mhs1); 
        
        mk3.daftarMahasiswa(mhs2); 
        mk3.daftarMahasiswa(mhs3); 

        // 1. TAMPILKAN FRS 
        System.out.println("\n--- DAFTAR MATA KULIAH YANG DIAMBIL (FRS) ---");
        
        // FRS Budi
        System.out.println("\n[FRS " + mhs1.getNama() + "]: Total " + frsBudi.getJumlahMatkul() + " mata kuliah.");
        // Loop untuk mengambil mata kuliah satu per satu
        for (int i = 0; i < frsBudi.getJumlahMatkul(); i++) {
            System.out.println("  - " + frsBudi.getMatkul(i).toString());
        }
        
        
        System.out.println("\n[FRS " + mhs2.getNama() + "]: Total " + frsCintya.getJumlahMatkul() + " mata kuliah.");
        for (int i = 0; i < frsCintya.getJumlahMatkul(); i++) {
            System.out.println("  - " + frsCintya.getMatkul(i).toString());
        }
        
        
        
        
        
    }

    
}