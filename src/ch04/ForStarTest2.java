package ch04;

public class ForStarTest2 {
    public static void main(String[] args) {
        /*
        if star == 2
        *
        **
        if star == 3
        *
        **
        ***
         */

        int star = (int) (Math.random() * 5) + 2; //2~6
        System.out.println("star : " + star);
        for (int i = 0; i < star; i++) {
            for (int z = 0; z<=i; z++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
