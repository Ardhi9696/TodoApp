# Panduan Struktur Project TodoApp (Untuk Pemula)

Halo! Dokumen ini dibuat khusus untuk membantu Anda memahami isi dari project ini tanpa harus pusing dengan istilah teknis yang rumit. 

Project ini menggunakan pola bernama **Clean Architecture**. Bayangkan seperti sebuah rumah yang rapi: ada dapur untuk masak (data), ada ruang tamu untuk menjamu orang (tampilan), dan ada otak yang mengatur semuanya (logika).

---

## 📂 Folder Utama: `app/src/main/java/com/lee/todoapp`

Di dalam folder ini, semua kode utama aplikasi berada. Berikut adalah penjelasan setiap foldernya:

### 1. 🧠 `domain` (Otak Aplikasi)
Ini adalah bagian terpenting. Isinya adalah "apa yang bisa dilakukan aplikasi", tanpa peduli datanya datang dari mana.
*   **`model/Todo.kt`**: Mendefinisikan apa itu "Todo". Contoh: punya Judul, Deskripsi, dan status Selesai.
*   **`repository/TodoRepository.kt`**: Daftar "janji" atau kontrak. Isinya hanya daftar fungsi seperti "Ambil data", "Simpan data", tapi belum tahu cara melakukannya.
*   **`usecase/`**: Isinya adalah aksi-aksi spesifik.
    *   `AddTodo.kt`: Logika untuk menambah catatan.
    *   `GetTodos.kt`: Logika untuk mengambil semua catatan.
    *   `DeleteTodo.kt`: Logika untuk menghapus catatan.

### 2. 🔌 `data` (Dapur / Sumber Data)
Di sini tempat aplikasi mengambil atau menyimpan data (ke HP Anda atau ke internet).
*   **`local/` (Penyimpanan di HP)**:
    *   `dao/TodoDao.kt`: Perintah-perintah khusus untuk bicara dengan Database (Room).
    *   `entity/TodoEntity.kt`: Bentuk data "Todo" khusus untuk disimpan di dalam HP.
    *   `TodoDatabase.kt`: Pusat pengaturan database di dalam HP Anda.
*   **`repository/TodoRepositoryImpl.kt`**: Si "Pelaksana". Di sini janji dari `domain` tadi dilaksanakan (misalnya: "Oke, saya simpan datanya ke HP ya").
*   **`mapper/TodoMapper.kt`**: "Penerjemah". Karena bentuk data di HP dan di Otak aplikasi bisa sedikit berbeda, file ini bertugas mengubahnya agar saling mengerti.

### 3. 🎨 `presentation` (Ruang Tamu / Tampilan)
Bagian yang Anda lihat dan tekan di HP.
*   **`screen/TodoListScreen.kt`**: Halaman utama yang menampilkan daftar catatan Anda.
*   **`component/`**: Potongan-potongan kecil tampilan agar kode tidak berantakan.
    *   `TodoItem.kt`: Kotak kecil untuk satu baris catatan.
    *   `EmptyState.kt`: Tampilan jika belum ada catatan sama sekali.
*   **`viewmodel/TodoViewModel.kt`**: "Pengatur Lalu Lintas". Ia mengambil data dari Otak (`domain`) lalu menyiapkannya agar bisa tampil dengan cantik di layar.

### 4. 🛠️ `core` & `di` (Alat Bantu)
*   **`core/util/CsvUtil.kt`**: Alat khusus untuk mengubah daftar catatan menjadi file Excel/CSV (agar bisa dibuka di komputer).
*   **`di/AppModule.kt`**: "Pabrik Otomatis". Ia membantu memasangkan semua bagian (seperti kabel) secara otomatis agar aplikasi bisa jalan.

---

## 📄 File Penting Lainnya

*   **`build.gradle.kts`**: Daftar belanjaan aplikasi. Isinya adalah daftar library (alat tambahan) yang dibutuhkan aplikasi agar bisa jalan.
*   **`gradle.properties`**: Pengaturan "mesin" agar proses pembuatan aplikasi (build) lebih cepat dan lancar.
*   **`libs.versions.toml`**: Gudang versi. Isinya adalah catatan angka versi semua alat yang kita pakai.

---

### Tips Mempelajari:
Jika Anda ingin mengubah **Tampilan**, pergilah ke folder `presentation`.
Jika Anda ingin mengubah **Cara Data Disimpan**, pergilah ke folder `data`.
Jika Anda ingin menambah **Fitur Baru**, mulailah dari folder `domain`.

Semangat belajar koding! Anda sudah punya pondasi project yang sangat profesional.
