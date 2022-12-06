package Tasks;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("Task 2/10");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Pawn", "A8", "A7"));
        System.out.println(canMove("Knight", "A4", "B2"));
        System.out.println(canMove("Queen", "C4", "D6"));
        System.out.println(canMove("King", "A8", "B7"));
    }
    // 2/10
    public static boolean canMove(String s, String n, String m) {
        char a1 = n.charAt(0); // "A" 8
        int a2 = n.charAt(1); // A "8"
        int l1 = (int) a1;
        char b1 = m.charAt(0); // "C"3
        int b2 = m.charAt(1); // C "3"
        int l2 = (int) b1;
        if (s.contains("Rook"))  //Ладья
            return ((a1 == b1) || (a2 == b2)); //если равна хотя бы одна коор-та
        if (s.contains("Bishop"))  //Слон
            return Math.abs((a2 - b2) / (l1 - l2)) == 1; //по диагонали, тогда х и у смещаются поровну => -1 или 1
        if (s.contains("Pawn")) //Пешка
            return ((l1 == l2) && ((a2 - b2 == 1) || (b2 - a2 == 1))); //координаты х равны, по у = 1 шаг
        if (s.contains("Knight"))  //Конь
            return ((Math.abs(l2 - l1) == 1 && Math.abs(a2 - b2) == 2 // шаг по х = 1, по у = 2
            || Math.abs(l2 - l1) == 2 && Math.abs(a2 - b2) == 1)); // шаг по х = 2, по у = 1
        if (s.contains("Queen"))  //Ферзь
            return (Math.abs((a2 - b2) / (l1 - l2)) == 1 //для слона
            || (((l1 - l2 == 1) || (l2 - l1 == 1)) && ((b2 - a2 == 1) || (a2 - b2 == 1)))); //для короля
        if (s.contains("King"))  //Король
            return (((l1 - l2 == 1) || (l2 - l1 == 1)) && ((b2 - a2 == 1) || (a2 - b2 ==1))); //есть смещение = 1 по х и по у
        return false;
    }
    // 7/10
    // public static String numToEng(int x) {
    //     if (x == 0)
    //         return "zero";
    //     return "zero";
    //}
}
