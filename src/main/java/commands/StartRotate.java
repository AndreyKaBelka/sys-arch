package commands;

import exceptions.AdapterException;
import interfaces.CommandStack;
import interfaces.Rotatable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class StartRotate implements Command {
    private final CommandStack stack;
    private final Rotatable command;

    @Override
    public void execute() {
        try {
            Command rotate = new Rotate(stack, command);

            command.setRotate(rotate);
            command.endRotate(new EndRotate(stack, command));

            stack.push(rotate);
        } catch (AdapterException ignored) {
        }
    }
}