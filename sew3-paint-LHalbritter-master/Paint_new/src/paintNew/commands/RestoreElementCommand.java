package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class RestoreElementCommand extends JMenuItem implements Command {

    public RestoreElementCommand(String name){
        super(name);
    }

    @Override
    public void execute(PaintController pc) {
        pc.getMenuPanel().z.restore();
    }
}
