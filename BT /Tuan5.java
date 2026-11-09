import java.util.Scanner;

public class Tuan5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int luaChon;
        int n = 0;
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        String danhSachSach = ""; // Lưu thông tin toàn bộ sách dạng văn bản

        // Bài 3: Menu lặp liên tục đến khi chọn Thoát (dùng DO-WHILE)
        do {
            System.out.println("\n=== MENU QUẢN LÝ SÁCH THƯ VIỆN ====");
            System.out.println("1. Nhập n sách bằng vòng lặp (Bài 1)");
            System.out.println("2. Tính tổng số lượng và tổng giá trị sách (Bài 2)");
            System.out.println("3. Hiển thị danh sách tất cả các sách");
            System.out.println("4. Tìm sách theo mã (Bài 4)");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (0-4): ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Xóa phím Enter thừa

            if (luaChon == 1) {
                // Bài 1: Nhập n sách (dùng vòng lặp FOR)
                System.out.print("Nhập số lượng sách cần thêm (n): ");
                n = sc.nextInt();
                sc.nextLine();

                tongSoLuong = 0;
                tongGiaTri = 0;
                danhSachSach = "";

                for (int i = 1; i <= n; i++) {
                    System.out.println("\n--- Nhập cuốn sách thứ " + i + " ---");
                    System.out.print("Mã sách: ");
                    String maSach = sc.nextLine();

                    System.out.print("Tên sách: ");
                    String tenSach = sc.nextLine();

                    System.out.print("Đơn giá: ");
                    double donGia = sc.nextDouble();

                    System.out.print("Số lượng: ");
                    int soLuong = sc.nextInt();
                    sc.nextLine();

                    // Bài 2: Tính tổng số lượng và tổng giá trị ngay trong vòng lặp
                    tongSoLuong += soLuong;
                    tongGiaTri += (donGia * soLuong);

                    // Ghép từng cuốn sách thành 1 dòng (dấu ';' để ngăn cách từng dòng)
                    danhSachSach += "Mã sách: " + maSach + " | Tên: " + tenSach
                            + " | Giá: " + donGia + " | SL: " + soLuong + ";";
                }
                System.out.println("-> Đã nhập thành công " + n + " cuốn sách!");

            } else if (luaChon == 2) {
                // Bài 2: In tổng số lượng và tổng giá trị
                if (n == 0) {
                    System.out.println("Chưa có sách nào! Vui lòng chọn mục 1 để nhập sách.");
                } else {
                    System.out.println("\n--- TỔNG KẾT (BÀI 2) ---");
                    System.out.println("Tổng số lượng sách: " + tongSoLuong);
                    System.out.printf("Tổng giá trị các cuốn sách: %,.2f VNĐ\n", tongGiaTri);
                }

            } else if (luaChon == 3) {
                // Hiển thị danh sách (dùng vòng lặp WHILE duyệt qua chuỗi)
                if (n == 0) {
                    System.out.println("Kho sách đang trống!");
                } else {
                    System.out.println("\n--- DANH SÁCH SÁCH HIỆN CÓ ---");
                    String temp = danhSachSach;
                    while (temp.contains(";")) {
                        int viTri = temp.indexOf(";");
                        String dongSach = temp.substring(0, viTri);
                        System.out.println("- " + dongSach);
                        temp = temp.substring(viTri + 1);
                    }
                }

            } else if (luaChon == 4) {
                // Bài 4: Tìm sách theo mã (dùng vòng lặp WHILE duyệt qua chuỗi)
                if (n == 0) {
                    System.out.println("Chưa có sách nào để tìm! Vui lòng chọn mục 1 để nhập sách.");
                } else {
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = sc.nextLine();
                    boolean timThay = false;

                    String temp = danhSachSach;
                    System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
                    while (temp.contains(";")) {
                        int viTri = temp.indexOf(";");
                        String dongSach = temp.substring(0, viTri);

                        // Kiểm tra nếu dòng sách có chứa mã cần tìm
                        if (dongSach.contains("Mã sách: " + maTim + " ")) {
                            System.out.println("-> Tìm thấy: " + dongSach);
                            timThay = true;
                        }
                        temp = temp.substring(viTri + 1);
                    }

                    if (!timThay) {
                        System.out.println("Không tìm thấy cuốn sách nào có mã: " + maTim);
                    }
                }

            } else if (luaChon == 0) {
                System.out.println("Đã thoát chương trình!");
            } else {
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại (0-4)!");
            }

        } while (luaChon != 0); // Vòng lặp kết thúc khi luaChon == 0

        sc.close();
    }
}