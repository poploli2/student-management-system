package GUI;
import DAL.Entity.Student;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTablePanel extends JPanel {
    private JTable studentTable;
    private JScrollPane scrollPane;

    public StudentTablePanel(List<Student> studentList) {
        // 创建表格模型
        StudentTableModel tableModel = new StudentTableModel(studentList);

        // 创建 JTable
        studentTable = new JTable(tableModel);

        // 创建滚动面板，并将表格添加到其中
        scrollPane = new JScrollPane(studentTable);

        // 将滚动面板添加到面板中
        add(scrollPane);
    }

    // 自定义学生表格模型
    private class StudentTableModel extends AbstractTableModel {
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
