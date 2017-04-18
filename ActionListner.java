package DBMS;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;

/**
 * Created by Pawan on 08-04-2017.
 */
public class ActionListner implements ActionListener {

    private AMSsystem ui;
    private Message msg;
    private ArrayList<String> Entity= new ArrayList<>();
    private ArrayList<String> Query = new ArrayList<>();
    private DataBase sql;
    private JPanel panel;

    ActionListner(AMSsystem s, DataBase sql, Message msg)
    {
        super();
        this.msg=msg;
        this.ui=s;
        this.sql=sql;
        setupEntity();
        setupQuery();
    }

    private void setupQuery()
    {
        Query.add("Print all Airports");
        Query.add("Print all Employees");
        Query.add("Print all Tickets");
        Query.add("Print all Flights");
        Query.add("Print all Passengers");
        Query.add("Print all Routes");
        Query.add("Print all Follows");
        Query.add("Print all Has");
        Query.add("Print all Serve");
        Query.add("Providing the cheapest flight from a particular destination to other");
        Query.add("Print PID and Name of Passenger who are resident of a particular country and travelling a particular country");
        Query.add("Print all the Country where Flight stay between non Direct Flight");
        Query.add("Most Rated Employee in Each Airport");
        Query.add("List of Flights which are Filled with given Percentage");
        Query.add("Flight which has the most Revenue collected");
        Query.add("Print all Employees of given Airport");
        Query.add("Print all Passenger who give the Rating to given Employee");
        Query.add("Tickets of certain Passenger");
        Query.add("Search Flight by Source and Destination");
        Query.add("Print Flights which are direct from Source and Destination");
        Query.add("Number of tickets sold for each flight");
    }
    private void setupEntity()
    {
        Entity.add("Airports");
        Entity.add("Tickets");
        Entity.add("Flights");
        Entity.add("Employees");
        Entity.add("Passengers");
        Entity.add("Routes");
        Entity.add("Flight follows Route");
        Entity.add("Airport has Flight");
        Entity.add("Employee serve Passenger");
        Entity.add("Managers");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        panel = ui.getUIPanel();
        switch (e.getActionCommand())
        {
            case "INFO":
                System.out.println("Informaton");
                ui.getMessageLabel().setText("");
                ui.getUIPanel().removeAll();
                JLabel title = UIrequired.setupLabel(new JLabel("Welcome to the System!"),new Dimension(400,300));
                title.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,60));
                ui.getUIPanel().add(title);
                ui.getUIPanel().updateUI();
                break;
            case "QUERIES":
                System.out.println("QUERIES");
                panel.removeAll();
                panel.repaint();
                ui.getMessageLabel().setText("Here is the list of Queries");
                JPanel jp = new JPanel();
                jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
                JScrollPane scroll = new JScrollPane(jp);
                scroll.setPreferredSize(new Dimension(700,400));
                scroll.setMaximumSize(new Dimension(700,400));
                scroll.setBackground(Color.yellow);

                for(int i=0;i<Query.size();i++)
                {
                    JButton b=UIrequired.setupButton(new JButton(Query.get(i)),null,new Color(0x99CCFF),new Dimension(550,40),new QueryListner(sql,panel,ui,Query.get(i)),"Query" + i);
                    ((JPanel)(scroll.getViewport().getView())).add(UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER)),new Dimension(600,50),null,new JComponent[]{b}));
                }

                scroll.updateUI();
                (scroll.getViewport().getView()).setBackground(new Color(0xfafafa));
                ((JPanel)(scroll.getViewport().getView())).setBorder(new EmptyBorder(20,0,20,0));
                panel.add(scroll);
                panel.updateUI();
                break;
            case "Insert":
                System.out.println("Insertion");
                if(msg!=null) msg.setVisible(false);
                panel.removeAll();
                panel.repaint();
                ui.getMessageLabel().setText("Here is the list where you can insert");

                for(int i=0;i<Entity.size();i++)
                {
                    JButton b=UIrequired.setupButton(new JButton(Entity.get(i)),null,new Color(0x99CCFF),new Dimension(200,40),new InsertListner(sql,panel,ui),Entity.get(i));
                    panel.add(UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER)),new Dimension(500,50),Color.white,new JComponent[]{b}));
                }

                panel.updateUI();
                break;
            case "Delete":
                System.out.println("Deletion");
                if(msg!=null) msg.setVisible(false);
                panel.removeAll();
                panel.repaint();
                ui.getMessageLabel().setText("Here is the list where you can Delete a row by there IDs");

                for(int i=0;i<Entity.size();i++)
                {
                    JButton b=UIrequired.setupButton(new JButton(Entity.get(i)),null,new Color(0x99CCFF),new Dimension(200,40),new DeleteListner(sql,panel,ui),Entity.get(i));
                    panel.add(UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER)),new Dimension(500,50),Color.white,new JComponent[]{b}));
                }

                panel.updateUI();
                break;
            case "Exit":
                ui.getUIclass().logout();
        }
    }
}