import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int in = scanner.nextInt();

        int res = 0;

        while (in != 42){
            if (isNumSimple(sumIn(in))){
                res++;
            }
            in = scanner.nextInt();
        }

        scanner.close();

        System.out.println("Count of coffee-request - " + res);
    }

    private static int sumIn(int in)	{
        int res = 0;

        while (in != 0)	{
            res += in % 10;
            in /= 10;
        }
        return (res);
    }

    private  static boolean isNumSimple(int in){
        boolean inSimple = true;

        if (in < 2) {
            inSimple = false;
        } else if (in > 2){
            for (int i = 2; i <= sqrt(in); i++){
                if (in % i == 0) {
                    inSimple = false;
                    break;
                }
            }
        }
        return inSimple;
    }

    private static int sqrt(int in) {
        long res = 0;

        long start = 1;

        while (res <= in) {
            start ++;
            res = start * start;
        }
        return (int)start;
    }
}

