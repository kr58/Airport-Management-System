package DBMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawan on 08-04-2017.
 */
public class AMSsystem extends JPanel {

    private JPanel menuPanel;
    private ArrayList<JButton> menuList;
    private JButton activeButton;
    private JPanel infoPanel;
    private JLabel messageLabel;
    private JPanel cPanel;
    private ActionListener listener;
    private DataBase sql;
    private UIclass ui;
    private String User;

    AMSsystem (DataBase sql, UIclass ui, String User)
    {
        this.User=User;
        this.ui=ui;
        this.sql=sql;
        this.listener = new ActionListner(this,sql,null);
        setupComponent();
        setupUILayout();
    }

    private void setupComponent()
    {
        menuPanel=UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER)),new Dimension(1000,45),Color.white,null);
        JLabel name = UIrequired.setupLabel(new JLabel("Hi, " + User),new Dimension(180,40));
        name.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        infoPanel=UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER)),new Dimension(1000,45),Color.white,new JComponent[]{name});
        messageLabel=UIrequired.setupLabel(new JLabel(""),new Dimension(500,40));
        messageLabel.setForeground(new Color(0x0099ff));
        cPanel=new JPanel();
        cPanel.setLayout(new BoxLayout(cPanel,BoxLayout.Y_AXIS));
        cPanel=UIrequired.setupPanel(cPanel,new Dimension(1150,600),Color.white,null);    //Changed Panel Size
    }

    private void setupUILayout()
    {
        this.setBackground(Color.white);
        makeMenu();
        this.add(menuPanel);
        this.add(infoPanel);
        this.add(messageLabel);
        this.add(Box.createVerticalStrut(100));
        cPanel.add(Box.createVerticalStrut(100));
        JLabel title = UIrequired.setupLabel(new JLabel("Welcome to the System!"),new Dimension(400,300));
        title.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,60));
        cPanel.add(title);
        this.add(cPanel);
        this.activeButton=menuList.get(0);
    }

    private void makeMenu()
    {
        menuList=new ArrayList<JButton>();
        menuList.add(UIrequired.setupButton(new JButton("Home"),null,Color.white,new Dimension(80,40),listener,"INFO"));
        menuList.add(UIrequired.setupButton(new JButton("Queries"),null,Color.white,new Dimension(80,40),listener,"QUERIES"));
        menuList.add(UIrequired.setupButton(new JButton("Insert"),null,Color.white,new Dimension(80,40),listener,"Insert"));
        menuList.add(UIrequired.setupButton(new JButton("Delete"),null,Color.white,new Dimension(80,40),listener,"Delete"));
        menuList.add(UIrequired.setupButton(new JButton("Log out"),null,new Color(0xff7777),new Dimension(80,40),listener,"Exit"));
        for(int i=0;i<menuList.size();i++) menuPanel.add(menuList.get(i));
        menuPanel.updateUI();
    }

    public UIclass getUIclass(){return ui;}
    public JPanel getUIPanel() {return cPanel;}
    public JButton getActiveButton(){
        return this.activeButton;
    }
    public void setActiveButton(JButton button){
        this.activeButton=button;
    }
    public JLabel getMessageLabel() {
        return messageLabel;
    }
}