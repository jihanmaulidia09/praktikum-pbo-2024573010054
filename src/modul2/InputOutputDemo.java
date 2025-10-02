package modul2;


import java.util.Scanner;

public class InputOutputDemo {
    public static void main(String[] args) {
        //membuat objek scanner
        Scanner input = new Scanner(System.in);

        //membaca input string
        System.out.print("Masukkan nama anda: ");
        String nama = input.nextLine();

        //membaca input integer
        System.out.print("Masukkan umur Anda ");
        int umur = input.nextInt();

        //membaca input double
        System.out.print("Masukkan tinggi anda (cm): ");
        double tinggi = input.nextDouble();

        //menampilkan output
        System.out.println("\n=== Data Anda ===");
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
        System.out.println("Tinggi: " + tinggi);

        //Menutup Scanner
        input.close();
    }

}