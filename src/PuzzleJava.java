import java.util.Random;
import java.util.Arrays;

public class PuzzleJava
{

    static Random r;

    public static void arrPrint(int[] arr)
    {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
            if (i + 1 < arr.length)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void arrPrint(String[] arr)
    {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
            if (i + 1 < arr.length)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int greaterThanY(int[] x, int y)
    {
        int g = 0;
        for (int i : x)
        {
            if (i > y)
            {
                g++;
            }
        }
        return g;
    }

    public static String[] shuffleArr(String[] arr)
    {
        String[] shuffled = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            int j;
            while (true)
            {
                j = r.nextInt(arr.length);
                if (shuffled[j] == null)
                {
                    shuffled[j] = arr[i];
                    break;
                }
            }
        }
        return shuffled;
    }

    public static char[] shuffleArr(char[] arr)
    {
        char[] shuffled = new char[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            int j;
            while (true)
            {
                j = r.nextInt(arr.length);
                if (shuffled[j] == '\u0000')
                {
                    shuffled[j] = arr[i];
                    break;
                }
            }
        }
        return shuffled;
    }

    public static char[] generateAlpha()
    {
        char[] alpha = new char[26];
        for (char c = 'a'; c <= 'z'; c++)
        {
            alpha[c - 'a'] = c;
        }
        return alpha;
    }

    public static void main(String[] args)
    {
        r = new Random();
        arrPrint(numberArray(new int[] { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 }));
        System.out.println();
        arrPrint(nameArray(new String[] { "Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa" }));
        System.out.println();
        alphaArray(generateAlpha());
        System.out.println();
        arrPrint(randomNums());
        System.out.println();
        arrPrint(sortedNums());
        System.out.println();
        System.out.println(randString());
        System.out.println();
        arrPrint(randStringArr());
    }

    public static int[] numberArray(int[] arr)
    {

        int[] grt = new int[greaterThanY(arr, 10)];
        int gCount = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > 10)
            {
                grt[gCount] = arr[i];
                gCount++;
            }
            sum += arr[i];
        }
        System.out.println(sum);
        return grt;
    }

    public static String[] nameArray(String[] arr)
    {
        int[] lengths = new int[arr.length]; // As it turns out, Strings take up a lot more memory than integers. This
                                             // is a more generally
        for (int i = 0; i < arr.length; i++) // efficient way of creating the greater-than array.
        {
            lengths[i] = arr[i].length();
        }
        String[] grt = new String[greaterThanY(lengths, 5)];
        int gCount = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].length() > 5)
            {
                grt[gCount] = arr[i];
                gCount++;
            }
        }
        arrPrint(shuffleArr(arr));
        return grt;
    }

    public static void alphaArray(char[] arr)
    {
        char[] shuffled = shuffleArr(arr);
        System.out.println("Last character: " + shuffled[shuffled.length - 1] + ", First character: " + shuffled[0]);
        switch (shuffled[0]) 
        {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            System.out.println("The first character was a vowel");
            break;
        case 'y':
            System.out.println("The first character may or may not have been a vowell, depending on whether you consider 'y' a vowel");
            break;
        }
    }
    
    public static int[] randomNums()
    {
        int[] rnd = new int[10];
        for(int i = 0; i < 10; i++)
        {
            rnd[i] = r.nextInt(46) + 55;
        }
        return rnd;
    }
    
    public static int[] sortedNums()
    {
        int[] rnd = randomNums();
        Arrays.sort(rnd);
        System.out.println("Max: " + rnd[rnd.length - 1] + ", Min: " + rnd[0]);
        return rnd;
    }
    
    public static String randString()
    {
        char[] chars = shuffleArr(generateAlpha());
        return ("" + chars[0] + chars[1] + chars[2] + chars[3] + chars[4]);
    }
    
    public static String[] randStringArr()
    {
        String[] strings = new String[10];
        for(int i = 0; i < strings.length; i++)
        {
            strings[i] = randString();
        }
        return strings;
    }

}
