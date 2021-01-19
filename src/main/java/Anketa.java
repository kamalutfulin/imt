import java.util.Scanner;

public class Anketa {
    Scanner scanner = new Scanner(System.in);
    private int age = 0;
    private static double imt = 0;
    private double height = 0;
    private double weight = 0;
    private String firstName = "";

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static double getImt() {
        return imt;
    }

    public static void setImt(double imt) {
        Anketa.imt = imt;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void startQuestions() {
        System.out.println("Как вас зовут?");
        firstName = scanner.nextLine();

        System.out.println(firstName + " ,введите свой возраст");
        age = scanner.nextInt();
        if (checkAge(age) == true) {


            System.out.println("Введите свой рост");
            height = scanner.nextInt();
            double heightToMetr = transformationToMetr(height);

            System.out.println("Введите свой вес");
            weight = scanner.nextInt();

            System.out.println(calculateImt(heightToMetr, weight));
            DB.create(firstName, age, height, weight, imt);
        }

    }


    public static boolean checkAge(int age) {
        if (age <= 17 || age >= 28) {
            System.out.println("Вы не подходите по возрасту");
            return false;
        } else return true;
    }

    public static double transformationToMetr(double height) {
        return height * 0.01;
    }

    public static double calculateImt(double height, double weight) {

        return imt = weight / (height * height);
    }
}