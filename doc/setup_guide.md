# Setup Guide - TodoApp

Selamat datang di proyek TodoApp! Dokumen ini menjelaskan tumpukan teknologi yang digunakan dan cara mengelola dependensi di proyek ini.

## Technology Stack

- **Jetpack Compose**: Untuk membangun UI modern dan deklaratif.
- **Material 3**: Sistem desain Material terbaru dari Google.
- **Hilt**: Library Dependency Injection untuk Android.
- **Room**: Library abstraksi SQLite untuk penyimpanan data lokal yang persisten.
- **Navigation Compose**: Untuk navigasi antar layar di dalam aplikasi Compose.
- **Kotlin Coroutines**: Untuk pemrograman asinkron.
- **Ktor Client**: Untuk komunikasi jaringan (jika diperlukan di masa mendatang).
- **Kotlin Serialization**: Untuk serialisasi dan deserialisasi data (misalnya format JSON).

## Dependency Management

Proyek ini menggunakan **Gradle Version Catalog** (`gradle/libs.versions.toml`) untuk manajemen dependensi terpusat.

### Cara Menambah Dependensi Baru:

1.  **Daftarkan Versi**: Buka `gradle/libs.versions.toml` dan tambahkan versi library di bagian `[versions]`.
2.  **Daftarkan Library**: Tambahkan library ke bagian `[libraries]` menggunakan referensi versi yang telah dibuat.
3.  **Terapkan di Modul**: Buka `app/build.gradle.kts` dan tambahkan library tersebut ke dalam blok `dependencies`.

Contoh:
```toml
# libs.versions.toml
[versions]
myLibrary = "1.0.0"

[libraries]
my-library = { group = "com.example", name = "my-library", version.ref = "myLibrary" }
```

```kotlin
// app/build.gradle.kts
dependencies {
    implementation(libs.my.library)
}
```

## Prasyarat Lingkungan

- **Android Studio Ladybug** (atau versi terbaru).
- **JDK 17**: Pastikan Android Studio menggunakan JDK 17 untuk proses build.
- **Minimum SDK**: 26 (Android 8.0).
- **Target SDK**: 35 (Android 15).
