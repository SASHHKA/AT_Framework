package randomizer;

public class Randomizer {

    public static String RandGeneratedStr(int l)

    {
        String AlphaNumericStr = "ABCDEFabcdef0123456789";
        StringBuilder s = new StringBuilder(l);

        int i;

        for ( i=0; i<l; i++) {

            int ch = (int)(AlphaNumericStr.length() * Math.random());

            s.append(AlphaNumericStr.charAt(ch));

        }

        return s.toString();

    }

    public static void main(String[] args)

    {

        //assign the size of the string

        int n = 10;

        //Output the randomly generated alphanumeric string

        System.out.println(Randomizer.RandGeneratedStr(n));

    }
}
