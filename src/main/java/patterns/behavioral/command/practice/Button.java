package patterns.behavioral.command.practice;

import java.security.SecureRandom;

//invoker
public class Button {
    private ActionCommand command;

    public void setCommand(ActionCommand command) {
        this.command = command;
    }

    public void click() {
        System.out.println("Handling action " + command.getName());
        command.execute();
    }
}

//commands
abstract class ActionCommand {
    private final Editor editor;
    private final String name;

    public ActionCommand(Editor editor, String name) {
        this.editor = editor;
        this.name = name;
    }

    public abstract void execute();

    public String getName() {
        return name;
    }

    public Editor getEditor() {
        return editor;
    }
}

class SaveCommand extends ActionCommand {
    private String backUp;

    public SaveCommand(Editor editor) {
        super(editor, "save");
    }

    @Override
    public void execute() {
        this.backUp = getEditor().getText();
        System.out.println("text :"+backUp+" saved");
    }
}

class CopyCommand extends ActionCommand {
    private String copy;

    public CopyCommand(Editor editor) {
        super(editor, "copy");
    }

    @Override
    public void execute() {
        this.copy = getEditor().getSelection();
        System.out.println("text :"+copy+" copied");
    }
}

class OpenFileCommand extends ActionCommand {
    private File file;

    public OpenFileCommand(Editor editor) {
        super(editor, "open file");
    }

    @Override
    public void execute() {
      this.file=new File("file"+new SecureRandom().nextDouble(100),new byte[]{3,5,13,127});
        System.out.println("File is :"+file);
    }

    @Override
    public String toString() {
        return "OpenFileCommand{" +
                "file=" + file +
                "} " + super.toString();
    }
}
//

class Editor {
    private String text;
    private String selection;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
}

class File {
    private final String name;
    private final byte[] data;

    public File(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }
}
//

class Main{
    public static void main(String[] args) {
        Editor editor=new Editor();
        editor.setText("salam bar shoma");
        editor.setSelection(" ba");

        ActionCommand saveCommand=new SaveCommand(editor);

        Button saveButton=new Button();
        saveButton.setCommand(saveCommand);

        saveButton.click();

        ActionCommand copyCommand=new CopyCommand(editor);

        Button copyButton=new Button();
        copyButton.setCommand(copyCommand);
        copyButton.click();
    }
}
