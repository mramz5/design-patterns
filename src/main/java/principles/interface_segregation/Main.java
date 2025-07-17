package principles.interface_segregation;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        OnlineServices digikala = new DigikalaWebsite();
        digikala.authenticateUser("USER");
        digikala.acceptOnlineOrders(Collections.singletonList("PRODUCT"));

        RemoteService remoteService = new DigikalaSupport();
        remoteService.acceptTelephoneOrders(new ArrayList<>());
    }
}

//class AbstractIntCollection implements Collection<Integer> {
//    private final Integer[] intCollection = new Integer[15];
//
//    @Override
//    public int size() {
//        return intCollection.length;
//    }
//
//    public int capacity
//
//    @Override
//    public boolean isEmpty() {
//        return size() == 0;
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        for (Integer i : intCollection) {
//            if (i.equals(o))
//                return true;
//        }
//        return false;
//    }
//
//    @NotNull
//    @Override
//    public Iterator<Integer> iterator() {
//        return;
//    }
//
//    @NotNull
//    @Override
//    public Object[] toArray() {
//        return intCollection;
//    }
//
//    @NotNull
//    @Override
//    public <T> T[] toArray(@NotNull T[] a) {
//        int size = size();
//        if (a.length < size)
//            // Make a new array of a's runtime type, but my contents:
//            return (T[]) Arrays.copyOf(intCollection, size, a.getClass());
//        System.arraycopy(intCollection, 0, a, 0, size);
//        if (a.length > size)
//            a[size] = null;
//        return a;
//    }
//
//    @Override
//    public boolean add(Integer integer) {
//        if (size())
//        Integer[] newIntegers = new Integer[(int) Math.ceil(size() * 1.5)];
//        System.arraycopy(intCollection, 0, newIntegers, 0, size());
//        return false;
//    }
//
//    @Override
//    public boolean remove(Object o) {
//        return false;
//    }
//
//    @Override
//    public boolean containsAll(@NotNull Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(@NotNull Collection<? extends Integer> c) {
//        return false;
//    }
//
//    @Override
//    public boolean removeAll(@NotNull Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public boolean retainAll(@NotNull Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public void clear() {
//
//    }