package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class RechteckCommand extends JRadioButtonMenuItem implements Command {

    public RechteckCommand(String name){
        super(name);
    }

    public RechteckCommand(String name, boolean selected){
        super(name, selected);
    }

    @Override
    public void execute(PaintController pc) {
        pc.setMode(PaintController.Mode.RECHTECK);
    }
}
