`JCopyButton` is a Java Swing component designed to copy the contents of a [JTextComponent](https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/text/JTextComponent.html)
to the system clipboard when clicked. It can be used with `JTextComponent` and all of its subclasses:

* [JEditorPane](https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/JEditorPane.html)
  * [JTextPane](https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/JTextPane.html)
* [JTextArea](https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/JTextArea.html)
* [JTextField](https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/JTextField.html)
  * [DefaultTreeCellEditor.DefaultTextField](https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/tree/DefaultTreeCellEditor.DefaultTextField.html)
  * [JFormattedTextField](https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/JFormattedTextField.html) 
  * [JPasswordField](https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/JPasswordField.html)


## Table of Contents

* [Installation](https://github.com/Valkryst/JCopyButton#installation)
    * [Gradle](https://github.com/Valkryst/JCopyButton#-gradle)
    * [Maven](https://github.com/Valkryst/JCopyButton#-maven)
    * [sbt](https://github.com/Valkryst/JCopyButton#-scala-sbt)
* [Example](https://github.com/Valkryst/JCopyButton#example)

## Installation

JCopyButton is hosted on the [JitPack package repository](https://jitpack.io/#Valkryst/JCopyButton)
which supports Gradle, Maven, and sbt.

### ![Gradle](https://i.imgur.com/qtc6bXq.png?1) Gradle

Add JitPack to your `build.gradle` at the end of repositories.

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Add JCopyButton as a dependency.

```
dependencies {
	implementation 'com.github.Valkryst:JCopyButton:2024.1.7'
}
```

### ![Maven](https://i.imgur.com/2TZzobp.png?1) Maven

Add JitPack as a repository.

``` xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Add JCopyButton as a dependency.

```xml
<dependency>
    <groupId>com.github.Valkryst</groupId>
    <artifactId>JCopyButton</artifactId>
    <version>2024.1.7</version>
</dependency>
```

### ![Scala SBT](https://i.imgur.com/Nqv3mVd.png?1) Scala SBT

Add JitPack as a resolver.

```
resolvers += "jitpack" at "https://jitpack.io"
```

Add JCopyButton as a dependency.

```
libraryDependencies += "com.github.Valkryst" % "JCopyButton" % "2024.1.7"
```

## Example

This creates a new `JCopyButton` and displays it in a `JFrame`, along with a `JTextArea` that contains some text for the
button to copy.

```java
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
```