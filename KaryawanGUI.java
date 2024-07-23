import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class KaryawanGUI extends javax.swing.JFrame {

    // Deklarasi komponen GUI
    private javax.swing.JButton buttonSubmit, buttonFirst, buttonLast, buttonNext, buttonPrev, buttonSave, buttonLoad;
    private javax.swing.JLabel labelNIK, labelNama, labelTgl_lahir, labelTempat_lahir, labelJenisKelamin, labelStatus, labelAlamat, labelGolongan, labelJabatan, labelTmt;
    private javax.swing.JTextField textNIK, textNama, textTgl_lahir, textTempat_lahir;
    private javax.swing.JTextField textAlamat, textGolongan, textJabatan, textTmt;
    private javax.swing.JComboBox<String> comboJenisKelamin, comboStatus;
    private javax.swing.ButtonGroup groupJenisKelamin;
    private javax.swing.JTextArea textAreaOutput;
    private javax.swing.JScrollPane scrollPaneOutput;

    // ArrayList untuk menyimpan data karyawan
    private ArrayList<DataKaryawan> karyawanList = new ArrayList<>();
    private int currentIndex = -1;
    private final String filePath = "Karyawan.csv";

    // Konstruktor untuk mengatur komponen GUI
    public KaryawanGUI() {
        initComponents();
    }

    private void initComponents() {

        // Inisialisasi komponen
        labelNIK = new javax.swing.JLabel("NIK: ");
        textNIK = new javax.swing.JTextField(15);

        labelNama = new javax.swing.JLabel("Nama: ");
        textNama = new javax.swing.JTextField(20);

        labelJenisKelamin = new javax.swing.JLabel("Jenis Kelamin: ");
        comboJenisKelamin = new javax.swing.JComboBox<>(new String[]{"Laki-laki", "Perempuan"});

        labelTgl_lahir = new javax.swing.JLabel("Tanggal Lahir: ");
        textTgl_lahir = new javax.swing.JTextField(10);

        labelTempat_lahir = new javax.swing.JLabel("Tempat Lahir: ");
        textTempat_lahir = new javax.swing.JTextField(20);

        labelStatus = new javax.swing.JLabel("Status: ");
        comboStatus = new javax.swing.JComboBox<>(new String[]{"Kawin", "Belum Kawin"});

        labelAlamat = new javax.swing.JLabel("Alamat: ");
        textAlamat = new javax.swing.JTextField(20);

        labelGolongan = new javax.swing.JLabel("Golongan: ");
        textGolongan = new javax.swing.JTextField(10);

        labelJabatan = new javax.swing.JLabel("Jabatan: ");
        textJabatan = new javax.swing.JTextField(20);

        labelTmt = new javax.swing.JLabel("TMT: ");
        textTmt = new javax.swing.JTextField(10);

        buttonSubmit = new javax.swing.JButton("Submit");
        buttonFirst = new javax.swing.JButton("First");
        buttonLast = new javax.swing.JButton("Last");
        buttonNext = new javax.swing.JButton("Next");
        buttonPrev = new javax.swing.JButton("Prev");
        buttonSave = new javax.swing.JButton("Save to CSV");
        buttonLoad = new javax.swing.JButton("Load from CSV");

        textAreaOutput = new javax.swing.JTextArea(10, 30);
        textAreaOutput.setEditable(false);
        scrollPaneOutput = new javax.swing.JScrollPane(textAreaOutput);

        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSubmitActionPerformed(evt);
            }
        });

        buttonFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showFirstData();
            }
        });

        buttonLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showLastData();
            }
        });

        buttonNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showNextData();
            }
        });

        buttonPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showPrevData();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveDataToFile();
            }
        });

        buttonLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loadDataFromFile();
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // GroupLayout setup
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSubmit)
                    .addComponent(buttonFirst)
                    .addComponent(buttonLast)
                    .addComponent(buttonNext)
                    .addComponent(buttonPrev)
                    .addComponent(buttonSave)
                    .addComponent(buttonLoad)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTmt)
                            .addComponent(labelJabatan)
                            .addComponent(labelGolongan)
                            .addComponent(labelAlamat)
                            .addComponent(labelTempat_lahir)
                            .addComponent(labelTgl_lahir)
                            .addComponent(labelJenisKelamin)
                            .addComponent(labelNama)
                            .addComponent(labelNIK)
                            .addComponent(labelStatus))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textNIK)
                            .addComponent(textNama)
                            .addComponent(comboJenisKelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textTgl_lahir)
                            .addComponent(textTempat_lahir)
                            .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textAlamat)
                            .addComponent(textGolongan)
                            .addComponent(textJabatan)
                            .addComponent(textTmt))))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNIK)
                    .addComponent(textNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNama)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJenisKelamin)
                    .addComponent(comboJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTgl_lahir)
                    .addComponent(textTgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTempat_lahir)
                    .addComponent(textTempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatus)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAlamat)
                    .addComponent(textAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGolongan)
                    .addComponent(textGolongan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJabatan)
                    .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTmt)
                    .addComponent(textTmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLoad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrollPaneOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }

     // Fungsi untuk menangani event submit

    private void buttonSubmitActionPerformed(ActionEvent evt) {
        String nik = textNIK.getText();
        String nama = textNama.getText();
        String tanggalLahir = textTgl_lahir.getText();
        String tempatLahir = textTempat_lahir.getText();
        String jenisKelamin = (String) comboJenisKelamin.getSelectedItem();
        String status = (String) comboStatus.getSelectedItem();
        String alamat = textAlamat.getText();
        String golongan = textGolongan.getText();
        String jabatan = textJabatan.getText();
        String tmt = textTmt.getText();
    
        // Membuat objek DataKaryawan baru
        DataKaryawan karyawan = new DataKaryawan(nik, nama, tanggalLahir, tempatLahir, jenisKelamin, status, alamat, golongan, jabatan, tmt);
    
        // Menambahkan karyawan ke dalam ArrayList
        karyawanList.add(karyawan);
        currentIndex = karyawanList.size() - 1;
    
        // Menampilkan data karyawan yang baru ditambahkan
        displayData(karyawan);
    }
    
    private void showFirstData() {
        if (!karyawanList.isEmpty()) {
            currentIndex = 0;
            displayData(karyawanList.get(currentIndex));
        }
    }
    
    private void showLastData() {
        if (!karyawanList.isEmpty()) {
            currentIndex = karyawanList.size() - 1;
            displayData(karyawanList.get(currentIndex));
        }
    }
    
    private void showNextData() {
        if (currentIndex < karyawanList.size() - 1) {
            currentIndex++;
            displayData(karyawanList.get(currentIndex));
        }
    }
    
    private void showPrevData() {
        if (currentIndex > 0) {
            currentIndex--;
            displayData(karyawanList.get(currentIndex));
        }
    }
    
    private void saveDataToFile() {
        try {
            DataKaryawan.saveToFile(karyawanList, filePath);
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke " + filePath);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
        }
    }
    
    private void loadDataFromFile() {
        try {
            karyawanList = DataKaryawan.loadFromFile(filePath);
            JOptionPane.showMessageDialog(this, "Data berhasil dimuat dari " + filePath);
            if (!karyawanList.isEmpty()) {
                currentIndex = 0;
                displayData(karyawanList.get(currentIndex));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
        }
    }
    
    // Fungsi untuk menampilkan data karyawan di textAreaOutput
    private void displayData(DataKaryawan karyawan) {
        textAreaOutput.setText("NIK: " + karyawan.getNIK() + "\n");
        textAreaOutput.append("Nama: " + karyawan.getNama() + "\n");
        textAreaOutput.append("Tanggal Lahir: " + karyawan.getTgl_lahir() + "\n");
        textAreaOutput.append("Tempat Lahir: " + karyawan.getTempat_lahir() + "\n");
        textAreaOutput.append("Jenis Kelamin: " + karyawan.getJenisKelamin() + "\n");
        textAreaOutput.append("Status: " + karyawan.getStatus() + "\n");
        textAreaOutput.append("Alamat: " + karyawan.getAlamat() + "\n");
        textAreaOutput.append("Golongan: " + karyawan.getGolongan() + "\n");
        textAreaOutput.append("Jabatan: " + karyawan.getJabatan() + "\n");
        textAreaOutput.append("TMT: " + karyawan.getTmt() + "\n");
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KaryawanGUI().setVisible(true);
            }
        });
    }

    public javax.swing.JButton getButtonSubmit() {
        return buttonSubmit;
    }

    public void setButtonSubmit(javax.swing.JButton buttonSubmit) {
        this.buttonSubmit = buttonSubmit;
    }

    public javax.swing.JButton getButtonFirst() {
        return buttonFirst;
    }

    public void setButtonFirst(javax.swing.JButton buttonFirst) {
        this.buttonFirst = buttonFirst;
    }

    public javax.swing.JButton getButtonLast() {
        return buttonLast;
    }

    public void setButtonLast(javax.swing.JButton buttonLast) {
        this.buttonLast = buttonLast;
    }

    public javax.swing.JButton getButtonNext() {
        return buttonNext;
    }

    public void setButtonNext(javax.swing.JButton buttonNext) {
        this.buttonNext = buttonNext;
    }

    public javax.swing.JButton getButtonPrev() {
        return buttonPrev;
    }

    public void setButtonPrev(javax.swing.JButton buttonPrev) {
        this.buttonPrev = buttonPrev;
    }

    public javax.swing.JButton getButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(javax.swing.JButton buttonSave) {
        this.buttonSave = buttonSave;
    }

    public javax.swing.JButton getButtonLoad() {
        return buttonLoad;
    }

    public void setButtonLoad(javax.swing.JButton buttonLoad) {
        this.buttonLoad = buttonLoad;
    }

    public javax.swing.JLabel getLabelNIK() {
        return labelNIK;
    }

    public void setLabelNIK(javax.swing.JLabel labelNIK) {
        this.labelNIK = labelNIK;
    }

    public javax.swing.JLabel getLabelNama() {
        return labelNama;
    }

    public void setLabelNama(javax.swing.JLabel labelNama) {
        this.labelNama = labelNama;
    }

    public javax.swing.JLabel getLabelTgl_lahir() {
        return labelTgl_lahir;
    }

    public void setLabelTgl_lahir(javax.swing.JLabel labelTgl_lahir) {
        this.labelTgl_lahir = labelTgl_lahir;
    }

    public javax.swing.JLabel getLabelTempat_lahir() {
        return labelTempat_lahir;
    }

    public void setLabelTempat_lahir(javax.swing.JLabel labelTempat_lahir) {
        this.labelTempat_lahir = labelTempat_lahir;
    }

    public javax.swing.JLabel getLabelJenisKelamin() {
        return labelJenisKelamin;
    }

    public void setLabelJenisKelamin(javax.swing.JLabel labelJenisKelamin) {
        this.labelJenisKelamin = labelJenisKelamin;
    }

    public javax.swing.JLabel getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(javax.swing.JLabel labelStatus) {
        this.labelStatus = labelStatus;
    }

    public javax.swing.JLabel getLabelAlamat() {
        return labelAlamat;
    }

    public void setLabelAlamat(javax.swing.JLabel labelAlamat) {
        this.labelAlamat = labelAlamat;
    }

    public javax.swing.JLabel getLabelGolongan() {
        return labelGolongan;
    }

    public void setLabelGolongan(javax.swing.JLabel labelGolongan) {
        this.labelGolongan = labelGolongan;
    }

    public javax.swing.JLabel getLabelJabatan() {
        return labelJabatan;
    }

    public void setLabelJabatan(javax.swing.JLabel labelJabatan) {
        this.labelJabatan = labelJabatan;
    }

    public javax.swing.JLabel getLabelTmt() {
        return labelTmt;
    }

    public void setLabelTmt(javax.swing.JLabel labelTmt) {
        this.labelTmt = labelTmt;
    }

    public javax.swing.JTextField getTextNIK() {
        return textNIK;
    }

    public void setTextNIK(javax.swing.JTextField textNIK) {
        this.textNIK = textNIK;
    }

    public javax.swing.JTextField getTextNama() {
        return textNama;
    }

    public void setTextNama(javax.swing.JTextField textNama) {
        this.textNama = textNama;
    }

    public javax.swing.JTextField getTextTgl_lahir() {
        return textTgl_lahir;
    }

    public void setTextTgl_lahir(javax.swing.JTextField textTgl_lahir) {
        this.textTgl_lahir = textTgl_lahir;
    }

    public javax.swing.JTextField getTextTempat_lahir() {
        return textTempat_lahir;
    }

    public void setTextTempat_lahir(javax.swing.JTextField textTempat_lahir) {
        this.textTempat_lahir = textTempat_lahir;
    }

    public javax.swing.JTextField getTextAlamat() {
        return textAlamat;
    }

    public void setTextAlamat(javax.swing.JTextField textAlamat) {
        this.textAlamat = textAlamat;
    }

    public javax.swing.JTextField getTextGolongan() {
        return textGolongan;
    }

    public void setTextGolongan(javax.swing.JTextField textGolongan) {
        this.textGolongan = textGolongan;
    }

    public javax.swing.JTextField getTextJabatan() {
        return textJabatan;
    }

    public void setTextJabatan(javax.swing.JTextField textJabatan) {
        this.textJabatan = textJabatan;
    }

    public javax.swing.JTextField getTextTmt() {
        return textTmt;
    }

    public void setTextTmt(javax.swing.JTextField textTmt) {
        this.textTmt = textTmt;
    }

    public javax.swing.JComboBox<String> getComboJenisKelamin() {
        return comboJenisKelamin;
    }

    public void setComboJenisKelamin(javax.swing.JComboBox<String> comboJenisKelamin) {
        this.comboJenisKelamin = comboJenisKelamin;
    }

    public javax.swing.JComboBox<String> getComboStatus() {
        return comboStatus;
    }

    public void setComboStatus(javax.swing.JComboBox<String> comboStatus) {
        this.comboStatus = comboStatus;
    }

    public javax.swing.ButtonGroup getGroupJenisKelamin() {
        return groupJenisKelamin;
    }

    public void setGroupJenisKelamin(javax.swing.ButtonGroup groupJenisKelamin) {
        this.groupJenisKelamin = groupJenisKelamin;
    }

    public javax.swing.JTextArea getTextAreaOutput() {
        return textAreaOutput;
    }

    public void setTextAreaOutput(javax.swing.JTextArea textAreaOutput) {
        this.textAreaOutput = textAreaOutput;
    }

    public javax.swing.JScrollPane getScrollPaneOutput() {
        return scrollPaneOutput;
    }

    public void setScrollPaneOutput(javax.swing.JScrollPane scrollPaneOutput) {
        this.scrollPaneOutput = scrollPaneOutput;
    }

    public ArrayList<DataKaryawan> getKaryawanList() {
        return karyawanList;
    }

    public void setKaryawanList(ArrayList<DataKaryawan> karyawanList) {
        this.karyawanList = karyawanList;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public String getFilePath() {
        return filePath;
    }
}