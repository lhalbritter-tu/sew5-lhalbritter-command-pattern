package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class VerschiebenCommand extends JRadioButtonMenuItem implements Command {

    public VerschiebenCommand(String name){
        super(name);
    }

    public VerschiebenCommand(String name, boolean selected){
        super(name, selected);
    }

    @Override
    public void execute(PaintController pc) {
        pc.setMode(PaintController.Mode.VERSCHIEBEN);
    }
}
