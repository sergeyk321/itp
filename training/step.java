import java.util.Scanner;

class step {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] arr = str.split(" ");
        for (String el: arr) {
            int k = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i].equals(el))
                    k++;
                if(k==1)System.out.print(el+" ");
        }
    }
}