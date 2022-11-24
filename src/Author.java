import java.util.ArrayList;

public class Author {
    private String name;
    private ArrayList<Book> books;

    public Author() {
        this.name = "";
        this.books = new ArrayList<>();
    }

    public Author(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Author(Author curAuthor) {
        this.name = curAuthor.name;
        this.books = curAuthor.books;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
