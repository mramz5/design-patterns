package patterns.structutral.adapter.better_exmpl;

import java.security.SecureRandom;

public class AdapteeImpl2 implements Adaptee {
    @Override
    public void specificRequest() {
        System.out.println("adapteeimpl2's specific request");
    }

    public int someAdapteeImpl2Method() {
        SecureRandom secureRandom = new SecureRandom();
        int random = secureRandom.nextInt(100);
        System.out.println("AdapteeImpl2's someAdapteeImpl2Method()");
        return random;
    }
}
