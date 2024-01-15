public class Formatter {
    public String getRuble(double number)
    {
        int num = (int) number;
        switch (num % 10)
        {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
