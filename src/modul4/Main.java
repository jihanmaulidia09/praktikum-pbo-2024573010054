package modul4;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Buat objek Mahasiswa dan KRS
        Mahasiswa mhs = new Mahasiswa("Jihan Maulidia", "2024573010054", "Teknik Informatika", 0.0);
        KartuRencanaStudi krs = new KartuRencanaStudi(mhs, 10);

        boolean running = true;

        while (running) {
            // Tampilan Menu
            System.out.println("---------------------------------------------");
            System.out.println("|             MENU KRS                      |");
            System.out.println("---------------------------------------------");
            System.out.println("| 1. Tambah Mata Kuliah                     |");
            System.out.println("| 2. Input Nilai Mata Kuliah                |");
            System.out.println("| 3. Tampilkan KRS                          |");
            System.out.println("| 4. Hapus Mata Kuliah                      |");
            System.out.println("| 5. Keluar                                 |");
            System.out.println("---------------------------------------------");
            System.out.print("Pilih menu: ");

            int pilihan;
            try {
                if (input.hasNextInt()) {
                    pilihan = input.nextInt();
                    input.nextLine();
                } else {
                    System.out.println("\n! Pilihan tidak valid. Harap masukkan angka menu (1-5).");
                    input.nextLine();
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n! Input menu harus berupa angka.");
                input.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("\nTAMBAH MATA KULIAH");
                    System.out.println("--------------------");

                    System.out.print("Kode Mata Kuliah: ");
                    String kode = input.nextLine();

                    System.out.print("Nama Mata Kuliah: ");
                    String namaMK = input.nextLine();

                    System.out.print("Jumlah SKS: ");
                    if (!input.hasNextInt()) {
                        System.out.println("! Jumlah SKS harus berupa angka.");
                        input.nextLine();
                        break;
                    }
                    int sks = input.nextInt();
                    input.nextLine();

                    Matakuliah mk = new Matakuliah(kode, namaMK, sks);
                    krs.tambahMatakuliah(mk);
                    break;

                case 2:
                    System.out.println("\nINPUT NILAI");
                    System.out.println("-----------");
                    System.out.print("Kode Mata Kuliah yang dicari: ");
                    String kodeCari = input.nextLine();

                    Matakuliah mkCari = krs.cariMatakuliah(kodeCari);

                    if (mkCari != null) {
                        System.out.print("Nilai (0-100): ");
                        if (!input.hasNextDouble()) {
                            System.out.println("! Nilai harus berupa angka.");
                            input.nextLine();
                            break;
                        }
                        double nilai = input.nextDouble();
                        input.nextLine();

                        mkCari.setNilai(nilai);
                        System.out.println("Nilai berhasil diinput!");
                    } else {
                        System.out.println("! Mata kuliah dengan kode '" + kodeCari + "' tidak ditemukan!");
                    }
                    break;

                case 3:
                    krs.tampilkanKRS();
                    break;

                case 4:
                    System.out.println("\nHAPUS MATA KULIAH");
                    System.out.println("------------------");
                    System.out.print("Masukkan kode mata kuliah yang ingin dihapus: ");
                    String kodeHapus = input.nextLine();
                    krs.hapusMatakuliah(kodeHapus);
                    break;

                case 5:
                    System.out.println("Terima kasih! Program diakhiri.");
                    running = false;
                    break;

                default:
                    System.out.println("! Pilihan tidak valid. Silakan pilih 1-5.");
            }
        }
        input.close();
    }
}
