import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Calc calc = new Calc();
        System.out.println("На скольких человек необходимо разделить счёт?");
        int countPeople = outCount();

       while (countPeople <= 1) {

           if (countPeople == 1) {
               System.out.println("Недостаточно людей для подсчёта, введите число ещё раз.");
               countPeople = scanner.nextInt();

           } else if (countPeople <= 0) {
               System.out.println("Ошибка. Введите число ещё раз.");
               countPeople = scanner.nextInt();

           }
       }
        System.out.println("Колличество человек " + countPeople);

       calc.inputProducts();
       String result = calc.calculate(countPeople);
       System.out.println(result);




    }
    private static int outCount(){
        while(!scanner.hasNextInt()){
            System.out.println("Введите количество человек!");
            scanner.next();
        }
        return scanner.nextInt();
    }


}