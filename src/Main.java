public class Main
{
    public static void main(String[] args)
    {
        System.out.print("\nprintNums: ");
        Main.printNums(5);
        Main.printNums(12);

        System.out.println("\nAscending 8: ");
        printNumsAscending(8);
        System.out.println("\nAscending 12: ");
        printNumsAscending(12);

        System.out.print("\n\nharmonicSeries 16:  ");
        double harmonicCheck = harmonicSeries(16);
        System.out.println(harmonicCheck);
        System.out.print("harmonicSeries 2:  ");
        double harmonicCheck2 = harmonicSeries(2);
        System.out.println(harmonicCheck2);

        System.out.println("\n\nproductOfEvens 1: " + productOfEvens(1));
        System.out.println("productOfEvens 2: " + productOfEvens(2));
        System.out.println("productOfEvens 3: " + productOfEvens(3));
        System.out.println("productOfEvens 4: " + productOfEvens(4));


        System.out.print("\n\nfunkyHeader 5: ");
        funkyHeader(5);
        System.out.print("\nfunkyHeader 6: ");
        funkyHeader(6);
        System.out.print("\nfunkyHeader 7: ");
        funkyHeader(7);
        System.out.print("\nfunkyHeader 8: ");
        funkyHeader(8);

        int [] numArray = {1,2,6,4,3,2};
        System.out.println("\n\nCountNumberOf 2 - {1,2,6,4,3,2}: " + countNumberOf(2, numArray));
        System.out.println("CountNumberOf 6 - {1,2,6,4,3,2}: " + countNumberOf(6, numArray));
        System.out.println("CountNumberOf 5 - {1,2,6,4,3,2}: " + countNumberOf(5, numArray));

        System.out.println("\n\nhowManyDigitsMatchAnswer [13222,10212]: " + howManyDigitsMatch(13222,10212));

        System.out.println("\n\ntooManyTwos 80: ");
        tooManyTwos(80);
        System.out.println("\ntooManyTwos 68: ");
        tooManyTwos(68);
        System.out.println("\ntooManyTwos 96: ");
        tooManyTwos(96);
        System.out.println("\ntooManyTwos 32: ");
        tooManyTwos(32);
        System.out.println("\ntooManyTwos 1: ");
        tooManyTwos(1);
        System.out.println("\ntooManyTwos 2: ");
        tooManyTwos(2);
        System.out.println();

        // Ternart Operator
        String typeOfNumber;
        int number = 7;
        typeOfNumber = (number % 2 == 0) ? "even" : "odd";
        System.out.println(typeOfNumber);
        System.out.println(9%10);
        System.out.println(12%10);
        System.out.println("\nsummation");
        System.out.println((summation(8)));

        int test = mystery5(-23, -48);
        System.out.println(test);


    }

    public static  int mystery5(int x, int y) {
        if (x < 0) {
            return -mystery5(-x, y);
        } else if (y < 0) {
            return -mystery5(x, -y);
        } else if (x == 0 && y == 0) {
            return 0;
        }
        else {
            return 100 * mystery5(x / 10, y / 10) + 10 * (x % 10) + y % 10;
        }
    }

    public static int summation(int n)
    {
        if (n < 0)
            throw new IllegalArgumentException("error");
        if(n == 0)
        {
            return 0;
        }
        return n + summation(n - 1);
    }

    // Dont declare variable inside recursive methods
    public static void tooManyTwos(int n)
    {
        /*
        if (n < 1)
            throw new IllegalArgumentException("error");
        if (n == 1) {
            System.out.print(1);
            return;
        }
        if(n % 2 == 1) {
            System.out.print(n);
            return;
        }
        if ((n / 4) > 1) {
            System.out.print("2 * ");
            tooManyTwos(n / 4);
            System.out.print(" * 2");
            return;
        }
        if ((n / 2) >= 1)
        {
            System.out.print("2 * ");
            tooManyTwos(n / 2);
        }
        */

        if (n < 1)
            throw new IllegalArgumentException("error");
        if (n%4 == 0) {
            System.out.print("2 * ");
            tooManyTwos(n/4);
            System.out.print(" * 2");
        }
        else if(n%2 == 0) {
            System.out.print("2 * ");
            tooManyTwos(n/2);
        }
        else System.out.print(n);
    }

    public static void printNums (int n)
    {
        if (n < 1)
            throw new IllegalArgumentException("n must be >= 1");

        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n);
        System.out.print(",");
        printNums(n-1);
    }

    public static void printNumsAscending(int n)
    {
        if (n < 1)
            throw new IllegalArgumentException("n must be >= 1");
        if (n == 1) {
            System.out.print(n);
            return;
        }
        printNumsAscending(n-1);
        System.out.print(", " + n);
    }

    public static double harmonicSeries(int n)
    { // 1) Error Case:
        if(n < 1)
            throw new IllegalArgumentException("n must be >= 1");
        // 2) Base case: When do we stop?
        if(n == 1) {return 1.0;}
        // Recursive Case:
        return (1.0 / n) + harmonicSeries(n-1);
    }

    public static int productOfEvens(int n)
    {
        if(n < 1)
            throw new IllegalArgumentException("ERROR");
        if(n ==1) {
            return 2;
        }
        return (n * 2) * productOfEvens(n - 1);
    }

    public static void funkyHeader(int n)
    {
        // error case
        if (n < 1)
            throw new IllegalArgumentException();
        // base case
        if (n == 1) {
            System.out.print("*");
            return;
        }
        if (n == 2) {
            System.out.print("**");
            return;
        }
        System.out.print("<");
        funkyHeader(n - 2);
        System.out.print(">");
    }


    public static int countNumberOf(int value, int[] array)
    {
        // error case:
        if(array == null)
            throw new IllegalArgumentException("ERROR, Array Null");
        return countNumberOf(value, array, array.length - 1);
    }

    private static int countNumberOf(int value, int[] array, int i)
    {
        // base case:
        if(i == 0) {
            return ((array[i] == value) ? 1 : 0);
        //(boolean condition) ? true value : what value if false
        /* // if we find the value, return 1
        if (array[i] == value)
        return 1;
        // otherwise return 0
        else
        return 0;
        */
        }
        // 3) recursive Case:
        return ((array[i] == value) ? 1 : 0) + countNumberOf(value, array, i - 1);
    }


    public static int howManyDigitsMatch(int n1, int n2)
    {
        // int number = 12345;
        // number % 10 = gives you ones places digit
        //
        // Compare the digits in the ones place of n1 vs.
        // the digit in the ones place in n2
        if (n1 < 0 || n2 < 0)
            throw new IllegalArgumentException("Error");
        if (n1 == 0 || n2 == 0)
        {
            return 0;
        }

        if((n1 % 10) == (n2 % 10))
            return (1 + howManyDigitsMatch(n1/10 , n2/10));
        else
            return howManyDigitsMatch(n1/10 , n2/10);

    }


    public static void mantra (int n)
    {

        // 1) error condition
        // 2) base case
        // 3) recursive

        // param arg
        // (int 5)

        // 1) Error Case:
        if(n < 0)
            throw new IllegalArgumentException("n must be >= 0"); // unchecked (runtime)
        // 2) base case: when recursion stops (n == 0)
        if (n == 0)
            return; // return for void just stops when return, return what? void thats what

        // 3) Recursive case: calling same method with the smaller input
        System.out.println("We are Resiliant");
        System.out.println("We are brave");
        System.out.println("We can do hard things");
        mantra(n-1);
        // why cant do n-- post fix
        // 5 is being decremented AFTER
        // --n prefix to have it processed before it is passed to mantra again
        // avoid creating local varibles as to avoid multiple calling of method, burning memory
    }
}

