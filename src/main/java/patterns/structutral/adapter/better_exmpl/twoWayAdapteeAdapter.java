package patterns.structutral.adapter.better_exmpl;

import lombok.Setter;

@Setter
public class twoWayAdapteeAdapter extends AdapteeImpl2 implements Target {
    private Target target;

    public twoWayAdapteeAdapter(Target target) {
        this.target = target;
    }

    //adaptee to target
    @Override
    public void request() {
        System.out.println("adapting target to adapteeimpl2");
        super.specificRequest();
    }

    //target to adaptee
    @Override
    public void specificRequest() {
        System.out.println("adapting adapteeimpl2 to target");
        target.request();
    }

    //target's specific method that we don't need to map it since we don't have any corresponding in target.
    @Override
    public void otherProcess() {
        System.out.println("nothing to adapt! running target's original otherProcess()");
        target.otherProcess();
    }
}
