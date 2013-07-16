package de.anvier.Trinkspiel;

import javax.swing.*;

import java.awt.*;

public class SpielereingabeUI
{

    private JDialog _dialog;
    private JTextField _name;
    private JButton _ok;
    private JButton _cancel;
    private JButton _insertNext;
    
    public SpielereingabeUI()
    {
        
        _dialog = new JDialog();
        _name = new JTextField("Hier Namen eingeben!");
        
        JPanel contentPane = new JPanel(new GridLayout(3,3));
        _dialog.setContentPane(contentPane);
        _ok = new JButton("OK");
        _cancel = new JButton("Abbrechen");
        _insertNext = new JButton("OK und Weiteren Spieler hinzufügen");
        contentPane.add(_ok);
        contentPane.add(_name);
        contentPane.add(_insertNext);
        contentPane.add(_cancel);
        _dialog.pack();
        _dialog.setModal(true);
        _dialog.setVisible(false);
        
    }
    
    public void setVisible(boolean b)
    {
        _dialog.setVisible(b);
    }
    
    public JButton getOKButton()
    {
        return _ok;
     }
    
    public JButton getCancelButton()
    {
        return _cancel;
    }
    
    public String getName()
    {
       return _name.getText();
    }
    public JTextField getTextField()
    {
        return _name;
    }

    public void beenden()
    {
        _dialog.dispose();
        
    }
    
    public JButton getNextButton()
    {
        return _insertNext;
    }
}
