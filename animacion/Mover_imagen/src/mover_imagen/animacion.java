
package mover_imagen;


  

import javax.swing.JComponent;

import javax.swing.JPanel;

import javax.swing.ImageIcon;

import java.awt.Graphics;

import java.awt.Color;
import javax.swing.JOptionPane;


public class animacion extends JComponent 
{
     static JPanel panel;
    
     static int columna = 1;
     static int columna_b =140;
     static int fila = 195;
     static int numero = 1;
     static int numero_b = 6;
     static boolean prueba=true;
  animacion(JPanel panel)
  {
      this.panel = panel;
      
      setBounds(0, 0,panel.getWidth() , panel.getHeight());
         
  }
    
  public void paint(Graphics g)
  {
    ImageIcon imagen =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/"+numero+".jpg")).getImage());
       
     g.drawImage(imagen.getImage(), columna, fila, 200, 400, null); 
       }
  
 
  
  static Thread hilo = new Thread()
    {
       @Override
        public void run()
        {
            try
            {
                while(true)
                {
                  numero++;
                  
                  if(numero==3)
                  {
                    numero=1;
                  }
                
                 panel.repaint();  
                 
                 columna+=10;
                 if(columna>=540)
                 {
                     prueba=false;
                     JOptionPane.showMessageDialog(null, "choque");
                     System.exit(0);
                 }
                  hilo.sleep(90);                  
                }
            } catch (java.lang.InterruptedException ex) {
                                                           System.out.println(ex.getMessage()); 
                                                         }
        }
    };
   
  
  
   public static void mover()
  {
     if(!hilo.isAlive())
    {
      hilo.start();
    }
      columna = 3;
    }
   
}










