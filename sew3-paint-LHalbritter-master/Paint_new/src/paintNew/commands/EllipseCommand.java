package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class EllipseCommand extends JRadioButtonMenuItem implements Command {

    public EllipseCommand(String name){
        super(name);
    }

    public EllipseCommand(String name, boolean selected){
        super(name, selected);
    }

    @Override
    public void execute(PaintController pc) {
        pc.setMode(PaintController.Mode.ELLIPSEN);
    }
}
