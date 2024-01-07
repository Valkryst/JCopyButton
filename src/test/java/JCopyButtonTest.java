import com.valkryst.JCopyButton.JCopyButton;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class JCopyButtonTest {
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
    public void canCreateJCopyButton() {
        for (final Class clazz : SUPPORTED_COMPONENT_CLASSES) {
            final JTextComponent object = createInstanceOfClass(clazz);
            System.out.println(object.getClass().getSimpleName());
            new JCopyButton(object);
        }
    }

    @Test
    public void cannotCreateJCopyButtonWhenComponentIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JCopyButton(null);
        });
    }

    @Test
    public void canCopyText() throws IOException, UnsupportedFlavorException {
        final Faker faker = new Faker();

        for (final Class clazz : SUPPORTED_COMPONENT_CLASSES) {
            final JTextComponent object = createInstanceOfClass(clazz);
            final JCopyButton button = new JCopyButton(object);

            final String text = faker.lorem().paragraph();

            object.setText(text);
            button.doClick();

            Assertions.assertEquals(text, JCopyButton.getSystemClipboard().getData(DataFlavor.stringFlavor));
        }
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
