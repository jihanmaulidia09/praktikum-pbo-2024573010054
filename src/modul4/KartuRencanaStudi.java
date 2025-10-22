package modul4;

public class KartuRencanaStudi {
    private Mahasiswa mahasiswa;
    private Matakuliah[] daftarMataKuliah;
    private int jumlahMatkul;
    private int maxMatkul;

    public KartuRencanaStudi(Mahasiswa mahasiswa, int maxMatkul) {
        this.mahasiswa = mahasiswa;
        this.maxMatkul = maxMatkul;
        this.daftarMataKuliah = new Matakuliah[maxMatkul];
        this.jumlahMatkul = 0;
    }

    public boolean tambahMatakuliah(Matakuliah matkul) {
        if (jumlahMatkul < maxMatkul) {
            daftarMataKuliah[jumlahMatkul] = matkul;
            jumlahMatkul++;
            System.out.println("\nNote: Mata kuliah " + matkul.getNama() + " berhasil ditambahkan.");
            return true;
        } else {
            System.out.println("\nNote: KRS sudah penuh! Maksimal " + maxMatkul + " mata kuliah.");
            return false;
        }
    }

    // ✅ FITUR BARU: Menghapus mata kuliah dari KRS berdasarkan kode
    public boolean hapusMatakuliah(String kode) {
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMataKuliah[i].getKode().equalsIgnoreCase(kode)) {
                String nama = daftarMataKuliah[i].getNama();

                // Geser elemen setelahnya ke kiri agar tidak ada celah kosong
                for (int j = i; j < jumlahMatkul - 1; j++) {
                    daftarMataKuliah[j] = daftarMataKuliah[j + 1];
                }

                daftarMataKuliah[jumlahMatkul - 1] = null;
                jumlahMatkul--;

                System.out.println("\nNote: Mata kuliah " + nama + " berhasil dihapus dari KRS.");
                return true;
            }
        }

        System.out.println("\nNote: Mata kuliah dengan kode " + kode + " tidak ditemukan di KRS.");
        return false;
    }

    public int hitungTotalSKS() {
        int totalSKS = 0;
        for (int i = 0; i < jumlahMatkul; i++) {
            totalSKS += daftarMataKuliah[i].getSks();
        }
        return totalSKS;
    }

    public double hitungIPK() {
        if (jumlahMatkul == 0) return 0.0;

        double totalBobot = 0.0;
        int totalSKS = 0;

        for (int i = 0; i < jumlahMatkul; i++) {
            Matakuliah mk = daftarMataKuliah[i];
            totalBobot += mk.getBobotNilai() * mk.getSks();
            totalSKS += mk.getSks();
        }

        return totalSKS > 0 ? totalBobot / totalSKS : 0.0;
    }

    public void tampilkanKRS() {
        String separator = "=".repeat(60);

        System.out.println("\n" + separator + "*");
        System.out.println("          KARTU RENCANA STUDI (KRS)           *");
        System.out.println(separator + "*");
        System.out.println("Nama Mahasiswa : " + mahasiswa.getNama());
        System.out.println("NIM            : " + mahasiswa.getNim());
        System.out.println("Jurusan        : " + mahasiswa.getJurusan());
        System.out.println(separator + "*");
        System.out.printf("%-10s %-30s %-5s %-10s%s\n", "KODE", "MATA KULIAH", "SKS", "NILAI(*)", "*");
        System.out.println(separator + "*");

        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            for (int i = 0; i < jumlahMatkul; i++) {
                daftarMataKuliah[i].tampilkanInfo();
            }
        }

        System.out.println(separator + "*");
        System.out.printf("Total SKS Semester: %d\n", hitungTotalSKS());
        System.out.printf("IPK Semester      : %.2f\n", hitungIPK());
        System.out.println(separator + "\n");
    }

    public Matakuliah cariMatakuliah(String kode) {
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMataKuliah[i].getKode().equalsIgnoreCase(kode)) {
                return daftarMataKuliah[i];
            }
        }
        return null;
    }
}
