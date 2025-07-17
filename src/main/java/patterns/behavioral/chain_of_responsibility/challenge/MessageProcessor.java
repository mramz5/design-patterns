package patterns.behavioral.chain_of_responsibility.challenge;

public class MessageProcessor {
    public void process(Message message) {
        Receiver emailReceiver = new EmailHandler();
        Receiver faxReceiver = new FaxHandler();
        emailReceiver.setNextHandler(faxReceiver);

        if (message.getText().length() > 5)
            emailReceiver.processMessage(message);
        else
            faxReceiver.processMessage(message);
    }
}
