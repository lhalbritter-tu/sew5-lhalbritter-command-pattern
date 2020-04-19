package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class DuplicateElementCommand extends JMenuItem implements Command {

    public DuplicateElementCommand(String name){
        super(name);
    }

    @Override
    public void execute(PaintController pc) {
        pc.getMenuPanel().z.duplizieren();
    }
}
