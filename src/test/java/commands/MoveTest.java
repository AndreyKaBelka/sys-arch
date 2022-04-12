package commands;

import exceptions.AdapterException;
import exceptions.SpaceShipErrorCode;
import interfaces.CommandStack;
import interfaces.Movable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utils.MyPoint2D;

class MoveTest {
    @Test
    public void correctMove() throws AdapterException {
        Movable obj = Mockito.mock(Movable.class);
        CommandStack stack = Mockito.mock(CommandStack.class);
        Mockito.when(obj.getPosition()).thenReturn(new MyPoint2D(12d, 5d));
        Mockito.when(obj.getVelocity()).thenReturn(new MyPoint2D(-7d, 3d));
        Move command = new Move(obj, stack);

        command.execute();

        Mockito.verify(obj, Mockito.times(1)).getVelocity();
        Mockito.verify(obj, Mockito.times(1)).getPosition();
        Mockito.verify(obj, Mockito.times(1)).getVelocity();
        Mockito.verify(obj, Mockito.times(1)).setPosition(Mockito.eq(new MyPoint2D(5d, 8d)));
    }

    @Test
    public void incorrectPosition() throws AdapterException {
        Movable obj = Mockito.mock(Movable.class);
        CommandStack stack = Mockito.mock(CommandStack.class);
        Mockito.when(obj.getPosition()).thenThrow(new AdapterException(SpaceShipErrorCode.VALUE_NOT_DEFINED));
        Mockito.when(obj.getVelocity()).thenReturn(new MyPoint2D(-7d, 3d));
        Move command = new Move(obj, stack);

        Assertions.assertThrows(AdapterException.class, command::execute);
    }

    @Test
    public void incorrectDirection() throws AdapterException {
        Movable obj = Mockito.mock(Movable.class);
        CommandStack stack = Mockito.mock(CommandStack.class);
        Mockito.when(obj.getVelocity()).thenThrow(new AdapterException(SpaceShipErrorCode.VALUE_NOT_DEFINED));
        Mockito.when(obj.getPosition()).thenReturn(new MyPoint2D(12d, 5d));
        Move command = new Move(obj, stack);

        Assertions.assertThrows(AdapterException.class, command::execute);
    }

    @Test
    public void cantMoveObject() throws AdapterException {
        Movable obj = Mockito.mock(Movable.class);
        CommandStack stack = Mockito.mock(CommandStack.class);
        Mockito.when(obj.getVelocity()).thenReturn(new MyPoint2D(-7d, 3d));
        Mockito.when(obj.getPosition()).thenReturn(new MyPoint2D(12d, 5d));
        Mockito.when(obj.getMove()).thenThrow(new AdapterException(SpaceShipErrorCode.COMMAND_NOT_EXECUTE_EXCEPTION));
        Move command = new Move(obj, stack);

        Assertions.assertThrows(AdapterException.class, command::execute);
    }
}