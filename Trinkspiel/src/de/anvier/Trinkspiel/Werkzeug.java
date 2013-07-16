package de.anvier.Trinkspiel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Werkzeug
{

   private UI _ui;
   
   private Queue<Spieler> _spieler;
   private List<List<Aktion>> _aktionen;
   private SpielereingabeUI _eingabeUI;
   
   public Werkzeug() throws IOException
   {
       
       
       
       _spieler = new LinkedList<Spieler>();
       _aktionen = new ArrayList<List<Aktion>>();
       importAktionen("80p.txt",0);
       importAktionen("20p.txt", 1);
       importAktionen("10p.txt", 2);
       
     
       _eingabeUI = new SpielereingabeUI();
       
       initEingabeListener();
       _eingabeUI.setVisible(true);
       
       _ui = new UI(naechsterSpieler().getName(), naechsteAktion());
       initUIListener();
//       _ui = new UI(new Spieler("Andrei").getName(), null);
   }
   
   public Spieler naechsterSpieler()
   {
       Spieler spieler = _spieler.remove();
       _spieler.add(spieler);
       return spieler;
   }
   public Aktion naechsteAktion()
   {
       Aktion aktion = getAktionList().get(0);
       getAktionList().add(aktion);
       getAktionList().remove(0);
       return aktion;
   }
   public List<Aktion> getAktionList()
   
   
   {
       Random rnd = new Random();
       if(rnd.nextInt(100)<70)
       {
           return _aktionen.get(0);
       }
       if(rnd.nextInt(100)<90)
       {
          return _aktionen.get(1);
       }
       else
       {
           return _aktionen.get(2);
       }
   }
  
   public void initEingabeListener()
   {
       _eingabeUI.getOKButton().addActionListener(new ActionListener()
       {
           
           @Override
           public void actionPerformed(ActionEvent arg0)
           {
              _spieler.add(new Spieler(_eingabeUI.getName()));
              _eingabeUI.beenden();
               
           }
       });
       
       _eingabeUI.getCancelButton().addActionListener(new ActionListener()
       {
           
           @Override
           public void actionPerformed(ActionEvent arg0)
           {
               _eingabeUI.beenden();
          }
           
       });
       
       _eingabeUI.getNextButton().addActionListener(new ActionListener()
       {
           
           @Override
           public void actionPerformed(ActionEvent arg0)
           {
               _spieler.add(new Spieler(_eingabeUI.getName()));
               _eingabeUI.getTextField().setText("");
           }
       });
}
   public void initUIListener()
   {
       _ui.getNextButton().addActionListener(new ActionListener()
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
            
            for(List<Aktion> aktion: _aktionen)
                    {Collections.shuffle(aktion);
                    }
           
           _ui.aktualisiereUI(naechsterSpieler().getName(), naechsteAktion().getAktionString());
            
        }
    });
   }

public void importAktionen(String datei, int j) throws IOException
{
    String line = "";
    List<Aktion> list = new ArrayList<>();
    _aktionen.add(j,list);

    FileReader fread = new FileReader(datei); //öffntet die gewünschte txt Datei
    BufferedReader in = new BufferedReader(fread); // txt wird in den BufferReader geladen
    
    for(int i = 0;(line = in.readLine())!=null; ++i)
    { // durchlaufen, bis line = null(datei zu ende ist)
       
       
        _aktionen.get(j).add(new Aktion(line));
        
    }
    // array[i] wird mit line(der aktuellen Zeile) belegt


 
}
}