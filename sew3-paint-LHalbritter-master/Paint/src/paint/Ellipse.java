package paint;

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
	 * Konstruktor für Ellipsen-Elemente
	 * 
	 * @param c die gewünschte Farbe
	 */
	public Ellipse(Color c){
		this.c = c;
		this.p = new Polygon();
	}
	
	/**
	 * {@link paint.Element#draw(Graphics g)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.c);
		if(this.fill)g.fillOval(p.getBoundingBox().x, p.getBoundingBox().y, p.getBounds().width, p.getBounds().height);
		else g.drawOval(p.getBoundingBox().x, p.getBoundingBox().y, p.getBounds().width, p.getBounds().height);
	}

	/**
	 * {@link paint.Element#clone()}
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
