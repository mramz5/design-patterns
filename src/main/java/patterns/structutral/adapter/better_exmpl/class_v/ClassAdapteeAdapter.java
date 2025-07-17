package patterns.structutral.adapter.better_exmpl.class_v;

import lombok.AllArgsConstructor;
import lombok.Setter;
import patterns.structutral.adapter.better_exmpl.AdapteeImpl;
import patterns.structutral.adapter.better_exmpl.Target;
import patterns.structutral.adapter.better_exmpl.ThreadUtility;

@AllArgsConstructor
@Setter
public class ClassAdapteeAdapter extends AdapteeImpl implements Target {
    private Target target;

    @Override
    public void request() {
        System.out.println("making the request compatible with adaptee...");
        ThreadUtility.sleep(1500);
        super.specificRequest();
        System.out.println("getting back the request's result");
    }

    @Override
    public void otherProcess() {
        target.otherProcess();
    }
}