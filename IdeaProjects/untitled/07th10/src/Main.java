// ==================== CÁC INTERFACE ====================
interface IMove {
    void move();
}

interface IRun {
    void run();
}

interface IHunt {
    void hunt();
}

interface IFly {
    void fly();
}

interface ISleep {
    void sleep();
}

interface IEat {
    void eat();
}

interface ISpeech {
    void speech();
}

// ==================== LỚP TRỪU TƯỢNG ANIMAL ====================
abstract class Animal {
    protected String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public abstract void xuat();
}

// ==================== LỚP CAT ====================
class Cat extends Animal implements IMove, IRun, IHunt, ISleep, IEat, ISpeech {
    private String type;

    public Cat() {
        super();
    }

    public Cat(String name, String type) {
        super(name);
        this.type = type;
    }

    @Override
    public void xuat() {
        System.out.println("Tên: " + this.name);
        System.out.println("Loài: " + this.type);
    }

    @Override
    public void speech() {
        System.out.println(this.name + " kêu: Meo Meo");
    }

    @Override
    public void move() {
        System.out.println(this.name + " đang đi lại nhẹ nhàng.");
    }

    @Override
    public void run() {
        System.out.println(this.name + " đang chạy rất nhanh.");
    }

    @Override
    public void hunt() {
        System.out.println(this.name + " đang rình bắt chuột.");
    }

    @Override
    public void sleep() {
        System.out.println(this.name + " đang ngủ: Khò khò...");
    }

    @Override
    public void eat() {
        System.out.println(this.name + " đang ăn cá.");
    }
}

// ==================== CLASS CHỨA HÀM MAIN ====================
public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. KHỞI TẠO ĐỐI TƯỢNG VÀ GỌI PHƯƠNG THỨC ===");
        Cat myCat = new Cat("Miu Miu", "Mèo Mướp");

        // Xuất thông tin
        myCat.xuat();

        System.out.println("\n--- Các hành vi của mèo ---");
        myCat.speech();
        myCat.eat();
        myCat.move();
        myCat.run();
        myCat.hunt();
        myCat.sleep();

        System.out.println("\n=== 2. MINH HOẠ TÍNH ĐA HÌNH (POLYMORPHISM) ===");
        // Gọi qua tham chiếu Interface ISpeech
        ISpeech speaker = myCat;
        speaker.speech();

        // Gọi qua tham chiếu lớp cha trừu tượng Animal
        Animal animal = myCat;
        animal.xuat();
    }
}