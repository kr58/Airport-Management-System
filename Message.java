package DBMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pawan on 08-04-2017.
 */
public class Message extends JFrame {
    private JLabel msg;
    private JButton ok;

    Message(String show, AMSsystem ui, DataBase sql)
    {
        msg = new JLabel(show, JLabel.CENTER);
        ok = new JButton();

        setTitle("Message");
        setSize(220, 150);
        getContentPane().setBackground(new Color(128, 212, 255));

        msg.setMaximumSize(new Dimension(200, 60));
        msg.setAlignmentX(Component.CENTER_ALIGNMENT);
        msg.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 15));

        ok= UIrequired.setupButton(new JButton("OK"),null,new Color(0, 170, 255),new Dimension(60, 20),new ActionListner(ui,sql,this),"Insert");

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(msg);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(ok);
        add(Box.createRigidArea(new Dimension(0, 20)));

        int screen_width = getToolkit().getScreenSize().width, screen_height = getToolkit().getScreenSize().height;
        setLocation((screen_width - getWidth()) / 2, (screen_height - getHeight()) / 2);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}