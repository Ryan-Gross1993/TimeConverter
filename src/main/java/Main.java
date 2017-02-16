/**
 * Created by ryangross on 2/16/17.
 */
public class Main {

    public static void main(String[] args) {
        TimeDisplay aDisplay = new TimeDisplay();
        TimeParser aTimeParser = new TimeParser();
        UserIO aUI = new UserIO();
        String user = aUI.askUserForTime();
        Time aTime = aTimeParser.createTime(user);
        System.out.println(aDisplay.displayBothTimes(aTime));
    }
}
