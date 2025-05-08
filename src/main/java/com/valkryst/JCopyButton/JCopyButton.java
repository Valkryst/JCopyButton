package com.valkryst.JCopyButton;

import com.sun.istack.internal.NotNull;
import lombok.NonNull;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

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
    public JCopyButton(final @NonNull JTextComponent component) {
        super("Copy");
        this.setAssociatedComponent(component);
    }

    /**
     * Constructs a new {@code JCopyButton}, which copies the text from a {@link JTextComponent} to the system
     * {@link Clipboard} when clicked.
     *
     * @param component A {@link JTextComponent}.
     * @param text Text to display on the button.
     */
    public JCopyButton(final @NonNull JTextComponent component, final String text) {
        super(text == null ? "" : text);
        this.setAssociatedComponent(component);
    }

    /**
     * Constructs a new {@code JCopyButton}, which copies the text from a {@link JTextComponent} to the system
     * {@link Clipboard} when clicked.
     *
     * @param component A {@link JTextComponent}.
     * @param icon An {@link Icon} to display on the button.
     */
    public JCopyButton(final @NotNull JTextComponent component, final @NonNull Icon icon) {
        super(icon);
        this.setAssociatedComponent(component);
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
    public void setAssociatedComponent(final @NonNull JTextComponent component) {
        super.addActionListener(e -> copyTextToClipboard(component));
    }
}
