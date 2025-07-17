package patterns.behavioral.chain_of_responsibility.challenge;

public class Client {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        messageProcessor.process(new Message("email: salam man be hosseino be karbalayae hossein", Message.MessagePriority.ONE));
        messageProcessor.process(new Message("fax: faxing to the ali", Message.MessagePriority.THREE));

    }
}
