package GUI;

import DAL.DAOimpl.ClassDAOImpl;
import DAL.DAOimpl.UserDAOImpl;
import DAL.Entity.Class;
import DAL.Entity.User;

import javax.swing.*;
import java.awt.*;

public class UserManagementPanel extends JPanel {
    private JTextField userIdField;
    private JPasswordField passWordField;

    public UserManagementPanel() {
        setLayout(null);

        JLabel titleLabel = new JLabel("用户管理");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(300, 60, 400, 50);
        JLabel userIdLabel = new JLabel("学号:");
        JLabel passWordLabel = new JLabel("密码:");

        userIdLabel.setBounds(400,180,200,20);
        passWordLabel.setBounds(400,220,200,20);

        userIdField = new JTextField();
        passWordField = new JPasswordField();
        userIdField.setBounds(470, 180, 140, 20);
        passWordField.setBounds(470, 220, 140, 20);

        JButton addButton = new JButton("增加用户");
        JButton deleteButton = new JButton("删除删除");
        addButton.setBounds(400, 260, 210, 30);
        deleteButton.setBounds(400, 300, 210, 30);

        // 添加组件到面板

        add(titleLabel);
        add(userIdLabel);
        add(passWordLabel);
        add(userIdField);
        add(passWordField);
        add(addButton);
        add(deleteButton);
        addButton.addActionListener(e -> addActionPerformed());

        deleteButton.addActionListener(e -> deleteActionPerformed());

    }

    private void addActionPerformed() {
        String userId = userIdField.getText();
        String passWord = passWordField.getText();
        UserDAOImpl userDAO = new UserDAOImpl();
        User user= new User(userId,passWord);
        if (userDAO.addUser(user)) {
            JOptionPane.showMessageDialog(this, "增加用户成功");
        } else {
            JOptionPane.showMessageDialog(this, "增加失败，请检查用户是否在学生表内", "用户管理", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void deleteActionPerformed() {
        String userId = userIdField.getText();
//        String passWord = passWordField.getText();
        UserDAOImpl userDAO = new UserDAOImpl();

        if (userDAO.deleteUserbyId(userId)) {
            JOptionPane.showMessageDialog(this, "删除成功");
        } else {
            JOptionPane.showMessageDialog(this, "删除失败，请核对学号是否存在", "班级管理", JOptionPane.ERROR_MESSAGE);
        }
    }
}
