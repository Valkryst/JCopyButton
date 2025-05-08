package com.valkryst.JCopyButton.JCopyButtonTest;

import com.valkryst.JCopyButton.JCopyButton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

public class ConstructorTest {
    private final static Class[] SUPPORTED_COMPONENT_CLASSES = {
        JEditorPane.class,
        JTextPane.class,
        JTextArea.class,
        JTextField.class,
        DefaultTreeCellEditor.DefaultTextField.class,
        JFormattedTextField.class,
        JPasswordField.class,
    };

    @Test
    public void canConstructWithAllSupportedComponents() {
        for (final Class clazz : SUPPORTED_COMPONENT_CLASSES) {
            final JTextComponent object = createInstanceOfClass(clazz);
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

    private JTextComponent createInstanceOfClass(final Class clazz) {
        final Object object;
        try {
            if (clazz == DefaultTreeCellEditor.DefaultTextField.class) {
                final DefaultTreeCellEditor editor = new DefaultTreeCellEditor(new JTree(), new DefaultTreeCellRenderer());
                object = clazz.getConstructor(DefaultTreeCellEditor.class, Border.class).newInstance(editor, BorderFactory.createEmptyBorder());
            } else {
                object = clazz.getConstructor().newInstance();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }

        return (JTextComponent) object;
    }
}
