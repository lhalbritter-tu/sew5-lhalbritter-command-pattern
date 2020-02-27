package paintNew;

import java.awt.Graphics;
import java.awt.*;

/**
 * Klasse f�r Polygon-Elemente
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class PPolygon extends Drawable {

	/**
	 * Konstruktor f�r Polygon-Elemente mit gew�nschter Farbe
	 * 
	 * @param c die gew�nschte Farbe
	 */
	public PPolygon(Color c){
		this.c = c;
		this.p = new Polygon();
	}
	
	/**
	 * {@link paintNew.Element#draw(Graphics g)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.c);
		if(this.fill) g.fillPolygon(this.p);
		else g.drawPolygon(this.p);
	}

	/**
	 * {@link paintNew.Element#clone()}
	 */
	@Override
	public Element clone() {
		PPolygon e = new PPolygon(this.c);
		e.p = this.p;
		e.fill = this.fill;
		e.c = this.c;
		return e;
	}

}
