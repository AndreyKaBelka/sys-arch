package interfaces;

import commands.Command;
import exceptions.AdapterException;

public interface Rotatable extends Angle {
    Float getAngle()  throws AdapterException;
    void setRotate(Command command) throws AdapterException;
    void endRotate(Command command) throws AdapterException;
    Command getRotate() throws AdapterException;


}
