package GUI;

import DAL.DAOimpl.StudentDAOImpl;
import DAL.Entity.Student;

import javax.swing.*;
import java.awt.*;
public class DataAdditionPanel extends JPanel {
    private JTextField studentIdField;
    private JTextField studentNameField;
    private JTextField studentGenderField;
    private JTextField studentEthnicityField;
    private JTextField studentClassIdField;

    public DataAdditionPanel(){
        setLayout(null);

        JLabel titleLabel = new JLabel("添加学生信息");
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
        JButton addButton = new JButton("提交");

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
        addButton.setBounds(400,300,200,50);

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
        add(addButton);

        addButton.addActionListener(e -> addActionPerformed());

    }
    private void addActionPerformed() {
        String studentId = studentIdField.getText();
        String studentName = studentNameField.getText();
        int classId = Integer.parseInt(studentClassIdField.getText());
        String studentGender = studentIdField.getText();
        String studentEthnicity = studentEthnicityField.getText();
        Student stu = new Student(studentId, studentName, studentGender, studentEthnicity, classId);
        StudentDAOImpl stuDAO = new StudentDAOImpl();
        if (stuDAO.addStudent(stu)) {
            JOptionPane.showMessageDialog(this, "增加学生成功");
        } else {
            JOptionPane.showMessageDialog(this, "增加失败，请检查输入!", "添加学生信息", JOptionPane.ERROR_MESSAGE);
        }
    }
}
