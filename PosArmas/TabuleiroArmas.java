package PosArmas;

import java.awt.Point;
import java.awt.geom.Point2D;

import Armas.ArmaListener;
import Armas.ConjArmas;
import Armas.ExceptionArmVectFilled;
import Tabuleiro.Celula;
import Tabuleiro.ExceptionCellAlreadyFilled;
//import Tabuleiro.ExceptionCellAlreadyHit;
import Tabuleiro.Tabuleiro;
public class TabuleiroArmas extends Tabuleiro{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public TabuleiroArmas(int x, int y, float boardsize, String player) {
		super(x, y, boardsize, player);
	}

	public void takeAction(Point2D p) throws ExceptionCellAlreadyFilled {
//		System.out.printf("\nCheguei TabuleiroEmbate.takeAction(%s)\n",p.toString());
//		Celula.fillCell(((Celula)getComponentAt(p)));
		try {
			ConjArmas.receiveArma((getTabuleiroInvisivel().getArmasArray()),p);
		} catch (ExceptionArmVectFilled e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
