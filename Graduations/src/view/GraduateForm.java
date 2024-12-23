package view;

import javax.swing.SwingUtilities;

public class GraduateForm {
    public static void main(String[] args) {
        // Giriş sayfasını başlat
        SwingUtilities.invokeLater(() -> new LoginPage());
    }
}

