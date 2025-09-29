public class Dosen
{
    private String nama;
    private String nid;
    
    public Dosen (String nama, String nid) {
        this.nama= nama;
        this.nid= nid;
    }
    
    public String getNama (){
        return nama;
    }
    public String getNid () {
        return nid;
    }
}