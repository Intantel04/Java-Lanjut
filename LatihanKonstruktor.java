import java.io.*;

class Login{
    private String username, password;

    public Login(){
        username = "admin";
        password = "12345";
    }

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}

public class latihanKonstruktor{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Login user1 = new Login();
        Login user2 = new Login("","");

        while (true) {
            System.out.println("========================");
            System.out.println("       MENU LOGIN       ");
            System.out.println("========================");
            System.out.println("1. Login admin");
            System.out.println("2. Ubah password admin");
            System.out.println("3. Buat user");
            System.out.println("4. Lihat data user");
            System.out.println("5. Keluar");
            System.out.println("========================");

            System.out.print("Masukkan pilihan : ");
            int pilih = Integer.parseInt(br.readLine());

            System.out.println("\n");

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan username : ");
                    String my_user = br.readLine();
                    System.out.print("Masukkan password : ");
                    String my_password = br.readLine();

                    System.out.print("\n");

                    if(my_user.equals(user1.getUsername()) && my_password.equals(user1.getPassword())){
                        System.out.println("*** Login Sukses ***");
                    }else{
                        System.out.println("*** Login Gagal ***");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan password lama : ");
                    String old_password = br.readLine();
                    System.out.print("Masukkan password baru : ");
                    String new_password = br.readLine();

                    System.out.print("\n");

                    if(old_password.equals(user1.getPassword())){
                        user1.setPassword(new_password);
                        System.out.println("*** Password berhasil diubah ***");
                    }else{
                        System.out.println("*** Password lama salah ***");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan username : ");
                    String create_user = br.readLine();
                    System.out.print("Masukkan password : ");
                    String create_password = br.readLine();

                    System.out.print("\n");

                    user2 = new Login(create_user, create_password);

                    System.out.print("\n");

                    System.out.println("*** User berhasil dibuat ***");
                    break;
                case 4:
                    System.out.println("=====================");
                    System.out.println("DATA USER");

                    System.out.println("User 1");
                    System.out.println("Username : " + user1.getUsername());
                    System.out.println("Password : " + user1.getPassword());

                    System.out.print("\n");

                    System.out.println("User 2");
                    System.out.println("Username : " + user2.getUsername());
                    System.out.println("Password : " + user2.getPassword());

                    System.out.println("=====================");
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
