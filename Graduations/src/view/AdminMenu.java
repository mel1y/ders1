package view;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
		
		class AdminMenu extends JFrame {
		    private JButton btnAddGraduate, btnDeleteGraduate, btnSearchGraduate, btnGrantAdmin, btnLogout;

		    public AdminMenu() {
		        // Admin Menüsü Tasarımı
		        setTitle("Admin Menüsü");
		        setLayout(new GridLayout(5, 1, 10, 10)); 
		        setSize(400, 300);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        //Butonlar
		        btnAddGraduate = new JButton("Mezun Ekle");
		        btnDeleteGraduate = new JButton("Mezun Sil");
		        btnSearchGraduate = new JButton("Mezun Sorgula");
		        btnGrantAdmin = new JButton("Admin Yetkisi Ver");
		        btnLogout = new JButton("Çıkış");

		        btnAddGraduate.addActionListener(e -> {
		            new AddGraduatePage(); // Mezun ekleme sayfasına geçirir
		            dispose(); // Admin menüsünü kapat
		        });

		        btnDeleteGraduate.addActionListener(e -> {
		            new DeleteGraduatePage(); // Mezun silme sayfasına gider
		            dispose();
		        });

		        btnSearchGraduate.addActionListener(e -> {
		            new SearchGraduatePage(); // Mezun sorgulama sayfasına geçer
		            dispose();
		        });

		        btnGrantAdmin.addActionListener(e -> {
		            new GrantAdminPage(); // Admin yetkisi verme sayfasına geç
		            dispose();
		        });

		        btnLogout.addActionListener(e -> {
		            new LoginPage(); // Giriş sayfasına dön
		            dispose();
		        });

		        // Bileşenleri Ekle
		        add(btnAddGraduate);
		        add(btnDeleteGraduate);
		        add(btnSearchGraduate);
		        add(btnGrantAdmin);
		        add(btnLogout);

		        setVisible(true); // Görünür yap
		    }
		

	}


		
