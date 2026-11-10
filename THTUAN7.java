import java.util.ArrayList;
import java.util.Scanner;


// YÊU CẦU 1: Lớp Sach với các thuộc tính cơ bản

class Sach {
    // Thuộc tính (attributes)
    String maSach;
    String tieuDe;
    String tacGia;
    int namXuatBan;
    int soLuong;

    // Constructor mặc định (không tham số)
    public Sach() {
    }

    // Constructor đầy đủ tham số
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    // Phương thức nhập thông tin sách từ bàn phím
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhập mã sách: ");
        this.maSach = sc.nextLine();

        System.out.print("Nhập tiêu đề sách: ");
        this.tieuDe = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        this.tacGia = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        this.namXuatBan = sc.nextInt();

        System.out.print("Nhập số lượng: ");
        this.soLuong = sc.nextInt();
        sc.nextLine(); // Xóa bộ đệm sau khi nhập số
    }


    // YÊU CẦU 2: Phương thức hienThiThongTin()

    public void hienThiThongTin() {
        System.out.printf("| %-10s | %-25s | %-18s | %-8d | %-8d |\n",
                maSach, tieuDe, tacGia, namXuatBan, soLuong);
    }
}


// YÊU CẦU 3 & 4: Lớp Test quản lý danh sách bằng ArrayList

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Minh họa Yêu cầu 3: Tạo đối tượng cụ thể từ lớp Sach
        System.out.println("=== MINH HỌA TẠO ĐỐI TƯỢNG TỪ LỚP SACH  ===");
        Sach sachMau = new Sach("B01", "Thương Em", "Đinh Tiến Hoàng", 2007, 1500);
        inTieuDeBang();
        sachMau.hienThiThongTin();

        // Yêu cầu 4: Quản lý danh sách đối tượng Sach bằng ArrayList
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("\n========== MENU QUẢN LÝ SÁCH  ==========");
            System.out.println("1. Thêm sách mới vào thư viện");
            System.out.println("2. Hiển thị danh sách tất cả các sách");
            System.out.println("3. Tìm kiếm sách theo mã sách");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Cập nhật số lượng sách");
            System.out.println("0. Thoát chương trình");
            System.out.print("-> Mời bạn chọn chức năng (0-5): ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm phím Enter

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- NHẬP THÔNG TIN SÁCH MỚI ---");
                    Sach sMoi = new Sach();
                    sMoi.nhapThongTin(sc);
                    danhSachSach.add(sMoi);
                    System.out.println("-> Thêm sách thành công!");
                    break;

                case 2:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Kho sách đang trống! Vui lòng chọn 1 để thêm sách.");
                    } else {
                        System.out.println("\n--- TỔNG DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
                        inTieuDeBang();
                        for (Sach s : danhSachSach) {
                            s.hienThiThongTin();
                        }
                    }
                    break;

                case 3:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Kho sách đang trống!");
                    } else {
                        System.out.print("Nhập mã sách cần tìm: ");
                        String maTim = sc.nextLine().trim();
                        boolean timThay = false;

                        inTieuDeBang();
                        for (Sach s : danhSachSach) {
                            if (s.maSach.equalsIgnoreCase(maTim)) {
                                s.hienThiThongTin();
                                timThay = true;
                                break;
                            }
                        }
                        if (!timThay) {
                            System.out.println("Không tìm thấy cuốn sách nào có mã: " + maTim);
                        }
                    }
                    break;

                case 4:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Kho sách đang trống!");
                    } else {
                        System.out.print("Nhập mã sách cần xóa: ");
                        String maXoa = sc.nextLine().trim();
                        boolean daXoa = false;

                        for (int i = 0; i < danhSachSach.size(); i++) {
                            if (danhSachSach.get(i).maSach.equalsIgnoreCase(maXoa)) {
                                danhSachSach.remove(i);
                                daXoa = true;
                                System.out.println("-> Đã xóa thành công sách có mã: " + maXoa);
                                break;
                            }
                        }
                        if (!daXoa) {
                            System.out.println("Không tìm thấy mã sách để xóa!");
                        }
                    }
                    break;

                case 5:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Kho sách đang trống!");
                    } else {
                        System.out.print("Nhập mã sách cần cập nhật số lượng: ");
                        String maCapNhat = sc.nextLine().trim();
                        boolean daCapNhat = false;

                        for (Sach s : danhSachSach) {
                            if (s.maSach.equalsIgnoreCase(maCapNhat)) {
                                System.out.print("Nhập số lượng mới: ");
                                s.soLuong = sc.nextInt();
                                sc.nextLine();
                                daCapNhat = true;
                                System.out.println("-> Cập nhật số lượng thành công!");
                                break;
                            }
                        }
                        if (!daCapNhat) {
                            System.out.println("Không tìm thấy mã sách cần cập nhật!");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình Quản lý sách!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại (0-5)!");
            }
        } while (luaChon != 0);

        sc.close();
    }

    // Hàm phụ trợ in tiêu đề bảng gọn gàng
    private static void inTieuDeBang() {
        System.out.printf("| %-10s | %-25s | %-18s | %-8s | %-8s |\n",
                "Mã Sách", "Tiêu Đề", "Tác Giả", "Năm XB", "Số Lượng");
        System.out.println("----------------------------------------------------------------------------------");
    }
}