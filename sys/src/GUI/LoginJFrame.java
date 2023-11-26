package GUI;

import DAL.DAOimpl.UserDAOImpl;
import DAL.Entity.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginJFrame extends JFrame {

    private JTextField userIdField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                LoginJFrame frame = new LoginJFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginJFrame() {
        setTitle("用户登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 350, 250, 150);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel userIdLabel = new JLabel("学号:");
        contentPane.add(userIdLabel);

        userIdField = new JTextField();
        contentPane.add(userIdField);

        JLabel passwordLabel = new JLabel("密码:");
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        contentPane.add(passwordField);

        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(e -> loginActionPerformed());
        contentPane.add(loginButton);

        JButton registerButton = new JButton("注册");
        registerButton.addActionListener(e -> registerActionPerformed());
        contentPane.add(registerButton);
    }

    private void loginActionPerformed() {
        String userId = userIdField.getText();
        char[] password = passwordField.getPassword();
        String passwordString = new String(password);
        UserDAOImpl userDAO = new UserDAOImpl();
        boolean isCertified = userDAO.certifyUser(userId, passwordString);

        if (isCertified) {
            JOptionPane.showMessageDialog(this, "登录成功");
            setVisible(false);
            SwingUtilities.invokeLater(MenuJFrame::new);
        } else {
            JOptionPane.showMessageDialog(this, "登录失败，学号或密码错误！", "用户登录", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registerActionPerformed() {
        String userId=userIdField.getText();
        char[]  password=passwordField.getPassword();
        String passwordString = new String(password);
        User user=new User(userId,passwordString);
        UserDAOImpl userDaoImpl=new UserDAOImpl();
        if(userDaoImpl.addUser(user)) {
            JOptionPane.showMessageDialog(this, "注册成功");
        }
        else {
            JOptionPane.showMessageDialog(this, "注册失败!","注册学生管理系统",JOptionPane.ERROR_MESSAGE);
        }
    }
}
