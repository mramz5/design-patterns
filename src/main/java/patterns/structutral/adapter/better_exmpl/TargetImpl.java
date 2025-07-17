package patterns.structutral.adapter.better_exmpl;

public class TargetImpl implements Target{
    @Override
    public void request() {
        System.out.println("requesting in target");
    }

    @Override
    public void otherProcess(){
        System.out.println("target impl's other processing...");
    }
}
