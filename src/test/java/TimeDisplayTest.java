import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryangross on 2/15/17.
 */
public class TimeDisplayTest {
    TimeDisplay aTimeDisplay;

    @Before
    public void setUp() {
        aTimeDisplay = new TimeDisplay();
    }

    @Test
    public void printHoursTest() {
        Time militaryTime = new Time("15", "00");
        Time civilianTime = new Time("3", "45", true);
        Assert.assertEquals("fifteen hundred", aTimeDisplay.printHours(militaryTime, "military"));
        Assert.assertEquals("three ", aTimeDisplay.printHours(civilianTime, "civilian"));
    }



    @Test
    public void printMinutesTest() {
        Time militaryTime = new Time("15", "15");
        Time anotherTime = new Time("00", "00");
        Time civilianTime = new Time("3", "45", true);
        Assert.assertEquals("fifteen ", aTimeDisplay.printMinutes(militaryTime, "military"));
        Assert.assertEquals("forty five ", aTimeDisplay.printMinutes(civilianTime, "civilian"));
        Assert.assertEquals("zero zero", aTimeDisplay.printMinutes(anotherTime, "military"));
    }


    @Test
    public void printTimeTest() {
        Time militaryTime = new Time("15", "00");
        Time militaryMidnight = new Time("00", "00");
        Time aTime = new Time("04", "30", true);
        Assert.assertEquals("four thirty in the morning", aTimeDisplay.printTime(aTime, "civilian"));
        Assert.assertEquals("fifteen hundred hours", aTimeDisplay.printTime(militaryTime, "military"));
        Assert.assertEquals("zero zero zero zero", aTimeDisplay.printTime(militaryMidnight, "military"));
    }

}
