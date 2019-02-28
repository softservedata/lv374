package com.softserve.edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    
    public static enum UserCol {
        FIRST_NAME(0),
        LAST_NAME(1),
        EMAIL(2),
        TELEPHONE(3),
        ADDRESS1(4),
        CITY(5),
        POST_CODE(6),
        COUNTRY(7),
        REGION_STATE(8),
        PASSWORD(9),
        SUBSCRIBE(10),
        FAX(11),
        COMPANY(12),
        ADDRESS2(13);
        //
        private int index;

        private UserCol(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        //System.out.println("List Result = " + list.get(2)); // Exception
        //
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "11111");
        map.put(1, "2222");
        System.out.println("Map Result = " + map.get(2)); // null
        //
        System.out.println("Enum Count = " + UserCol.values().length);
        //
        System.out.println("Hello World!");
    }
}
