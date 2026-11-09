import java.util.Scanner;

public class QuanLySach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- BÀI 1: Nhập thông tin sách ---
        System.out.println("=== NHẬP THÔNG TIN SÁCH ===");

        System.out.print("Nhập mã sách: ");
        String maSach = sc.nextLine();

        System.out.print("Nhập tên sách: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int namXuatBan = sc.nextInt();

        System.out.print("Nhập đơn giá: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();

        // --- BÀI 2: Tính thành tiền = đơn giá * số lượng ---
        double thanhTien = donGia * soLuong;

        // --- BÀI 3: Phí vận chuyển = 5% giá trị sách (thành tiền) ---
        double phiVanChuyen = thanhTien * 0.05;

        // --- BÀI 4: Tổng tiền nhập = Thành tiền + Phí vận chuyển ---
        double tongTienNhap = thanhTien + phiVanChuyen;

        // --- HIỂN THỊ KẾT QUẢ ---
        System.out.println("\n=== THÔNG TIN NHẬP KHO SÁCH ===");
        System.out.println("Mã sách        : " + maSach);
        System.out.println("Tên sách       : " + tenSach);
        System.out.println("Tác giả        : " + tacGia);
        System.out.println("Năm xuất bản   : " + namXuatBan);
        System.out.printf("Đơn giá        : %,.2f VNĐ\n", donGia);
        System.out.println("Số lượng       : " + soLuong);
        System.out.println("--------------------------------");
        System.out.printf("Thành tiền     : %,.2f VNĐ\n", thanhTien);
        System.out.printf("Phí vận chuyển : %,.2f VNĐ\n", phiVanChuyen);
        System.out.printf("Tổng tiền nhập : %,.2f VNĐ\n", tongTienNhap);

        sc.close();
    }
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome!"));

    for (int i = 1; i <= 5; i++) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        IO.println("i = " + i);
    }
}
