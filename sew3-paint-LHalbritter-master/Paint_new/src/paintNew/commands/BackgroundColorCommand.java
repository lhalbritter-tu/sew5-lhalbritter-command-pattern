package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class BackgroundColorCommand extends JMenuItem implements Command {

    public BackgroundColorCommand(String text){
        super(text);
    }

    @Override
    public void execute(PaintController pc) {
        pc.setBackgroundColor(JColorChooser.showDialog(null, "Hintergrundfarbe", pc.getBackgroundColor()));
        pc.getMenuPanel().setBgColor(pc.getBackgroundColor());
        pc.getMenuPanel().z.setzeHintergrund(pc.getBackgroundColor());
    }

}
