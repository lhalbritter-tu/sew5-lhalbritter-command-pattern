package paintNew.commands;

import paintNew.Freihand;
import paintNew.PaintController;

import javax.swing.*;

public class FreihandCommand extends JRadioButtonMenuItem implements Command {

    public FreihandCommand(String name){
        super(name);
    }

    public FreihandCommand(String name, boolean selected){
        super(name, selected);
    }

    @Override
    public void execute(PaintController pc) {
        pc.setMode(PaintController.Mode.FREIHAND);
    }
}
