package exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SpaceShipErrorCode {
    VALUE_NOT_DEFINED("Не задано значение"),
    COMMAND_NOT_EXECUTE_EXCEPTION("Выполнить команды невозможно");

    private final String errorString;
}