package GUI;

import DAL.DAOimpl.ClassDAOImpl;
import DAL.Entity.Class;

import javax.swing.*;
import java.awt.*;

public class ClassManagementPanel extends JPanel {
    private JTextField classIdField;
    private JTextField classNameField;

    public ClassManagementPanel() {
        setLayout(null); // 使用 null 布局

        // 添加组件
        JLabel titleLabel = new JLabel("班级管理");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(300, 60, 400, 50); // 设置标题的位置和大小
        JLabel classIdLabel = new JLabel("班级ID:");
        JLabel classNameLabel = new JLabel("班级名称:");

        classIdLabel.setBounds(400,180,200,20);
        classNameLabel.setBounds(400,220,200,20);

        classIdField = new JTextField();
        classNameField = new JTextField();
        classIdField.setBounds(470, 180, 140, 20); // 设置班级ID文本框的位置和大小
        classNameField.setBounds(470, 220, 140, 20); // 设置班级名称文本框的位置和大小

        JButton addButton = new JButton("增加班级");
        JButton deleteButton = new JButton("删除班级");
        addButton.setBounds(400, 260, 210, 30); // 设置增加班级按钮的位置和大小
        deleteButton.setBounds(400, 300, 210, 30); // 设置删除班级按钮的位置和大小

        // 添加组件到面板

        add(titleLabel);
        add(classNameLabel);
        add(classIdLabel);
        add(classIdField);
        add(classNameField);
        add(addButton);
        add(deleteButton);
        addButton.addActionListener(e -> addActionPerformed());

        deleteButton.addActionListener(e -> deleteActionPerformed());

    }

    private void addActionPerformed() {
        int classId = Integer.parseInt(classIdField.getText());
        String className = classNameField.getText();
        ClassDAOImpl classDAO = new ClassDAOImpl();
        Class cla = new Class(classId,className);
        if (classDAO.addClass(cla)) {
            JOptionPane.showMessageDialog(this, "增加班级成功");
        } else {
            JOptionPane.showMessageDialog(this, "增加失败，请检查输入!", "班级管理", JOptionPane.ERROR_MESSAGE);
        }
    }

//    private void updateActionPerformed() {
//        int classId = Integer.parseInt(classIdField.getText());
//        String className = classNameField.getText();
//        ClassDAOImpl classDAO = new ClassDAOImpl();
//        Class cla = new Class(classId,className);
//        if (classDAO.updateClass(cla)) {
//            JOptionPane.showMessageDialog(this, "修改班级名称成功");
//        } else {
//            JOptionPane.showMessageDialog(this, "修改失败，请检查班级id及名称", "班级管理", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    private void deleteActionPerformed() {
        int classId = Integer.parseInt(classIdField.getText());
        String className = classNameField.getText();
        ClassDAOImpl classDAO = new ClassDAOImpl();
        Class cla = new Class(classId,className);
        if (classDAO.deleteClassbyID(classId)) {
            JOptionPane.showMessageDialog(this, "删除成功");
        } else {
            JOptionPane.showMessageDialog(this, "删除失败，请检查班级id是否正确", "班级管理", JOptionPane.ERROR_MESSAGE);
        }
    }
}
