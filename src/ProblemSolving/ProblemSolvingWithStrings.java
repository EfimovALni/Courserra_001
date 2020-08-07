/**
* task from Courserra
*
* Programming Exercise: Finding a Gene and Web Links
* */

package ProblemSolving;

import javax.swing.plaf.IconUIResource;
import javax.xml.stream.events.Characters;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemSolvingWithStrings {
    public static String twoOccurrences(String stringa, String stringb) {
        Pattern p = Pattern.compile(stringa);
        Matcher m = p.matcher(stringb);

        int count = 0;
        while (m.find()) {
            count++;
        }

        if (count >= 2) {
            return "true, was " + count + " times";
        } else
            return "false";
    }


    public static String findSimpleGene (String data) {

        int countUpperCase = 0;
        int countLowerCase = 0;
        char[] charArray = data.toCharArray();

        for (char charLetter : charArray) {
            if (Character.isUpperCase(charLetter)) {
                countUpperCase++;
            } else {
                countLowerCase++;
            }
        }

        return "Amount of 'Upper': " + countUpperCase + ", \tAmount of 'Lower': " + countLowerCase + "\t\tInput data: " + data;
    }


    public static String lastPart (String stringA, String stringB) {

        int aLenght = stringA.length();
        int indStart = stringB.indexOf(stringA);

        return stringB.indexOf(stringA) != -1 ? stringB.substring(indStart + aLenght) : stringB;
    }



    public static void main(String[] args) throws IOException {
//        Task 3.1
        System.out.println("//        Task 3.1");
        System.out.println(twoOccurrences("ctgtatgta", "atg"));
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("na", "bannan + bam"));

//        Task 3.2
        System.out.println("//        Task 3.2");
        System.out.println(findSimpleGene("ATGGGTTAAGTC"));;
        System.out.println(findSimpleGene("gatgctataat"));;
        System.out.println(findSimpleGene("AlexandeR"));
        System.out.println("\nReading data from file:");

        String fileName = "E:\\Lists.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";

        while ((line = br.readLine()) != null) {
            System.out.println(findSimpleGene(line));
        }

//        Task 3.4
        System.out.println("//        Task 3.4");
        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("zoo", "Lešna"));
        System.out.println(lastPart("Alexander", "I'm Alexander and I prefer meat"));
        System.out.println(lastPart("London", "English country is a ..."));




    }
}
