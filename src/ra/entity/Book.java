package ra.entity;

import ra.run.BookManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Book implements IBook,Serializable, Comparator<Book> {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private ArrayList<Author> authorArrayList = new ArrayList<>();
    private String tittle;
    private String content;
    private String publishing;
    private boolean bookStatus;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, float profit, int quantity,
                ArrayList<Author> authorArrayList, String tittle, String content, String publishing, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.authorArrayList = authorArrayList;
        this.tittle = tittle;
        this.content = content;
        this.publishing = publishing;
        this.bookStatus = bookStatus;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Author> getAuthorArrayList() {
        return authorArrayList;
    }

    public void setAuthorArrayList(ArrayList<Author> authorArrayList) {
        this.authorArrayList = authorArrayList;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap id");
        this.bookId = pushBookId(sc, BookMethod.bookList);
        System.out.println("nhap ten");
        this.bookName = pushBookName(sc);
        System.out.println("nhap gia sach");
        this.importPrice = pushBookPice(sc);
        System.out.println("nhap gia ban");
        this.exportPrice = pushExportBookPrice(sc, this.importPrice);
        System.out.println("nhap so luong sach");
        this.quantity = pushBookQuantity(sc);
        System.out.println("nhap tieu de sach");
        this.tittle = sc.nextLine();
        System.out.println("nhap noi dung sach");
        this.content = sc.nextLine();
        System.out.println("nha xuat ban");
        this.publishing = sc.nextLine();
        System.out.println("Trang thai sach");
        this.bookStatus = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Chon tac gia");
        this.authorArrayList = pushAuthorbook(sc);

    }

    public String pushBookId(Scanner sc, List<Book> bookList) {
        String bookId;
        do {
            bookId = sc.nextLine();
            if (bookId.trim().length() != 0) {
                if (bookId.trim().length() == 5) {
                    if (bookId.charAt(0) == 'B') {
                        boolean check = true;
                        for (Book book : bookList) {
                            if (book.bookId.equals(bookId.trim())) {
                                break;
                            }
                        }
                        if (check) {
                            break;
                        } else {
                            System.out.println(" BookId da bi trung.");
                        }
                    } else {
                        System.out.println("BookId phai bat dau tu ki tu B.");
                    }
                } else {
                    System.out.println("BookId phai gom 5 ki tu");
                }
            } else {
                System.out.println("khong duoc de trong id");
            }
        } while (true);

        return bookId;
    }

    public static String pushBookName(Scanner sc) {
        String bookName;
        do {
            bookName = sc.nextLine();
            if (bookName.trim().length() != 0) {
                if (bookName.trim().length() > 5 && bookName.trim().length() < 100) {
                    break;
                } else {
                    System.out.println("Tên sách có từ 10-100 ký tự");
                }
            } else {
                System.out.println("khong duoc de trong id");
            }
        } while (true);
        return bookName;
    }

    public static float pushBookPice(Scanner sc) {
        float inputPice;
        do {
            try {
                inputPice = Float.parseFloat(sc.nextLine());
                if (inputPice > 0) {
                    break;
                } else {
                    System.out.println("gia sach phai lon hon 0.");
                }
            } catch (Exception e) {
                System.out.println("Sai dinh dang, nhap lai");
            }

        } while (true);
        return inputPice;
    }

    public static float pushExportBookPrice(Scanner sc, float importPrice) {
        float inputExPice;
        do {
            try {
                inputExPice = Float.parseFloat(sc.nextLine());
                if (inputExPice > 0) {
                    if (inputExPice > (importPrice + importPrice * 0.2)) {
                        break;
                    } else {
                        System.out.println("Gia sach phai lon hon gia nhap.");
                    }
                } else {
                    System.out.println("gia sach phai lon hon 0.");
                }
            } catch (Exception e) {
                System.out.println("Sai dinh dang, nhap lai.");
            }

        } while (true);
        return inputExPice;
    }

    public static int pushBookQuantity(Scanner sc) {
        int inputQuantity;
        do {
            try {
                inputQuantity = Integer.parseInt(sc.nextLine());
                if (inputQuantity >= 0) {
                    break;
                } else {
                    System.out.println("So luong nhap vao phai lon hon hoac bang 0");
                }
            } catch (Exception e) {
                System.out.println("Sai dinh dang, nhap lai: ");
            }
        } while (true);
        return inputQuantity;
    }

    public static ArrayList<Author> pushAuthorbook(Scanner sc) {
        ArrayList<Author> authorListofBook=new ArrayList<>();
        do {
            System.out.println("Danh sach tac gia");
            for (Author author : AuthorMethod.authorList) {
                System.out.printf("%d.  %s\n ", author.getAuthorId(), author.getAuthorName());
            }
            System.out.println("lua chon cua ban la");
            int choice = BookManagement.checkChoice(1,AuthorMethod.authorList.size()+1);
            for (Author author : AuthorMethod.authorList) {
                if (choice == author.getAuthorId()) {
                    if (authorListofBook.size()==0){
                        authorListofBook.add(author);
                    }else {
                        boolean check= true;
                        for (Author authorcheck : authorListofBook) {
                            if (authorcheck.getAuthorName().equals(author.getAuthorName())) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            authorListofBook.add(author);
                            break;
                        } else {
                            System.out.println("ten tac gia da ton tai");
                        }
                    }
                }
            }
            System.out.println(" ban co muon add them tac gia khong");
            System.out.println("1. yes    2.No");
            int inputchoice = Integer.parseInt(sc.nextLine());
            if (inputchoice != 1) {
                break;
            }
        } while (true);
        return authorListofBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", profit=" + profit +
                ", quantity=" + quantity +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", publishing='" + publishing + '\'' +
                ", bookStatus=" + bookStatus +
                '}';
    }

    @Override
    public void displayData() {
        System.out.printf("%s, %s, %f, %f, %f, %d, %s, %s, %b ", bookId, bookName, importPrice, exportPrice, profit, quantity, tittle, publishing, bookStatus);
        System.out.println("Danh sach tac gia: ");

        for (Author author : authorArrayList) {
            System.out.printf("%d.  %s",AuthorMethod.authorList.indexOf(author)+1,author.getAuthorName());
        }
    }
    public static ArrayList<Book> getData() {
        ArrayList<Book> bookList=new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(File_Book);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            bookList = (ArrayList<Book>)  ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        return bookList;
    }
    public static void insertData( ArrayList<Book>  bookslist) {
        File file=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            file=new File(File_Book);
            fos=new FileOutputStream(file);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(bookslist);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void calProfit(){
        this.profit=(this.exportPrice-this.importPrice)*this.quantity;
    }
    public void buyBook(int number){
        if (number >0){
                if (number<this.getQuantity()){
                    this.setQuantity(this.quantity-number);
                    if (this.getQuantity()==0){
                        this.setBookStatus(false);
                    }
                }else {
                    System.out.printf("so luong sach ban vuot qua so luong hien co(%d)\n",this.getQuantity());
                }
        }else {
            System.out.println("so luong phai lon hon 0");
        }
    }


    @Override
    public int compare(Book o1, Book o2) {
      return 0;
    }
}
