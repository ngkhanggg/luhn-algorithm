// 4847 3529 8926 3094
// 4003 6000 0000 0014

import java.util.Scanner;

public class LuhnAlgorithm {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        String creditCardNum = getCreditCard(in);
        in.close();

        try {
            boolean cardIsValid = validate(convertToArr(creditCardNum));
    
            if (cardIsValid) {
                System.out.println("This is a valid card");
            }
            else {
                System.out.println("This is not a valid card");
            }

        }
        catch(Exception err) {
            System.out.println("Invalid input");
        }
    }

    // get input
    public static String getCreditCard(Scanner in) {
        System.out.print("Credit card number: ");
        return in.nextLine();
    }

    // store credit card number in an array
    public static int[] convertToArr(String creditCardNum) {
        int[] creditCardNums = new int[16];

        // check for space between digits
        int x = 0, y= 0;
        while (y < 16) {
            if (creditCardNum.charAt(x) == ' ') {
                x++;
                continue;
            }
            creditCardNums[y] = Integer.parseInt(String.valueOf(creditCardNum.charAt(x)));
            x++;
            y++;
        }

        return creditCardNums;
    }

    // validate the card by Luhn's algorithm
    public static boolean validate(int[] creditCardNums) {
        int sum = 0;

        int x = 1, y = 0;
        while (x < 16 && y < 16) {
            // odd indexes
            sum += creditCardNums[x];

            // even indexes
            int n = creditCardNums[y]*2;
            if (n >= 10) {
                n = 1 + (n - 10);
            }
            sum += n;

            // increment
            x+=2;
            y+=2;
        }
        
        return sum % 10 == 0;
    }
}