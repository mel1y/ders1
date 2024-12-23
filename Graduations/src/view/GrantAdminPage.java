package view;

import java.awt.GridLayout;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GrantAdminPage extends JFrame {
    private JTextField txtGraduateID;
    private JButton btnGrantAdmin, btnBack;

    public GrantAdminPage() {
        setTitle("Admin Yetkisi Ver");
        setLayout(new GridLayout(3, 2, 10, 10));
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mezun ID'si Alanı
        JLabel lblGraduateID = new JLabel("Mezun ID:");
        txtGraduateID = new JTextField();

        // Butonlar
        btnGrantAdmin = new JButton("Yetki Ver");
        btnBack = new JButton("Geri");

        // Yetkilendirme kısmı
        btnGrantAdmin.addActionListener(e -> {
            String graduateID = txtGraduateID.getText();

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_management", "root", "1234")) {
                // Random şifre üretme
                String generatedPassword = generateRandomPassword(8);

                // Admin yetkisi ve şifre ekleme sorgusu
                String sql = "UPDATE graduates SET is_admin = 1, password = ? WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, generatedPassword); // Şifreyi ayarla
                    pstmt.setInt(2, Integer.parseInt(graduateID)); // ID'yi ayarla

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Admin yetkisi verdiniz! Yeni şifre: " + generatedPassword);
                    } else {
                        JOptionPane.showMessageDialog(this, "Mezun bulunamadı!");
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Hata aldınız: " + ex.getMessage());
            }
        });

        btnBack.addActionListener(e -> {
            new AdminMenu();
            dispose();
        });

        // Bileşenler kısmı
        add(lblGraduateID);
        add(txtGraduateID);
        add(new JLabel()); // Boşluk için
        add(btnGrantAdmin);
        add(new JLabel());
        add(btnBack);

        setVisible(true);
    }

    // Random şifre üretme kısmı
    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            password.append(chars.charAt(randomIndex));
        }

        return password.toString();
    }
}
