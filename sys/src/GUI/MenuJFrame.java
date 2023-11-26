package GUI;
import DAL.DAOimpl.StudentDAOImpl;
import DAL.DAOimpl.UserDAOImpl;
import DAL.DBUtil;
import DAL.Entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuJFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MenuJFrame frame = new MenuJFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MenuJFrame() {

        setTitle("学生管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 150, 1000, 600);

        // Create functional buttons
        JButton dataMaintenanceButton = createButton("数据维护", "关于.png", "班级管理", "数据添加", "数据修改", "数据删除", "退出系统");
        JButton dataQueryButton = createButton("数据查询", "关于.png", "按学号查询");
        JButton dataDisplayButton = createButton("数据显示", "display.png", "浏览");
        JButton systemMaintenanceButton = createButton("系统维护", "maintenance.png", "用户管理", "关于", "帮助");
        // Set layout to BorderLayout
        setLayout(new BorderLayout());

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(dataMaintenanceButton);
        buttonPanel.add(dataQueryButton);
        buttonPanel.add(dataDisplayButton);
        buttonPanel.add(systemMaintenanceButton);

        // Add button panel to the main panel at the north
        add(buttonPanel, BorderLayout.NORTH);

        // Create content panel
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(createContentPanel(new AboutPanel()), "关于");
        cardPanel.add(createContentPanel(new ClassManagementPanel()), "班级管理");
        cardPanel.add(createContentPanel(new DataAdditionPanel()), "数据添加");
        cardPanel.add(createContentPanel(new DataModificationPanel()), "数据修改");
        cardPanel.add(createContentPanel(new DataDeletionPanel()), "数据删除");
        cardPanel.add(createContentPanel(new DataQueryPanel()), "按学号查询");
        cardPanel.add(createContentPanel(new DataBrowsePanel()), "浏览");
        cardPanel.add(createContentPanel(new UserManagementPanel()), "用户管理");
        cardPanel.add(createContentPanel(new AboutPanel()), "关于");
        cardPanel.add(createContentPanel(new HelpPanel()), "帮助");
        JFrame frame = this;
        cardPanel.add(createContentPanel(new SystemExitPanel( frame)), "退出系统");
        // Add content panel to the main panel at the center
        add(cardPanel, BorderLayout.CENTER);


        setVisible(true);

    }

    private JButton createButton(String text, String iconName, String... options) {
        JButton button = new JButton(text, new ImageIcon(iconName));
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        button.setPreferredSize(new Dimension(200, 30));

        JPopupMenu popupMenu = new JPopupMenu();
        for (String option : options) {
            String optionIcon = "resources/" + option.toLowerCase() + ".png";
            JMenuItem menuItem = new JMenuItem(option, new ImageIcon(optionIcon));
            menuItem.setPreferredSize(new Dimension(150, 70));
            menuItem.addActionListener(e -> cardLayout.show(cardPanel, option));

            popupMenu.add(menuItem);
        }

        button.addActionListener(e -> popupMenu.show(button, 0, button.getHeight()));

        return button;
    }

    private JPanel createContentPanel(JPanel contentPanel) {
        return contentPanel;
    }

}
