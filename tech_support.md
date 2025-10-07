Dokumentasi Tugas atau Project mata kuliah Pemrograman Berorientasi Objek (B)

Dafa Kumara Sahasika (5025241112)

## Membuat Tech Support

TechSupport merupakah aplikasi chat untuk pendukung pekerjaan teknis. 
Sebagai contoh pengembangan bertahap awalnya sangat sederhana: jika pengguna memasukkan sesuatu, sistem memberi jawaban tetap. 
Kemudian diperluas agar sistem bisa mengenali “kata kunci” dalam masukan pengguna dan memberi jawaban yang lebih relevan.

Idenya: kita punya kelas yang menyimpan peta (map) dari kata kunci ke jawaban yang sesuai, lalu ketika pengguna mengetik kalimat, 
kita memecah kalimat menjadi kata (token), dan jika ada kata yang cocok, kita pilih jawaban terkait.

<img width="771" height="481" alt="Screenshot 2025-10-07 150918" src="https://github.com/user-attachments/assets/e95d4ada-e77d-4ab5-8b23-8545cf915897" />
<img width="772" height="486" alt="Screenshot 2025-10-07 150942" src="https://github.com/user-attachments/assets/74a4b96b-ceca-4ed1-a2ab-4a732925a9d7" />



```java
import java.util.Map;  
import java.util.HashMap;  
import java.util.Random;  
public class TechSupport {  
   private Map<String, String> responses;  
   private Random random;  
   public TechSupport() {  
     responses = new HashMap<>();  
     random = new Random();  
     // beberapa pasangan kata kunci → respons  
     responses.put("error", "Apakah Anda menerima pesan kesalahan? Coba restart sistem.");  
     responses.put("help", "Apa yang bisa saya bantu?");  
     responses.put("crash", "Kapan crash terjadi? Apakah ada pesan spesifik?");  
     responses.put("slow", "Sudahkah Anda memeriksa penggunaan CPU dan RAM?"); 
     responses.put("network", "Sudahkah anda memeriksa jaringan interner anda?");  
     responses.put("login", "Apakah anda yakin Username dan Password sudah benar?");  
     responses.put("delete", "File yang sudah dihapus masih ada di Recycle bin. Coba periksa disana");  
     responses.put("update", "Update untuk memperbaiki bug.");
     responses.put("font", "Apakah ukuran font terlalu besar / terlalu kecil? Anda bisa ubah ukuran font di pengaturan tampilan.");  
     responses.put("dark", "Apakah anda ingin mengaktifkan mode gelap? Anda bisa ubah tampilan di pengaturan tampilan.");  
   }  
   
   public String getResponse(String userInput) {  
     String[] words = userInput.toLowerCase().split("\\s+");  
     for (String w : words) {  
       if (responses.containsKey(w)) {  
         return responses.get(w);  
       }  
     }  
     // kalau tidak ada kata kunci cocok, jawaban acak generik  
     String[] generic = {  
       "Coba jelaskan lebih rinci.",  
       "Saya belum mengerti, bisa ulangi?",  
       "Bisakah Anda memberi detail lebih lanjut?"  
     };  
     return generic[random.nextInt(generic.length)];  
   }  
   
   public static void main(String[] args) {  
     TechSupport ts = new TechSupport();  
     System.out.println(ts.getResponse("My computer is slow after update"));  
     System.out.println(ts.getResponse("I need help"));  
     System.out.println(ts.getResponse("It gives an unknown error"));  
   }  
}
```

