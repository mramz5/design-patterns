package patterns.structutral.bridge;

import java.util.Random;

public abstract class Device {
    private boolean isOn = false;
    private float volume;
    private static final int MAX_CHANNELS_NUMBER = 50;
    private static final int MAX_VOLUME = 100;
    private int channel;

    public void togglePower() {
        if (!isOn){
            channel = new Random().nextInt(MAX_CHANNELS_NUMBER);
            volume=new Random().nextInt(MAX_VOLUME);
            isOn=true;
        }
        else
            isOn=false;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        if (volume < 0)
            volume = 0;
        if (volume > MAX_VOLUME)
            this.volume = MAX_VOLUME;
        this.volume = volume;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        if (channel > MAX_CHANNELS_NUMBER)
            this.channel = channel % MAX_CHANNELS_NUMBER;
        if (channel < 0)
            this.channel=MAX_CHANNELS_NUMBER-channel;
        this.channel = channel;
    }
}
