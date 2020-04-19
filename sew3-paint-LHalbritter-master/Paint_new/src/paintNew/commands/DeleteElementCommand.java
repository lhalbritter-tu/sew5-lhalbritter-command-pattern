package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class DeleteElementCommand extends JMenuItem implements Command {

    public DeleteElementCommand(String name){
        super(name);
    }

    @Override
    public void execute(PaintController pc) {
        pc.getMenuPanel().z.entferne();
    }
}
