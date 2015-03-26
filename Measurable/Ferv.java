import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;

public class Ferv extends JFrame implements MouseListener{


    private JFrame frame;
    private JPanel panel;
    private JButton buttonA;
    private JButton buttonB;
 
    public Ferv(){
       super("");
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(500,500);
       
       Button buttonA = new Button("CONNECT THE DOTS");      
       
       JPanel panel = new JPanel();
       panel.setVisible(true);
       
       panel.addMouseListener(this);     
       panel.setSize(500,500);
       
       panel.add(buttonA);
       add(panel, BorderLayout.CENTER);       
    }
 
    public void paint(Graphics g){
        super.paint(g);
        //g.setColor(Color.RED);
        //g.fillRect(0,0,500,500);
    }
    
    public static void main(String[] args){
        new Ferv();
    }
    
   public void mouseClicked(MouseEvent e){
       System.out.println(e.getX()+","+getY());
   }
  public void mouseEntered(MouseEvent e){/*implementation goes here...*/}
  public void mouseExited(MouseEvent e){/*implementation goes here...*/}
  public void mousePressed(MouseEvent e){/*implementation goes here...*/}
  public void mouseReleased(MouseEvent e){/*implementation goes here...*/}
      
    
}


