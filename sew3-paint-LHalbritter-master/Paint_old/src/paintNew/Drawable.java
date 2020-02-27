package paintNew;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.Serializable;

/**
 * Klasse f�r alle Zeichen-Elemente
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public abstract class Drawable implements Element, Serializable {
	
	//Attribute
	protected Color c;
	
	protected Polygon p;
	protected boolean fill;
	
	/**
	 * {@link paintNew.Element#draw(Graphics)}
	 */
	@Override
	public abstract void draw(Graphics g);

	/**
	 * {@link paintNew.Element#clone()}
	 */
	@Override
	public abstract Element clone();

	/**
	 * {@link paintNew.Element#addPoint(int, int)}
	 */
	@Override
	public void addPoint(int x, int y) {
		p.addPoint(x, y);
	}

	/**
	 * {@link paintNew.Element#removeLastPoint()}
	 */
	@Override
	public void removeLastPoint() {
		p.npoints -= 1;
	}

	/**
	 * {@link paintNew.Element#setHomePosition()}
	 */
	@Override
	public void setHomePosition() {
		p.translate(p.getBoundingBox().x*-1, p.getBoundingBox().y*-1);
	}

	/**
	 * {@link paintNew.Element#getColor()}
	 */
	@Override
	public Color getColor() {
		return this.c;
	}

	/**
	 * {@link paintNew.Element#setColor(Color c)}
	 */
	@Override
	public void setColor(Color c) {
		this.c = c;
		
	}
	
	/**
	 * Setzt ob das Element gef�llt werden soll
	 * 
	 * @param b true, wenn es gef�llt werden soll; false, wenn nicht
	 */
	public void setFill(boolean b){
		this.fill = b;
	}

}
