package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class ElementToHomeCommand extends JMenuItem implements Command {

    public ElementToHomeCommand(String name){
        super(name);
    }

    @Override
    public void execute(PaintController pc) {
        pc.getMenuPanel().z.home();
    }
}
