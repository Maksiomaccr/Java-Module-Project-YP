import java.util.Scanner;

public class Calc {
    static Scanner scanner = new Scanner(System.in);
    Product product = new Product();
    Formatter format = new Formatter();
    public String calculate(int countPeople){
        double sum = product.sum / countPeople;
       return String.format("Каждый должен заплатить: %.2f %s", sum, format.getRuble(sum));
    }


    public void inputProducts(){
        String answer = null;
        String list = "Введённые товары:\n";
        while (true) {
            System.out.println("Введите название товара.");
            product.name = scanner.next();
            scanner.useDelimiter("\n");
            System.out.println("Введите стоимость товара.");
            product.price = getDouble();
            product.sum = product.sum + product.price;
            list = list + String.format("%s - %.2f %s\n", product.name, product.price, format.getRuble(product.sum));

            System.out.println("Товар добавлен. Добавить ещё товар или завершить?");
            answer = scanner.next();

            if(answer.equalsIgnoreCase("завершить")){
                break;
            }
        }
        System.out.println(list);
    }

    private static double getDouble(){
        while(!scanner.hasNextDouble()){
            System.out.println("Введите сумму");
            scanner.nextLine();
            while(scanner.nextDouble() <= 0){
               System.out.println("Стоимость не может быть отрицательной. Введите стоимость корректно.");
              scanner.nextLine();
          }
        }

        return scanner.nextDouble();
    }






}
