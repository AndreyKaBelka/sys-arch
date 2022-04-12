package commands;

import exceptions.AdapterException;
import interfaces.CommandStack;
import interfaces.Movable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import utils.MyPoint2D;

@AllArgsConstructor
@EqualsAndHashCode
public class Move implements Command {
    private final Movable object;
    private final CommandStack stack;

    @Override
    public void execute() throws AdapterException {
        try {
            MyPoint2D position = this.object.getPosition();
            MyPoint2D velocity = this.object.getVelocity();
            commandStack(position, velocity);
            stack.push(object.getMove());
        } catch (AdapterException exception) {
            throw exception;
        }
    }

    public void commandStack(MyPoint2D position, MyPoint2D velocity) throws AdapterException {
        this.object.setPosition(new MyPoint2D(position.getX() + velocity.getX(), position.getY() + velocity.getY()));
    }
}
