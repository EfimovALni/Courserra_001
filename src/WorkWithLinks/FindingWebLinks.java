package WorkWithLinks;
/* Links
 * https://docs.oracle.com/javase/tutorial/networking/urls/creatingUrls.html#:~:text=In%20your%20Java%20program%2C%20you,reach%20the%20resource%20in%20question.
 * https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
 *
 *
 * */

import java.io.*;
import java.net.URL;

import java.util.ArrayList;

public class FindingWebLinks {

    public static void main(String[] args) throws IOException {

        String filePath = "E:\\WebPage.txt"; // You need create file before start program!
        String link = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";

        createFile(filePath, link);
        makeListOfLinks(filePath);

    }

    public static void makeListOfLinks(String filePath) throws IOException {
        String title = "<TITLE>";
        String href = "http://";

        File file = new File(filePath);
        FileReader reader = null;
        ArrayList arrayListLinsAll =  new ArrayList();

        try {
            reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String readLine = "";
            while ((readLine = bufferedReader.readLine()) != null) {
                if (readLine.indexOf(href) != -1) {
//                    There are we gave only lin link
                    int firstQuotes = readLine.indexOf(href);
                    String linkWithLastQuotes = readLine.substring(firstQuotes);

                    int secondQuotes = linkWithLastQuotes.indexOf("\"");
                    String finshLink = readLine.substring(firstQuotes, firstQuotes + secondQuotes);

//                    System.out.println(finshLink);
                    arrayListLinsAll.add(finshLink);
                }
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("File was READ success...");

        System.out.println("\nAll links: ");
        for (int i = 0; i < arrayListLinsAll.size(); i++) {
            System.out.println(i + "  "+ arrayListLinsAll.get(i));
        }
        cleanLinks(arrayListLinsAll);
    }

    private static void cleanLinks(ArrayList arrayListLinsAll) {
        String www = "www.";
        String tempString = "";
        String youtubeKey = "youtube";
        ArrayList linksYoutube = new ArrayList();

        for (int i = 0; i < arrayListLinsAll.size(); i++) {
            tempString = arrayListLinsAll.get(i).toString();
            int start = tempString.indexOf(www) + 4; //                Four because  'www.' = 4

            String youtubeToLowCase = "";
            if (start != -1) {

                int end = start + 7; // 7 becouse in the word 'youtube' 7 letters
                youtubeToLowCase = tempString.substring(start, end).toLowerCase();
//                System.out.println(youtubeToLowCase);
                if (youtubeToLowCase.indexOf(youtubeKey) != -1) {
//                    System.out.println(tempString);
                    linksYoutube.add(tempString);
                } else {}
            } else {
                System.out.println("Broken link...");
            }
//            https://www.youtube.com/
        }
        System.out.println();
        printLinksOfYoutube(linksYoutube);
    }

    private static void printLinksOfYoutube(ArrayList linksYoutube) {
        System.out.println("Answer: Youtube links");
        for (int i = 0; i < linksYoutube.size(); i++) {
            System.out.println(i +"\t"+ linksYoutube.get(i));
        }
    }

    /**
     * There are we create file for write HTML code of web page
     */
    public static void createFile(String filePath, String link) {
        File file = new File(filePath);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);

//             There are we read all information from page, according transmitted link
            URL myUrl = new URL(link);
            BufferedReader in = new BufferedReader(new InputStreamReader(myUrl.openStream()));

//            Write input stream in the file
            String inputLine = "";
            while ((inputLine = in.readLine()) != null) {
//                System.out.println(inputLine);  // Print to console
                buffer.write(inputLine + "\n"); // Print to file
            }
            in.close();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File was WRITE success...");
    }


    /**
     * There are we read all information from page, according transmitted link in this method
     */
    public static void readContentOfPage(String link) throws IOException {
        URL myUrl = new URL(link);
        BufferedReader in = new BufferedReader(new InputStreamReader(myUrl.openStream()));


        String inputLine = "";
        // РАБОТАЕТ РАСКОМЕНТИТЬ С ДОКУМЕНТАЦИИЁ
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }
}
