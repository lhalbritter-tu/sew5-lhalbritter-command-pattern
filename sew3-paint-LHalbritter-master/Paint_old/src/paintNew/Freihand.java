package paintNew;

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
	 * Konstruktor f�r die Freihand-Zeichenelemente
	 */
	public Freihand(){
		this.p = new Polygon();
		this.c = Color.BLACK;
	}
	
	/**
	 * Konstruktor f�r die Freihand-Zeichenelemente mit der gew�nschten Farbe
	 * 
	 * @param c die gew�nschte Farbe
	 */
	public Freihand(Color c){
		this.p = new Polygon();
		this.c = c;
	}
	
	/**
	 * {@link paintNew.Element#draw(Graphics g)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.c);
		g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
	}

	/**
	 * {@link paintNew.Element#clone()}
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
