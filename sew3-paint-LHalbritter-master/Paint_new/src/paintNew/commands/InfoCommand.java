package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class InfoCommand extends JMenuItem implements Command {

    public InfoCommand(String name){
        super(name);
    }

    @Override
    public void execute(PaintController pc) {
        pc.openInfoPanel();
    }
}
