package DBMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pawan on 14-04-2017.
 */
public class DeleteListner implements ActionListener {

    private DataBase sql;
    private JPanel panel;
    private JButton delete,cancel;
    private AMSsystem ui;

    DeleteListner(DataBase sql,JPanel jp,AMSsystem ui)
    {
        super();
        this.sql=sql;
        this.panel=jp;
        this.ui=ui;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        panel.removeAll();
        panel.repaint();
        switch (e.getActionCommand())
        {
            case "Airports":
                deleteAirport();
                break;
            case "Employees":
                deleteEmployees();
                break;
            case "Passengers":
                deletePassenger();
                break;
            case "Flights":
                deleteFlight();
                break;
            case "Tickets":
                deleteTicket();
                break;
            case "Routes":
                deleteRoute();
                break;
            case "Flight follows Route":
                deleteFollows();
                break;
            case "Airport has Flight":
                deleteHas();
                break;
            case "Employee serve Passenger":
                deleteServe();
                break;
            case "Managers":
                deleteManager();
                break;
        }
    }

    private void deleteAirport()
    {
        ui.getMessageLabel().setText("Enter Airport ID !! ");
        JTextField A_ID = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
        JPanel AID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport ID : "),new Dimension(200,40)),A_ID});
        delete=UIrequired.setupButton(new JButton("Delete"), null, Color.red, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deleteAirport(A_ID.getText());
                new Message("SuccessFully Deleted !!",ui,sql);
            }
        }, "Delete");
        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(AID);;panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void deleteEmployees()
    {
        ui.getMessageLabel().setText("Enter Employee ID !! ");
        JTextField E_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("ID : "),new Dimension(200,40)),E_ID});
        delete=UIrequired.setupButton(new JButton("Delete"), null, Color.red, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deleteEmployee(E_ID.getText());
                new Message("SuccessFully Deleted !!",ui,sql);
            }
        }, "Delete");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(ID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }
    
    private void deletePassenger()
    {
        ui.getMessageLabel().setText("Enter Passenger ID !! ");
        JTextField P_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("ID : "),new Dimension(200,40)),P_ID});
        delete=UIrequired.setupButton(new JButton("Delete"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deletePassenger(P_ID.getText());
                new Message("SuccessFully Deleted !!",ui,sql);
            }
        }, "Delete");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(ID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }
    
    private void deleteFlight()
    {
        ui.getMessageLabel().setText("Enter Flight details !! ");
        JTextField F_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Flight ID : "),new Dimension(200,40)),F_ID});
        delete=UIrequired.setupButton(new JButton("Delete"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deleteFlight(F_ID.getText());
                new Message("SuccessFully Deleted !!",ui,sql);
            }
        }, "Delete");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null),"Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(ID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }
    
    private void deleteTicket()
    {
        ui.getMessageLabel().setText("Enter Ticket ID !! ");
        JTextField T_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Ticket ID : "),new Dimension(200,40)),T_ID});
        delete=UIrequired.setupButton(new JButton("Delete"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deleteTicket(T_ID.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Delete");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(ID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }
    
    private void deleteRoute()
    {
        ui.getMessageLabel().setText("Enter Route details !! ");
        JTextField R_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Route ID : "),new Dimension(200,40)),R_ID});
        delete=UIrequired.setupButton(new JButton("Delete"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deleteRoute(R_ID.getText());
                new Message("SuccessFully Deleted !!",ui,sql);
            }
        }, "Delete");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(ID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void deleteFollows()
    {
        ui.getMessageLabel().setText("Enter Follows details !! ");
        JTextField F_RID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JTextField F_FID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JPanel RID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Route ID : "),new Dimension(200,40)),F_RID});
        JPanel FID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Flight ID : "),new Dimension(200,40)),F_FID});
        delete=UIrequired.setupButton(new JButton("Delete"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deleteFollows(F_RID.getText(),F_FID.getText());
                new Message("SuccessFully Deleted !!",ui,sql);
            }
        }, "Delete");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(RID);panel.add(FID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void deleteHas()
    {
        ui.getMessageLabel().setText("Enter Has details !! ");
        JTextField H_AID = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
        JTextField H_FID = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
        JPanel AID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport ID : "),new Dimension(200,40)),H_AID});
        JPanel FID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Flight ID : "),new Dimension(200,40)),H_FID});
        delete=UIrequired.setupButton(new JButton("Delete"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deleteHas(H_AID.getText(),H_FID.getText());
                new Message("SuccessFully Deleted !!",ui,sql);
            }
        }, "Delete");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(AID);panel.add(FID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void deleteServe()
    {
        ui.getMessageLabel().setText("Enter Serve details !! ");
        JTextField S_EID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JTextField S_PID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JPanel EID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Employee ID : "),new Dimension(200,40)),S_EID});
        JPanel PID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Passenger ID : "),new Dimension(200,40)),S_PID});
        delete=UIrequired.setupButton(new JButton("Delete"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deleteServe(S_EID.getText(),S_PID.getText());
                new Message("SuccessFully Deleted !!",ui,sql);
            }
        }, "Delete");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null),"Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(EID);panel.add(PID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void deleteManager()
    {
        ui.getMessageLabel().setText("Enter Manager details !! ");
        JTextField user = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JPanel username = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Username : "),new Dimension(200,40)),user});
        delete=UIrequired.setupButton(new JButton("Delete"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.deleteManager(user.getText());
                new Message("SuccessFully Deleted !!",ui,sql);
            }
        }, "Delete");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),delete,cancel});
        panel.add(username);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }
}
