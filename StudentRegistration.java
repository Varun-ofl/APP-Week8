import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentRegistration extends JFrame {
    private final JTextField nameField = new JTextField();
    private final JTextField registerNumberField = new JTextField();
    private final JRadioButton maleButton = new JRadioButton("Male");
    private final JRadioButton femaleButton = new JRadioButton("Female");
    private final JComboBox<String> departmentBox = new JComboBox<>(
            new String[]{"Computer Science", "Information Technology", "Electronics", "Mechanical"});

    public StudentRegistration() {
        setTitle("Student Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 260);
        setLocationRelativeTo(null);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        maleButton.setSelected(true);

        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));
        form.add(new JLabel("Student name:"));
        form.add(nameField);
        form.add(new JLabel("Register number:"));
        form.add(registerNumberField);
        form.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        form.add(genderPanel);
        form.add(new JLabel("Department:"));
        form.add(departmentBox);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(event -> showStudentDetails());
        form.add(new JLabel());
        form.add(submitButton);
        add(form);
    }

    private void showStudentDetails() {
        String gender = maleButton.isSelected() ? "Male" : "Female";
        String details = "Name: " + nameField.getText()
                + "\nRegister number: " + registerNumberField.getText()
                + "\nGender: " + gender
                + "\nDepartment: " + departmentBox.getSelectedItem();
        JOptionPane.showMessageDialog(this, details, "Registration Details",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistration().setVisible(true));
    }
}
