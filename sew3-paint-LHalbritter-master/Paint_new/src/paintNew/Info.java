package paintNew;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * JPanel f�r das About
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class Info extends JPanel {
	
	private JTextPane informationen;
	
	/**
	 * Konstruktor
	 */
	public Info() {
		//JTextPane Attribut "informationen" wird gesetzt
		informationen = new JTextPane();
		informationen.setEditable(false);
		informationen.setText("Dies ist eine Applikation, \nerstellt von Leo Halbritter im Laufe des Software-Entwicklung Unterrichts,\nim Auftrag vom Herrn Professor Rafeiner-Magor Walter. \n 2018");
		//Text des Attributs wird zentriert
		StyledDocument doc = informationen.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		this.add(informationen);
	}
}
