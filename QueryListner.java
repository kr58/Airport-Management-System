package DBMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pawan on 09-04-2017.
 */
public class QueryListner implements ActionListener
{
    private String query;
    private DataBase sql;
    private JPanel panel;
    private AMSsystem ui;
    private int count;

    QueryListner(DataBase sql, JPanel panel, AMSsystem ui, String query)
    {
        super();
        this.query=query;
        this.sql=sql;
        this.panel=panel;
        this.ui=ui;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        panel.removeAll();
        panel.repaint();
        switch (e.getActionCommand())
        {
            case "Query0":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(790,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Airport ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Airport Name"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Airport Address"),new Dimension(200,40))}));
                ResultSet result=sql.getQuery0();
                ArrayList<String> q=new ArrayList<String>();
                q.add("Airport ID");q.add("Airport Name");q.add("Aiport Address");
                print(result, 790, q);
                break;
            case "Query1":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(990,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Employee ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Name"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Address"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Salary"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("AID"),new Dimension(200,40))}));
                ResultSet res1=sql.getQuery1();
                ArrayList<String> q1=new ArrayList<String>();
                q1.add("Employee ID");q1.add("Name");q1.add("Address");q1.add("Salary");q1.add("AID");
                print(res1, 990, q1);
                break;
            case "Query2":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(990,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Ticket ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Route ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Passenger ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Price"),new Dimension(200,40))}));
                ResultSet res=sql.getQuery2();
                ArrayList<String> q2=new ArrayList<String>();
                q2.add("Ticket ID");q2.add("Route ID");q2.add("Passenger ID");q2.add("Price");
                print(res, 990, q2);
                break;
            case "Query3":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(790,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Capacity"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Rating"),new Dimension(200,40))}));
                ResultSet res3=sql.getQuery3();
                ArrayList<String> q3=new ArrayList<String>();
                q3.add("Flight ID");q3.add("Capacity");q3.add("Rating");
                print(res3, 790, q3);
                break;
            case "Query4":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(990,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Passenger ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Name"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Address"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40))}));
                ResultSet res4=sql.getQuery4();
                ArrayList<String> q4=new ArrayList<String>();
                q4.add("Passenger ID");q4.add("Name");q4.add("Address");q4.add("Flight ID");
                print(res4,990,q4);
                break;
            case "Query5":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(990,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Route ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Source"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Destination"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Direct or Not"),new Dimension(200,40))}));
                ResultSet res5=sql.getQuery5();
                ArrayList<String> q5=new ArrayList<String>();
                q5.add("Route ID");q5.add("Source");q5.add("Destination");q5.add("Direct or Not");
                print(res5, 990, q5);
                break;
            case "Query6":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(990,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Route ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Time"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Date"),new Dimension(200,40))}));
                ResultSet res6=sql.getQuery6();
                ArrayList<String> q6=new ArrayList<String>();
                q6.add("Route ID");q6.add("Flight ID");q6.add("Time");q6.add("Date");
                print(res6, 990, q6);
                break;
            case "Query7":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(590,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Airport ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40))}));
                ResultSet res7=sql.getQuery7();
                ArrayList<String> q7=new ArrayList<String>();
                q7.add("Airport ID");q7.add("Flight ID");
                print(res7, 590, q7);
                break;
            case "Query8":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(790,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Employee ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Passenger ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Rating "),new Dimension(200,40))}));
                ResultSet res8=sql.getQuery8();
                ArrayList<String> q8=new ArrayList<>();
                q8.add("Employee ID");q8.add("Passenger ID");q8.add("Rating");
                print(res8, 790, q8);
                break;
            case "Query9":
                ui.getMessageLabel().setText(query);

                JTextField src = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JTextField des = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));

                JPanel jsrc = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Source : "),new Dimension(200,40)),src});
                JPanel jdes = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Destination : "),new Dimension(200,40)),des});

                JButton submit = UIrequired.setupButton(new JButton("Submit"), null, Color.cyan, new Dimension(100, 30), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet result = sql.cheapFlight(src.getText(),des.getText());
                        panel.removeAll();panel.repaint();
                        panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(950,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Date"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Time"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Price"),new Dimension(200,40))}));
                        ArrayList<String> q=new ArrayList<String>();
                        q.add("FLight ID");q.add("Date");q.add("Time");q.add("Price");
                        print(result, 950, q);
                    }
                }, "Submit");
                JButton cancel = UIrequired.setupButton(new JButton("Cancel"),null, Color.red, new Dimension(100,30), new ActionListner(ui,sql,null),"QUERIES");
                JPanel  b = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),submit,cancel});
                panel.add(jsrc);panel.add(jdes);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(b);
                System.out.print("Query5");
                panel.updateUI();
                break;
            case "Query10":
                ui.getMessageLabel().setText(query);

                JTextField Src = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JTextField Des = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));

                JPanel jSrc = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Source : "),new Dimension(200,40)),Src});
                JPanel jDes = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Destination : "),new Dimension(200,40)),Des});

                JButton Submit = UIrequired.setupButton(new JButton("Submit"), null, Color.cyan, new Dimension(100, 30), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet result = sql.getQuery10(Src.getText(),Des.getText());
                        panel.removeAll();panel.repaint();
                        panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(550,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Passenger ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Passenger Name"),new Dimension(200,40))}));
                        ArrayList<String> q=new ArrayList<String>();
                        q.add("Passenger ID");q.add("Passenger Name");
                        print(result, 550, q);
                    }
                }, "Submit");
                JButton Cancel = UIrequired.setupButton(new JButton("Cancel"),null, Color.red, new Dimension(100,30), new ActionListner(ui,sql,null),"QUERIES");
                JPanel  B = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),Submit,Cancel});
                panel.add(jSrc);panel.add(jDes);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(B);
                System.out.print("Query5");
                panel.updateUI();
                break;
            case "Query11":
                ui.getMessageLabel().setText(query);

                JTextField Src11 = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JTextField Des11 = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));

                JPanel jSrc11 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Source : "),new Dimension(200,40)),Src11});
                JPanel jDes11 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Destination : "),new Dimension(200,40)),Des11});

                JButton Submit11 = UIrequired.setupButton(new JButton("Submit"), null, Color.cyan, new Dimension(100, 30), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet result = sql.getQuery11(Src11.getText(),Des11.getText());
                        panel.removeAll();panel.repaint();
                        panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(750,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("From"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("To"),new Dimension(200,40))}));
                        ArrayList<String> q=new ArrayList<String>();
                        q.add("Flight ID");q.add("From");q.add("To");
                        print(result, 750, q);
                    }
                }, "Submit");
                JButton Cancel11 = UIrequired.setupButton(new JButton("Cancel"),null, Color.red, new Dimension(100,30), new ActionListner(ui,sql,null),"QUERIES");
                JPanel  B11 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),Submit11,Cancel11});
                panel.add(jSrc11);panel.add(jDes11);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(B11);
                panel.updateUI();
                break;
            case "Query12":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(990,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Airport ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Employee ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Employee Name "),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Rating"),new Dimension(200,40))}));
                ResultSet res12=sql.getQuery12();
                ArrayList<String> q12=new ArrayList<>();
                q12.add("Airport ID");q12.add("Employee ID");q12.add("Employee Name");q12.add("Rating");
                print(res12, 990, q12);
                break;
            case "Query13":
                ui.getMessageLabel().setText(query);
                JTextField Check = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JPanel chk = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Percentage : "),new Dimension(200,40)),Check});
                JButton Submit13 = UIrequired.setupButton(new JButton("Submit"), null, Color.cyan, new Dimension(100, 30), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet result = sql.getQuery13(Check.getText());
                        panel.removeAll();panel.repaint();
                        panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(350,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("FID"),new Dimension(200,40))}));
                        ArrayList<String> q=new ArrayList<String>();
                        q.add("FID");
                        print(result, 350, q);
                    }
                }, "Submit");
                JButton Cancel13 = UIrequired.setupButton(new JButton("Cancel"),null, Color.red, new Dimension(100,30), new ActionListner(ui,sql,null),"QUERIES");
                JPanel  B13 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),Submit13,Cancel13});
                panel.add(chk);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(B13);
                panel.updateUI();
                break;
            case "Query14":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(590,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Revenue"),new Dimension(200,40))}));
                ResultSet res14=sql.getQuery14();
                ArrayList<String> q14=new ArrayList<>();
                q14.add("Flight ID");q14.add("Revenue");
                print(res14, 590, q14);
                break;
            case "Query15":
                ui.getMessageLabel().setText(query);
                JTextField AID = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JPanel AD = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport ID : "),new Dimension(200,40)),AID});
                JButton Submit15 = UIrequired.setupButton(new JButton("Submit"), null, Color.cyan, new Dimension(100, 30), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet result = sql.getQuery15(AID.getText());
                        panel.removeAll();panel.repaint();
                        panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(550,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("EID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Emplyee Name"),new Dimension(200,40))}));
                        ArrayList<String> q=new ArrayList<String>();
                        q.add("EID");q.add("Employee Name");
                        print(result, 550, q);
                    }
                }, "Submit");
                JButton Cancel15 = UIrequired.setupButton(new JButton("Cancel"),null, Color.red, new Dimension(100,30), new ActionListner(ui,sql,null),"QUERIES");
                JPanel  B15 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),Submit15,Cancel15});
                panel.add(AD);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(B15);
                panel.updateUI();
                break;
            case "Query16":
                ui.getMessageLabel().setText(query);
                JTextField Eid = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JPanel EID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Employee ID : "),new Dimension(200,40)),Eid});
                JButton Submit16 = UIrequired.setupButton(new JButton("Submit"), null, Color.cyan, new Dimension(100, 30), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet result = sql.getQuery16(Eid.getText());
                        panel.removeAll();panel.repaint();
                        panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(950,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Emplyee ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Passenger ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Passenger Name"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Rating"),new Dimension(200,40))}));
                        ArrayList<String> q=new ArrayList<String>();
                        q.add("Employee ID");q.add("Passenger ID");q.add("Passenger Name");q.add("Rating");
                        print(result, 950, q);
                    }
                }, "Submit");
                JButton Cancel16 = UIrequired.setupButton(new JButton("Cancel"),null, Color.red, new Dimension(100,30), new ActionListner(ui,sql,null),"QUERIES");
                JPanel  B16 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),Submit16,Cancel16});
                panel.add(EID);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(B16);
                panel.updateUI();
                break;
            case "Query17":
                ui.getMessageLabel().setText(query);
                JTextField Pid = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JTextField Pname = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JPanel PID = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Passenger ID : "),new Dimension(200,40)),Pid});
                JPanel PNAME = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Passenger Name : "),new Dimension(200,40)),Pname});
                JButton Submit17 = UIrequired.setupButton(new JButton("Submit"), null, Color.cyan, new Dimension(100, 30), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet result = sql.getQuery17(Pid.getText(),Pname.getText());
                        panel.removeAll();panel.repaint();
                        panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(950,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Ticket ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Date"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Time"),new Dimension(200,40))}));
                        ArrayList<String> q=new ArrayList<String>();
                        q.add("Ticket ID");q.add("Flight ID");q.add("Date");q.add("Time");
                        print(result, 950, q);
                    }
                }, "Submit");
                JButton Cancel17 = UIrequired.setupButton(new JButton("Cancel"),null, Color.red, new Dimension(100,30), new ActionListner(ui,sql,null),"QUERIES");
                JPanel  B17 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),Submit17,Cancel17});
                panel.add(PID);panel.add(PNAME);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(B17);
                panel.updateUI();
                break;
            case "Query18":
                ui.getMessageLabel().setText(query);
                JTextField Aid = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JTextField Src18 = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JTextField Des18 = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JPanel AID18 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport ID : "),new Dimension(200,40)),Aid});
                JPanel SRC18 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Source : "),new Dimension(200,40)),Src18});
                JPanel DES18 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Destination : "),new Dimension(200,40)),Des18});
                JButton Submit18 = UIrequired.setupButton(new JButton("Submit"), null, Color.cyan, new Dimension(100, 30), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet result = sql.getQuery18(Aid.getText(),Src18.getText(),Des18.getText());
                        panel.removeAll();panel.repaint();
                        panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(1150,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Airport ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Date"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Time"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Price"),new Dimension(200,40))}));
                        ArrayList<String> q=new ArrayList<String>();
                        q.add("Airport ID");q.add("Flight ID");q.add("Date");q.add("Time");q.add("Price");
                        print(result, 1150, q);
                    }
                }, "Submit");
                JButton Cancel18 = UIrequired.setupButton(new JButton("Cancel"),null, Color.red, new Dimension(100,30), new ActionListner(ui,sql,null),"QUERIES");
                JPanel  B18 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),Submit18,Cancel18});
                panel.add(AID18);panel.add(SRC18);panel.add(DES18);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(B18);
                panel.updateUI();
                break;
            case "Query19":
                ui.getMessageLabel().setText(query);
                JTextField Aid19 = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JTextField src19 = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JTextField des19 = UIrequired.setupTextField(new JTextField(20),new Dimension(200,30));
                JPanel AID19 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Airport ID : "),new Dimension(200,40)),Aid19});
                JPanel SRC19 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Source : "),new Dimension(200,40)),src19});
                JPanel DES19 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel("Destination : "),new Dimension(200,40)),des19});
                JButton Submit19 = UIrequired.setupButton(new JButton("Submit"), null, Color.cyan, new Dimension(100, 30), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet result = sql.getQuery19(Aid19.getText(),src19.getText(),des19.getText());
                        panel.removeAll();panel.repaint();
                        panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(1150,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Airport ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Date"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Time"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Price"),new Dimension(200,40))}));
                        ArrayList<String> q=new ArrayList<String>();
                        q.add("Airport ID");q.add("Flight ID");q.add("Date");q.add("Time");q.add("Price");
                        print(result, 1150, q);
                    }
                }, "Submit");
                JButton Cancel19 = UIrequired.setupButton(new JButton("Cancel"),null, Color.red, new Dimension(100,30), new ActionListner(ui,sql,null),"QUERIES");
                JPanel  B19 = UIrequired.setupPanel(new JPanel(),new Dimension(500,40),Color.white,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(200,40)),Submit19,Cancel19});
                panel.add(AID19);panel.add(SRC19);panel.add(DES19);panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(500,40),null,null));panel.add(B19);
                panel.updateUI();
                break;
            case "Query20":
                ui.getMessageLabel().setText(query);
                panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(590,50),Color.lightGray,new JComponent[]{UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)),UIrequired.setupLabel(new JLabel("Flight ID"),new Dimension(200,40)),UIrequired.setupLabel(new JLabel("Tickets Sold"),new Dimension(200,40))}));
                ResultSet res20=sql.getQuery20();
                ArrayList<String> q20=new ArrayList<>();
                q20.add("Flight ID");q20.add("Tickes Sold");
                print(res20, 590, q20);
                break;
        }
    }

    private void print(ResultSet result, int panelsize, ArrayList<String> q)
    {
        System.out.println(panelsize);
        try {
            count=0;int i=0;
            int column=result.getMetaData().getColumnCount();
            System.out.print(column);
            HashMap<Integer, ArrayList<String>> data = new HashMap<>();
            while (result.next())
            {
                ArrayList<String> value = new ArrayList<>();
                for(int j=0;j<column;j++) value.add(result.getString(j+1));
                data.put(i++, value);
            }
            while (count < 10  && count < data.size())
            {
                JPanel jp = UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0)), new Dimension(panelsize, 30), new Color(0xfafafa), null);
                jp.add(UIrequired.setupLabel(new JLabel(count + 1 + "."), new Dimension(30, 30)));
                for(int j=0;j<column;j++) jp.add(UIrequired.setupLabel(new JLabel(data.get(count).get(j)), new Dimension(200, 30)));
                panel.add(jp);
                ++count;
            }
            panel.add(UIrequired.setupPanel(new JPanel(), new Dimension(panelsize, 30), null, null));
            Print p = new Print(data, count, panel, q, panelsize, column);
            JButton b1 = UIrequired.setupButton(new JButton("Next"), null, Color.cyan, new Dimension(150, 30), p, "NextQuery");
            JButton b2 = UIrequired.setupButton(new JButton("Back"), null, Color.cyan, new Dimension(150, 30), p, "BackQuery");
            if (count < 10) b1.setEnabled(false);
            b2.setEnabled(false);
            panel.add(UIrequired.setupPanel(new JPanel(), new Dimension(790, 40), null, new JComponent[]{UIrequired.setupLabel(new JLabel(""), new Dimension(400, 30)), b2, b1}));
        }catch (Exception e){ ui.getMessageLabel().setText("NO DATA");e.printStackTrace();}
        panel.updateUI();
    }
}