package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class PolygonCommand extends JRadioButtonMenuItem implements Command {

    public PolygonCommand(String name){
        super(name);
    }

    public PolygonCommand(String name, boolean selected){
        super(name, selected);
    }

    @Override
    public void execute(PaintController pc) {
        pc.setMode(PaintController.Mode.POLYGONE);
    }
}
