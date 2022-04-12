package commands;


import exceptions.AdapterException;
import interfaces.CommandStack;
import interfaces.Movable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class EndMove implements Command {
    private final Movable command;
    private final CommandStack stack;

    @Override
    public void execute() {
        try {
            command.startMove(new StartMove(command, stack));
            command.setMove(new Empty());
            command.endMove(new Empty());
        } catch (AdapterException ignored) {
        }
    }
}