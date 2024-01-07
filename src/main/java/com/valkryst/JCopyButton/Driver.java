package com.valkryst.JCopyButton;

import javax.swing.*;
import java.awt.*;

public class Driver {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JTextArea textArea = new JTextArea();
            textArea.setLineWrap(true);
            textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
            textArea.setWrapStyleWord(true);

            final JFrame frame = new JFrame("JCopyButton Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(500, 500));

            final Container contentPane = frame.getContentPane();
            contentPane.setLayout(new BorderLayout());
            contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);
            contentPane.add(new JCopyButton(textArea), BorderLayout.SOUTH);

            frame.setVisible(true);
            frame.pack();
            frame.setLocationRelativeTo(null);
        });
    }
}
