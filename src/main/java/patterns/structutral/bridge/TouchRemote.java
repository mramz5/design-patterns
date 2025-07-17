package patterns.structutral.bridge;

public class TouchRemote extends Remote{
    private boolean mute=false;

    public TouchRemote(Device device){
        this.device=device;
    }

    public void showMenu(){
        System.out.println("Menu is:\n1-op1\n2-op2\n3-op3");
    }
    public void muteTV(){
        if (!mute)
            mute=true;
    }
    public void unMuteTv(){
        if (mute)
            mute=false;
    }
}
