import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Book> books = new ArrayList<>();
        readBooks("data_books.csv", books);

        ArrayList<Author> authors = new ArrayList<>();
        books.sort(Comparator.comparing(Book::getAuthor));
        addAuthors(authors, books);

        writeAuthorOfLargestBookInfo(authors);

        publishingOfAuthor(authors);
    }

    public static void readBooks(String file, ArrayList<Book> books) {
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNext()) {
                String str = sc.nextLine();
                String[] elements = str.split(",");
                String[] date = elements[5].split("/");
                if (elements.length < 7) continue;
                books.add(new Book(elements[0], elements[1], Double.parseDouble(elements[2]), Integer.parseInt(elements[4]), elements[6],
                        Integer.parseInt(date[1]), Integer.parseInt(date[0]), Integer.parseInt(date[2])));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
        catch (Exception e) {
            System.out.println("Файл заполнен с ошибкой!");
        }
    }

    public static void addAuthors(ArrayList<Author> authors, ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            ArrayList<Book> hisBooks = new ArrayList<>();
            while ((i < books.size() - 1) && (books.get(i)).getAuthor().equals((books.get(i + 1)).getAuthor())) {
                hisBooks.add(books.get(i));
                i++;
            }
            hisBooks.add(books.get(i));
            authors.add(new Author((books.get(i)).getAuthor(), hisBooks));
        }
    }

    public static void writeAuthorOfLargestBookInfo(ArrayList<Author> authors) {
        try {
            FileWriter fw = new FileWriter("Largest_Book's_Author.txt");
            int maxCountPages = authors.get(0).getBooks().get(0).getPages();
            Author hardworking = new Author(authors.get(0));
            Book big = new Book(authors.get(0).getBooks().get(0));
            for (Author i : authors) {
                for (Book j : i.getBooks()) {
                    if (j.getPages() > maxCountPages) {
                        maxCountPages = j.getPages();
                        hardworking = i;
                        big = j;
                    }
                }
            }
            fw.write("Автор " + hardworking.getName() + " написал самую толстую книгу " + big.getName()
                    + " размером в " + maxCountPages + " страниц\nКниги, написанные автором:");
            hardworking.getBooks().sort(Comparator.comparing(Book::getRating).reversed());
            for (Book i : hardworking.getBooks()) {
                fw.write("\n" + i.getName() + " с рейтингом " + i.getRating());
            }
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (Exception e) {
            System.out.println("Файл заполнен с ошибкой!");
        }
    }

    public static void publishingOfAuthor(ArrayList<Author> authors) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя писателя: ");
        String name = sc.nextLine();
        System.out.println("Издательства, в которых опубликованы его книги:");
        boolean flag = true;
        ArrayList<String> publish = new ArrayList<>();
        for (Author i : authors) {
            if (i.getName().equals(name)) {
                flag = false;
                for (Book j : i.getBooks()) {
                    if (!publish.contains(j.getPublish())) System.out.println(j.getPublish());
                    publish.add(j.getPublish());
                }
            }
        }
        if (flag) System.out.println("Автор не найден");
    }
}
