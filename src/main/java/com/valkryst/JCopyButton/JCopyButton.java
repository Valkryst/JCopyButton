package com.valkryst.JCopyButton;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Objects;

/**
 * <p>
 *     Represents a button which copies the text from a {@link JTextComponent} to the system {@link Clipboard} when
 *     clicked.
 * </p>
 */
public class JCopyButton extends JButton {
    /**
     * Constructs a new {@code JCopyButton}, which copies the text from a {@link JTextComponent} to the system
     * {@link Clipboard} when clicked.
     *
     * @param component A {@link JTextComponent}.
     */
    public JCopyButton(final JTextComponent component) {
        super("Copy");
        setAssociatedComponent(component);
    }

    /**
     * Copies text from a {@link JTextComponent} to the system {@link Clipboard}.
     *
     * @param component A {@link JTextComponent}.
     */
    private void copyTextToClipboard(final JTextComponent component) {
        JCopyButton.getSystemClipboard().setContents(getComponentText(component), null);
    }

    /**
     * Retrieves the system {@link Clipboard}.
     *
     * @return The system {@link Clipboard}.
     */
    public static Clipboard getSystemClipboard() {
        return Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Retrieves a {@link StringSelection} containing the text from a {@link JTextComponent}.
     *
     * @param component A {@link JTextComponent}.
     * @return The {@link StringSelection}.
     */
    private StringSelection getComponentText(final JTextComponent component) {
        return new StringSelection(component.getText());
    }

    /**
     * Updates this {@code JCopyButton} to copy the text from a {@link JTextComponent} to the system {@link Clipboard}
     * when clicked.
     *
     * @param component A {@link JTextComponent}.
     */
    public void setAssociatedComponent(final JTextComponent component) {
        Objects.requireNonNull(component);
        super.addActionListener(e -> copyTextToClipboard(component));
    }
}
