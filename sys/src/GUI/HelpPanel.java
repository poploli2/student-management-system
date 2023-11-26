package GUI;

import javax.swing.*;
import java.awt.*;

public class HelpPanel extends JPanel {
    public HelpPanel() {

        setLayout(null);

        JLabel titleLabel = new JLabel("帮助");

        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(300, 60, 400, 50);

        add(titleLabel);


    }
}
