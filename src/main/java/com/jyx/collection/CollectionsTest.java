package com.jyx.collection;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
       List<String> syncList = Collections.synchronizedList(new ArrayList<>());

       syncList.add("aa");
       syncList.add("bb");
       syncList.add("cc");
       syncList.add("dd");
       Iterator<String> iterator = syncList.iterator();
       syncList.set(1, "ee");
       synchronized (syncList) {
           while (iterator.hasNext()) {
               String str = iterator.next();
               System.out.println(str);
           }
       }

       Map<String, String> hashMap = new HashMap<String, String>();
       Object o = hashMap.put("aa", "aa");
       Object o1 = hashMap.putIfAbsent("aa", "bb");
       Object o2 = hashMap.put("aa", "aa");

    }
}
