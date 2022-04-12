package interfaces;

import commands.Command;
import exceptions.AdapterException;
import utils.MyPoint2D;

public interface Velocity {
    MyPoint2D getVelocity() throws AdapterException;
    void setVelocity(MyPoint2D newVelocity) throws AdapterException;
    void startMove(Command command) throws AdapterException;
}

