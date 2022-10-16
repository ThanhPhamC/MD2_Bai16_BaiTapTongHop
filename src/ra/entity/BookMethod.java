package ra.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static ra.entity.Book.*;

public class BookMethod {
    public static ArrayList<Book> bookList = new ArrayList<>();

    public static void showlistBook() {                                        //1.show list book
        bookList = getData();
        for (Book book : bookList) {
            book.displayData();
        }
    }

    public static void addNewBook(Scanner sc) {
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
            Book book = new Book();
            System.out.printf("Sach thu %d\n ", (i + 1));
            book.inputData();
            bookList.add(book);
        }
        insertData(bookList);
    }

    public static void editBook(Scanner sc) {
        System.out.println("nhap id sach muon cap nhap: ");
        String inputId = sc.nextLine();
        for (Book book : bookList) {
            if (book.getBookId().trim().equals(inputId.trim())) {
                System.out.println("nhap ten sach");
                book.setBookName(pushBookName(sc));
                System.out.println("nhap gia sach");
                book.setImportPrice(pushBookPice(sc));
                System.out.println("nhap gia ban");
                book.setExportPrice(pushExportBookPrice(sc, book.getImportPrice()));
                System.out.println("nhap so luong sach");
                book.setQuantity(pushBookQuantity(sc));
                System.out.println("nhap tieu de sach");
                book.setTittle(sc.nextLine());
                System.out.println("nhap noi dung sach");
                book.setContent(sc.nextLine());
                System.out.println("nha xuat ban");
                book.setPublishing(sc.nextLine());
                System.out.println("Trang thai sach");
                book.setBookStatus(Boolean.parseBoolean(sc.nextLine()));
                System.out.println("Chon tac gia");
                book.setAuthorArrayList(pushAuthorbook(sc));
                System.out.println("cap nhap thanh cong");
            } else {
                System.out.println("sach khong ton tai ");
            }
        }
    }

    public static void updateStatusBook(Scanner sc) {
        for (Book book : bookList) {
            if (book.getQuantity() > 0) {
                book.setBookStatus(true);
            } else {
                book.setBookStatus(false);
            }
        }
        System.out.println("cap nhap thanh cong");
    }

    public static void profitBook() {
        for (Book book : bookList) {
            book.calProfit();
        }
        System.out.println("Da tinh xong loi nhuan");
    }

    public static void arrangePriceBook() {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getExportPrice() > o2.getExportPrice()) {
                    return 1;
                } else if (o1.getExportPrice() == o2.getExportPrice()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    public static void searchBook(Scanner sc) {
        System.out.println("Nhap ten sach hoac ten tac gia ");
        String inputSearch = sc.nextLine();
        for (Book book : bookList) {
            if (book.getBookId().equals(inputSearch.trim())) {
                book.displayData();
                break;
            }for (Author author : AuthorMethod.authorList) {
                if (author.getAuthorName().equals(inputSearch.trim())) {
                    book.displayData();
                }
            }
        }

    }
        public static void saleBook (Scanner sc){
            System.out.println("nhap id sach muon ban");
            String inputID = sc.nextLine();
            for (Book book : bookList) {
                if (book.getBookId().equals(inputID.trim())) {
                    int quatity;
                    do {
                        try {
                            System.out.println("nhap so luong sach muon ban");
                            quatity = Integer.parseInt(sc.nextLine());
                            if (quatity > 0 && quatity < book.getQuantity()) {
                                book.setQuantity(book.getQuantity() - quatity);
                                System.out.println("ban thanh cong");
                                break;
                            } else {
                                System.out.printf("so luong ban phai nho hon so luong ton kho(%d).\n", book.getQuantity());
                            }
                        } catch (Exception e) {
                            System.out.println("sai dinh dang nhap lai");
                        }

                    } while (true);


                }
            }
        }
    }

