package commands;

import exceptions.AdapterException;
import interfaces.CommandStack;
import interfaces.Rotatable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Rotate implements Command {
    private final CommandStack stack;
    private final Rotatable command;
    private boolean isClockwise = true;

    @Override
    public void execute() {
        try {
            command.setAngle(command.getAngle() + (isClockwise ? command.getDeltaAngle() : -command.getDeltaAngle()));
            stack.push(command.getRotate());
        } catch (AdapterException ignored) {
        }
    }
}
