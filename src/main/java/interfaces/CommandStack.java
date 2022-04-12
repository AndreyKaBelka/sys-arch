package interfaces;

import commands.Command;

import java.util.ArrayList;

public interface CommandStack {
    void push(Command command);
}

