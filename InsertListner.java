package DBMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pawan on 09-04-2017.
 */
public class InsertListner implements ActionListener {

    private DataBase sql;
    private JPanel panel;
    private JButton save,cancel;
    private AMSsystem ui;

    InsertListner(DataBase sql,JPanel jp,AMSsystem ui)
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
                insertAirport();
                break;
            case "Employees":
                insertEmployees();
                break;
            case "Passengers":
                insertPassenger();
                break;
            case "Flights":
                insertFlight();
                break;
            case "Tickets":
                insertTicket();
                break;
            case "Routes":
                insertRoute();
                break;
            case "Flight follows Route":
                insertFollows();
                break;
            case "Airport has Flight":
                insertHas();
                break;
            case "Employee serve Passenger":
                insertServe();
                break;
            case "Managers":
                insertManager();
                break;
        }
    }

    private void insertAirport()
    {
        ui.getMessageLabel().setText("Enter Airport details !! ");
        JTextField A_name,A_add,A_ID;

        A_ID = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
        A_name = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
        A_add = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));

        JPanel AID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport ID                    : "),new Dimension(200,40)),A_ID});
        JPanel AName = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport Name              : "),new Dimension(200,40)),A_name});
        JPanel AAdd = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport Address          : "),new Dimension(200,40)),A_add});
        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertAirport(A_ID.getText(),A_name.getText(),A_add.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});

        panel.add(AID);panel.add(AName);panel.add(AAdd);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void insertEmployees()
    {
        ui.getMessageLabel().setText("Enter Employee details !! ");
        JTextField E_ID,E_Add,E_Name,E_Salary,E_AID;

        E_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        E_Name = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        E_Add = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        E_Salary = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        E_AID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));

        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("ID : "),new Dimension(200,40)),E_ID});
        JPanel Name = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Name : "),new Dimension(200,40)),E_Name});
        JPanel ADD = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Address : "),new Dimension(200,40)),E_Add});
        JPanel Salary = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Salary : "),new Dimension(200,40)),E_Salary});
        JPanel AID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport ID : "),new Dimension(200,40)),E_AID});
        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertEmployee(E_ID.getText(),E_Name.getText(),E_Add.getText(),E_Salary.getText(),E_AID.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});

        panel.add(ID);panel.add(Name);panel.add(ADD);panel.add(Salary);panel.add(AID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void insertTicket()
    {
        ui.getMessageLabel().setText("Enter Ticket details !! ");
        JTextField T_PID, T_RID, T_Price,T_ID;

        T_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        T_RID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        T_PID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        T_Price = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));

        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Ticket ID : "),new Dimension(200,40)),T_ID});
        JPanel RID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Route ID : "),new Dimension(200,40)),T_RID});
        JPanel PID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Passenger ID : "),new Dimension(200,40)),T_PID});
        JPanel Price = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Price : "),new Dimension(200,40)),T_Price});

        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertTicket(T_ID.getText(),T_RID.getText(),T_PID.getText(),T_Price.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});
        panel.add(ID);panel.add(RID);panel.add(PID);panel.add(Price);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void insertFlight()
    {
        ui.getMessageLabel().setText("Enter Flight details !! ");
        JTextField F_ID, F_Cap, F_Rat;

        F_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        F_Cap = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        F_Rat = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));

        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Flight ID : "),new Dimension(200,40)),F_ID});
        JPanel Cap = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Capacity : "),new Dimension(200,40)),F_Cap});
        JPanel Rat = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Rating : "),new Dimension(200,40)),F_Rat});

        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertFlight(F_ID.getText(),F_Cap.getText(),F_Rat.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null),"Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});
        panel.add(ID);panel.add(Cap);panel.add(Rat);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void insertPassenger()
    {
        ui.getMessageLabel().setText("Enter Passenger details !! ");
        JTextField P_ID,P_FID,P_Name,P_Add;
        P_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        P_Name = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        P_Add = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        P_FID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));

        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("ID : "),new Dimension(200,40)),P_ID});
        JPanel Name = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Name : "),new Dimension(200,40)),P_Name});
        JPanel Add = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Address : "),new Dimension(200,40)),P_Add});
        JPanel FID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Flight ID : "),new Dimension(200,40)),P_FID});

        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertPassenger(P_ID.getText(),P_Name.getText(),P_Add.getText(),P_FID.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});
        panel.add(ID);panel.add(Name);panel.add(Add);panel.add(FID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void insertRoute()
    {
        ui.getMessageLabel().setText("Enter Route details !! ");
        JTextField R_ID,R_Source,R_Destination, R_Path;

        R_ID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        R_Source = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        R_Destination = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        R_Path = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));

        JPanel ID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Route ID : "),new Dimension(200,40)),R_ID});
        JPanel SRC = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Source : "),new Dimension(200,40)),R_Source});
        JPanel DES = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Destination : "),new Dimension(200,40)),R_Destination});
        JPanel Path = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Path (Direct(Yes) or Not(No)) : "),new Dimension(200,40)),R_Path});

        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertRoute(R_ID.getText(),R_Source.getText(),R_Destination.getText(),R_Path.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});
        panel.add(ID);panel.add(SRC);panel.add(DES);panel.add(Path);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void insertFollows()
    {
        ui.getMessageLabel().setText("Enter Follows details !! ");
        JTextField F_RID,F_FID,F_Time,F_Date;

        F_RID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        F_FID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        F_Time = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        F_Date = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));

        JPanel RID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Route ID : "),new Dimension(200,40)),F_RID});
        JPanel FID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Flight ID : "),new Dimension(200,40)),F_FID});
        JPanel Time = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Time (hh:mm): "),new Dimension(200,40)),F_Time});
        JPanel Date = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Date (dd-mm-yyyy) : "),new Dimension(200,40)),F_Date});

        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertFollows(F_RID.getText(),F_FID.getText(),F_Time.getText(),F_Date.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});
        panel.add(RID);panel.add(FID);panel.add(Time);panel.add(Date);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void insertHas()
    {
        ui.getMessageLabel().setText("Enter Has details !! ");
        JTextField H_FID,H_AID;

        H_AID = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
        H_FID = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));

        JPanel AID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport ID : "),new Dimension(200,40)),H_AID});
        JPanel FID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Flight ID : "),new Dimension(200,40)),H_FID});
        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertHas(H_AID.getText(),H_FID.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null), "Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});

        panel.add(AID);panel.add(FID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void insertServe()
    {
        ui.getMessageLabel().setText("Enter Serve details !! ");

        JTextField S_EID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JTextField S_PID = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JTextField S_RAT = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));

        JPanel EID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Employee ID : "),new Dimension(200,40)),S_EID});
        JPanel PID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Passenger ID : "),new Dimension(200,40)),S_PID});
        JPanel RAT = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Rating : "),new Dimension(200,40)),S_RAT});

        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertServe(S_EID.getText(),S_PID.getText(),S_RAT.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null),"Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});
        panel.add(EID);panel.add(PID);panel.add(RAT);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }

    private void insertManager()
    {
        ui.getMessageLabel().setText("Enter Manager Username and Password !! ");

        JTextField user = UIrequired.setupTextField(new JTextField(),new Dimension(200,30));
        JPasswordField pass = (JPasswordField) UIrequired.setupTextField(new JPasswordField(),new Dimension(200,30));
        JPanel username = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Username : "),new Dimension(200,40)),user});
        JPanel password = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Password : "),new Dimension(200,40)),pass});

        save=UIrequired.setupButton(new JButton("Save"), null, null, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql.insertManager(user.getText(),pass.getText());
                new Message("SuccessFully Stored !!",ui,sql);
            }
        }, "Save");

        cancel=UIrequired.setupButton(new JButton("Cancel"), null, new Color(0xff7777), new Dimension(100, 30), new ActionListner(ui,sql,null),"Insert");
        JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),save,cancel});
        panel.add(username);panel.add(password);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
    }
}