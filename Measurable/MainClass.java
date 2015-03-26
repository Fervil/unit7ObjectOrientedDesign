import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainClass extends JFrame implements MouseListener, ActionListener{

	/**
	 * Marc Fervil 2015
	 * Getting stuff done early yeahh
	 */
	
	private static final long serialVersionUID = 1L;
	ArrayList <Point> points= new ArrayList <Point>();
	public boolean dotsConnected=false;
	JButton connectButton;
	
	
	class Point{
		int x=0;
		int y=0;
		public Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public MainClass(){
		super("TRIANGLE");
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addMouseListener(this);
		
		JPanel panel= new JPanel();
		
		connectButton = new JButton("Connect Dots: "+dotsConnected);
		connectButton.addActionListener(this);
		panel.add(connectButton);
		
		JButton clearButton = new JButton("clear");
		clearButton.addActionListener(this);
		
		panel.add(clearButton);
		
		add(panel);
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		connectButton.setText("Connect Dots: "+dotsConnected);
		g.setColor(Color.RED);
		for(Point p:points){
			g.fillOval(p.x,p.y,10,10);
		}
		if(dotsConnected){
			for(int i=0;i<points.size();i++){
				try{
					g.drawLine(points.get(i).x,points.get(i).y,points.get(i+1).x,points.get(i+1).y);
				}catch(Exception e){
					g.drawLine(points.get(i).x,points.get(i).y,points.get(0).x,points.get(0).y);
				}
			}
		}
	}
	
	public static void main(String[] args){
		new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = (String)((AbstractButton) e.getSource()).getText();
		if(text.equals("clear")){
			points.clear();
			repaint();
		}else{
			if(dotsConnected){
				dotsConnected=false;
				repaint();	
				return;
			}else{
				dotsConnected=true;
				repaint();	
				return;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		points.add(new Point(e.getX(),e.getY()));
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
