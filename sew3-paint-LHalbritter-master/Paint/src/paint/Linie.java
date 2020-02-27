package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Linien-Klasse
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class Linie extends Drawable {

	/**
	 * Konstruktor für Linien-Elemente
	 * 
	 * @param c die gewünschte Farbe
	 */
	public Linie(Color c){
		this.p = new Polygon();
		this.c = c;
	}
	
	/**
	 * {@link paint.Element#draw(Graphics g)}
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(this.c);
		g.drawLine(this.p.xpoints[0], this.p.ypoints[0], this.p.xpoints[1], this.p.ypoints[1]);
	}

	/**
	 * {@link paint.Element#clone()}
	 */
	@Override
	public Element clone() {
		Linie r = new Linie(this.c);
		r.p = this.p;
		r.fill = this.fill;
		r.c = this.c;
		return r;
	}

}
