package principles.open_closed;

public class Animalwalker {
    //for each new animal we should add new method --> not closed for modification!
    //we are adding new method (new solution) for each animal --> not open for extension! yani tori nist ke flexible baray extension bashe
//    public void walkTiger(Tiger tiger){
//        System.out.println("The tiger is walking");
//    }
//    public void walkFish(Fish fish){
//        System.out.println("The fish is swimming");
//    }
//    public void walkSnake(Snake snake){
//        System.out.println("The snake is crawling");
//    }

    public void animalWalker(Animal animal){
        animal.walk();
    }

}
