package interfaces;
import commands.Command;
import exceptions.AdapterException;

public interface Movable extends Position, Velocity{
    void endMove(Command command) throws AdapterException;
    void setMove(Command command) throws AdapterException;
    Command getMove() throws AdapterException;
}
