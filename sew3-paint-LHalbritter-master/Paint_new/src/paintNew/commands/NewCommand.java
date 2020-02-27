package paintNew.commands;

import paintNew.PaintController;

import javax.swing.*;
import java.awt.*;

public class NewCommand extends JMenuItem implements Command {

    public NewCommand(String text){
        super(text);
    }

    @Override
    public void execute(PaintController pc) {
        pc.getMenuPanel().z.reset();
        pc.getMenuPanel().setPenColor(Color.WHITE);
        pc.getMenuPanel().setBgColor(Color.WHITE);
        pc.setPenColor(Color.BLACK);
        pc.setBackgroundColor(Color.WHITE);
    }

}
