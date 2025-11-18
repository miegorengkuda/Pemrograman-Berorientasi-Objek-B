Dokumentasi Tugas atau Project mata kuliah Pemrograman Berorientasi Objek (B)

Dafa Kumara Sahasika (5025241112)

## Abstraksi Kelas

**Hirarki Makhluk Hidup (Living Being Hierarchy)**

Desain Kelas:
1. LivingBeing (Kelas Abstrak Utama):
   - Tujuan: Menetapkan sifat dan perilaku umum yang dimiliki oleh semua makhluk hidup.
   - Atribut: name (String).
   - Metode Konkret: `breathe()` (diimplementasikan, menampilkan proses bernapas).
   - Metode Abstrak: `grow()` (tidak memiliki implementasi dan harus didefinisikan ulang oleh setiap subclass di bawahnya, karena cara tumbuh setiap makhluk hidup berbeda).
2. Human, Animal, Plant (Kelas Abstrak Perantara):
   - Tujuan: Memperkenalkan sifat-sifat khusus untuk kelompok makhluk hidup tertentu, sekaligus mewarisi dari LivingBeing.
   - Metode Abstrak Tambahan:
   - Human: `speak()`
   - Animal: `move()`
   - Plant: `photosynthesize()`
3. Subkelas Konkret (Contoh: Programmer, Doctor, Dog, Bird, FloweringPlant, NonFloweringPlant):
   - Tujuan: Mengimplementasikan semua metode abstrak yang diwarisi dari kelas-kelas abstrak di atasnya.
   - Setiap subclass memberikan implementasi unik untuk metode seperti `grow()`, `speak()`, `move()`, dan `photosynthesize()`, sesuai dengan jenis makhluk hidup tersebut.
  
Diagram:

<img width="2662" height="1420" alt="Screenshot 2025-11-18 080131" src="https://github.com/user-attachments/assets/6af53615-c215-4c63-b13e-131a3f9be951" />

Hasil:

<img width="1276" height="737" alt="Screenshot 2025-11-18 080203" src="https://github.com/user-attachments/assets/11e1c812-c873-4d46-bf37-7e7b7d151944" />

Source [Code](Week12/LivingBeing)

