package DBMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.FileLock;

import static java.lang.Thread.sleep;

/**
 * Created by Pawan on 15-04-2017.
 */
public class Login extends JPanel {

    private UIclass ui;
    private DataBase sql;
    private JPanel loading;

    Login(UIclass ui,DataBase sql)
    {
        this.sql=sql;
        this.ui=ui;
        this.setAlignmentX(CENTER_ALIGNMENT);
        setup();
    }

    private void setup()
    {
        JLabel title1= new JLabel("AMS System");
        title1.setAlignmentX(CENTER_ALIGNMENT);
        title1.setForeground(Color.black);
        title1.setFont(new Font("Roboto Thin",Font.PLAIN,70));
        JLabel title2 = new JLabel("Login");
        title2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        title2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
        JPanel jp = UIrequired.setupPanel(new JPanel(),new Dimension(600,100),Color.white,null);
        JTextField username = UIrequired.setupTextField(new JTextField(20),new Dimension(150,30));
        JTextField password = (JPasswordField)UIrequired.setupTextField(new JPasswordField(20),new Dimension(150,30));
        JLabel messageLabel=new JLabel("");
        messageLabel.setAlignmentX(CENTER_ALIGNMENT);
        JButton loginButton=UIrequired.setupButton(new JButton("Sign in"), null, new Color(0x88ddff), new Dimension(100, 40), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = sql.login(username.getText(),password.getText());
                if(flag == 1) {
                    ui.setUser(username.getText());
                    addLoading();
                    ui.setupSystem();
                }
                else {
                    messageLabel.setForeground(new Color(0xff44444));
                    messageLabel.setFont(new Font("Roboto Light", Font.PLAIN, 16));
                    messageLabel.setText("Invalid username or password!");
                }
            }
        }, "Login");
        JButton exitButton=UIrequired.setupButton(new JButton("Exit"), new Color(0xffffff), new Color(0xff4444), new Dimension(100, 40), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }, "Exit");

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        this.add(Box.createVerticalStrut(10));

        this.add(title1);
        this.add(Box.createVerticalStrut(60));
        this.add(title2);
        this.add(Box.createVerticalStrut(40));
        JLabel usernameLabel=UIrequired.setupLabel(new JLabel("Username: "),new Dimension(200,40));usernameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        JPanel usernamePanel=UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER)),new Dimension(500,40),Color.white,new JComponent[]{usernameLabel,username});
        jp.add(usernamePanel);
        JLabel passwordLabel=UIrequired.setupLabel(new JLabel("Password: "),new Dimension(200,40));passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        JPanel passwordPanel=UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER)),new Dimension(500,40),Color.white,new JComponent[]{passwordLabel,password});
        jp.add(passwordPanel);
        JPanel buttonPanel = UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER,20,0)),new Dimension(600,100),Color.white,new JComponent[]{loginButton,exitButton});
        loading = UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER,20,0)),new Dimension(600,100),Color.WHITE,null);
        this.add(jp);
        this.add(messageLabel);
        this.add(Box.createVerticalStrut(80));
        //this.add(loading);
        this.add(buttonPanel);
    }

    public void addLoading()
    {
        ImageIcon image = new ImageIcon("ajax-loader.gif");
        loading.add(UIrequired.setupLabel(new JLabel("ASDSEGDF"),new Dimension(200,40)));
        loading.updateUI();
        //System.out.println("Start");
        //try{sleep(10000);}
        //catch (Exception e){e.printStackTrace();}
        //loading.removeAll();
        //loading.repaint();
    }
}
