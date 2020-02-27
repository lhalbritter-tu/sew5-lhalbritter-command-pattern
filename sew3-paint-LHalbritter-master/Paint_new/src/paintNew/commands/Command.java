package paintNew.commands;

import paintNew.PaintController;

public interface Command {

    public abstract void execute(PaintController pc);

}
