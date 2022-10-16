package ra.entity;

public interface IBook {
    final String File_Author="/Users/phamthanh/Desktop/JaVa/Bai16/BaiTapTongHop/Authors.txt";
    final String File_Book="/Users/phamthanh/Desktop/JaVa/Bai16/BaiTapTongHop/Books.txt";
    void inputData();

    void displayData();

    static void getData() {};

    static void insertData() {};
}
