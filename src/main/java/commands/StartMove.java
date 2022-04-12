package commands;

import exceptions.AdapterException;
import interfaces.CommandStack;
import interfaces.Movable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class StartMove implements Command {
    private final Movable command;
    private final CommandStack stack;

    @Override
    public void execute() {
        try {
            Command moveCommand = new Move(command, stack);

            command.setMove(moveCommand);
            command.endMove(new EndMove(command, stack));

            stack.push(moveCommand);
        } catch (AdapterException ignored) {
        }
    }
}