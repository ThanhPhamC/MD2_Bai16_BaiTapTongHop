package ra.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.entity.Author.*;
import static ra.entity.IBook.File_Author;

public class AuthorMethod {
    public static ArrayList<Author> authorList = new ArrayList<>();

    public static void showlistauthor() {                                        //1.show list author
        authorList = getData();
        for (Author author : authorList) {
            author.displayData();
        }
    }

    public static void addNewAuthor(Scanner sc) {
        int count;
        while (true) {
            try {
                System.out.println("nhap so luong muon them");
                count = Integer.parseInt(sc.nextLine());
                if (count > 0) {
                    break;
                } else {
                    System.out.println("nhap so nguyen lon hon 0.");
                }
            } catch (Exception e) {
                System.out.println(" sai dinh dang");
            }

        }
        for (int i = 0; i < count; i++) {
            Author author = new Author();
            System.out.printf("Tac gia thu %d\n ", (i + 1));
            author.inputData();
            authorList.add(author);
        }
        insertData(authorList);

    }

    public static void editAuthor(Scanner sc) {
        authorList = getData();
        System.out.println("nhap id tac gia muon cap nhap: ");
        int inputId = Integer.parseInt(sc.nextLine());
        boolean check = true;
        for (Author author : authorList) {
            if (author.getAuthorId()==inputId){
               author.setAuthorName(checkinputName(sc));
                System.out.println("Trang thai tac gia");
               author.setAuthorStatus(Boolean.parseBoolean(sc.nextLine()));
                System.out.println("cap nhap thanh cong");
                check=true;
                break;
            }else {
                check=false;
            }
        }
        if (check){
            insertData(authorList);
        }else {
            System.out.println(" id khong ton tai");
        }

    }
    public static void updateStatusAuthor(Scanner sc){
        authorList = getData();
        System.out.println("nhap id tac gia muon cap nhap: ");
        int inputId = Integer.parseInt(sc.nextLine());
        for (Author author : authorList) {
            if (author.getAuthorId()==inputId){
                author.setAuthorStatus(!author.isAuthorStatus());
            }
        }
        insertData(authorList);
        System.out.println("da cap nhap trang thai tac gia thanh cong");
    }
}
