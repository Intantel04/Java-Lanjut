class BubblesortMahasiswa {
    String NIM;
    String Nama;
    Alamat alamat;
    String Prodi;

    public BubblesortMahasiswa(String NIM, String Nama, Alamat alamat, String Prodi) {
        this.NIM = NIM;
        this.Nama = Nama;
        this.alamat = alamat;
        this.Prodi = Prodi;
    }

    static class Alamat {
        String namaJalan;
        String noRumah;
        String RT;
        String RW;
        String Desa;

        public Alamat(String namaJalan, String noRumah, String RT, String RW, String Desa) {
            this.namaJalan = namaJalan;
            this.noRumah = noRumah;
            this.RT = RT;
            this.RW = RW;
            this.Desa = Desa;
        }
    }

    public static void bubbleSort(BubblesortMahasiswa[] arr) {
        int n = arr.length;
        BubblesortMahasiswa temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].NIM.compareTo(arr[j].NIM) > 0) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();
        BubblesortMahasiswa[] mahasiswas = new BubblesortMahasiswa[jumlah];

        System.out.println("Input data!");

        for (int i = 0; i < jumlah; i++) {
            System.out.print("\n");

            System.out.println("Mahasiswa ke-" + (i+1));
            System.out.print("NIM            : ");
            String NIM = scanner.nextLine();
            System.out.print("Nama           : ");
            String Nama = scanner.nextLine();
            System.out.println("Alamat");
            System.out.print("  - Nama Jalan : ");
            String namaJalan = scanner.nextLine();
            System.out.print("  - No Rumah   : ");
            String noRumah = scanner.nextLine();
            System.out.print("  - RT         : ");
            String RT = scanner.nextLine();
            System.out.print("  - RW         : ");
            String RW = scanner.nextLine();
            System.out.print("  - Desa       : ");
            String Desa = scanner.nextLine();
            System.out.print("Prodi          : ");
            String Prodi = scanner.nextLine();

            Alamat alamat = new Alamat(namaJalan, noRumah, RT, RW, Desa);
            mahasiswas[i] = new BubblesortMahasiswa(NIM, Nama, alamat, Prodi);
        }

        System.out.print("\n");

        System.out.println("Sebelum Pengurutan:");
        for (BubblesortMahasiswa m : mahasiswas) {
            System.out.println("NIM            : " + m.NIM);
            System.out.println("Nama           : " + m.Nama);
            System.out.println("Alamat         : Jalan " + m.alamat.namaJalan + " No." + m.alamat.noRumah + ", RT " + m.alamat.RT + " / RW " + m.alamat.RW + ", Desa " + m.alamat.Desa);
            System.out.println("Prodi          : " + m.Prodi);
            System.out.print("\n");
        }

        bubbleSort(mahasiswas);

        System.out.print("\n");

        System.out.println("Setelah Pengurutan:");
        for (BubblesortMahasiswa m : mahasiswas) {
            System.out.println("NIM            : " + m.NIM);
            System.out.println("Nama           : " + m.Nama);
            System.out.println("Alamat         : Jalan " + m.alamat.namaJalan + " No." + m.alamat.noRumah + ", RT " + m.alamat.RT + " / RW " + m.alamat.RW + ", Desa " + m.alamat.Desa);
            System.out.println("Prodi          : " + m.Prodi);
            System.out.print("\n");
        }

        scanner.close();
    }
}