package PosArmas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import Armas.ArmaListener;
import Armas.ExceptionComponentIsNotArma;

public class ArmasPickPanel extends JPanel{
	private static ArmasPickPanel APanel;
	private ArmasPickPanel(float x, float y, float width, float height){
		super();
		setBounds((int) x, (int) y, (int) width, (int) height);
	}
	public static ArmasPickPanel instance(float x, float y, float width, float height){
		APanel = new ArmasPickPanel(x,y,width, height);
		return APanel;
	}
	public static ArmasPickPanel getInstance(){
		return APanel;
	}
	public void paintComponent(Graphics g){
	
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GRAY);
		g2d.fill(getBounds());
	}
	public void selectArmaAqui(Point p){
		try{
			ArmaListener.selectArma(getComponentAt(p));
			this.remove(getComponentAt(p));
		} catch (ExceptionComponentIsNotArma e) {
//			System.out.println("Cheguei ExceptionComponentIsNotArma in ArmasPickPanel.selectArmaAqui");
			return;
		}		
	}


}
