import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainClass2 extends JFrame implements MouseListener, ActionListener, MouseMotionListener{

	/**
	 * Marc Fervil 2015
	 * is this real like, or a fanta sea
	 * get it
	 * fanta
	 * sea
	 * ...
	 * im so funny
	 */
	
	private static final long serialVersionUID = 1L;
	ArrayList <Point> points= new ArrayList <Point>();
	public boolean dotsConnected=false;
	JButton connectButton;
	public int currentP=-1;
	public int orgX=-1;
	public int orgY=-1;
	
	class Point{
		int x=0;
		int y=0;
		int w=0;
		int h=0;
		boolean d=false;
		public Point(int x,int y,int w,int h,boolean d){
			this.x=x;
			this.y=y;
			this.w=w;
			this.h=h;
			this.d=d;
		}
	}
	
	public MainClass2(){
		super("CIRCLE");
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
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
			if(p.d){
				g.fillOval(p.x,p.y,p.w,p.h);
			}else{
				g.drawOval(p.x,p.y,p.w,p.h);
			}
		}

	}
	
	public static void main(String[] args){
		new MainClass2();
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
		points.add(new Point(e.getX(),e.getY(),50,50,false));
		currentP=points.size()-1;
		orgX=e.getX();
		orgY=e.getY();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Point p=points.get(currentP);
		Point newPoint=new Point(p.x,p.y,p.w,p.h,true);
		points.set(currentP,newPoint);
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p=points.get(currentP);
		int size=(int) Math.sqrt(Math.pow(p.x-e.getX(),2)+Math.pow(p.y-e.getY(),2));
		Point newPoint=new Point(p.x,p.y,size,size,false);
		points.set(currentP,newPoint);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
