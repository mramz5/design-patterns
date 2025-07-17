package patterns.behavioral.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public interface Component {
    void handle();
    void setNextHandler(Component handler);
}

abstract class BaseComponent implements Component {
    protected String helpText;
    protected Component nextHandler;
    private ComponentContainer container;

    public BaseComponent(String helpText) {
        this.helpText = helpText;
    }

    @Override
    public void handle() {
        if (!helpText.isEmpty())
            System.out.println("please do : "+helpText);
        else if (nextHandler!=null)
            nextHandler.handle();
        else
            System.out.println("Please contact +831-3131-453");
    }

    public void setNextHandler(Component handler){
        this.nextHandler=handler;
    }
    public void setContainer(ComponentContainer container) {
        this.container = container;
    }
}

class Button extends BaseComponent{

    public Button(String helpText) {
        super(helpText);
    }
}

class TextField extends BaseComponent{

    public TextField(String helpText) {
        super(helpText);
    }
}


class ComponentContainer extends BaseComponent {
    protected final List<BaseComponent> components=new ArrayList<>();

    public ComponentContainer(String helpText) {
        super(helpText);
    }


    public void addHandler(BaseComponent tipHandler){
        if (tipHandler!=null) {
            components.add(tipHandler);
            tipHandler.setContainer(this);
            tipHandler.setNextHandler(this);
        }
        else
            throw new IllegalArgumentException("Invalid param");
    }

    @Override
    public void handle() {
        System.out.println("Handling help by the container :");
    }
}

class Tab extends ComponentContainer{

    public Tab() {
        super("");
    }

    public String showElements(){
        return String.format("tab elements are= %s",components);
    }
}

class Dialog extends ComponentContainer{

    public Dialog(String helpText) {
        super(helpText);
    }
}



class Main{
    public static void main(String[] args) {
        BaseComponent okButton=new Button("handle the ok button");
        BaseComponent cancelButton=new Button("");
        BaseComponent textField=new TextField("handle the text field");
        ComponentContainer dialog=new ComponentContainer("");

        dialog.addHandler(okButton);
        dialog.addHandler(cancelButton);
        dialog.addHandler(textField);

        ComponentContainer tab=new Tab();
        dialog.setNextHandler(tab);

        Component application=new BaseComponent("") {};
        tab.setNextHandler(application);

        cancelButton.handle();
    }
}
