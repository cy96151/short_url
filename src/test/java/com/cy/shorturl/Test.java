package com.cy.shorturl;

import com.cy.shorturl.contant.ShortUrlContant;

import java.util.*;

/**
 * @auther: cy96151
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        //test.divisionTest();
        test.generateIndex();
        System.out.println((int) 's');
    }

    void generateIndex() {
        List<Integer> list = new LinkedList<>();
        for (char c = '0'; c <= 'z'; c++) {
            if ((c > '9' && c < 'A') || (c > 'Z' && c < 'a')) {
                list.add(0);
            }
            for (int i = 0; i < 62; i++) {
                if (c == ShortUrlContant.charArray[i]) {
                    list.add(i);
                    break;
                }
            }
        }
        System.out.println(list);

    }

    void divisionTest() {
        Long l = 30000000000L;
        Object i = l / 2;
        System.out.println(l / 2);
    }

    void generateCode() {
        String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String[] cz = s.split("");
        LinkedList<String> list = new LinkedList(Arrays.asList(cz));
        for (int i = list.size(); i > 0; i--) {
            int randomIndex = random.nextInt(i);
            list.add("'" + list.remove(randomIndex) + "'");
        }
        System.out.println(list.toString());
    }
}
