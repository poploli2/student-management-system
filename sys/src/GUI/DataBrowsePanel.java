package GUI;
import DAL.DAOimpl.StudentDAOImpl;
import DAL.Entity.Student;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DataBrowsePanel extends JPanel {
    private JComboBox<String> comboBox;
    private JTextField textField;
    private JButton queryButton;
    private JTable studentTable;

    public DataBrowsePanel() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("浏览学生信息");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        String[] keyWords = {"学号", "姓名", "性别", "民族", "班级"};
        comboBox = new JComboBox<>(keyWords);
        textField = new JTextField();
        textField.setColumns(10);
        queryButton = new JButton("查询");

        inputPanel.add(new JLabel("按"));
        inputPanel.add(comboBox);
        inputPanel.add(textField);
        inputPanel.add(queryButton);

        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String column = mapColumnToDatabaseField(comboBox.getSelectedItem().toString());
                String content = textField.getText();
                StudentDAOImpl studentDAO = new StudentDAOImpl();
                List<Student> students;
                if (content.isEmpty()) {
                    students = studentDAO.getAllStudent();
                } else {
                    students = studentDAO.getStudentbyAny(column, content);
                }

                updateStudentTable(students);

            }
        });

        // 初始化表格
        studentTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private String mapColumnToDatabaseField(String column) {
        switch (column) {
            case "学号":
                return "student_id";
            case "姓名":
                return "name";
            case "性别":
                return "gender";
            case "民族":
                return "ethnicity";
            case "班级":
                return "class_id";
            default:
                throw new IllegalArgumentException("无效的查询关键字: " + column);
        }
    }

    private void updateStudentTable(List<Student> students) {
        StudentTableModel tableModel = new StudentTableModel(students);
        studentTable.setModel(tableModel);
    }

    private static class StudentTableModel extends AbstractTableModel {
        private List<Student> studentList;
        private String[] columnNames = {"学号", "姓名", "性别", "民族", "班级"};

        public StudentTableModel(List<Student> studentList) {
            this.studentList = studentList;
        }

        @Override
        public int getRowCount() {
            return studentList.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Student student = studentList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return student.getStudentId();
                case 1:
                    return student.getName();
                case 2:
                    return student.getGender();
                case 3:
                    return student.getEthnicity();
                case 4:
                    return student.getClassId();
                default:
                    return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}
