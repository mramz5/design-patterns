package patterns.structutral.bridge;

public class Television extends Device{
    private boolean usbConnected=false;



    public void connectUSB(){
        if (!usbConnected)
            usbConnected=true;
    }
}
