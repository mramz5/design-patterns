package principles.dependency_injection;

public class Controller implements ServiceInjector {
    private Service service;

//    public Controller(Service service) {
//        this.service = service;
//    }


    public void setService(Service service) {
        this.service = service;
    }

    public String showHelloPage(){
        service.sayGreeting();
        return "hello.html";
    }
}
