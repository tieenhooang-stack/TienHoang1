import java.util.ArrayList;
import java.util.Scanner;

class Sack {
    // Yêu cầu 1: Khai báo tất cả các thuộc tính ở chế độ private để đảm bảo tính đóng gói
    protected String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    int soLuong;

    // Constructor mặc định không tham số
    public Sack() {
    }

    // Yêu cầu 4: Constructor đầy đủ tham số để khởi tạo toàn bộ thông tin sách khi tạo đối tượng
    public Sack(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        // Gọi setter để áp dụng kiểm tra tính hợp lệ dữ liệu ngay khi khởi tạo
        this.setNamXuatBan(namXuatBan);
        this.setSoLuong(soLuong);
    }

    // Yêu cầu 2: Cung cấp đầy đủ các phương thức getter và setter để truy xuất và cập nhật dữ liệu
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    // Yêu cầu 3: Ràng buộc năm xuất bản phải lớn hơn 0 và không vượt quá năm hiện tại (2026)
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = 2026;
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Cảnh báo: Năm xuất bản " + namXuatBan + " không hợp lệ (phải > 0 và <= " + currentYear + ")!");
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Yêu cầu 3: Ràng buộc số lượng sách không được mang giá trị âm (>= 0)
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Cảnh báo: Số lượng không được nhận giá trị âm (" + soLuong + ")!");
        }
    }

    // Phương thức in toàn bộ thông tin chi tiết của một cuốn sách
    public void hienThiThongTin() {
        System.out.printf("| %-10s | %-25s | %-18s | %-8d | %-8d |\n",
                maSach, tieuDe, tacGia, namXuatBan, soLuong);
    }

    public void nhapThongTin(Scanner sc) {
    }
}

public class Tuan8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khởi tạo đối tượng mẫu bằng constructor có tham số (Yêu cầu 4)
        Sack s1 = new Sack("S01", "Nho Em", "Đinh Tiến Hoàng", 2025, 2000);
        inTieuDeBang();
        s1.hienThiThongTin();

        // Kiểm tra ràng buộc dữ liệu của setter khi truyền giá trị sai quy định (Yêu cầu 3)
        s1.setNamXuatBan(2030); // Năm vượt quá năm hiện tại
        s1.setSoLuong(-5);       // Số lượng bị âm

        // Quản lý tập hợp các đối tượng Sach bằng danh sách động ArrayList
        ArrayList<Sack> danhSach = new ArrayList<>();
        danhSach.add(s1);

        int luaChon;
        do {
            System.out.println("\nMENU BÀI THỰC HÀNH TUẦN 8");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Sửa số lượng sách");
            System.out.println("4. Tìm kiếm sách theo mã");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn chức năng (0-4): ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Đọc bỏ ký tự Enter thừa trong bộ đệm

            switch (luaChon) {
                case 1:
                    // Nhập thông tin sách từ bàn phím và khởi tạo đối tượng mới qua constructor
                    System.out.print("Nhập mã sách: ");
                    String ma = sc.nextLine();
                    System.out.print("Nhập tiêu đề: ");
                    String tieuDe = sc.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String tacGia = sc.nextLine();
                    System.out.print("Nhập năm xuất bản: ");
                    int nam = sc.nextInt();
                    System.out.print("Nhập số lượng: ");
                    int sl = sc.nextInt();
                    sc.nextLine();

                    Sack sachMoi = new Sack(ma, tieuDe, tacGia, nam, sl);
                    danhSach.add(sachMoi);
                    System.out.println("Đã thêm sách vào danh sách!");
                    break;

                case 2:
                    // Hiển thị toàn bộ danh sách sách hiện có
                    if (danhSach.isEmpty()) {
                        System.out.println("Kho sách đang trống!");
                    } else {
                        System.out.println("\nDANH SÁCH SÁCH TRONG THƯ VIỆN");
                        inTieuDeBang();
                        for (Sack s : danhSach) {
                            s.hienThiThongTin();
                        }
                    }
                    break;

                case 3:
                    // Tìm kiếm và cập nhật số lượng thông qua setter có kiểm tra tính hợp lệ
                    System.out.print("Nhập mã sách cần cập nhật số lượng: ");
                    String maCapNhat = sc.nextLine().trim();
                    boolean timThay = false;

                    for (Sack s : danhSach) {
                        if (s.getMaSach().equalsIgnoreCase(maCapNhat)) {
                            System.out.print("Nhập số lượng mới: ");
                            int slMoi = sc.nextInt();
                            sc.nextLine();
                            s.setSoLuong(slMoi);
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Không tìm thấy mã sách: " + maCapNhat);
                    }
                    break;

                case 4:
                    // Tìm kiếm sách theo mã và hiển thị chi tiết thông qua các hàm getter
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = sc.nextLine().trim();
                    boolean found = false;

                    for (Sack s : danhSach) {
                        if (s.getMaSach().equalsIgnoreCase(maTim)) {
                            System.out.println("Tiêu đề: " + s.getTieuDe() + " | Tác giả: " + s.getTacGia()
                                    + " | Năm XB: " + s.getNamXuatBan() + " | Số lượng: " + s.getSoLuong());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách có mã " + maTim);
                    }
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (luaChon != 0);

        sc.close();
    }

    // Phương thức phụ trợ định dạng hàng tiêu đề bảng hiển thị
    private static void inTieuDeBang() {
        System.out.printf("| %-10s | %-25s | %-18s | %-8s | %-8s |\n",
                "Mã Sách", "Tiêu Đề", "Tác Giả", "Năm XB", "Số Lượng");
        System.out.println("----------------------------------------------------------------------------------");
    }
}