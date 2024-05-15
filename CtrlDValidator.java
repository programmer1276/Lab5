package Validators;

import Console.MyConsole;
import Managers.InputHandler;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CtrlDValidator implements Validatable<String> {
    @Override
    public boolean validate(String value) {
        return value == null;
    }
}
