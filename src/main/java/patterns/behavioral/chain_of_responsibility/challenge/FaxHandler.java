package patterns.behavioral.chain_of_responsibility.challenge;

public class FaxHandler extends Receiver {
    @Override
    public void processMessage(Message message) {
        if (message.getText()!=null && message.getText().contains("fax"))
            System.out.println("Processing the fax");
        else if (getNextHandler()!=null)
            getNextHandler().processMessage(message);
    }
}
