package interfaces;

import commands.Command;
import exceptions.AdapterException;

public interface Angle {
    void setAngle(Float newAngle) throws AdapterException;
    Float getDeltaAngle() throws AdapterException;
    void startRotate(Command command) throws AdapterException;
}
