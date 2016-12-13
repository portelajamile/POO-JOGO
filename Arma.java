package Armas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;

//import javax.swing.JFrame;
import javax.swing.JPanel;

//import Tabuleiro.TabuleiroInvisivel;

public abstract class Arma extends JPanel {

	private static final long serialVersionUID = 1L;
	//	private final int qtdMax;
	//	private boolean destroyed; //indica se uma arma foi completamente atingida
	protected int numPartes=0;
	protected int rotate=0;			//cada acrescimo indica giro de 90º
	protected Point2D.Float vector[];		//vetor c coord das partes da arma
	protected boolean vectHit[];			//indica partes atingidas
	private final Color MAIN_COLOR;			//indica cor da arma
	private final Color DEFAUT_COLOR = Color.BLUE;
	private float SIZE;

	public Arma(){
		MAIN_COLOR = DEFAUT_COLOR;
		SIZE=1;
	}

	public Arma(int size){
		SIZE=(float)size;
		MAIN_COLOR = DEFAUT_COLOR;
	}

	public Arma(int partes, Color c,float size){
		numPartes=partes;
		MAIN_COLOR = c;
		SIZE=size;
		vector=new Point2D.Float[numPartes];
		vectHit=new boolean[numPartes];
		for(int i=0;i<vectHit.length;i++){
			vectHit[i] = false;
		}
		setNotDestroyed();
	}
	protected void setRotate(){
		if (rotate==3)
			rotate=0;
		else
			rotate++;
	}
	protected void setRotate(int x){
		rotate=x;
	}
	//	protected void setColor(Color c){
	//		MAIN_COLOR=c;
	//	}
	public Color getColor(){
		return MAIN_COLOR;
	}
	public boolean getDestroyed(){
		for(int i=0; i<numPartes;i++)
			if(vectHit[i]==false)
				return false;
		return true;
	}
	protected void setNotDestroyed(){
		for(int i=0; i<numPartes;i++)
			vectHit[i]=false;
	}
	protected boolean isHitHere(Point2D point){
		int i;
		for (i=0; i<vector.length&&!(point.equals(vector[i]));i++);
		return vectHit[i];
	}
	protected boolean Atingir(Point2D.Float pt){
		for (int i=0; i<vector.length;i++)
			if(pt.equals(vector[i])){
				vectHit[i]=true;
				return true;
			}
		return false;
	}
	protected void setNumPartes(int x){
		numPartes=x;
		setNotDestroyed();
	}
	public int getNumPartes(){
		return numPartes;
	}
	public abstract void setLocation(float x, float y);

	public void paintComponent(Graphics g){
		//
		Graphics2D g2d = (Graphics2D) g;
		int i;
//		System.out.println("Cheguei Armas.paintComponent()");
//		System.out.printf("\nCheguei numPartes = %d\tArmas.paintComponent()\n", numPartes);
		for(i=0; i<numPartes; i++){
				g2d.setColor(MAIN_COLOR);
				g2d.fillRect((int)vector[i].getX(),(int)vector[i].getY(), (int) SIZE, (int) SIZE);
				g2d.setColor(Color.GRAY);
				g2d.drawRect((int)vector[i].getX(),(int)vector[i].getY(),(int)SIZE-1, (int)SIZE-1);
			}
//		System.out.printf("\nCheguei numPartes = %d\tArmas.paintComponent()\n", numPartes);
			//	g2d.drawRect((int)vector[i].getX(),(int)vector[i].getY(),SIZE, SIZE);
		}
	public Point2D.Float getInitialLocation(){
		return vector[0];
	}
	public boolean isHere(Float pt) {
		for(int j=0; j<vector.length; j++)
			if(vector[j].equals(pt))
				return true;
		return false;
	}
	float getThisSize(){
		return SIZE;
	}
}

