package patterns.behavioral.state;

import java.security.SecureRandom;

public interface PhoneNotifier {
    void alert(Phone phone);
}

class Vibration implements PhoneNotifier {
    @Override
    public void alert(Phone phone) {
        System.out.println(phone + " is vibrating");
    }
}

class Silent implements PhoneNotifier {
    @Override
    public void alert(Phone phone) {
        System.out.println(phone + " is silent");
    }
}

class Phone {
    private PhoneNotifier notifier;

    public PhoneNotifier getNotifier() {
        return notifier;
    }

    public void setNotifier(PhoneNotifier notifier) {
        this.notifier = notifier;
    }

    public void alert() {
        notifier.alert(this);
    }

    @Override
    public String toString() {
        return "Phone " + new SecureRandom().nextInt(5);
    }
}

class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setNotifier(new Silent());
        phone.alert();

        phone.setNotifier(new Vibration());
        phone.alert();
    }

}