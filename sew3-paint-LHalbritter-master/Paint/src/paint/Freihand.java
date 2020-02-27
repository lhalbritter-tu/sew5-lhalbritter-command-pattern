package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Freihand-Klasse
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class Freihand extends Drawable {

	/**
	 * Konstruktor für die Freihand-Zeichenelemente
	 */
	public Freihand(){
		this.p = new Polygon();
		this.c = Color.BLACK;
	}
	
	/**
	 * Konstruktor für die Freihand-Zeichenelemente mit der gewünschten Farbe
	 * 
	 * @param c die gewünschte Farbe
	 */
	public Freihand(Color c){
		this.p = new Polygon();
		this.c = c;
	}
	
	/**
	 * {@link paint.Element#draw(Graphics g)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.c);
		g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
	}

	/**
	 * {@link paint.Element#clone()}
	 */
	@Override
	public Element clone() {
		Freihand f = new Freihand();
		f.fill = this.fill;
		f.p = this.p;
		f.c = this.c;
		return f;
	}

}
