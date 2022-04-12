package interfaces;

import exceptions.AdapterException;
import utils.MyPoint2D;

public interface Position  {
    MyPoint2D getPosition() throws AdapterException;
    void setPosition(MyPoint2D newPosition) throws AdapterException;
}
