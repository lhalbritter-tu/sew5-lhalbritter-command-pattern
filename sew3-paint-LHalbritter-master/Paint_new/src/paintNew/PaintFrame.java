package paintNew;

import javax.swing.*;

/**
 * Frame-Klasse f�r das Zeichenbrett
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class PaintFrame extends JFrame{

	/**
	 * Konstruktor f�r das Fenster
	 * @param pp das Panel, welches hinzugef�gt werden soll
	 * @param title der Titel des Fensters
	 * @param operation die Operation die durchgef�hrt werden soll, wenn das Fenster geschlossen wird
	 */
	public PaintFrame(JPanel pp, String title, int operation){
		this.add(pp);
		this.setDefaultCloseOperation( operation );
		this.setBounds( 100, 200, 500, 200 );
		this.setTitle(title);
		this.setVisible( true );
	}
}
