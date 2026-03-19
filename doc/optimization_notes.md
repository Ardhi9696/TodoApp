# Gradle Optimization Notes

Proyek ini telah dikonfigurasi dengan beberapa optimisasi Gradle untuk memastikan waktu build yang cepat dan penggunaan sumber daya yang efisien.

## Optimisasi yang Diterapkan

Dalam file `gradle.properties`, pengaturan berikut telah diaktifkan:

1.  **Parallel Execution (`org.gradle.parallel=true`)**: Memungkinkan Gradle untuk menjalankan tugas-tugas di modul yang berbeda secara paralel, memanfaatkan prosesor multi-core.
2.  **Configuration Cache (`org.gradle.configuration-cache=true`)**: Menyimpan hasil dari fase konfigurasi build. Jika tidak ada perubahan pada file konfigurasi, Gradle akan melewati fase ini, yang mempercepat build secara signifikan (terutama pada build bertahap).
3.  **Build Caching (`org.gradle.caching=true`)**: Menyimpan output dari tugas-tugas sebelumnya untuk digunakan kembali di build mendatang atau bahkan di mesin yang berbeda.
4.  **File System Watching (`org.gradle.vfs.watch=true`)**: Memungkinkan Gradle untuk memantau perubahan file secara real-time daripada memindai seluruh sistem file setiap kali build dijalankan.
5.  **JVM Heap Size (`org.gradle.jvmargs=-Xmx4096m`)**: Meningkatkan alokasi memori untuk daemon Gradle menjadi 4GB untuk menangani build yang kompleks dengan lebih lancar.

## Tips Tambahan untuk Kecepatan Build

- **Gunakan JDK yang Sesuai**: Pastikan versi JDK yang digunakan oleh Android Studio sama dengan yang digunakan oleh Gradle di terminal (Java 17).
- **Hindari Dynamic Versions**: Selalu gunakan versi spesifik di `libs.versions.toml` untuk menghindari pencarian versi terbaru di setiap build.
- **Modularisasi**: Jika proyek berkembang pesat, pertimbangkan untuk membagi aplikasi menjadi beberapa modul kecil untuk meningkatkan efektivitas build paralel.
- **Offline Mode**: Jika Anda sedang bekerja tanpa koneksi internet yang stabil, aktifkan "Offline Mode" di Android Studio untuk mencegah Gradle mencoba memeriksa dependensi secara online.
