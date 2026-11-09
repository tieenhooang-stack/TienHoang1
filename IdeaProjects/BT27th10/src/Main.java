import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    String maSach;
    String tenSach;
    String tacGia;
    int namXuatBan;
    double donGia;
    int soLuong;

    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, double donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    // Bài 2: Thành tiền = đơn giá * số lượng
    public double tinhThanhTien() {
        return donGia * soLuong;
    }

    // Bài 3: Phí vận chuyển = 5% giá trị sách
    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }

    // Bài 4: Tổng tiền nhập = Thành tiền + Phí vận chuyển
    public double tinhTongTienNhap() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }

    public void hienThi() {
        System.out.printf("| %-8s | %-20s | %-15s | %-6d | %,10.0f | %-8d | %,12.0f | %,10.0f | %,12.0f |\n",
                maSach, tenSach, tacGia, namXuatBan, donGia, soLuong,
                tinhThanhTien(), tinhPhiVanChuyen(), tinhTongTienNhap());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSach = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("\n========= CHƯƠNG TRÌNH QUẢN LÝ SÁCH THƯ VIỆN =========");
            System.out.println("1. Nhập thêm sách mới vào kho (Bài 1)");
            System.out.println("2. Hiển thị danh sách & Bảng tính giá trị nhập kho (Bài 1 - 4)");
            System.out.println("3. Tìm kiếm sách theo mã hoặc tên");
            System.out.println("4. Xóa sách khỏi kho theo mã sách");
            System.out.println("5. Thống kê tổng chi phí nhập kho của toàn thư viện");
            System.out.println("0. Thoát chương trình");
            System.out.print("-> Mời bạn chọn chức năng (0-5): ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng đầu sách muốn thêm: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhập cuốn sách thứ " + (i + 1) + " ---");
                        System.out.print("Mã sách: ");
                        String ma = sc.nextLine();
                        System.out.print("Tên sách: ");
                        String ten = sc.nextLine();
                        System.out.print("Tác giả: ");
                        String tg = sc.nextLine();
                        System.out.print("Năm xuất bản: ");
                        int nam = sc.nextInt();
                        System.out.print("Đơn giá: ");
                        double gia = sc.nextDouble();
                        System.out.print("Số lượng: ");
                        int sl = sc.nextInt();
                        sc.nextLine();

                        danhSach.add(new Sach(ma, ten, tg, nam, gia, sl));
                        System.out.println("-> Đã thêm sách thành công!");
                    }
                    break;

                case 2:
                    if (danhSach.isEmpty()) {
                        System.out.println("-> Kho sách hiện đang trống!");
                    } else {
                        inTieuDeBang();
                        for (Sach s : danhSach) {
                            s.hienThi();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập từ khóa (mã sách hoặc tên sách) cần tìm: ");
                    String tuKhoa = sc.nextLine().toLowerCase();
                    boolean timThay = false;
                    inTieuDeBang();
                    for (Sach s : danhSach) {
                        if (s.maSach.toLowerCase().contains(tuKhoa) || s.tenSach.toLowerCase().contains(tuKhoa)) {
                            s.hienThi();
                            timThay = true;
                        }
                    }
                    if (!timThay) {
                        System.out.println("-> Không tìm thấy cuốn sách nào phù hợp!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = sc.nextLine();
                    boolean daXoa = danhSach.removeIf(s -> s.maSach.equalsIgnoreCase(maXoa));
                    if (daXoa) {
                        System.out.println("-> Đã xóa sách có mã: " + maXoa);
                    } else {
                        System.out.println("-> Không tìm thấy mã sách cần xóa!");
                    }
                    break;

                case 5:
                    double tongThanhTien = 0, tongPhiVC = 0, tongNhapKho = 0;
                    for (Sach s : danhSach) {
                        tongThanhTien += s.tinhThanhTien();
                        tongPhiVC += s.tinhPhiVanChuyen();
                        tongNhapKho += s.tinhTongTienNhap();
                    }
                    System.out.println("\n--- TỔNG KẾT CHI PHÍ NHẬP KHO ---");
                    System.out.printf("Tổng số đầu sách   : %d\n", danhSach.size());
                    System.out.printf("Tổng thành tiền    : %,.2f VNĐ\n", tongThanhTien);
                    System.out.printf("Tổng phí vận chuyển: %,.2f VNĐ\n", tongPhiVC);
                    System.out.printf("Tổng tiền nhập kho : %,.2f VNĐ\n", tongNhapKho);
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình Quản lý sách.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);

        sc.close();
    }

    public static void inTieuDeBang() {
        System.out.printf("\n| %-8s | %-20s | %-15s | %-6s | %-10s | %-8s | %-12s | %-10s | %-12s |\n",
                "Mã Sách", "Tên Sách", "Tác Giả", "Năm XB", "Đơn Giá", "Số Lượng", "Thành Tiền", "Phí VC(5%)", "Tổng Tiền");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }
}