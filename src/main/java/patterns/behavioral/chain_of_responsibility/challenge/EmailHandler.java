package patterns.behavioral.chain_of_responsibility.challenge;

public class EmailHandler extends Receiver {
    @Override
    public void processMessage(Message message) {
        if (message.getText() != null && message.getText().contains("email"))
            System.out.println("Processing the email");
        else if (getNextHandler() != null)
            getNextHandler().processMessage(message);
    }
}
