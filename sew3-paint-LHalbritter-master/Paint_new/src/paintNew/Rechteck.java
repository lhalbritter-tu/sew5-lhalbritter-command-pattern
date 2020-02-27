package paintNew;

import java.awt.*;
import java.awt.Graphics;

/**
 * Rechteck-Klasse
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class Rechteck extends Drawable {
	
	/**
	 * Konstruktor f�r Rechteck
	 * 
	 * @param c die Farbe f�r das Rechteck
	 */
	public Rechteck(Color c){
		this.c = c;
		this.p = new Polygon();
	}
	
	/**
	 * {@link paintNew.Element#draw(Graphics g)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.c);
		if(this.fill){
			g.fillRect(p.getBoundingBox().x, p.getBoundingBox().y, p.getBoundingBox().width, p.getBoundingBox().height);
		}else{
			g.drawRect(p.getBoundingBox().x, p.getBoundingBox().y, p.getBoundingBox().width, p.getBoundingBox().height);
		}
	}

	/**
	 * {@link paintNew.Element#clone()}
	 */
	@Override
	public Element clone() {
		Rechteck r = new Rechteck(this.c);
		r.p = this.p;
		r.fill = this.fill;
		r.c = this.c;
		return r;
	}
	
}
