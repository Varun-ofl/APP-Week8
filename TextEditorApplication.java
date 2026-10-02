import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class TextEditorApplication extends JFrame {
    private final JTextArea textArea = new JTextArea();

    public TextEditorApplication() {
        setTitle("Simple Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 450);
        setLocationRelativeTo(null);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(event -> textArea.setText(""));
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(event -> textArea.setText(""));
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> dispose());
        fileMenu.add(newItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        cutItem.addActionListener(event -> textArea.cut());
        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        copyItem.addActionListener(event -> textArea.copy());
        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        pasteItem.addActionListener(event -> textArea.paste());
        JMenuItem selectAllItem = new JMenuItem("Select All");
        selectAllItem.addActionListener(event -> textArea.selectAll());
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(selectAllItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        return menuBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditorApplication().setVisible(true));
    }
}
