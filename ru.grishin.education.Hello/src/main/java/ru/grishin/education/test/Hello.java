package ru.grishin.education.test;

public class Hello {
    public static void main(String[] args) {
        int startNumber = Integer.parseInt(args[0]);
        int count = Integer.parseInt(args[1]);
        Hello h = new Hello();
              h.start(startNumber,count, h.getClass().getName());
    }

    public void start(int startNumber, int count, String className) {
        System.out.println("Hi  and welcome to class " + className +"!");

        for (int i = startNumber; i <= startNumber+count-1; i++) {
            System.out.println("i = " + i);
        }
    }
}