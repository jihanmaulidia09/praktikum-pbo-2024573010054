package modul2;


import java.util.Scanner;

public class GradeDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nilai (0-100) : ");
        int nilai = input.nextInt();

        char grade;
        String keterangan;

        //menggunakan if-else
        if (nilai >= 85) {
            grade = 'A';
            keterangan = "sangat bagus";
        } else if (nilai >= 75) {
            grade ='B';
            keterangan = "bagus";
        } else if (nilai >= 65) {
            grade ='C';
            keterangan = "buruk";
        }else if (nilai >= 50){
            grade ='D';
            keterangan = "cukup buruk";
        } else {
            grade ='E';
            keterangan = "gagal";
        }

        System.out.println("Nilai: " + nilai);
        System.out.println("Grade: " + grade);
        System.out.println("Keterangan: " + keterangan);

        input.close();
    }
}
