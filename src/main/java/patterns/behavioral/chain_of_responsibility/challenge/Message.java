package patterns.behavioral.chain_of_responsibility.challenge;

public class Message {
    private String text;
    private MessagePriority priority;

    public enum MessagePriority{
        ONE(1),TWO(2),THREE(3);
        private final int priority;

        MessagePriority(int priority) {
            this.priority = priority;
        }
    }

    public Message(String text, MessagePriority priority) {
        this.text = text;
        this.priority = priority;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public void setPriority(MessagePriority priority) {
        this.priority = priority;
    }
}
