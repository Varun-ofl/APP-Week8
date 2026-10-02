import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class StudentCourseManagement extends JFrame {
    private final DefaultListModel<String> courseModel = new DefaultListModel<>();
    private final JList<String> courseList = new JList<>(courseModel);
    private final DefaultTableModel tableModel = new DefaultTableModel(
            new String[]{"Student Name", "Selected Course", "Enrollment Status"}, 0);
    private final JTable registrationTable = new JTable(tableModel);

    public StudentCourseManagement() {
        setTitle("Student Course Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        courseModel.addElement("Java Programming");
        courseModel.addElement("Database Management");
        courseModel.addElement("Computer Networks");
        courseModel.addElement("Web Development");
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel coursePanel = new JPanel(new BorderLayout(5, 5));
        coursePanel.setBorder(BorderFactory.createTitledBorder("Available Courses"));
        coursePanel.add(new JScrollPane(courseList), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Registration");
        addButton.addActionListener(event -> addRegistration());
        JButton removeButton = new JButton("Remove Registration");
        removeButton.addActionListener(event -> removeRegistration());
        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(addButton);
        buttons.add(removeButton);
        coursePanel.add(buttons, BorderLayout.SOUTH);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Student Registrations"));
        tablePanel.add(new JScrollPane(registrationTable), BorderLayout.CENTER);

        JPanel content = new JPanel(new GridLayout(1, 2, 10, 10));
        content.add(coursePanel);
        content.add(tablePanel);
        add(content);
    }

    private void addRegistration() {
        String course = courseList.getSelectedValue();
        if (course == null) {
            JOptionPane.showMessageDialog(this, "Select a course first.");
            return;
        }
        String studentName = JOptionPane.showInputDialog(this, "Enter student name:");
        if (studentName != null && !studentName.trim().isEmpty()) {
            tableModel.addRow(new Object[]{studentName.trim(), course, "Enrolled"});
        }
    }

    private void removeRegistration() {
        int selectedRow = registrationTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a registration to remove.");
            return;
        }
        tableModel.removeRow(selectedRow);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentCourseManagement().setVisible(true));
    }
}
