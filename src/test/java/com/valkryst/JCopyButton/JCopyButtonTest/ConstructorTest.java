package com.valkryst.JCopyButton.JCopyButtonTest;

import com.valkryst.JCopyButton.JCopyButton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ConstructorTest {
    @Test
    public void canConstructWithAllSupportedComponents() {
        for (final Class clazz : TestHelper.SUPPORTED_COMPONENT_CLASSES) {
            final JTextComponent object = TestHelper.createInstanceOfClass(clazz);
            System.out.println(object.getClass().getSimpleName());
            new JCopyButton(object);
        }
    }

    @Test
    public void cannotConstructWithNullComponent() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JCopyButton(null);
        });
    }

    @Test
    public void canConstructWithNullText() {
        final JCopyButton button = new JCopyButton(new JTextArea(), (String) null);
        Assertions.assertEquals("", button.getText());
    }

    @Test
    public void cannotConstructWithNullIcon() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JCopyButton(new JTextArea(), (Icon) null);
        });
    }
}
