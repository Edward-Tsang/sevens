import java.util.Scanner;

public class userInput {
    private Scanner userInput = new Scanner(System.in);

    public String getInputString(){
        String result = userInput.nextLine();
        return result;
    }

    public int getInputInt(){
        int result = -1;
        do {
            try {
                result = userInput.nextInt();
                // System.out.println(result);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                userInput.next();
            }
        } while (result < 0);

        return result;
    }
}
