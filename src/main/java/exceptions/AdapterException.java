package exceptions;

public class AdapterException extends Exception {
    public AdapterException(final SpaceShipErrorCode spaceShipErrorCode) {
        super(spaceShipErrorCode.getErrorString());
    }
}