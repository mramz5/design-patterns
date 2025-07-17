package patterns.structutral.bridge;

public class Radio extends Device{
    private boolean playTape=false;

    public void toggleTape(){
        playTape=!playTape;
    }
}
