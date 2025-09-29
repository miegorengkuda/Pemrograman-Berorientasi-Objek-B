public class MataKuliah
{
    private String kode;
    private String nama;
    private int sks;
    private Dosen dosenPengampu;
    private int kapasitas;
    private int jumlahPeserta;
    private String jadwal;
    private Mahasiswa[] peserta;
    
    public MataKuliah (String kode, String nama, int sks, Dosen dosenPengampu,
    int kapasitas, String jadwal){
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.dosenPengampu= dosenPengampu;
        this.kapasitas= kapasitas;
        this.jadwal= jadwal;
        this.peserta= new Mahasiswa[kapasitas];
        this.jumlahPeserta = 0;
    }
    
    public String getKode() { 
        return kode; 
    }
    public String getNama() {
        return nama; 
    }
    public int getSks() {
        return sks; 
    }
    public Dosen getDosenPengampu() {
        return dosenPengampu; 
    }
    public String getJadwal() {
        return jadwal; 
    }
    public int getKapasitas() {
        return kapasitas; 
    }
    public int getJumlahPeserta() {
        return jumlahPeserta; 
    }

    public boolean sudahTerdaftar(Mahasiswa m) {
        for (int i = 0; i < jumlahPeserta; i++) {
            if (peserta[i].getNim().equals(m.getNim())) {
                return true;
            }
        }
        return false;
    }

    public boolean daftarMahasiswa(Mahasiswa m) {
        if (sudahTerdaftar(m)) {
            return false;
        }
        if (jumlahPeserta < kapasitas) {
            peserta[jumlahPeserta] = m;
            jumlahPeserta++;
            return true;
        }
        return false;
    }

    public Mahasiswa[] getDaftarPeserta() {
        Mahasiswa[] result = new Mahasiswa[jumlahPeserta];
        for (int i = 0; i < jumlahPeserta; i++) {
            result[i] = peserta[i];
        }
        return result;
    }
    
    @Override
    public String toString() {
        
        return kode + " | " + nama + " (" + sks + " SKS) | Dosen: " + dosenPengampu.getNama();
    }
}