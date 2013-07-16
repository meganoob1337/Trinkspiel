package de.anvier.Trinkspiel;

import javax.swing.*;
import java.awt.*;

public class UI
{

    private JFrame _frame;
    private JLabel _spielername;
    private JLabel _aktion;
    private JButton _naechsterSpieler;
    
    public UI(String spieler, Aktion aktion)
    {
        _frame = new JFrame("Spiel");
        _spielername = new JLabel(spieler+" muss folgendes machen:");
        _aktion = new JLabel(aktion.getAktionString());
        _naechsterSpieler = new JButton("Next");
        
        JPanel contentpane = new JPanel(new GridLayout(3, 3));
        _frame.setContentPane(contentpane);
        _frame.setSize(300,400);
        contentpane.add(_spielername);
        contentpane.add(_naechsterSpieler);
        _aktion.getFont().deriveFont(50);
        contentpane.add(_aktion);
        
        
        _frame.setVisible(true);
        
        
        
    }
    
   public void aktualisiereUI(String spieler, String aktion)
   {
       _spielername.setText(spieler);
       _aktion.setText(aktion);
   }

   public JButton getNextButton()
   {
       return _naechsterSpieler;
   }
}
