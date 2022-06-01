import java.util.Scanner;

public class Program {

    private static final int MAX_CHAR = 65535;

    private static final int MAX_TOP = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.nextLine();

        scanner.close();
		
		if (in.equals(""))
			System.exit(0);

        char[] inMass = in.toCharArray();

        short[] mass = new short[MAX_CHAR];

        for (int i = 0; i < in.length(); i++) {
            if (mass[inMass[i]] < 999) {
                mass[inMass[i]]++;
            }
        }

        short[] massRes = getTop(mass);
        printTop(massRes);
    }
    private  static  void printTop(short[] massRes){
        int max = massRes[1];

        int len = max <= 10 ? max : 10;

        for (int i = 0; i < len + 2; i++) {
            for (int j = 0; j < MAX_TOP; j++) {
                if (massRes[j * 2 + 1] != 0) {
                    if (i + (massRes[j * 2 + 1] * len) / max + 2 == len + 2) {
                        System.out.printf("%3d", massRes[j * 2 + 1]);
                    } else if (i == len + 1) {
                        System.out.printf("%3c", massRes[j * 2]);
                    } else if (i + (massRes[j * 2 + 1] * len) / max >= len) {
                        System.out.printf("%3c", '#');
                    }
                }
            }
            System.out.println();
        }

    }

    private static short[] getTop(short[] mass){
        short[] massRes = new short[MAX_TOP * 2];

        short max = 0;

        for (int i = 0; i < MAX_CHAR; i++) {
            max = mass[i];
            for (int j = 0; j < MAX_TOP; j += 2) {
                if (max > massRes[j + 1]) {
                    massRes = addFrontMass(massRes, mass, j, i);
                    break;
                }
            }
        }
        return massRes;
    }

    private static short[] addFrontMass(short[] massRes, short[] mass, int j, int k) {
        short[] massRes_c = new short[MAX_TOP * 2];

        for (int i = 0; i < j; i++) {
            massRes_c[i] = massRes[i];
        }

        massRes_c[j] = (short) k;

        massRes_c[j + 1] = mass[k];

        for (int i = j + 2; i < MAX_TOP; i++) {
            massRes_c[i] = massRes[i - 2];
        }

        return (massRes_c);
    }
}
