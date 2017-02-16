import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryangross on 2/15/17.
 */
public class TimeParserTest {
    TimeParser aTimeParser;

    @Before
    public void setUp() {
        aTimeParser = new TimeParser();
    }

    @Test
    public void isMilitaryTest() {
        String militaryTime = "0500";
        Assert.assertTrue(aTimeParser.isMilitary(militaryTime));
    }

    @Test
    public void militaryAMTest() {
        String mMorning = "1100";
        Assert.assertTrue(aTimeParser.militaryAM(mMorning));
    }

    @Test
    public void civilianAMTest() {
        String anotherMorning = "9:30 am";
        String aMorning = "9:35am";
        Assert.assertTrue(aTimeParser.civilianAM(anotherMorning));
        Assert.assertTrue(aTimeParser.civilianAM(aMorning));
    }

    @Test
    public void isAMTest() {
        String aMorning = "09:30 A.M.";
        String mMorning = "1100";
        String anotherMorning = "9:30 am";
        Assert.assertTrue(aTimeParser.isAM(aMorning));
        Assert.assertTrue(aTimeParser.isAM(anotherMorning));
        Assert.assertTrue(aTimeParser.isAM(mMorning));
    }

    @Test
    public void getMilitaryHoursTest() {
        String militaryTime = "0500";
       Assert.assertEquals("05", aTimeParser.getMilitaryHours(militaryTime));
    }

    @Test
    public void getCivilianHoursTest() {
        String civilianTime = "3:40am";
        Assert.assertEquals("3", aTimeParser.getCivilianHours(civilianTime));
    }

    @Test
    public void getHoursTest() {
        String civilianTime = "3:40A.M.";
        String militaryTime = "1500";
        Assert.assertEquals("3", aTimeParser.getHours(civilianTime));
        Assert.assertEquals("15", aTimeParser.getHours(militaryTime));
    }

    @Test
    public void getMilitaryMinutesTest() {
        String militaryTime = "2134";
        Assert.assertEquals("34", aTimeParser.getMilitaryMinutes(militaryTime));
    }

    @Test
    public void getCivilianMinutesTest() {
        String civilianTime = "04:15am";
        Assert.assertEquals("15", aTimeParser.getCivilianMinutes(civilianTime));
    }

    @Test
    public void paddedZeroHourTest() {
        String test = "3";
        Assert.assertEquals("03", aTimeParser.paddedZeroHour(test));
    }

    @Test
    public void lessThanTenTest() {
        String test = "03";
        Assert.assertTrue(aTimeParser.lessThanTen(test));
    }

    @Test
    public void convertToCivilianTest() {
        Time aTime = new Time("2", "23");
        Time militaryLateNight = new Time("22", "00");
        aTimeParser.convertMilitaryToCivilian(aTime);
        aTimeParser.convertMilitaryToCivilian(militaryLateNight);
        Assert.assertEquals("02", aTime.getCivilianHours());
        Assert.assertEquals("10", militaryLateNight.getCivilianHours());
    }

    @Test
    public void convertToMilitaryTest() {
        Time aTime = new Time("7", "30",false);
        Time midnight = new Time("12", "00", true);
        Time noon = new Time("12", "00", false);
        aTimeParser.convertCivilianToMilitary(aTime);
        aTimeParser.convertCivilianToMilitary(midnight);
        aTimeParser.convertCivilianToMilitary(noon);
        Assert.assertEquals("19", aTime.getMilitaryHours());
        System.out.println(midnight.getMilitaryHours());
       // Assert.assertEquals("00", midnight.getMilitaryHours());
        Assert.assertEquals("12", noon.getMilitaryHours());
    }

    @Test
    public void createTimeTest() {
        String military = "0500";
        Time militaryTime = aTimeParser.createTime(military);
        Assert.assertEquals("05", militaryTime.getMilitaryHours());
        Assert.assertEquals("00", militaryTime.getMinutes());
        Assert.assertTrue(militaryTime.isAM());
        String civilian = "4:30 P.M";
        Time civilianTime = aTimeParser.createTime(civilian);
        Assert.assertEquals("04", civilianTime.getCivilianHours());
        Assert.assertEquals("30", civilianTime.getMinutes());
        Assert.assertEquals("16", civilianTime.getMilitaryHours());
        Assert.assertFalse(civilianTime.isAM());
    }

    @Test
    public void convertCivilianToMilitaryMidnightAndNoonTest() {
        Time noon = new Time("12", "00", false);
        Time midnight = new Time("12", "00", true);
        Assert.assertEquals("12", aTimeParser.convertCivilianToMilitaryMidnightAndNoon(noon));
        Assert.assertEquals("00", aTimeParser.convertCivilianToMilitaryMidnightAndNoon(midnight));
    }





}
