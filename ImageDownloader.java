import java.io.*;
import java.net.*;
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
      System.out.println(lines.size());
    for (int i = 0; i < lines.size(); i++) {
        System.out.println(i);
      String website = lines.get(i);
      try {
            URLConnection c = new URL("" + website).openConnection();
          c.connect();
          c.setConnectTimeout(50);
          c.setReadTimeout(50);


          InputStream in = c.getInputStream();
          System.out.println(in.available());
          long end = System.currentTimeMillis();
          
          if(in.available()<= 900 || System.currentTimeMillis() >= end + 1000){
              in.close();
              
          }else{
          //while(System.currentTimeMillis() <= end + 1000 ){}
          
             
        Files.copy(in, Paths.get("\\Users\\kartikar\\Desktop\\compost\\" + i + ".jpg"));
              in.close();
              System.out.println(i);}
      } catch (Exception e) {

      }
        
    }
  }
    public static boolean isConnected(URLConnection con) {
        try {
            con.setDoOutput(con.getDoOutput()); // throws IllegalStateException if connected
            return false;
        } catch (IllegalStateException e) {
            return true;
        }
    }
}
