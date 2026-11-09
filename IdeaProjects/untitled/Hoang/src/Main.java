package qlyungcuvien;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author lethu
 */
public class CANDIDATE {
    protected String hoTen;
    protected Date ngaySinh;
    protected String diaChiThuongTru;
    protected String queQuan;
    protected int soDT;
    protected String email;
    protected Scanner sc= new Scanner(System.in);
    public CANDIDATE() {
    }
    public CANDIDATE(String hoTen, Date ngaySinh,
                     String diaChiThuongTru, String queQuan, int soDT, String email) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChiThuongTru = diaChiThuongTru;
        this.queQuan = queQuan;
        this.soDT = soDT;
        this.email = email;
    }
    public String getHoTen() {
        return hoTen;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public String getDiaChiThuongTru() {
        return diaChiThuongTru;
    }
    public String getQueQuan() {
        return queQuan;
    }
    public int getSoDT() {
        return soDT;
    }
    public String getEmail() {
        return email;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public void setDiaChiThuongTru(String diaChiThuongTru) {
        this.diaChiThuongTru = diaChiThuongTru;
    }
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void Nhap(){
        System.out.println("Nhập thông tin ứng viên: ");
        System.out.println("Họ tên: ");
        this.hoTen=this.sc.nextLine();
        try{
            System.out.println("Ngày sinh: ");
            SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
            this.ngaySinh=d.parse(this.sc.nextLine());
        }catch(Exception ex){}
        System.out.println("Địa chỉ: ");
        this.diaChiThuongTru=this.sc.nextLine();
        System.out.println("Quê quán: ");
        this.queQuan=this.sc.nextLine();
        System.out.println("Số điện thoại: ");
        this.soDT=Integer.parseInt(this.sc.nextLine());
        System.out.println("Email: ");
        this.email=this.sc.nextLine();
    }
    public void xuat(){
        System.out.println("Thông tin ứng viên: "+this.hoTen);
        System.out.println("Ngày sinh: "+this.ngaySinh);
        System.out.println("Địa chỉ thường trú: "+this.diaChiThuongTru);
        System.out.println("Quê quán: "+this.queQuan);
        System.out.println("Số điện thoại: "+this.soDT);
        System.out.println("Email: "+this.email);
    }
}
// lớp con fresher
class fresher extends staff{
    private int namtotnghiep;
    private string xeploai;
    private string truongtotnghiep;
    public fresher(){
        super();

    }
    public void Nhap(scaner sc){
        super.nhap(sc);
        system.out.print("nhập năm tốt nghiệp");
        this.namtotnghiep= int.parseint(sc.nextline());
        system.out.print("nhập xếp loại");
        this.xeploai=sc.nextline();
        system.out.print("nhập trường tốt nghiệp:");
    }
    public void xuat() {
        super.xuat();
        system.out.println("năm tn:" + namtotnghiep + "| xếp loại:" + xeploai + "| trường tn:" + truongtotnghiep);
    }

    }

