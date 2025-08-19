import java.util.*;

public class Driver {
    public static void main(String[] args) {
        List<Book> books = DatasetReader.readBooksFromCSV("data.csv");

        System.out.println("Total books by George Orwell: " + countBooksByAuthor(books, "George Orwell"));

        System.out.println("\nAll authors:");
        printAllAuthors(books);

        System.out.println("\nBooks by George R. R. Martin:");
        printBooksByAuthor(books, "George R. R. Martin");

        System.out.println("\nBooks with 4.7 rating:");
        printBooksByRating(books, 4.7);

        System.out.println("\nBooks and prices by JJ Smith:");
        printBooksAndPricesByAuthor(books, "JJ Smith");
    }

    public static int countBooksByAuthor(List<Book> books, String author) {
        int count = 0;
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        return count;
    }

    public static void printAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book b : books) {
            authors.add(b.getAuthor());
        }
        for (String author : authors) {
            System.out.println(author);
        }
    }

    public static void printBooksByAuthor(List<Book> books, String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b.getTitle());
            }
        }
    }

    public static void printBooksByRating(List<Book> books, double rating) {
        for (Book b : books) {
            if (b.getUserRating() == rating) {
                System.out.println(b.getTitle() + " by " + b.getAuthor());
            }
        }
    }

    public static void printBooksAndPricesByAuthor(List<Book> books, String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b.getTitle() + " - $" + b.getPrice());
            }
        }
    }
}
