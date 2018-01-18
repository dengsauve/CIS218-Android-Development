import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Animal treeMonkey = new Animal("Jarvis");

        Animal zach = new Animal("Zach");
        System.out.println(zach.getName());
        System.out.println(zach.getColor());

        zach.setColor("Red");
        zach.setName("Zachary");
        System.out.println(zach.getName());
        System.out.println(zach.getColor());

        System.out.println(zach);

        Zebra john = new Zebra("John", "Black and White", 5, 55);
        System.out.println(john);
    }
}

