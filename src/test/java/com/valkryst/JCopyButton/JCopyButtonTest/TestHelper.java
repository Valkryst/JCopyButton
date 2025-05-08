package com.valkryst.JCopyButton.JCopyButtonTest;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TestHelper {
    public final static Class[] SUPPORTED_COMPONENT_CLASSES = {
        JEditorPane.class,
        JTextPane.class,
        JTextArea.class,
        JTextField.class,
        DefaultTreeCellEditor.DefaultTextField.class,
        JFormattedTextField.class,
        JPasswordField.class,
    };

    public static JTextComponent createInstanceOfClass(final Class clazz) {
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
