import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentManagement extends JFrame {
    private DefaultTableModel model;
    private JTable table;
    private JTextField idField, nameField, courseField;

    public StudentManagement() {
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 4));
        inputPanel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Course:"));
        courseField = new JTextField();
        inputPanel.add(courseField);

        JButton addButton = new JButton("Add Student");
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table to show students
        model = new DefaultTableModel(new String[]{"ID", "Name", "Course"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Add button action
        addButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String course = courseField.getText().trim();

            if (!id.isEmpty() && !name.isEmpty() && !course.isEmpty()) {
                model.addRow(new String[]{id, name, course});
                idField.setText("");
                nameField.setText("");
                courseField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Fill all fields");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagement().setVisible(true));
    }
}
