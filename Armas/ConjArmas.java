package Armas;

import java.awt.Color;
import java.awt.Component;
import java.awt.geom.Point2D;
import javax.swing.JFrame;

public class ConjArmas{
	private static int TotalNotDestroyed=TipoArma.getSomaQtdMax();
	private static Arma selectedArma = null;
	public Arma ArmVect[] = new Arma[TotalNotDestroyed];/*[TotalNotDestroyed]*/

	public ConjArmas(int size){
		/*
		ArmVect=new Arma[TotalNotDestroyed];
		for(int i=0; i<TotalNotDestroyed;i++)
			ArmVect[i]= new Arma(size);*/

	}
	public ConjArmas(){
	}
	public boolean atingiuArma(int x, int y){
		Point2D.Float pt = new Point2D.Float((float)x,(float)y);
		for(int i=0; i<ArmVect.length; i++)
			if(ArmVect[i].Atingir(pt)){
				if(ArmVect[i].getDestroyed())
					TotalNotDestroyed--;
				return true;
			}
		return false;
	}

	public boolean EhArma( int x, int y){
		if(getIndiceArma(x,y)==-1)
			return false;
		return true;
	}

	public boolean EhAresta(int x, int y){
		for(int i=-1; i<1; i++)
			for(int j=-1;j<1;j++){
				if(EhArma((x+i),(j+y))){
					return true;
				}
			}
		return false;
	}

	int getIndiceArma( int x, int y){
		Point2D.Float pt = new Point2D.Float((float)x,(float)y);
		for(int i=0; i<ArmVect.length; i++){
			if(ArmVect[i]==null){
			}
			else if(ArmVect[i].isHere(pt)){
				return i;
			}
		}
		return -1;
	}


	public TipoArma	getTipoArma ( int x, int y ){
		int i= getIndiceArma(x, y);
		return TipoArma.getnome( ArmVect[i].getNumPartes() );
	}

	public boolean allDestroyed(){
		//		for(int i=0; i<ArmVect.length; i++)
		//			if(!ArmVect[i].getDestroyed())
		if(TotalNotDestroyed == 0)
			return true;
		return false;
	}

	public Color getColorArma(int x,int y){
		int i=getIndiceArma(x, y);
		if(i != -1)
			return ArmVect[i].getColor();
		return null;
	}

	public static Arma[] getFilledArray(float size, float width) {
//		System.out.printf("\nCheguei forInsereArmas\n");
		int j=0;
		Arma c[] = new Arma[TotalNotDestroyed];
//		System.out.printf("getFilledArray:\n\tc\t= %s\n",Boolean.toString(c==null));
//		System.out.printf("TipoArma.Hidroaviao.getQtdMax() = %d\n",TipoArma.Hidroaviao.getQtdMax());
//		System.out.printf("TotalNotDestroyed = %d\n",TotalNotDestroyed);
		for(int i=0; i<TipoArma.Hidroaviao.getQtdMax(); i++,j++)
			c[j]= new Hidroaviao(size);
		
		for(int i=0; i<TipoArma.Submarino.getQtdMax(); i++,j++)
			c[j]= new Navio( TipoArma.Submarino, size);
		for(int i=0; i<TipoArma.Destroyer.getQtdMax(); i++,j++)
			c[j]= new Navio( TipoArma.Destroyer, size);
		for(int i=0; i<TipoArma.Cruzador.getQtdMax(); i++,j++)
			c[j]= new Navio( TipoArma.Cruzador, size);
		for(int i=0; i<TipoArma.Couracado.getQtdMax();i++,j++)
			c[j]= new Navio (TipoArma.Couracado, size);

//		System.out.printf("J = %d\n",j);
		for(int i=0; i<TipoArma.getSomaQtdMax();i++){
			c[i].setLocation((i-((i%5)*5))*(width/5),((i%5)*width/3));
			c[i].setIgnoreRepaint(false);
			c[i].setVisible(true);
		}
		return c;
	}

//	public void instArmaPlayer ( JFrame tab, TipoArma nome, int rotate,int x, int y){
//		ArmVect[i].setColor(nome.getColor());
//		setNumPartes(nome.getNumCels());
//		setLocation( (float) x, (float) y );
//		setRotate(rotate);
//
//
//
//	}

	public static ConjArmas getEmptyArray(){
		return new ConjArmas();
	}
	public static void receiveArma(ConjArmas c, Point2D p) throws ExceptionArmVectFilled{
		Arma a = getSelectedArma();
		a.setLocation((float)p.getX(),(float)p.getY());
		addArma(c,a);
	}
	private static void addArma(ConjArmas c, Arma a) throws ExceptionArmVectFilled {
		for(int i=0;i<TotalNotDestroyed;i++){
			if(c.ArmVect[i]==null){
				c.ArmVect[i] = a;
				emptySelectedArma();
				break;
			}
		}
		throw new ExceptionArmVectFilled();
	}
	static void setSelectedArma(Arma a){
			selectedArma = a;
	}
	private static Arma getSelectedArma() {
		return selectedArma;
	}
	private static void emptySelectedArma() {
		selectedArma = null;
	}
	public Arma[] getArmVec() {
		return ArmVect;
	}


}

