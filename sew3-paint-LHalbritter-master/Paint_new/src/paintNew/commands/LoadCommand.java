package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;

public class LoadCommand extends JMenuItem implements Command {

    public LoadCommand(String text){
        super(text);
    }

    @Override
    public void execute(PaintController pc) {

    }
}
