package com.basaki.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * {@code MyCommands} is a simple Shell command that takes two ints and returns
 * their sum.
 * <p/>
 *
 * @author Indra Basak
 * @since 10/16/17
 */
@ShellComponent
public class MyCommands {

    @ShellMethod(value = "Add two integers together.", group = "Mathematical Commands")
    public int add(int a, int b) {
        return a + b;
    }
}
