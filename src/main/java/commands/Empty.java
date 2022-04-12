package commands;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
public class Empty implements Command {

    @Override
    public void execute() {
    }
}
