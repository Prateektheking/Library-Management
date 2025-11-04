import java.util.*;
// I am not that much Sharp at programming that's why i build what I understand and What knowledge of Language i carry 
// so i made this 
class Person {
    protected String name;
    protected int id;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
    public int getId() { return id; }
}

class Student extends Person {
    public Student(int id, String name) {
        super(id, name);
    }

    public void showInfo() {
        System.out.println("Student ID: " + id + ", Name: " + name);
    }
}

// Book class
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    public void showBook() {
        System.out.println(bookId + " - " + title + " by " + author + (isIssued ? " (Issued)" : " (Available)"));
    }
}

// Library class
class Library {
    private List<Book> books = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addStudent(Student student) { students.add(student); }

    public void showAllBooks() {
        if (books.isEmpty()) System.out.println("No books in library.");
        else for (Book b : books) b.showBook();
    }

    public void showAllStudents() {
        if (students.isEmpty()) System.out.println("No students registered.");
        else for (Student s : students) s.showInfo();
    }

    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId && !b.isIssued()) {
                b.issue();
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId && b.isIssued()) {
                b.returnBook();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}

// Main class 
public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        library.addBook(new Book(1, "Clean Code", "Robert Martin"));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
        library.addStudent(new Student(101, "Prateek"));
        library.addStudent(new Student(102, "Aman"));

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("you are using the system that is created by PRATEEK");
            System.out.println("1. ** Show All Books ***");
            System.out.println("2. ** Show All Students ***");
            System.out.println("3. ** Issue Book ** ");
            System.out.println("4. ** Return Book ** ");
            System.out.println("5. ** Add New Book ** ");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> library.showAllBooks();
                case 2 -> library.showAllStudents();
                case 3 -> {
                    System.out.print("Enter Book ID to issue: ");
                    int id = sc.nextInt();
                    library.issueBook(id);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to return: ");
                    int id = sc.nextInt();
                    library.returnBook(id);
                }
                case 5 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    System.out.println("Book added successfully!");
                }
                case 0 -> {
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
        //System.out.println("Thank you for using Library Management System");
    }
}

    

