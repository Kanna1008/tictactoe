import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] arr = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        System.out.println("Display the array");
        display(arr);
        int num_count = 1;  // Keeps track of the number of valid moves
        String s;
        String result = null;

        while (result == null) {
            System.out.println("Enter the position to mark (1-9):");
            s = sc.nextLine();
            boolean validInput = false;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s.equals(arr[i][j])) {
                        if (num_count % 2 == 0) {
                            arr[i][j] = "O";
                        } else {
                            arr[i][j] = "X";
                        }
                        num_count++;
                        validInput = true;
                        break;
                    }
                }
                if (validInput) break;
            }


            if (!validInput) {
                System.out.println("Invalid input or position already marked. Try again.");
                continue;
            }

            display(arr);
            result = check(arr, num_count);
        }


        if (result.equals("draw")) {
            System.out.println("It's a draw! No winners.");
        } else {
            System.out.println("The winner is " + result);
        }
    }


    public static void display(String[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + arr[i][j] + " |");
            }
            System.out.println();
        }
    }


    public static String check(String[][] arr, int num_count) {
        String winner = null;


        for (int i = 0; i < 3; i++) {
            // Check rows
            if (arr[i][0].equals(arr[i][1]) && arr[i][1].equals(arr[i][2])) {
                winner = arr[i][0];
            }
            // Check columns
            if (arr[0][i].equals(arr[1][i]) && arr[1][i].equals(arr[2][i])) {
                winner = arr[0][i];
            }
        }


        if (arr[0][0].equals(arr[1][1]) && arr[1][1].equals(arr[2][2])) {
            winner = arr[0][0];
        }
        if (arr[0][2].equals(arr[1][1]) && arr[1][1].equals(arr[2][0])) {
            winner = arr[0][2];
        }


        if (winner == null && num_count > 9) {
            winner = "draw";
        }

        return winner;
    }
}
