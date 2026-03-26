import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            FileWriter fw = new FileWriter("data.text",true);

            System.out.print("Enter text to save: ");
            String text = sc.nextLine();

            fw.write(text + "\n");
            fw.close();

            System.out.println("Data saved");

            System.out.println("\n--- File content ---");

            FileReader fr = new FileReader("data.text");
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: "+ e.getMessage());
        }
        sc.close();
    }
}
