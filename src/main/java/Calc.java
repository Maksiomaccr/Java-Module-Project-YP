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
        String answer;
        String list = "Введённые товары:\n";
        while (true) {
            System.out.println("Введите название товара.");
            scanner.useDelimiter("\n");
            product.name = getName();
            System.out.println("Введите стоимость товара.");
            product.price = getDouble();
            product.sum += product.price;
            list = list + String.format("%s - %.2f %s\n", product.name, product.price, format.getRuble(product.sum));
            System.out.println("Товар добавлен. Добавить ещё товар или завершить?");
            answer = getAnswer();
            if (answer.equalsIgnoreCase("завершить")){
                break;
            }

        }
        System.out.println(list);
    }

    private double getDouble() {

        while (true) {
            if (scanner.hasNextDouble()) {
                double num = scanner.nextDouble();
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("Стоимость не может быть отрицательной. Введите стоимость корректно.");
                    scanner.nextLine();

                }
            } else if (!scanner.hasNextDouble()) {
                System.out.println("Введите число");
                scanner.next();
            }

        }
    }

    private String getName(){
        String name;
        while(true){
            name = scanner.next();
            if(name.trim().isEmpty() || name == null){
                System.out.println("Введите пожалуйста название товара!");
            }
            else{break;}
        }
        return name;
    }

    private String getAnswer() {

        while (true) {
            if (scanner.hasNextLine()) {
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("добавить") || answer.equalsIgnoreCase("завершить")) {
                    return answer;
                } else {
                    System.out.println("Добавить ещё товар или завершить?");
                    scanner.nextLine();
                }
            } else if (!scanner.hasNextLine()) {
                System.out.println("Добавить ещё товар или завершить?");
                scanner.nextLine();
            }

        }
    }






}
