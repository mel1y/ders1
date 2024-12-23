package view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DeleteGraduatePage extends JFrame {

		    private JTextField txtGraduateID;
		    private JButton btnDelete, btnBack;

		    public DeleteGraduatePage() {
		        setTitle("Mezun Sil");
		        setLayout(new GridLayout(3, 2, 10, 10));
		        setSize(400, 200);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        // Mezun ID'sini Silmek İçin Giriş Alanı
		        JLabel lblGraduateID = new JLabel("Mezun ID:");
		        txtGraduateID = new JTextField();

		        // Silme ve Geri Dön Butonları
		        btnDelete = new JButton("Sil");
		        btnBack = new JButton("Geri");

		        // Silme Butonu Olayı
		        btnDelete.addActionListener(e -> {
		            String graduateID = txtGraduateID.getText();

		            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_management", "root", "1234")) {
		                String sql = "DELETE FROM graduates WHERE id = ?";
		                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
		                    pstmt.setInt(1, Integer.parseInt(graduateID));
		                    int rowsAffected = pstmt.executeUpdate();

		                    if (rowsAffected > 0) {
		                        JOptionPane.showMessageDialog(this, "Mezun başarıyla silindi!");
		                    } else {
		                        JOptionPane.showMessageDialog(this, "Mezun bulunamadı!");
		                    }
		                }
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(this, "Hata: " + ex.getMessage());
		            }
		        });

		        btnBack.addActionListener(e -> {
		            new AdminMenu();
		            dispose();
		        });

		        // Bileşenleri Ekle
		        add(lblGraduateID);
		        add(txtGraduateID);
		        add(new JLabel()); // Boş alan
		        add(btnDelete);
		        add(new JLabel());
		        add(btnBack);

		        setVisible(true);
		    }
		}


