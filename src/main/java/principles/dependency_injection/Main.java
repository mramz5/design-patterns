package principles.dependency_injection;

public class Main {
    public static void main(String[] args) {
        //this code is injecting instead of ServiceImp
        //constructor injection
        Service service=new ServiceImp();

//        Controller homePageController=new Controller(service);  injector
        //setter
//        Controller homePageController=new Controller();
//        homePageController.setService(service); injector

        Controller homePageController=new Controller();
        service.inject(homePageController);
        homePageController.showHelloPage();
    }
}
