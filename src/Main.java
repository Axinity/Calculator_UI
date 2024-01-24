import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public  Main() {
        JFrame window = new JFrame("Calculator");
        window.setSize(270, 350);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.add(new Panel());
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}