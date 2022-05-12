import java.io.*;
import java.util.*;

public class passwordStrength
{

    public static void strength(String pw)
    {
        int numChar = pw.length();
        int numUp = 0;
        int numLow = 0;
        int numNum = 0; 
        int numSpec = 0;
        double entropy;
        double nop;

        ArrayList<Character> spec = new ArrayList<Character>(
            Arrays.asList('!', '@', '#', '$', '%', '+', '/', '^', '?', ':', ',', '(', ')', '{', '}', '[', ']', '~', '`', '-', '_', '.', '&', '*', '=', '|', ';', '<', '>', '\\', '\"', '\'')
            );

        for (int i = 0; i < numChar; i++)
        {
            if (Character.isUpperCase(pw.charAt(i)))
                numUp++;
            if (Character.isLowerCase(pw.charAt(i)))
                numLow++;
            if (Character.isDigit(pw.charAt(i)))
                numNum++;
            if (spec.contains(pw.charAt(i)))
                numSpec++;

        }

        if (numChar < 8)
            System.out.println("Password is too short \n Minimum 8 Characters");
        else if (numLow == 0 && numUp == 0)
            System.out.println("Invalid: Must contain letters");
        else
        {
            if (numUp > 0 && numLow > 0 && numSpec > 0 && numNum > 0)
            {
                nop = Math.pow(94, numChar);
                entropy = Math.log(nop) / Math.log(2);

                System.out.println("This is a Strong Password \n Entropy: " + entropy);
            }
            else if (numUp > 0 && numLow > 0 && numSpec > 0 && numNum == 0)
            {
                nop = Math.pow(84, numChar);
                entropy = Math.log(nop) / Math.log(2);

                System.out.println("Recommended to use at least one Digit \n Strength: Fair \n Entropy: " + entropy);
            }
            else if ((numUp == 0 && numLow > 0 && numSpec > 0 && numNum > 0) || (numUp > 0 && numLow == 0 && numSpec > 0 && numNum > 0))
            {
                nop = Math.pow(68, numChar);
                entropy = Math.log(nop) / Math.log(2);
                if (numUp == 0)
                    System.out.println("Recommended to include at least 1 uppercase letter \n Stength: Medium \n Entropy: " + entropy);
                if (numLow == 0)
                    System.out.println("Recommended to include at least 1 lowercase letter \n Stength: Medium \n Entropy: " + entropy);
            }
            else if (numUp > 0 && numLow > 0 && numSpec == 0 && numNum > 0)
            {
                nop = Math.pow(62, numChar);
                entropy = Math.log(nop) / Math.log(2);

                System.out.println("Recommended to use at least one Special Character \n Strength: Medium \n Entropy: " + entropy);
            }
            else if ((numUp == 0 && numLow > 0 && numSpec > 0 && numNum == 0) || (numUp > 0 && numLow == 0 && numSpec > 0 && numNum == 0))
            {
                nop = Math.pow(58, numChar);
                entropy = Math.log(nop) / Math.log(2);

                if (numUp == 0)
                    System.out.println("Recommended to inlude at least 1 uppercase letter and at least 1 Digit \n Stength: Medium to Weak \n Entropy: " + entropy);
                if (numLow == 0)
                    System.out.println("Recommended to inlude at least 1 lowercase letter and at least 1 Digit \n Stength: Medium to Weak \n Entropy: " + entropy);
            }
            else if (numUp > 0 && numLow > 0 && numSpec == 0 && numNum == 0)
            {
                nop = Math.pow(52, numChar);
                entropy = Math.log(nop) / Math.log(2);

                System.out.println("Recommended to use at least 1 digit and 1 special character in your password \n Strength: Weak \n Entropy: " + entropy);
            }
            else if ((numUp == 0 && numLow > 0 && numSpec == 0 && numNum > 0) || (numUp > 0 && numLow == 0 && numSpec == 0 && numNum > 0))
            {
                nop = Math.pow(36, numChar);
                entropy = Math.log(nop) / Math.log(2);
                if (numUp == 0)
                    System.out.println("Recommended to include at least 1 Uppercase Letter and at least 1 Special Character \n Strength: Weak \n Entropy: " + entropy);
                if (numLow == 0)
                    System.out.println("Recommended to include at least 1 Lowercase Letter and at least 1 Special Character \n Strength: Weak \n Entropy: " + entropy);
            }
            else if ((numUp == 0 && numLow > 0 && numSpec == 0 && numNum == 0) || (numUp > 0 && numLow == 0 && numSpec == 0 && numNum == 0))
            {
                nop = Math.pow(26, numChar);
                entropy = Math.log(nop) / Math.log(2);
                if (numUp == 0)
                    System.out.println("Recommended to include at least 1 Uppercase Letter, at least 1 Special Character, and 1 Digit \n Strength: Very Weak \n Entropy: " + entropy);
                if (numLow == 0)
                    System.out.println("Recommended to include at least 1 Lowercase Letter, at least 1 Special Character, and 1 Digit \n Strength: Very Weak \n Entropy: " + entropy);
            }
        }
    }
    public static void dictAtt(String pw) throws IOException
    {
        List<String> listOfStrings = new ArrayList<String>();
   
        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("engmix.txt"));
   
        // read entire line as string
        String line = bf.readLine();
   
        // checking for end of file
        while (line != null) 
        {
            listOfStrings.add(line);
            line = bf.readLine();
        }
   
    // closing bufferreader object
        bf.close();
   
    // storing the data in arraylist to array
        int counter = 0; 
        for (String i : listOfStrings)
        {
            if (pw.toLowerCase().contains(i))
            {
                if(i.length() > 2)
                {
                    System.out.println("Your password, " + pw + " contains a word, " + i + ", to make your password the most optimal against Dictionary Attacks, we recommend to not use any words in your password");
                    counter++;
                }
            }
        }
        if (counter == 0)
        {
            System.out.println("Your password is Strong against Dictionary Attacks");
        }
   

    }
    public static void name(String fn, String ln, String pw)
    {
        int m = fn.length();
        int n = ln.length();
        int c1 = 0;
        int c2 = 0;
        List<String> fnList = new ArrayList<String>();
        List<String> lnList = new ArrayList<String>();

        for (int i = 0; i < m; i++)
        {
            for(int j = i + 1; j <= m; j++)
            {
                fnList.add(fn.toLowerCase().substring(i, j));
            }
        }
        for (int i = 0; i < n; i++)
        {
            for(int j = i + 1; j <= n; j++)
            {
                lnList.add(ln.toLowerCase().substring(i, j));
            }
        }
        for (String i : fnList)
        {
            if (pw.toLowerCase().contains(i) && i.length() > 2)
            {
                System.out.println("Your password contains an abreviation of your first name, " + i + ", we recommend not putting any variations of your name into your password");
                c1++;
            }
        }
        for (String i : lnList)
        {
            if (pw.toLowerCase().contains(i) && i.length() > 2)
            {
                System.out.println("Your password contains an abreviation of your last name, " + i + ", we recommend not putting any variations of your name into your password");
                c2++;
            }
        }
        if (c1 == 0 && c2 == 0)
        {
            System.out.println("There are no variations of your first or last name contained in your password. This is good");
        }

    }
    public static void main(String [] args) throws IOException
    {
        System.out.println("Welcome to Password Strength Generator \n In this program, we will take in some information, as well as your password, and give reccomendations to make your password the most optimal it can be ");
        System.out.println("Some guidelines for your password:\n1. Password must conatain at least 8 characters\n2. The password must contain letters\n3. The password is reccomended to use a mix of lowercase/uppercase letters, digits, and special characters\n4. We recommend making you password as random as possible, and try not to use words in your password\n5. We strongly recommend not using any personal information in your password e.g. your name\n6. All of these algorithms are independent of each other. Your password might be strong against a brute force attack but not necessarily strong against a dictionary attack");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String fn = sc.nextLine();
        System.out.println("Enter your last name: ");
        String ln = sc.nextLine();
        System.out.println("Now Enter your password: ");
        String pw = sc.nextLine();

        System.out.println("Here is the strength of your password with respect to Brute Force Attacks: ");
        strength(pw);
        System.out.println("Here are some recomendations for your password with respect to Dictionary Attacks: ");
        dictAtt(pw);
        System.out.println("Here are some recomendations for you password based on your personal information: ");
        name(fn, ln, pw);
    }
}