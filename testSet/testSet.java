package testSet;

import java.util.*;

public class testSet {
    public static void main(String[] args){
        HashSet hashSet = new LinkedHashSet(16);

        List list = new LinkedList(hashSet);

        LinkedHashSet linkedHashSet = new LinkedHashSet(list);
        linkedHashSet.clear();
    }


}
