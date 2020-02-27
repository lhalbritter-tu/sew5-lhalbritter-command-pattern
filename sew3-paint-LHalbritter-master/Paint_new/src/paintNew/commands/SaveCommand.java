package paintNew.commands;

import paintNew.Drawable;
import paintNew.PaintController;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SaveCommand extends JMenuItem implements Command {

    public SaveCommand(String text){
        super(text);
    }

    @Override
    public void execute(PaintController pc) {
        File file = null;
        final JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(pc.getMenuPanel())==JFileChooser.APPROVE_OPTION)
            //File wird aus dem File-Browser ausgesucht
            file = fc.getSelectedFile();

        if (file == null) {
            JOptionPane.showMessageDialog(pc.getPaintFrames()[0], "Die aktuelle Zeichnung" + " wurde nicht gespeichert!");
            return;
        }

        Drawable[] d = pc.getMenuPanel().z.getDrawables();
        int length = d.length;
        int ok = JOptionPane.YES_OPTION;
        if (file.exists()) {
            ok = JOptionPane.showConfirmDialog(pc.getPaintFrames()[0], "Soll das File " + "�berschreiben werden`", "Speichern", JOptionPane.YES_NO_OPTION);
        }
        if (ok==JOptionPane.YES_OPTION) {
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                Drawable[] dneu = Arrays.copyOfRange(d,0,length);

                //Die brauchbaren Daten des Zeichenbretts werden in den OutputStream gespeichert
                oos.writeObject(pc);
                oos.writeObject(pc.getMenuPanel().z.getBackground());

                oos.writeObject(dneu);

                oos.flush();
                oos.close();

                JOptionPane.showMessageDialog(pc.getPaintFrames()[0], "Gespeichert!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(pc.getPaintFrames()[0], e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
