package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class AusmalenCommand extends JCheckBoxMenuItem implements Command {

    public AusmalenCommand(String name){
        super(name);
    }

    public AusmalenCommand(String name, boolean checked){
        super(name, checked);
    }

    @Override
    public void execute(PaintController pc) {
        return;
    }
}
