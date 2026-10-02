import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UserLoginPreferences extends JFrame {
    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JCheckBox rememberMeBox = new JCheckBox("Remember Me");
    private final JCheckBox notificationsBox = new JCheckBox("Receive Notifications");

    public UserLoginPreferences() {
        setTitle("User Login and Preferences");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 230);
        setLocationRelativeTo(null);

        GridLayout layout = new GridLayout(5, 2, 8, 8);
        setLayout(layout);
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(rememberMeBox);
        add(notificationsBox);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(event -> login());
        add(new JLabel());
        add(loginButton);
    }

    private void login() {
        String username = usernameField.getText().trim();
        boolean hasPassword = passwordField.getPassword().length > 0;
        if (username.isEmpty() || !hasPassword) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.",
                    "Login Failed", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String message = "Welcome, " + username + "!\n"
                + "Remember Me: " + (rememberMeBox.isSelected() ? "Yes" : "No") + "\n"
                + "Receive Notifications: " + (notificationsBox.isSelected() ? "Yes" : "No");
        JOptionPane.showMessageDialog(this, message, "Login Successful",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserLoginPreferences().setVisible(true));
    }
}
