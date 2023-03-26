import java.util.Arrays;
import java.util.Scanner;

public class con2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ns = s.nextLine(); // количество рядов в самолёте
        int n = Integer.parseInt(ns); 
        String[] str = new String[n];
        for (int i = 0; i < n; i++) 
            str[i] = s.nextLine(); // изначальная рассадка по рядам
        String ms = s.nextLine(); // количество групп пасс.
        int m = Integer.parseInt(ms);
        String[] word = new String[m];
        for (int j = 0; j < m; j++) 
            word[j] = s.nextLine(); // описание групп пасс.
        s.close();
        System.out.println(Con2(n, str, m, word));
    }
    public static String Con2(int n, String[] str, int m, String[] word) {
        String ans = "";
        int countPas = 0;
        String side = "";
        String place = "";
        int miss = 0;
        for (int i = 0; i < m; i++) {
            countPas = Integer.parseInt(word[i].substring(0, 1));
            if (word[i].contains("left")) side = "left";
            else side = "right";
            if (word[i].contains("window")) place = "window";
            else place = "aisle"; // определили характеристики группы пасс.
            for (int j = 0; j < n; j++) { // ищем место, проходим по всем рядам
                for (int k = 0; k < 7; k++) { // заходим в ряд
                    if ((word[i].charAt(0) == '#' && place == "window" && side == "left") || 
                        (word[i].charAt(2) == '#' && place == "aisle" && side == "left") ||
                        (word[i].charAt(4) == '#' && place == "aisle" && side == "right") ||
                        (word[i].charAt(6) == '#' && place == "window" && side == "right")) {
                            System.out.println("Cannot fulfill passengers requirements\n"); // отсекли сразу ненужных
                            break;
                    }
                    else { // единственное место может быть занято требовательным пассажиром, тогда:
                        for (int p = 0; p < countPas; p++) { // берем всех из группы
                            if (place == "window" && side == "left") { // требовательный сел слева у окна:
                                if (word[i].charAt(p) == '.')
                            }
                        }
                    }
                }
            }
        }
        //return str[1];
    }
}
