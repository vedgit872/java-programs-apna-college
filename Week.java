import java.util.*;

public class Week {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int day = sc.nextInt();
            String s = "";
            switch (day) {
                case 1:

                    s = "monday";
                    break;
                case 2:
                    s = "tuesday";
                    break;
                case 3:
                    s = "wednesday";
                    break;
                case 4:
                    s = "thursday";
                    break;
                case 5:
                    s = "friday";
                    break;
                case 6:
                    s = "saturday";
                    break;
                case 7:
                    s = "sunday";
                    break;

                default:
                    System.out.println("not valid");
                    return;

            }
            System.out.println(s);
        }
    }
}
