package com.jyx.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-21 10:06
 **/
public class Test {
    public static void main(String[] args) {
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
                "yyyyMMddhhmmss");
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.roll(java.util.Calendar.DAY_OF_YEAR, -1);
        String yesterday = df.format(calendar.getTime());


        HashMap map = new HashMap();
        map.values();
        map.keySet();
        List<UrgeBO> items = new LinkedList<UrgeBO>();
        Date date = new Date();
        items.add(new UrgeBO(new Date(date.getTime())));
        items.add(new UrgeBO(new Date(date.getTime() - 3000)));

        items.add(new UrgeBO(new Date(date.getTime() - 6000)));
        items.add(new UrgeBO(new Date(date.getTime() + 3000)));

        List<UrgeBO> res = null;//items.stream().sorted(Comparator.comparing(UrgeBO::getUrgeDate)).collect(Collectors.toList());
        //Collections.sort(items, Comparator.comparing(UrgeBO::getUrgeDate));
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).getUrgeDate());
        }
        System.out.println("------------------------");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getUrgeDate());
        }

    }
}
final class UrgeBO {
    private Date urgeDate;
    UrgeBO(Date urgeDate) {
        this.setUrgeDate(urgeDate);
    }

    public Date getUrgeDate() {
        return urgeDate;
    }

    public void setUrgeDate(Date urgeDate) {
        this.urgeDate = urgeDate;
    }
}
