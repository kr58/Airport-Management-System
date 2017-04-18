package DBMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pawan on 09-04-2017.
 */
public class Print implements ActionListener
{
    private HashMap<Integer,ArrayList<String >> data;
    private int count;
    private JPanel panel;
    private ArrayList<String> query;
    private int panelSize;
    private int column;

    Print(HashMap<Integer,ArrayList<String >> data,int count,JPanel panel, ArrayList<String> q, int panelSize, int column)
    {
        super();
        this.panel=panel;
        this.data=data;
        this.count=count;
        this.panelSize=panelSize;
        this.query=q;
        this.column=column;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        panel.removeAll();
        panel.repaint();
        JPanel jp = UIrequired.setupPanel(new JPanel(),new Dimension(panelSize,50),Color.lightGray,null);
        jp.add(UIrequired.setupLabel(new JLabel("SNo."),new Dimension(40,40)));
        for(int j=0;j<query.size();j++) jp.add(UIrequired.setupLabel(new JLabel(query.get(j)),new Dimension(200,40)));
        panel.add(jp);
        switch (e.getActionCommand())
        {
            case "NextQuery":
                try {
                    System.out.println("Count : " + count + "Data Size : " + data.size());
                    while (count<data.size()) {
                        JPanel jpanel = UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0)), new Dimension(panelSize, 30), new Color(0xfafafa), null);
                        jpanel.add(UIrequired.setupLabel(new JLabel(count + 1 + "."), new Dimension(30, 30)));
                        for(int j=0;j<column;j++) jpanel.add(UIrequired.setupLabel(new JLabel(data.get(count).get(j)), new Dimension(200, 30)));
                        panel.add(jpanel);++count;
                        if(count%10==0) break ;
                    }
                    panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(790,30),null,null));
                    JButton b1=UIrequired.setupButton(new JButton("Next"),null,Color.cyan,new Dimension(150,30),this,"NextQuery");
                    JButton b2=UIrequired.setupButton(new JButton("Back"),null,Color.cyan,new Dimension(150,30),this,"BackQuery");
                    if(count%10!=0) b1.setEnabled(false);
                    if(count<=10) b2.setEnabled(false);
                    panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(790,40),null,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(400,30)),b2,b1}));
                }catch (Exception r){r.printStackTrace();}
                panel.updateUI();
                break;
            case "BackQuery":
                try {
                    int i=count-(count%10)-10;
                    System.out.println("Count : " + count + " i : " + i);
                    while (i>=0 && i<data.size()) {
                        JPanel jpanel = UIrequired.setupPanel(new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0)), new Dimension(panelSize, 30), new Color(0xfafafa), null);
                        jpanel.add(UIrequired.setupLabel(new JLabel(i + 1 + "."), new Dimension(30, 30)));
                        for(int j=0;j<column;j++) jpanel.add(UIrequired.setupLabel(new JLabel(data.get(i).get(j)), new Dimension(200, 30)));
                        panel.add(jpanel);++i;
                        if(i%10==0) break;
                    }
                    System.out.println("Count : " + count + " i : " + i);
                    count=i;
                    panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(790,30),null,null));
                    JButton b1=UIrequired.setupButton(new JButton("Next"),null,Color.cyan,new Dimension(150,30),this,"NextQuery");
                    JButton b2=UIrequired.setupButton(new JButton("Back"),null,Color.cyan,new Dimension(150,30),this,"BackQuery");
                    if(count%10!=0) b1.setEnabled(false);
                    else b1.setEnabled(true);
                    if(count<=10) b2.setEnabled(false);
                    panel.add(UIrequired.setupPanel(new JPanel(),new Dimension(790,40),null,new JComponent[]{UIrequired.setupLabel(new JLabel(""),new Dimension(400,30)),b2,b1}));
                }catch (Exception r){r.printStackTrace();}
                panel.updateUI();
                break;
        }
    }
}