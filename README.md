# Command Pattern
## Problem
Eine bestimmte Abfolge an Kommandos soll zu einem bestimmten Zeitpunkt
ausgeführt werden, ohne zu wissen, was die Operation bewirkt und welches
Kommando ausgeführt wird. Außerdem sollen in weiterer Folge Kommandos
rückgängig gemacht werden.

## Beschreibung
Im Command Pattern geht es genau um die Lösung dieses Problem. Dabei gibt es einen
Client, welcher die Commands kennt und dem Invoker mit der Information sendet.
Der Receiver ist dann im Grunde das Command selbst, also die Logik die ausgeführt wird.

## Beispiel: Zeichenbrett für die Welt
Als Beispiel hier das [Zeichenbrett für die Welt](sew3-paint-LHalbritter-master/Paint_old/src/paintNew/PaintController.java), 
wo man Formen zeichnen kann und diese Speichern und Laden kann. Es wurde mit java swing gearbeitet
und somit alle Optionen zum Stiftfarbe ändern, speichern und laden von files über den ActionListener geregelt.

Das heißt die actionPerformed Methode wurde überschrieben und so sieht sie vor dem Command Pattern aus:

```java
@Override
public void actionPerformed(ActionEvent e) {
		/**
		 * Wenn der gedrückte Button "Stift" war, soll eine Auswahl erscheinen, die die
		 * Stiftfarbe ändert.
		 */
		if(e.getActionCommand().equals("Stift")){
			this.pc = JColorChooser.showDialog(null, "Stiftfarbe", null);
			pp.setPenColor(this.pc);
		}
		/**
		 * Wenn der gedrückte Button "Hintergrund" war, soll eine Auswahl erscheinen, die die
		 * Hintergrundfarbe ändert.
		 */
		if(e.getActionCommand().equals("Hintergrund")){
			this.bg = JColorChooser.showDialog(null, "Hintergrundfarbe", null);
			pp.setBgColor(this.bg);
			pp.z.setzeHintergrund(this.bg);
		}
		//*Debug* System.out.println(e.getActionCommand());
		//Bei "Speichern" soll der Speichervorgang begonnen werden.
		if(e.getActionCommand().equals("Speichern..."))this.speichern();
		//Bei "Laden" soll der Ladevorgang begonnen werden.
		if(e.getActionCommand().equals("Laden..."))this.laden();
		//Bei "Neu" soll das Zeichenbrett geleert werden.
		if(e.getActionCommand().equals("Neu")) {
			pp.z.reset();
			pp.setPenColor(Color.WHITE);
			pp.setBgColor(Color.WHITE);
			this.pc = Color.BLACK;
			this.bg = Color.WHITE;
		}

        // Und viele weitere if-Verzweigungen...
}
```
Ein Teil der actionPerformed Methode im [PaintController](sew3-paint-LHalbritter-master/Paint_old/src/paintNew/PaintController.java)

Die ActionCommands bekommt man vom [MenuPanel](sew3-paint-LHalbritter-master/Paint_old/src/paintNew/MenuPanel.java):

```java
// Menüleisten-Subelemente
private JMenuItem[] dItems, bItems, zItems, fItems;

public MenuPanel(PaintController pc){
        
		z = new Zeichenbrett();
        
        // Items für Dateimanipulation initialisieren
		dItems = new JMenuItem[3];

        // Untermenüelemente hinzufügen
        dItems[0] = new JMenuItem("Neu");
        //Shortcut setzen
        dItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        
        dItems[1] = new JMenuItem("Laden...");
        dItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        
        dItems[2] = new JMenuItem("Speichern...");
        dItems[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        
        for(int i = 0; i < dItems.length; i++){
            // Jedes dItem dem Menüpunkt 'Datei' hinzufügen
            datei.add(dItems[i]);
            // ActionListener adden
            dItems[i].addActionListener(pc);
        }
}
```
Ein Teil des MenuPanel Konstruktors

Wie man sieht ist das ziemlich unpraktisch gelöst in der ```actionPerformed()``` Methode
und nicht sehr leicht erweiterbar, da man dann neue if-Verzweigungen hinzufügen muss. Zur Rettung
kommt das Command Pattern!