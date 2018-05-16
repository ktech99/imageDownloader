import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;

public class ImageDownloader {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter file name");
    String fileName = sc.nextLine();
    Scanner input = new Scanner(new File(fileName));
    List<String> lines = new ArrayList<>();
    while (input.hasNextLine()) {
      String next = input.nextLine().trim();
      if (next.length() > 0) {
        lines.add(next);
      }
    }
    // Iterator<String> itr = new lines.iterator();
    // int i = 0;
    for (int i = 0; i < lines.size(); i++) {
      String website = lines.get(i);
      try (InputStream in = new URL("" + website).openStream()) {
        Files.copy(in, Paths.get("C:\\Users\\karti\\Desktop\\image\\" + i + ".jpg"));
        System.out.println(i);
      } catch (Exception e) {

      }
      // i++;
    }
  }
}
