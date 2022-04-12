package commands;

import exceptions.AdapterException;

public interface Command {
    void execute() throws AdapterException;
}
