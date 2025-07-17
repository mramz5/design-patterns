package patterns.structutral.adapter.better_exmpl.object_v;

import lombok.AllArgsConstructor;
import patterns.structutral.adapter.better_exmpl.Adaptee;
import patterns.structutral.adapter.better_exmpl.Target;
import patterns.structutral.adapter.better_exmpl.ThreadUtility;

@AllArgsConstructor
public class ObjectAdapteeAdapter implements Target {
    private final Adaptee adaptee;

    @Override
    public void request() {
        System.out.println("making the request compatible with adaptee...");
        ThreadUtility.sleep(1500);
        adaptee.specificRequest();
        System.out.println("getting back the request's result");
    }

    @Override
    public void otherProcess() {
        System.out.println("object adapter other process...");
    }
}
