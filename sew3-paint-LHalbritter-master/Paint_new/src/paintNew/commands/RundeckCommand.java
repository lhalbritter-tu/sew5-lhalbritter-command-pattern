package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class RundeckCommand extends JRadioButtonMenuItem implements Command {

    public RundeckCommand(String name){
        super(name);
    }

    public RundeckCommand(String name, boolean selected){
        super(name, selected);
    }

    @Override
    public void execute(PaintController pc) {
        pc.setMode(PaintController.Mode.RUNDECK);
    }
}
