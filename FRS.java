public class FRS
{
    private int jumlahMatkul;
    private Mahasiswa mahasiswa;
    private MataKuliah[] mataKuliahDiambil;
    
    public FRS(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        this.mataKuliahDiambil = new MataKuliah[8];
    }
    
    public boolean tambahMatkul(MataKuliah matkul) {
        if (jumlahMatkul < 8) {
            mataKuliahDiambil[jumlahMatkul] = matkul;
            jumlahMatkul++;
            return true;
        }
        return false;
    }
    
    public MataKuliah getMatkul(int index){
        if (index >= 0 && index < jumlahMatkul){
            return mataKuliahDiambil[index];
        }
        return null;
    }
    
    public int getJumlahMatkul(){
        return jumlahMatkul;
    }
}