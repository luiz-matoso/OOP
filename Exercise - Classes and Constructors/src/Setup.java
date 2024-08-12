import java.util.Scanner;

public class Setup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.println("Enter the motherboard:");
        // String motherboard = sc.nextLine();

        String motherboard = "test";

        Computer c1 = new Computer(motherboard, "Geforce RTX 3060 12GB", 16, "Ryzen 7 5700", "Black", 480, "600w");

        c1.turnOn();

        System.out.println(c1.videoCard + " " + c1.font);

        Computer c2 = new Computer(motherboard, "RX 7600 8GB", 16, "Ryzen 5 5600GT", motherboard, 480, "600w");
        System.out.println(c2);

        sc.close();
    }

}
