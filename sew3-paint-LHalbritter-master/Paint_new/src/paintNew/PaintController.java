package paintNew;

import paintNew.commands.Command;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.io.*;

import javax.swing.*;

/**
 * Controller-Klasse für das Zeichenbrett
 * 
 * @author Leo Halbritter
 * @version 2018-06-04
 */
public class PaintController implements ActionListener, MouseListener, MouseMotionListener {

	//Attribute
	private PaintFrame[] pf = new PaintFrame[2];
	private MenuPanel pp;

	public Mode getMode() {
		return m;
	}

	public void setMode(Mode m) {
		this.m = m;
	}

	private Mode m = Mode.FREIHAND;
	private Drawable d;
	private Color penColor = Color.BLACK;

	public Color getPenColor() {
		return penColor;
	}

	public void setPenColor(Color penColor) {
		this.penColor = penColor;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	private Color backgroundColor = Color.WHITE;
	private Info i;
	
	/**
	 * Konstruktor für den Controller
	 */
	public PaintController(){
		pp = new MenuPanel(this);
		pf[0] = new PaintFrame(pp, "Zeichenbrett", JFrame.EXIT_ON_CLOSE);
		i = new Info();
	}
	
	/**
	 * main-Methode
	 * @param args not used
	 */
	public static void main(String[] args){
		new PaintController();
	}

	/**
	 * Methode, die daf�r sorgt, dass alle Aktionen f�r die Men�leiste funktionieren
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Command command = (Command)e.getSource();
		command.execute(this);

		/**
		//Bei den folgenden Buttons habe ich die ActionCommands ver�ndert, damit sie nicht zu lang waren (siehe Menupanel.java)
		//Beim Button "Element l�schen" soll das letzte Element entfernt werden.
		if (e.getActionCommand().equals("101")) pp.z.entferne();
		//Beim Button "Element wiederherstellen" soll das letzte gel�schte Element wiederhergestellt werden.
		if (e.getActionCommand().equals("111")) pp.z.restore();
		//Beim Button "Element duplizieren" soll das letzte Element dupliziert werden.
		if (e.getActionCommand().equals("121")) pp.z.duplizieren();
		//Beim Button "Element in Home Position" soll das letzte Element so weit links oben wie m�glich gesetzt werden.
		if (e.getActionCommand().equals("131")) pp.z.home();
		//Beim Button "Elementfarbe �ndern" soll die Farbe des letzten Elements ge�ndert werden.
		if (e.getActionCommand().equals("141"))
			pp.z.changeColor(JColorChooser.showDialog(null, "Elementfarbe", null));

		//Bei diesen Button-Interaktionen wird ausgew�hlt wie gezeichnet werden soll.
		if (e.getActionCommand().equals("0")) {
			m = Mode.FREIHAND;
			ausmalen = false;
		}
		if (e.getActionCommand().equals("1")) {
			m = Mode.LINIEN;
			ausmalen = false;
		}
		if (e.getActionCommand().equals("2")) {
			m = Mode.RECHTECK;
			ausmalen = false;
		}
		if (e.getActionCommand().equals("3")) {
			m = Mode.RUNDECK;
			ausmalen = false;
		}
		if (e.getActionCommand().equals("4")) {
			m = Mode.ELLIPSEN;
			ausmalen = false;
		}
		if (e.getActionCommand().equals("5")) {
			m = Mode.POLYGONE;
			ausmalen = false;
		}
		if (e.getActionCommand().equals("6")) {
			m = Mode.RECHTECK;
			ausmalen = true;
		}
		if (e.getActionCommand().equals("7")) {
			m = Mode.RUNDECK;
			ausmalen = true;
		}
		if (e.getActionCommand().equals("8")) {
			m = Mode.ELLIPSEN;
			ausmalen = true;
		}
		;
		if (e.getActionCommand().equals("9")) {
			m = Mode.POLYGONE;
			ausmalen = true;
		}
		;
		if (e.getActionCommand().equals("10")) {
			m = Mode.VERSCHIEBEN;
		}
		;

		//Wenn About gedr�ckt wird soll ein neues Fenster ge�ffnet werden, welches die Infos �ber dieses Programm anzeigt.
		if (e.getActionCommand().equals("About"))
			pf[1] = new PaintFrame(i, "Informationen", JFrame.DISPOSE_ON_CLOSE);
		 */
	}

	/**
	 * Methode die die Maus "verfolgt" und die Punkte f�r die entsprechenden Zeichnungen einspeichert.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(m){
			case LINIEN:
				d.p.xpoints[1] = e.getX();
				d.p.ypoints[1] = e.getY();
				pp.z.punktHinzu(e.getX(), e.getY());
				break;
			case VERSCHIEBEN:
				pp.z.move(e.getX(), e.getY());
				break;
			default:
				pp.z.punktHinzu(e.getX(), e.getY());
				break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// not used
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// not used
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// not used
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// not used
		
	}

	/**
	 * Methode bei der das Drawable-Attribut gesetzt wird, je nachdem welcher Modus aktiv ist
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		switch(m){
			case FREIHAND:
				d = new Freihand(this.penColor);
				d.p.addPoint(e.getX(), e.getY());
				pp.z.hinzufuegen(d);
				break;
			case LINIEN:
				d = new Linie(this.penColor);
				d.p.xpoints[0] = e.getX();
				d.p.ypoints[0] = e.getY();
				d.p.xpoints[1] = e.getX();
				d.p.ypoints[1] = e.getY();
				pp.z.hinzufuegen(d);
				break;
			case RECHTECK:
				d = new Rechteck(this.penColor);
				pp.z.hinzufuegen(d);
				break;
			case RUNDECK:
				d = new Rundeck(this.penColor);
				pp.z.hinzufuegen(d);
				break;
			case ELLIPSEN:
				this.d = new Ellipse(this.penColor);
				pp.z.hinzufuegen(d);
				break;
			case POLYGONE:
				this.d = new PPolygon(this.penColor);
				pp.z.hinzufuegen(d);
				break;
			default:
				break;
		}	
		if(pp.getAusmalen()) pp.z.setFill();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// not used
	}
	
	/**
	 * Methode die das aktuelle Zeichenbrett speichert.
	 */
	public void speichern(){ 
		 
		 File file = null;
		 final JFileChooser fc = new JFileChooser();
		 if(fc.showSaveDialog(pp)==JFileChooser.APPROVE_OPTION)
			 //File wird aus dem File-Browser ausgesucht
		 	file = fc.getSelectedFile();
		 
		 if (file == null) {
		 		JOptionPane.showMessageDialog(pf[0], "Die aktuelle Zeichnung" + " wurde nicht gespeichert!");
		 return;
		 }
		 
		 Drawable[] d = pp.z.getDrawables();
		 int length = d.length;
		 int ok = JOptionPane.YES_OPTION;
		 if (file.exists()) {
		 		ok = JOptionPane.showConfirmDialog(pf[0], "Soll das File " + "�berschreiben werden`", "Speichern", JOptionPane.YES_NO_OPTION);		
		 }
		 if (ok==JOptionPane.YES_OPTION) {
		 		ObjectOutputStream oos = null;
		 		try {
		 			oos = new ObjectOutputStream(new FileOutputStream(file));
		 			Drawable[] dneu = Arrays.copyOfRange(d,0,length);
		 
		 			//Die brauchbaren Daten des Zeichenbretts werden in den OutputStream gespeichert
		 			oos.writeObject(penColor);
		 			oos.writeObject(pp.z.getBackground());
		 
		 			oos.writeObject(dneu);
		 
		 			oos.flush();
		 			oos.close();
		 
		 			JOptionPane.showMessageDialog(pf[0], "Gespeichert!");
		 		} catch (IOException e) {
		 			JOptionPane.showMessageDialog(pf[0], e.getMessage());
		 			e.printStackTrace();
		 		}
		 }
		 
		 }
	
	/**
	* Methode, die erlaubt, dass man ein File laden kann, welches die entsprechenden Zeichenkomponenten beinhaltet
	*/
	public void laden(){
		 
		 final JFileChooser fc = new JFileChooser();
		 File file = null;
		 if (fc.showOpenDialog(pp)==JFileChooser.APPROVE_OPTION) file = fc.getSelectedFile();
		 if (file == null) {
		 		JOptionPane.showMessageDialog(pf[0], "Kein file" + " wurde ausgew�hlt!");
		 return;
		 }
		 ObjectInputStream ois = null;
		 try {
			 ois = new ObjectInputStream(new FileInputStream(file));
		 }catch(IOException e) {
			 JOptionPane.showMessageDialog(pf[0], e.getMessage());
			 e.printStackTrace();
		 }
		 Drawable[] dneu = null;
		 Color bg = Color.WHITE;
		 Color fg = Color.BLACK;
		 try {
			 //Die entsprechenden Komponenten werden herausgelesen.
			 fg = (Color) ois.readObject();
		 	 bg = (Color) ois.readObject();
		 	 dneu = (Drawable[]) ois.readObject();
		 }catch(IOException e) {
			 JOptionPane.showMessageDialog(pf[0], e.getMessage());
			 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
			 JOptionPane.showMessageDialog(pf[0], e.getMessage());
			e.printStackTrace();
		}
		 int index = dneu.length-1;
		 for (int i = 0; i < index; i++) {
			 pp.z.hinzufuegen(dneu[i]);
		 }
		 
		 pp.setForeground(fg);
		 pp.setBackground(bg);
		 
	}

	public MenuPanel getMenuPanel() {
		return pp;
	}

	public Component[] getPaintFrames() {
		return pf;
	}

	/**
	 * enum-Klasse f�r den Zeichenmodus
	 * 
	 * @author Leo Halbritter
	 * @version 2018-06-04
	 */
	public enum Mode{
		FREIHAND,
		LINIEN,
		RECHTECK,
		RUNDECK,
		ELLIPSEN,
		POLYGONE,
		VERSCHIEBEN;
	}
}