package modul4;

public class Matakuliah {
    private String kode;
    private String nama;
    private int sks;
    private double nilai;

    public Matakuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.nilai = 0.0;
    }

    // Getters
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getSks() { return sks; }
    public double getNilai() { return nilai; }

    // Setter (dengan validasi)
    public void setNilai(double nilai) {
        if (nilai >= 0.0 && nilai <= 100.0) {
            this.nilai = nilai;
        } else {
            System.out.println("Nilai harus antara 0-100");
        }
    }

    // Metode Konversi: Nilai Angka ke Huruf
    public String getNilaiHuruf() {
        if (nilai >= 85) return "A";
        else if (nilai >= 80) return "A-";
        else if (nilai >= 75) return "B+"; // Baris yang hilang dari potongan Anda
        else if (nilai >= 70) return "B";  // Baris yang hilang dari potongan Anda
        else if (nilai >= 65) return "B-"; // Baris yang hilang dari potongan Anda
        else if (nilai >= 60) return "C+"; // Baris yang hilang dari potongan Anda
        else if (nilai >= 55) return "C";  // Baris yang hilang dari potongan Anda
        else if (nilai >= 50) return "D";
        else return "E";
    }

    // Metode Konversi: Nilai Huruf ke Bobot
    public double getBobotNilai() {
        String huruf = getNilaiHuruf();
        switch (huruf) {
            case "A": return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3; // Baris yang hilang dari potongan Anda
            case "B": return 3.0;  // Baris yang hilang dari potongan Anda
            case "B-": return 2.7; // Baris yang hilang dari potongan Anda
            case "C+": return 2.3; // Baris yang hilang dari potongan Anda
            case "C": return 2.0;  // Baris yang hilang dari potongan Anda
            case "D": return 1.0;
            default: return 0.0;
        }
    }

    public void tampilkanInfo() {
        // PERHATIAN: Di gambar Anda, formatnya adalah %-10s %-30s %d SKS | Nilai: %.2f (%s)\n
        System.out.printf("%-10s %-30s %d SKS | Nilai: %.2f (%s)\n",
                kode, nama, sks, nilai, getNilaiHuruf());
    }
}