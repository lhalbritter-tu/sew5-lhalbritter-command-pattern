package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class PenColorCommand extends JMenuItem implements Command {

    public PenColorCommand(String text){
        super(text);
    }

    @Override
    public void execute(PaintController pc) {
        pc.setPenColor(JColorChooser.showDialog(null, "Stiftfarbe", pc.getPenColor()));
        pc.getMenuPanel().setPenColor(pc.getPenColor());
    }

}
