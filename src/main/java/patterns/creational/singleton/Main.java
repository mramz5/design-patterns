package patterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
//        Class<DoubleCheckLocking> doubleCheckLockingClass= (Class<DoubleCheckLocking>) Main.class.getClassLoader().loadClass("main.java.patterns.creational.singleton.DoubleCheckLocking");
//        System.out.println(doubleCheckLockingClass.);
//        Reflections reflections = new Reflections("main.java.patterns.creational.singleton.Main", new SubTypesScanner(false));
//        Set<Class> classes = new HashSet<>(reflections.getSubTypesOf(Object.class));
//        Eager eager=Eager.getInstance();
//        Lazy lazy=Lazy.getInstance();
    }
}

//not thread safe
//not recommended approach
class Lazy {
    private static Lazy lazy;

    private Lazy() {
    }

    public static Lazy getInstance() {
        if (lazy == null)
            lazy = new Lazy();
        return lazy;
    }
}

//thread safe
//use when the object does not consume a lot of resources because it may not be used always
class Eager {
    private static final Eager eager = new Eager();

    private Eager() {
    }

    public static Eager getInstance() {
        return eager;
    }
}

//thread safe
//performance issues --> use when the performance is not important
class Synchronized {
    private static Synchronized theSynchronized;

    private Synchronized() {
    }

    public static synchronized Synchronized getInstance() {
        if (theSynchronized == null)
            theSynchronized = new Synchronized();
        return theSynchronized;
    }
}

/**
 * thread safe
 * better performance than synchronized
 * 1-first we check if It is null or not and then we enter in synchronized block
 * 2-then in sync block we check if no other threads initialized the variable then we start initializing it
 * without the volatile maybe the object is not be visible to other threads even if we initialized it,
 * so we solved the visibility with volatile, and the reordering will also be solved with it
 * also the volatile does not make the compound operations atomic like i++ it just make the variable value visible and ensures
 * that the instructions are executed in the desired order,it means its not like synchronized in this situation
 * reordering problem :
 * $1-first it assigns a memory space
 * $2-then calls its constructor and create the object
 * $3-then assign it to the reference
 * but some times due to compiler or cpu optimizations may the step 2 and 3 swap and the schedular stops at step 2 (previous 3)
 * and assign a reference to a inconsistent object and then we have a incomplete object
 **/
class DoubleCheckLocking {
    private static volatile DoubleCheckLocking doubleCheckLocking;

    private DoubleCheckLocking() {
    }

    public static DoubleCheckLocking getInstance() {
        if (doubleCheckLocking == null) {
            synchronized (DoubleCheckLocking.class) {
                if (doubleCheckLocking == null)
                    doubleCheckLocking = new DoubleCheckLocking();
            }
        }
        return doubleCheckLocking;
    }
}

//thread safe
//the best optimization
//singleton object initialized when its needed
class BillPugh {
    private BillPugh() {
    }

    private static class BillPughHelper {
        private static final BillPugh billPugh = new BillPugh();
    }

    public static BillPugh getInstance() {
        return BillPughHelper.billPugh;
    }
}