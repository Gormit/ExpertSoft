package by.gormit.controller;

/**
 * Created by Gormit on 26.08.2015.
 */
public class Testin {
    public static void main(String[] args) {

        StringBuilder buffer = new StringBuilder();
        System.out.println(buffer.length());
        buffer.append("ASC, ");
        buffer.append("ASC, ");
        buffer.append("ASC, ");
        buffer.append("ASC, ");
        buffer.insert(0, "ORDER BY ");
        String sort = buffer.substring(0, buffer.length() - 2);
        System.out.println(sort);

    }
}
