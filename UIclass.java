package DBMS;

import javax.swing.*;

/**
 * Created by Pawan on 08-04-2017.
 */
public class UIclass extends Thread {

    private JFrame uiF;
    private JPanel uiP;
    private DataBase sql;
    private String user;

    UIclass()
    {
        uiF = new JFrame();
        sql=new DataBase();
    }

    public void init()
    {
        uiF.setTitle("Airport Managment System");
        uiF.setSize(1000,100);
        uiF.setExtendedState(uiF.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        uiF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        uiF.setVisible(true);
        this.uiP = new Login(this,sql);
        uiF.setContentPane(uiP);
        uiF.revalidate();
    }

    public void setupSystem(){
        this.uiP=new AMSsystem(sql,this,user);
        uiF.setContentPane(uiP);
        uiF.revalidate();
    }

    public void logout()
    {
        this.uiP=new Login(this,sql);
        uiF.setContentPane(uiP);
        uiF.revalidate();
    }

    public void setUser(String user)
    {
        this.user=user;
    }
}
