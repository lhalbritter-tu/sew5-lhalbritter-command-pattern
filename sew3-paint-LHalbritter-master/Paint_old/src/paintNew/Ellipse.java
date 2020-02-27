package paintNew;

import java.awt.Graphics;
import java.awt.*;

/**
 * Ellipsen-Klasse
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class Ellipse extends Drawable {

	/**
	 * Konstruktor f�r Ellipsen-Elemente
	 * 
	 * @param c die gew�nschte Farbe
	 */
	public Ellipse(Color c){
		this.c = c;
		this.p = new Polygon();
	}
	
	/**
	 * {@link paintNew.Element#draw(Graphics g)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.c);
		if(this.fill)g.fillOval(p.getBoundingBox().x, p.getBoundingBox().y, p.getBounds().width, p.getBounds().height);
		else g.drawOval(p.getBoundingBox().x, p.getBoundingBox().y, p.getBounds().width, p.getBounds().height);
	}

	/**
	 * {@link paintNew.Element#clone()}
	 */
	@Override
	public Element clone() {
		Ellipse e = new Ellipse(this.c);
		e.p = this.p;
		e.fill = this.fill;
		e.c = this.c;
		return e;
	}

}
