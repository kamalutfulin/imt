import java.util.Scanner;

public class Program {

    static int inputChange = 0;

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в программу ИМТ 2.0 ");
        System.out.println("Введите число : ");
        System.out.println("1 - создать учетку пользователя в базе данных ");
        System.out.println("2 - показать текущую информацию в базе данных ");
        DB db = new DB();
        try {

            for (int i = 1; i > 0; i++) {
                inputChange = scanner.nextInt();
                if (inputChange == 1) {
                    Anketa anketa = new Anketa();
                    anketa.startQuestions();
                }
                if (inputChange == 2) {
                    db.showDB();
                } else if (inputChange != 1 && inputChange != 2) {
                    System.out.println("Вы ввели неправильный номер, повторите попытку");
                }
            }
        } catch (Exception e) {
            System.out.println("Вы ввели неправильный символ, программа завершает работу..");


        }


    }


}

