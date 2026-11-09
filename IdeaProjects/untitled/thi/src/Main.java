import java.util.Scanner;

public abstract class Candidate {
    protected String id, name, birth, address, hometown, phone, email;

    public Candidate() {}
    public Candidate(String id, String name, String birth, String address, String hometown, String phone, String email) {
        this.id = id; this.name = name; this.birth = birth;
        this.address = address; this.hometown = hometown; this.phone = phone; this.email = email;
    }

    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mã: "); id = sc.nextLine();
        System.out.print("Tên: "); name = sc.nextLine();
        System.out.print("Ngày sinh: "); birth = sc.nextLine();
        git push  System.out.print("Địa chỉ: "); address = sc.nextLine();
        System.out.print("Quê quán: "); hometown = sc.nextLine();
        System.out.print("SĐT: "); phone = sc.nextLine();
        System.out.print("Email: "); email = sc.nextLine();
    }

    public void showInfo() {
        System.out.println(id + " - " + name + " - " + birth + " - " + address + " - " + phone + " - " + email);
    }
}



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
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
