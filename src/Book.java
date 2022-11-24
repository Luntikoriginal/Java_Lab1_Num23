public class Book {
    private String name, author, publish;
    private double rating;
    private int pages, dayOfPublic, monthOfPubic, yearOfPublic;

    public Book() {
        name = "";
        author = "";
        rating = 0;
        pages = 0;
        publish = "";
        dayOfPublic = 1;
        monthOfPubic = 1;
        yearOfPublic = 1;
    }

    public Book(String name, String author, double rating, int pages, String publish, int dayOfPublic, int monthOfPubic, int yearOfPublic) {
        this.name = name;
        this.author = author;
        this.rating = rating;
        this.pages = pages;
        this.publish = publish;
        this.dayOfPublic = dayOfPublic;
        this.monthOfPubic = monthOfPubic;
        this.yearOfPublic = yearOfPublic;
    }

    public Book(Book curBook) {
        this.name = curBook.name;
        this.author = curBook.author;
        this.rating = curBook.rating;
        this.pages = curBook.pages;
        this.publish = curBook.publish;
        this.dayOfPublic = curBook.dayOfPublic;
        this.monthOfPubic = curBook.monthOfPubic;
        this.yearOfPublic = curBook.yearOfPublic;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getRating() {
        return rating;
    }

    public int getPages() {
        return pages;
    }

    public String getPublish() {
        return publish;
    }

    public int getDayOfPublic() {
        return dayOfPublic;
    }

    public int getMonthOfPubic() {
        return monthOfPubic;
    }

    public int getYearOfPublic() {
        return yearOfPublic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public void setDayOfPublic(int dayOfPublic) {
        this.dayOfPublic = dayOfPublic;
    }

    public void setMonthOfPubic(int monthOfPubic) {
        this.monthOfPubic = monthOfPubic;
    }

    public void setYearOfPublic(int yearOfPublic) {
        this.yearOfPublic = yearOfPublic;
    }

    public boolean checkPositiveNum(double num) {
        return num >= 0;
    }
}
