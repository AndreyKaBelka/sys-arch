package commands;

import exceptions.AdapterException;
import interfaces.CommandStack;
import interfaces.Rotatable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class EndRotate implements Command {
    private final CommandStack stack;
    private final Rotatable command;

    @Override
    public void execute() {
        try {
            command.startRotate(new StartRotate(stack, command));
            command.setRotate(new Empty());
            command.endRotate(new Empty());
        } catch (AdapterException ignored) {
        }
    }
}