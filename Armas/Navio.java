package Armas;

import java.awt.geom.Point2D;

public class Navio extends Arma {

	private static final long serialVersionUID = 1L;

	public Navio(TipoArma nome, float size){
	//	super(nome.getNumCels(),nome.getColor(), nome.getQtdMax(),size);
		super(nome.getNumCels(),nome.getColor(),size);
	}

	public void setLocation(float x, float y) {
		if (rotate==0|| rotate ==3)	//horizontal
			for(int i=0;i<numPartes;i++)
				vector[i]=new Point2D.Float(x+i,y);
		else
			for(int i=0;i<numPartes;i++)	//vertical
				vector[i]=new Point2D.Float(x,y+i);

	}

}
