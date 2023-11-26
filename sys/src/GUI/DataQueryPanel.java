package GUI;

import DAL.DAOimpl.ClassDAOImpl;
import DAL.DAOimpl.StudentDAOImpl;
import DAL.Entity.Class;
import DAL.Entity.Student;

import javax.swing.*;
import java.awt.*;
public class DataQueryPanel extends JPanel {
    private JTextField studentIdField;
    private JTextField studentNameField;
    private JTextField studentGenderField;
    private JTextField studentEthnicityField;
    private JTextField studentClassIdField;

    private Student student;
    public DataQueryPanel(){
        Student defaultStudent = new Student();
        defaultStudent.setStudentId("");
        defaultStudent.setName("");
        defaultStudent.setGender("");
        defaultStudent.setEthnicity("");
        defaultStudent.setClassId(0);
        this.student = defaultStudent;
        setLayout(null);

        JLabel titleLabel = new JLabel("查询结果");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(300, 60, 400, 50); // 设置标题的位置和大小

        JLabel studentIdLabel = new JLabel("学号:");
        JLabel studentNameLabel = new JLabel("姓名:");
        JLabel studentGenderLabel = new JLabel("性别:");
        JLabel studentClassIdLabel = new JLabel("班级:");
        JLabel studentEthnicityLabel = new JLabel("民族:");
        studentIdField= new JTextField();
        studentNameField = new JTextField();
        studentGenderField= new JTextField();
        studentEthnicityField= new JTextField();
        studentClassIdField= new JTextField();
        JButton queryResultButton = new JButton("查询");

//        studentIdField.setText(student.getStudentId()+"");
//        studentNameField.setText(student.getName());
//        studentGenderField.setText(student.getGender());
//        studentEthnicityField.setText(student.getEthnicity());
//        studentClassIdField.setText(student.getClassId()+"");

        studentIdLabel.setBounds(0,150,200,30);
        studentIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        studentNameLabel.setBounds(0,190,200,30);
        studentNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        studentClassIdLabel.setBounds(400,190,200,30);
        studentClassIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        studentGenderLabel.setBounds(0,230,200,30);
        studentGenderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        studentEthnicityLabel.setBounds(400,230,200,30);
        studentEthnicityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        studentIdField.setBounds(220,150,140,20);
        studentNameField.setBounds(220,190,140,20);
        studentClassIdField.setBounds(620,190,140,20);
        studentGenderField.setBounds(220,230,140,20);
        studentEthnicityField.setBounds(620,230,140,20);
        queryResultButton.setBounds(400,300,200,30);

        add(titleLabel);
        add(studentIdLabel);
        add(studentNameLabel);
        add(studentGenderLabel);
        add(studentClassIdLabel);
        add(studentEthnicityLabel);
        add(studentIdField);
        add(studentNameField);
        add(studentGenderField);
        add(studentEthnicityField);
        add(studentClassIdField);
        add(queryResultButton);
        queryResultButton.addActionListener(e -> queryActionPerformed());
    }
    private void queryActionPerformed() {
        int studentId = Integer.parseInt(studentIdField.getText());
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        student = studentDAO.getStudentbyID(studentId);
        if (student!=null) {
            updateStudentFields();
            JOptionPane.showMessageDialog(this, "查询成功");
        } else {
            JOptionPane.showMessageDialog(this, "失败失败，请检查输入", "学生信息查询", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void updateStudentFields() {
        studentIdField.setText(String.valueOf(student.getStudentId()));
        studentNameField.setText(student.getName());
        studentGenderField.setText(student.getGender());
        studentEthnicityField.setText(student.getEthnicity());
        studentClassIdField.setText(String.valueOf(student.getClassId()));
    }
}
