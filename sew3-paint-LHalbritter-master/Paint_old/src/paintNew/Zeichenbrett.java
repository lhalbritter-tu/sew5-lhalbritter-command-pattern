package paintNew;
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Das Panel auf dem gezeichnet wird, f�r das Zeichenbrett
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class Zeichenbrett extends JPanel {
	
	//Attribute
	//Arraylist f�r die gezeichneten Elemente
	private ArrayList<Drawable> d = new ArrayList<Drawable>();
	//Arraylist zum Wiederherstellen gel�schter Elemente
	private ArrayList<Drawable> r = new ArrayList<Drawable>();
	
	/**
	 * Konstruktor f�r das Zeichenbrett
	 */
	public Zeichenbrett(){
		this.setBackground(Color.WHITE);
	}
	
	/**
	 * paintComponent-Klasse welche alle Drawable-Elemente zeichnet
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(d.size() != 0){
			for(int i = 0; i < d.size(); i++){
				d.get(i).draw(g);
			}
		}
	}
	
	/**
	 * F�gt ein neues Drawable-Element hinzu
	 * 
	 * @param d das neue Drawable-Element
	 */
	public void hinzufuegen(Drawable d){
		this.d.add(d);
		this.repaint();
	}
	
	/**
	 * Stellt das zuletzt gel�schte Drawable-Element wieder her
	 */
	public void restore(){
		if(this.r != null){
			this.d.add(this.r.get(this.r.size()-1));
			this.repaint();
			this.r.remove(this.r.size()-1);
		}
	}
	
	/**
	 * F�gt einen Punkt zum gerade gezeichneten Element hinzu
	 * 
	 * @param x x-Koordinate
	 * @param y y-Koordinate
	 */
	public void punktHinzu(int x, int y){
		this.d.get(d.size()-1).addPoint(x, y);
		this.repaint();
	}
	
	/**
	 * Setzt den Hintergrund des Zeichenbretts
	 * 
	 * @param bg die Hintergrundfarbe
	 */
	public void setzeHintergrund(Color bg){
		this.setBackground(bg);
	}
	
	/**
	 * Entfernt das letzte Drawable-Element der Liste
	 */
	public void entferne(){
		this.r.add(this.d.get(this.d.size()-1));
		this.d.remove(this.d.size()-1);
		this.repaint();
	}
	
	/**
	 * Setzt das letzte Drawable-Element ganz oben links
	 */
	public void home(){
		this.d.get(this.d.size()-1).setHomePosition();
		this.repaint();
	}
	
	/**
	 * �ndert die Farbe des letzten Drawable-Elements
	 * 
	 * @param c die neue Farbe
	 */
	public void changeColor(Color c){
		this.d.get(this.d.size()-1).setColor(c);
		this.repaint();
	}
	
	/**
	 * Dupliziert das letzte Drawable-Element
	 */
	public void duplizieren(){
		Drawable d = (Drawable) this.d.get(this.d.size()-1).clone();
		this.hinzufuegen(d);
	}
	
	/**
	 * Resettet das Zeichenbrett
	 */
	public void reset(){
		d.removeAll(d);
		this.setBackground(Color.WHITE);
		this.repaint();
	}
	
	/**
	 * Setzt das F�llen des Drawable-Elements auf true
	 */
	public void setFill(){
		this.d.get(d.size()-1).setFill(true);
		this.repaint();
	}
	
	/**
	 * Gibt die Drawable-Liste als Array zur�ck
	 * 
	 * @return das Drawable-Array
	 */
	public Drawable[] getDrawables() {
		return d.toArray(new Drawable[d.size()]);
	}
	
	public void move(int x, int y) {
		int last = d.size()-1;
		this.d.get(last).p.translate(x-d.get(last).p.getBoundingBox().x, y-d.get(last).p.getBoundingBox().y);
		this.repaint();
	}
}
