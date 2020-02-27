package paint;

import java.awt.Graphics;
import java.awt.*;

/**
 * Klasse für abgerundete Rechteck-Elemente
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class Rundeck extends Drawable {

	/**
	 * Konstruktor für abgerundete Rechtecke
	 * 
	 * @param c die gewünschte Farbe
	 */
	public Rundeck(Color c){
		this.c = c;
		this.p = new Polygon();
	}
	
	/**
	 * {@link paint.Element#draw(Graphics g)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.c);
		if(this.fill)g.fillRoundRect(p.getBoundingBox().x, p.getBoundingBox().y, p.getBounds().width, p.getBounds().height, p.getBounds().width/2, p.getBounds().height/2);
		else g.drawRoundRect(p.getBoundingBox().x, p.getBoundingBox().y, p.getBounds().width, p.getBounds().height, p.getBounds().width/2, p.getBounds().height/2);
	}

	/**
	 * {@link paint.Element#clone()}
	 */
	@Override
	public Element clone() {
		Rundeck r = new Rundeck(this.c);
		r.fill = this.fill;
		r.p = this.p;
		r.c = this.c;
		return r;
	}

}
