package GUI;

import javax.swing.*;
import java.awt.*;

public class AboutPanel extends JPanel {
    public AboutPanel() {

        setLayout(null);

        JLabel titleLabel = new JLabel("关于我们");

        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(300, 60, 400, 50);

        add(titleLabel);


    }
}
