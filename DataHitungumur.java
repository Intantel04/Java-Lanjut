import java.time.Year;
import java.util.Scanner;

class Mahasiswa{
    private String nama;
    private String alamat;
    private int tahun_lahir;
    private int nim;

    Scanner input = new Scanner(System.in);

    public Mahasiswa(String nama, String alamat, int tahun_lahir, int nim){
        this.nama = nama;
        this.alamat = alamat;
        this.tahun_lahir = tahun_lahir;
        this.nim = nim;
    }

    // Method Setter
    public void setNama(String nama){
        this.nama = nama;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public void setTahunLahir(int tahun_lahir){
        this.tahun_lahir = tahun_lahir;
    }

    public void setNim(int nim){
        this.nim = nim;
    }


    // Method getter
    public String getNama(){
        return nama;
    }

    public String getAlamat(){
        return alamat;
    }

    public int getTahunLahir(){
        return tahun_lahir;
    }

    public int getNim(){
        return nim;
    }

    public void tampil(){
        System.out.println("Nama        : " + getNama());
        System.out.println("NIM         : " + getNim());
        System.out.println("Alamat      : " + getAlamat());
        System.out.println("Tahun lahir : " + getTahunLahir());
        System.out.print("\n");
        System.out.println("Sekarang anda berumur " + hitung_umur() + " tahun");
    }

    // Method hitung umur
    public int hitung_umur(){
        int tahun_sekarang = Year.now().getValue();
        return tahun_sekarang - tahun_lahir;
    }
}

public class dataHitungumur {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa("Intan", "Kp.Rancaemas", 2004, 301230016);

        mhs.tampil();
    }
}
