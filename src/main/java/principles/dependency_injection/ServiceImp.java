package principles.dependency_injection;

public class ServiceImp implements Service {
    @Override
    public void inject(ServiceInjector service) {
        service.setService(this);
    }

    @Override
    public void sayGreeting() {
        System.out.println("Greeting sir!");
    }
}
