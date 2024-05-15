package Validators;

import Exceptions.EmptyLineException;

public class ValidateInput implements Validatable<String> {
    @Override
    public boolean validate(String value) {
            if (value.isEmpty() && value.isBlank()) {
                throw new EmptyLineException("Нельзя вводить пустую строку. " +
                        "Воспользуйтесь командой help если на данный момент никакая команда не исполняется и введите интересующую команду " +
                        "либо введите требуемое значение еще раз если сейчас исполняется команда \\add\\ или \\update\\");
            }
            return true;
    }
}
