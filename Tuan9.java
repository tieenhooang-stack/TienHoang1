package Tuan9;

import java.util.ArrayList;
import java.util.Scanner;

// Lớp cha Tuan9.Sach chứa các thuộc tính và phương thức dùng chung
class Sach {
    protected String maSach, ngayNhap, nhaXuatBan;
    protected double donGia;
    protected int soLuong;

    public void nhap(Scanner sc) {
        System.out.print("Mã sách: "); maSach = sc.nextLine();
        System.out.print("Ngày nhập: "); ngayNhap = sc.nextLine();
        System.out.print("Đơn giá: "); donGia = sc.nextDouble();
        System.out.print("Số lượng: "); soLuong = sc.nextInt();
        sc.nextLine(); // Xóa bộ đệm Enter
        System.out.print("Nhà xuất bản: "); nhaXuatBan = sc.nextLine();
    }

    public double tinhThanhTien() {
        return 0;
    }

    public void xuat() {
        System.out.print("Mã: " + maSach + " | Ngày: " + ngayNhap + " | Giá: " + donGia + " | SL: " + soLuong + " | NXB: " + nhaXuatBan);
    }
}

// Lớp con Sách giáo khoa kế thừa lớp Tuan9.Sach
class SachGiaoKhoa extends Sach {
    private String tinhTrang;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Tình trạng (mới/cũ): ");
        tinhTrang = sc.nextLine();
    }

    @Override
    public double tinhThanhTien() {
        if (tinhTrang.equalsIgnoreCase("mới")) {
            return soLuong * donGia;
        }
        return soLuong * donGia * 0.5;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(" | Tình trạng: " + tinhTrang + " | Thành tiền: " + tinhThanhTien());
    }
}

// Lớp con Sách tham khảo kế thừa lớp Tuan9.Sach
class SachThamKhao extends Sach {
    private double thue;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Thuế: ");
        thue = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    public double tinhThanhTien() {
        return soLuong * donGia + thue;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(" | Thuế: " + thue + " | Thành tiền: " + tinhThanhTien());
    }
}

public class Tuan9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> ds = new ArrayList<>();

        // 1. Nhập danh sách các loại sách
        System.out.print("Nhập số lượng sách giáo khoa: ");
        int n1 = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < n1; i++) {
            System.out.println("Nhập SGK thứ " + (i + 1) + ":");
            SachGiaoKhoa sgk = new SachGiaoKhoa();
            sgk.nhap(sc);
            ds.add(sgk);
        }

        System.out.print("Nhập số lượng sách tham khảo: ");
        int n2 = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < n2; i++) {
            System.out.println("Nhập STK thứ " + (i + 1) + ":");
            SachThamKhao stk = new SachThamKhao();
            stk.nhap(sc);
            ds.add(stk);
        }

        // 2. Xuất danh sách các loại sách
        System.out.println("\nDANH SÁCH SÁCH VỪA NHẬP:");
        for (Sach s : ds) {
            s.xuat();
        }

        // 3. Tính tổng thành tiền từng loại & 4. Trung bình cộng đơn giá sách tham khảo
        double tongSGK = 0, tongSTK = 0, tongDonGiaSTK = 0;
        int demSTK = 0;

        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa) {
                tongSGK += s.tinhThanhTien();
            } else if (s instanceof SachThamKhao) {
                tongSTK += s.tinhThanhTien();
                tongDonGiaSTK += s.donGia;
                demSTK++;
            }
        }
        System.out.println("\nTổng thành tiền SGK: " + tongSGK);
        System.out.println("Tổng thành tiền STK: " + tongSTK);
        if (demSTK > 0) {
            System.out.println("Trung bình cộng đơn giá STK: " + (tongDonGiaSTK / demSTK));
        }

        // 5. Xuất các sách giáo khoa của nhà xuất bản X
        System.out.print("\nNhập tên nhà xuất bản X cần tìm: ");
        String nxbX = sc.nextLine();
        System.out.println("Các SGK của NXB " + nxbX + ":");
        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa && s.nhaXuatBan.equalsIgnoreCase(nxbX)) {
                s.xuat();
            }
        }

        sc.close();
    }
}