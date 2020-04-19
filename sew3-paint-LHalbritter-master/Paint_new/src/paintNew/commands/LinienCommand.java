package paintNew.commands;

import paintNew.Linie;
import paintNew.PaintController;

import javax.swing.*;

public class LinienCommand extends JRadioButtonMenuItem implements Command {

    public LinienCommand(String name){
        super(name);
    }

    public LinienCommand(String name, boolean selected){
        super(name, selected);
    }

    @Override
    public void execute(PaintController pc) {
        pc.setMode(PaintController.Mode.LINIEN);
    }
}
