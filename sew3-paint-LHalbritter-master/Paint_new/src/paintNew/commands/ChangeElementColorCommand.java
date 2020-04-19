package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class ChangeElementColorCommand extends JMenuItem implements Command {

    public ChangeElementColorCommand(String name){
        super(name);
    }

    @Override
    public void execute(PaintController pc) {
        pc.getMenuPanel().z.changeColor(JColorChooser.showDialog(null, "Elementfarbe", null));
    }
}
