import java.util.Scanner;

class Mahasiswa {
    private String nama, alamat, prodi, bulan;
    private int nim, tanggal, tahun;

    public Mahasiswa() {
    }

    public void isi_data(Scanner input) {
        System.out.print("Nama        : ");
        nama = input.nextLine();
        System.out.print("NIM         : ");
        nim = input.nextInt();
        input.nextLine();
        System.out.print("Alamat      : ");
        alamat = input.nextLine();
        System.out.println("TTL ");
        System.out.print("   -Tanggal : ");
        tanggal = input.nextInt();
        input.nextLine();
        System.out.print("   -Bulan   : ");
        bulan = input.nextLine();
        System.out.print("   -Tahun   : ");
        tahun = input.nextInt();
        input.nextLine();
        System.out.print("Prodi  : ");
        prodi = input.nextLine();
    }

    public void tampil_data() {
        System.out.println("Nama   : " + nama);
        System.out.println("NIM    : " + nim);
        System.out.println("Alamat : " + alamat);
        System.out.println("Ttl    : " + tanggal + " " + bulan + " " + tahun);
        System.out.println("Prodi  : " + prodi);
    }
}

public class DataMahasiswa {
    public static void main(String[] args) {
        Mahasiswa data1 = new Mahasiswa();
        Scanner input = new Scanner(System.in);

        System.out.println("Isi data anda dibawah ini!");
        data1.isi_data(input);

        System.out.println();

        System.out.println("Data anda :");
        data1.tampil_data();
    }
}
