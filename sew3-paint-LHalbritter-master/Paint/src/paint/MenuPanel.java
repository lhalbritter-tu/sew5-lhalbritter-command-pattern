package paint;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Die Panel-Klasse für die Menüleiste des Zeichenbretts (beinhaltet auch das eigentliche
 * Zeichenbrett)
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class MenuPanel extends JPanel {
    
	//Attribute
	private Color sc = Color.WHITE, bc = Color.WHITE;
	//public damit der Controller Zugriff darauf hat
	public Zeichenbrett z;
	
    // Menüleiste
    private JMenuBar m;
    
    // Menüleisten-Elemente
    private JMenu datei, bearbeiten, zeichnen, farbe, info;
    
    // Menüleisten-Subelemente
    private JMenuItem[] dItems, bItems, zItems, fItems;
    private JMenuItem about;
    

	
    /**
     * Konstruktor für das Panel
     * 
     * @param pc der Controller, der für den ActionListener/MouseListener zuständig ist
     */
	public MenuPanel(PaintController pc){
        
		z = new Zeichenbrett();
		dItems = new JMenuItem[3];
		bItems = new JMenuItem[5];
		zItems = new JMenuItem[11];
		fItems = new JMenuItem[2];
		
        // Menüleiste erzeugen
        m = new JMenuBar();
        
        // Menüelemente erzeugen
        datei = new JMenu("Datei");
        bearbeiten = new JMenu("Bearbeiten");
        zeichnen = new JMenu("Zeichnen");
        farbe = new JMenu("Farbe");
        info = new JMenu("Info");
        
        // Menüelemente hinzufügen
        m.add(datei);
        m.add(bearbeiten);
        m.add(zeichnen);
        m.add(farbe);
        m.add(info);
        
        // Untermenüelemente hinzufügen
        dItems[0] = new JMenuItem("Neu");
        dItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        dItems[1] = new JMenuItem("Laden...");
        dItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        dItems[2] = new JMenuItem("Speichern...");
        dItems[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        for(int i = 0; i < dItems.length; i++){
        	datei.add(dItems[i]);
        	dItems[i].addActionListener(pc);
        }
        
        bItems[0] = new JMenuItem("Element löschen");
        bItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        bItems[1] = new JMenuItem("Element wiederherstellen");
        bItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        bItems[2] = new JMenuItem("Element duplizieren");
        bItems[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        bItems[3] = new JMenuItem("Element in Home Position");
        bItems[4] = new JMenuItem("Elementfarbe ändern");
        
        for(int i = 0; i < bItems.length; i++){
        	if(i == 3)bearbeiten.addSeparator();
        	bearbeiten.add(bItems[i]);
        	bItems[i].addActionListener(pc);
        	bItems[i].setActionCommand("1"+i+"1");
        }
        
        zItems[0] = new JRadioButtonMenuItem("Freihand zeichnen", true);
        zItems[1] = new JRadioButtonMenuItem("Linien zeichnen");
        zItems[2] = new JRadioButtonMenuItem("Rechtecke zeichnen");
        zItems[3] = new JRadioButtonMenuItem("Rechtecke abger. zeichnen");
        zItems[4] = new JRadioButtonMenuItem("Ellipsen zeichnen");
        zItems[5] = new JRadioButtonMenuItem("Polygone zeichnen");
        zItems[6] = new JRadioButtonMenuItem("Rechtecke ausmalen");
        zItems[7] = new JRadioButtonMenuItem("Rechtecke abger. ausmalen");
        zItems[8] = new JRadioButtonMenuItem("Ellipsen ausmalen");
        zItems[9] = new JRadioButtonMenuItem("Polygone ausmalen");
        zItems[10] = new JRadioButtonMenuItem("Element Verschieben");
        
        ButtonGroup bt = new ButtonGroup();
        
        for(int i = 0; i < zItems.length; i++){
        	if(i == 6)zeichnen.addSeparator();
        	zeichnen.add(zItems[i]);
        	zItems[i].addActionListener(pc);
        	zItems[i].setActionCommand(""+i);
        	bt.add(zItems[i]);
        }
        
        fItems[0] = new JMenuItem("Stift");
        fItems[0].setBackground(sc);
        fItems[1] = new JMenuItem("Hintergrund");
        fItems[1].setBackground(bc);
        
        for(int i = 0; i < fItems.length; i++){
        	farbe.add(fItems[i]);
        	fItems[i].addActionListener(pc);
        }
        
        about = new JMenuItem("About");
        
        info.add(about);
        about.addActionListener(pc);
        
        this.setLayout(new BorderLayout());
        
        z.addMouseListener(pc);
        z.addMouseMotionListener(pc);
        this.add(z, BorderLayout.CENTER);
        this.add(m, BorderLayout.NORTH);
	}
	
	/**
	 * Setzt die Hintergrundfarbe vom "Hintergrund"-Item
	 * 
	 * @param c die neue Farbe
	 */
	public void setBgColor(Color c){
		bc = c;
	    fItems[1].setBackground(bc);
	}
	
	/**
	 * Setzt die Hintergrundfarbe vom "Stift"-Item
	 * 
	 * @param c die neue Farbe
	 */
	public void setPenColor(Color c){
		sc = c;
	    fItems[0].setBackground(sc);
	}
}
