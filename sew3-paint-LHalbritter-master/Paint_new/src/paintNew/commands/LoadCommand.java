package paintNew.commands;

import paintNew.Drawable;
import paintNew.PaintController;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand extends JMenuItem implements Command {

    public LoadCommand(String text){
        super(text);
    }

    @Override
    public void execute(PaintController pc) {
        final JFileChooser fc = new JFileChooser();
        File file = null;
        if (fc.showOpenDialog(pc.getMenuPanel())==JFileChooser.APPROVE_OPTION) file = fc.getSelectedFile();
        if (file == null) {
            JOptionPane.showMessageDialog(pc.getPaintFrames()[0], "Kein file" + " wurde ausgew�hlt!");
            return;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
        }catch(IOException e) {
            JOptionPane.showMessageDialog(pc.getPaintFrames()[0], e.getMessage());
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
            JOptionPane.showMessageDialog(pc.getPaintFrames()[0], e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(pc.getPaintFrames()[0], e.getMessage());
            e.printStackTrace();
        }
        int index = dneu.length-1;
        for (int i = 0; i < index; i++) {
            pc.getMenuPanel().z.hinzufuegen(dneu[i]);
        }

        pc.getMenuPanel().setForeground(fg);
        pc.getMenuPanel().setBackground(bg);
    }
}
