package view;


import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

		
		class AddGraduatePage extends JFrame {
		    private JTextField txtUsername, txtEmail, txtGraduationYear, txtEmployer;
		    private JButton btnSubmit, btnBack;

		    public AddGraduatePage() {
		        setTitle("Mezun Ekle");
		        setLayout(new GridLayout(5, 2, 10, 10));
		        setSize(400, 300);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        // Alanlar ve Butonlar
		        JLabel lblUsername = new JLabel("Kullanıcı Adı:");
		        txtUsername = new JTextField();
		        JLabel lblEmail = new JLabel("E-posta:");
		        txtEmail = new JTextField();
		        JLabel lblGraduationYear = new JLabel("Mezuniyet Yılı:");
		        txtGraduationYear = new JTextField();
		        JLabel lblEmployer = new JLabel("Çalıştığı Kurum:");
		        txtEmployer = new JTextField();
		        btnSubmit = new JButton("Ekle");
		        btnBack = new JButton("Geri");

		        // Mezun ekleme işlemi
		        btnSubmit.addActionListener(e -> {
		            String username = txtUsername.getText();
		            String email = txtEmail.getText();
		            String graduationYear = txtGraduationYear.getText();
		            String employer = txtEmployer.getText();

		            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_management", "root", "1234")) {
		                String sql = "INSERT INTO graduates (username, email, graduation_year, current_employer) VALUES (?, ?, ?, ?)";
		                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
		                    pstmt.setString(1, username);
		                    pstmt.setString(2, email);
		                    pstmt.setInt(3, Integer.parseInt(graduationYear));
		                    pstmt.setString(4, employer);
		                    pstmt.executeUpdate();
		                    JOptionPane.showMessageDialog(this, "Mezun başarıyla eklendi!");
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
		        add(lblUsername);
		        add(txtUsername);
		        add(lblEmail);
		        add(txtEmail);
		        add(lblGraduationYear);
		        add(txtGraduationYear);
		        add(lblEmployer);
		        add(txtEmployer);
		        add(btnSubmit);
		        add(btnBack);

		        setVisible(true);
		    }
		

	}


