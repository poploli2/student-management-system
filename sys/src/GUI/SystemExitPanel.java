package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemExitPanel extends JPanel {

    public SystemExitPanel(JFrame frame) {

        setLayout(null);

        JLabel label = new JLabel("确定要退出系统吗?");

        JButton yesButton = new JButton("确定");
        label.setFont(new Font("微软雅黑", Font.BOLD, 24));
        label.setBounds(350, 100, 300, 40);
        yesButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        yesButton.setBounds(380, 200, 160, 40);

        add(label);
        add(yesButton);
        yesButton.addActionListener(e -> {
            frame.dispose();
            System.exit(0);
        });
    }

}