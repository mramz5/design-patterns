package principles.dependency_injection;

public interface Service {
    void sayGreeting();
    void inject(ServiceInjector injector);
}
