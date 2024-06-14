import java.util.Scanner;

class Handphone{
    private String merk;
    private String warna;
    private String tipe;
    private double harga;

    Scanner userInput = new Scanner(System.in);

    // Method setter
    public void setMerk(String merk){
        this.merk = merk;
    }

    public void setWarna(String warna){
        this.warna = warna;
    }

    public void setTipe(String tipe){
        this.tipe = tipe;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    // Methos getter
    public String getMerk(){
        return merk;
    }

    public String getWarna(){
        return warna;
    }

    public String getTipe(){
        return tipe;
    }

    public double getHarga(){
        return harga;
    }

    public void input(){
        System.out.print("Masukkan merk handphone  : ");
        merk = userInput.nextLine();
        System.out.print("Masukkan tipe handphone  : ");
        tipe = userInput.nextLine();
        System.out.print("Masukkan warna handphone : ");
        warna = userInput.nextLine();
        System.out.print("Masukkan harga handphone : ");
        harga = userInput.nextDouble();

        setMerk(merk);
        setTipe(tipe);
        setWarna(warna);
        setHarga(harga);
    }

    public void output(){
        System.out.println("========================================");
        System.out.println(" DAFTAR HARGA PONSEL DAN SPESIFIKASINYA ");
        System.out.println("========================================");
        System.out.println("Merk HP  : " + getMerk());
        System.out.println("Tipe HP  : " + getTipe());
        System.out.println("Warna HP : " + getWarna());
        System.out.println("Harga HP sebelum diskon       : Rp " + getHarga());
        keterangan();
    }

    public double HargaDiskon(){
        double diskon =  0.10 * harga;
        double total = getHarga() - diskon;

        return total;
    }

    public void keterangan(){
        System.out.println("Harga HP setelah diskon (10%) : Rp " + HargaDiskon());
    }
}

public class latihan {
    public static void main(String[] args) {
        Handphone hp = new Handphone();

        hp.input();
        hp.output();
    }
}
