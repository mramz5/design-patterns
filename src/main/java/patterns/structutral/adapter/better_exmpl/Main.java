package patterns.structutral.adapter.better_exmpl;

import lombok.Setter;
import patterns.structutral.adapter.better_exmpl.class_v.ClassAdapteeAdapter;
import patterns.structutral.adapter.better_exmpl.object_v.ObjectAdapteeAdapter;

@Setter
public class Main {
    private static boolean isObjectV = true;
    private static boolean isClassV = true;

    public static void main(String[] args) throws InterruptedException {
//        Client.config(adaptee);// wont compile, we adapt it so we can use it in our methods
        //object_v
        Target target;
        if (isClassV && isObjectV) {
            target = new twoWayAdapteeAdapter(new TargetImpl());

            //2way adapter
            target = new twoWayAdapteeAdapter(new TargetImpl());
            target.request();
            target.otherProcess();

            Adaptee adaptee = new twoWayAdapteeAdapter(new TargetImpl());
            adaptee.specificRequest();
        } else if (isObjectV) {
            target = new ClassAdapteeAdapter(new TargetImpl());
        } else if (isClassV) {
            target = new ObjectAdapteeAdapter(new AdapteeImpl());
            Client.config(target);

            //all impls are adapted
            target = new ObjectAdapteeAdapter(new AdapteeImpl2());
            Client.config(target);
        }

    }
}