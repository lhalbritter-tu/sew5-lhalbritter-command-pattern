package paintNew;

import paintNew.commands.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Die Panel-Klasse f�r die Men�leiste des Zeichenbretts (beinhaltet auch das eigentliche
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
	
    // Men�leiste
    private JMenuBar m;
    
    // Men�leisten-Elemente
    private JMenu datei, bearbeiten, zeichnen, farbe, info;
    
    // Men�leisten-Subelemente
    private JMenuItem[] dItems, bItems, zItems, fItems;
    private JMenuItem about;
    

	
    /**
     * Konstruktor f�r das Panel
     * 
     * @param pc der Controller, der f�r den ActionListener/MouseListener zust�ndig ist
     */
	public MenuPanel(PaintController pc){
        
		z = new Zeichenbrett();
		dItems = new JMenuItem[3];
		bItems = new JMenuItem[5];
		zItems = new JMenuItem[8];
		fItems = new JMenuItem[2];
		
        // Men�leiste erzeugen
        m = new JMenuBar();
        
        // Men�elemente erzeugen
        datei = new JMenu("Datei");
        bearbeiten = new JMenu("Bearbeiten");
        zeichnen = new JMenu("Zeichnen");
        farbe = new JMenu("Farbe");
        info = new JMenu("Info");
        
        // Men�elemente hinzuf�gen
        m.add(datei);
        m.add(bearbeiten);
        m.add(zeichnen);
        m.add(farbe);
        m.add(info);
        
        // Untermen�elemente hinzuf�gen
        dItems[0] = new NewCommand("Neu");
        dItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        dItems[1] = new LoadCommand("Laden...");
        dItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        dItems[2] = new SaveCommand("Speichern...");
        dItems[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        for(int i = 0; i < dItems.length; i++){
        	datei.add(dItems[i]);
        	dItems[i].addActionListener(pc);
        }
        
        bItems[0] = new DeleteElementCommand("Element löschen");
        bItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        bItems[1] = new RestoreElementCommand("Element wiederherstellen");
        bItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        bItems[2] = new DuplicateElementCommand("Element duplizieren");
        bItems[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        bItems[3] = new ElementToHomeCommand("Element in Home Position");

        bItems[4] = new ChangeElementColorCommand("Elementfarbe ändern");
        
        for(int i = 0; i < bItems.length; i++){
        	if(i == 3)bearbeiten.addSeparator();
        	bearbeiten.add(bItems[i]);
        	bItems[i].addActionListener(pc);
        	bItems[i].setActionCommand("1"+i+"1");
        }
        
        zItems[0] = new FreihandCommand("Freihand zeichnen", true);
        zItems[1] = new LinienCommand("Linien zeichnen");
        zItems[2] = new RechteckCommand("Rechtecke zeichnen");
        zItems[3] = new RundeckCommand("Rechtecke abger. zeichnen");
        zItems[4] = new EllipseCommand("Ellipsen zeichnen");
        zItems[5] = new PolygonCommand("Polygone zeichnen");
        zItems[6] = new VerschiebenCommand("Element verschieben");

        zItems[7] = new AusmalenCommand("Ausmalen?", false);
        
        ButtonGroup bt = new ButtonGroup();
        
        for(int i = 0; i < zItems.length; i++){
        	if(i == 7)zeichnen.addSeparator();
        	zeichnen.add(zItems[i]);
        	zItems[i].addActionListener(pc);
        	zItems[i].setActionCommand(""+i);
        	if(i < 7) bt.add(zItems[i]);
        }
        
        fItems[0] = new PenColorCommand("Stift");
        fItems[0].setBackground(sc);
        fItems[1] = new BackgroundColorCommand("Hintergrund");
        fItems[1].setBackground(bc);
        
        for(int i = 0; i < fItems.length; i++){
        	farbe.add(fItems[i]);
        	fItems[i].addActionListener(pc);
        }
        
        about = new InfoCommand("About");
        
        info.add(about);
        about.addActionListener(pc);
        
        this.setLayout(new BorderLayout());
        
        z.addMouseListener(pc);
        z.addMouseMotionListener(pc);
        this.add(z, BorderLayout.CENTER);
        this.add(m, BorderLayout.NORTH);
	}

	public boolean getAusmalen(){
	    return ((JCheckBoxMenuItem) this.zItems[7]).getState();
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
