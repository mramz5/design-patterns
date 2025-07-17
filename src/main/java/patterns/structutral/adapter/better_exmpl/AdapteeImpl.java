package patterns.structutral.adapter.better_exmpl;

public class AdapteeImpl implements Adaptee {
    @Override
    public void specificRequest() {
        System.out.println("adapteeimpl's specific request v1");
    }
}