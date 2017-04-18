package DBMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by Pawan on 08-04-2017.
 */
public class UIrequired
{
    public static JPanel setupPanel(JPanel jPanel, Dimension dimension, Color bg, JComponent[] components)
    {
        jPanel.setMaximumSize(dimension);
        jPanel.setPreferredSize(dimension);
        jPanel.setBackground(bg);
        if(components!=null)
            for (JComponent jComponent:components)
                jPanel.add(jComponent);
        return jPanel;
    }

    public static JLabel setupLabel(JLabel jLabel, Dimension dimension)
    {
        if(dimension!=null) jLabel.setPreferredSize(dimension);
        //if(font!=null) jLabel.setFont(font);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setBackground(Color.red);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return jLabel;
    }

    public static JButton setupButton(JButton button, Color fg, Color bg, Dimension dimension, ActionListener listener, String actionString)
    {
        if(fg!=null) button.setForeground(fg);
        if(bg!=null) button.setBackground(bg);
        if(dimension!=null) button.setPreferredSize(dimension);
        if(dimension!=null) button.setMinimumSize(dimension);
        button.setFocusPainted(false);
        if(listener!=null) button.addActionListener(listener);
        if(actionString!=null)button.setActionCommand(actionString);
        return button;
    }

    public static JTextField setupTextField(JTextField textField, Dimension dimension)
    {
        if(dimension!=null) textField.setPreferredSize(dimension);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textField;
    }
}