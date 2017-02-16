import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ryangross on 2/15/17.
 */
public class UserIO {
    Scanner aScanner = new Scanner(System.in);
    protected static String validInputPattern = "[0-2][0-9][0-5][0-9]|[0-9][0-5][0-9]|[0-1][0-9]:[0-5][0-9] {0,1}[AaPp].{0,1}[Mm].{0,1}|[0-9]:[0-5][0-9] {0,1}[AaPp].{0,1}[Mm].{0,1}";

    public String askUserForTime() {
        System.out.println("What time is it?\n");
        String userInput = aScanner.next();

        while (!isValidInput(userInput)) {
            System.out.println("Invalid Input. Try military (0400) or standard (4:30pm)");
            userInput = aScanner.next();
        }
        return userInput;
    }

    public boolean isValidInput(String aString) {
        Pattern checkForValidInput = Pattern.compile(validInputPattern);
        Matcher validMatch = checkForValidInput.matcher(aString);
        return validMatch.matches();
    }
}
