import java.io.*;
import java.util.*;

public class DatasetReader {
    public static List<Book> readBooksFromCSV(String filename) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1); 
                if (values.length == 7) {
                    try {
                        String title = values[0];
                        String author = values[1];
                        double userRating = Double.parseDouble(values[2]);
                        int reviews = Integer.parseInt(values[3]);
                        double price = Double.parseDouble(values[4]);
                        int year = Integer.parseInt(values[5]);
                        String genre = values[6];

                        Book book = new Book(title, author, userRating, reviews, price, year, genre);
                        books.add(book);
                    } catch (Exception e) {
                        throw new RuntimeException("Error parsing line: " + line, e);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
