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
    Iterator<String> itr = new lines.iterator();
    while (itr.hasNextLine()) {}
  }
}