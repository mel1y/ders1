package view;

		import javax.swing.*;
		import java.awt.*;
		import java.awt.event.*;

		public class LoginPage extends JFrame {
		    private JTextField txtUsername;
		    private JPasswordField txtPassword;
		    private JButton btnLogin;

		    public LoginPage() {
		        // Giriş Sayfası tasarım
		        setTitle("Admin Giriş");
		        setLayout(new GridLayout(3, 2, 10, 10)); //3 satır,2 sütun
		        setSize(400, 200);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        // Kullanıcı Adı ve Şifre
		        JLabel lblUsername = new JLabel("Kullanıcı Adı:");
		        txtUsername = new JTextField();
		        JLabel lblPassword = new JLabel("Şifre:");
		        txtPassword = new JPasswordField();

		        // Giriş Butonu
		        btnLogin = new JButton("Giriş Yap");
		        btnLogin.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                String username = txtUsername.getText();
		                String password = new String(txtPassword.getPassword());

		                // Kullanıcı adı ve şifre doğrulaması
		                if (username.equals("admin") && password.equals("1234")) {
		                    JOptionPane.showMessageDialog(null, "Giriş Başarılı!");
		                    new AdminMenu(); // Ana menü geçişi için
		                    dispose(); // Giriş sayfasını kapatıyor
		                } else {
		                    JOptionPane.showMessageDialog(null, "Geçersiz Kullanıcı Adı veya Şifre!");
		                }
		            }
		        });

		        // Bileşenleri Ekle
		        add(lblUsername);
		        add(txtUsername);
		        add(lblPassword);
		        add(txtPassword);
		        add(new JLabel()); // Boş alan
		        add(btnLogin);

		        setVisible(true); // Görünür yap
		    }

		    public static void main(String[] args) {
		        new LoginPage(); // Giriş sayfasını başlat
		    }
		

	}


