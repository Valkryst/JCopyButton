package com.valkryst.JCopyButton.JCopyButtonTest;

import com.valkryst.JCopyButton.JCopyButton;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CopyTest {
    @Test
    public void canCopyTextFromAllSupportedComponents() throws IOException, UnsupportedFlavorException {
        final Faker faker = new Faker();

        for (final Class clazz : TestHelper.SUPPORTED_COMPONENT_CLASSES) {
            final JTextComponent object = TestHelper.createInstanceOfClass(clazz);
            final JCopyButton button = new JCopyButton(object);

            final String text = faker.lorem().paragraph();

            object.setText(text);
            button.doClick();

            Assertions.assertEquals(text, Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
        }
    }
}
