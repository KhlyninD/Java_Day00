import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.nextLine();

        int weekNum = 1;

        long grads = 0;

        while (weekNum <= 18 && !in.equals("42")){
            if (!in.equals("Week " + weekNum)) {
                printErr(scanner);
            }
            grads = getGrads(getMin(scanner), grads, weekNum);
            in = scanner.nextLine();
            weekNum++;
        }

        scanner.close();

        printRes(grads, weekNum);
    }

    private static void printRes(long grads, int weekNum){
        long min = 0;

        for (int i = 1; i < weekNum; i++){
            System.out.print("Week " + i + " ");
            min = grads % 10;
            grads = grads / 10;
            for (int j = 0; j < min; j++)
                System.out.print("=");
            System.out.println(">");
        }
    }
    private static long getGrads(int min, long gards, int weekNum){
        long numGard = 1;

        for (int i = 1; i < weekNum; i++){
            numGard *= 10;
        }
        return (gards + numGard * min);
    }

    private  static void printErr(Scanner scanner){
        System.err.println("Illegal Argument");
        scanner.close();
        System.exit(-1);
    }
    private static int getMin(Scanner scanner){
        int min = scanner.nextInt();

        int minCop;

        if (min < 1 || min > 9){
            printErr(scanner);
        }
        for (int i = 0; i < 4; i++){
            minCop = scanner.nextInt();
            if (minCop < 1 || minCop > 9){
                printErr(scanner);
            }
            min = (minCop < min) ? minCop : min;
        }
        if (!scanner.nextLine().equals(""))
            printErr(scanner);
        return min;

    }
}

