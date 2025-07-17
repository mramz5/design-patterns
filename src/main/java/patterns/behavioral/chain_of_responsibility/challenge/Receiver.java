package patterns.behavioral.chain_of_responsibility.challenge;

abstract class Receiver {
    private Receiver nextHandler;
    abstract void processMessage(Message message);
    void setNextHandler(Receiver nextHandler){
        this.nextHandler=nextHandler;
    }

    public Receiver getNextHandler() {
        return nextHandler;
    }
}
