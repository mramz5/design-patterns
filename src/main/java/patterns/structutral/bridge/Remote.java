package patterns.structutral.bridge;

public abstract class Remote {
    protected Device device;

    public Device getDevice() {
        return device;
    }

    public void togglePower(){
        this.device.togglePower();
    }
    public void volumeDown(float amount){
        this.device.setVolume(device.getVolume()-amount);
    }
    public void volumeUp(float amount){
        this.device.setVolume(device.getVolume()+amount);
    }
    public void channelDown(int amount){
        this.device.setChannel(device.getChannel()-amount);
    }
    public void channelUp(int amount){
        this.device.setChannel(device.getChannel()+amount);
    }
}
