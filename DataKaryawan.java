import java.io.*;
import java.util.ArrayList;

public class DataKaryawan {
    private String NIK, Nama, tgl_lahir, tempat_lahir, JenisKelamin, Status, Alamat, golongan, Jabatan, tmt;

    public DataKaryawan(String NIK, String Nama, String tgl_lahir, String tempat_lahir, String JenisKelamin,
                        String Status, String Alamat, String golongan, String Jabatan, String tmt) {
        this.NIK = NIK;
        this.Nama = Nama;
        this.tgl_lahir = tgl_lahir;
        this.tempat_lahir = tempat_lahir;
        this.JenisKelamin = JenisKelamin;
        this.Status = Status;
        this.Alamat = Alamat;
        this.golongan = golongan;
        this.Jabatan = Jabatan;
        this.tmt = tmt;
    }

    public String getNIK() {
        return NIK;
    }

    public String getNama() {
        return Nama;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public String getJenisKelamin() {
        return JenisKelamin;
    }

    public String getStatus() {
        return Status;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getGolongan() {
        return golongan;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public String getTmt() {
        return tmt;
    }

    // Menyimpan daftar karyawan ke dalam file CSV
    public static void saveToFile(ArrayList<DataKaryawan> karyawanList, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (DataKaryawan karyawan : karyawanList) {
            writer.write(karyawan.toCSV());
            writer.newLine();
        }
        writer.close();
    }

    // Membaca daftar karyawan dari file CSV
    public static ArrayList<DataKaryawan> loadFromFile(String filePath) throws IOException {
        ArrayList<DataKaryawan> karyawanList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 10) {
                DataKaryawan karyawan = new DataKaryawan(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
                karyawanList.add(karyawan);
            }
        }
        reader.close();
        return karyawanList;
    }

    // Mengonversi objek DataKaryawan ke format CSV
    private String toCSV() {
        return String.join(",", NIK, Nama, tgl_lahir, tempat_lahir, JenisKelamin, Status, Alamat, golongan, Jabatan, tmt);
    }
}
