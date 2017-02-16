import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ryangross on 2/15/17.
 */
public class TimeParser {

    private static String amPattern = "[Aa].?[Mm].?";
    private static String mPattern = "(\\d{2})(\\d{2})";
    private static String cPattern = "(\\d{1,2})(\\W)(\\d{1,2})";

    public boolean isMilitary(String aString) {
        return (aString.length() == 4);
    }

    public boolean militaryAM(String aString) {
        return (Integer.valueOf(aString.substring(0, 3)) > 12);
    }

    public boolean civilianAM(String aString) {
        Pattern checkForValidInput = Pattern.compile(amPattern);
        Matcher matcher = checkForValidInput.matcher(aString);
        return matcher.find();
    }

    public boolean isAM(String aString) {
        if (isMilitary(aString)) {
            return militaryAM(aString);
        } else {
            return civilianAM(aString);
        }
    }

    public String getMilitaryHours(String aString) {
        Pattern checkForHours = Pattern.compile(mPattern);
        Matcher matchHours = checkForHours.matcher(aString);
        matchHours.find();
        return matchHours.group(1);
    }

    public String getCivilianHours(String aString) {
        Pattern checkForHours = Pattern.compile(cPattern);
        Matcher matchHours = checkForHours.matcher(aString);
        matchHours.find();
        return matchHours.group(1);
    }

    public String getHours(String aString) {
        if (isMilitary(aString)) {
            return getMilitaryHours(aString);
        } else {
            return getCivilianHours(aString);
        }
    }

    public String getMilitaryMinutes(String aString) {
        Pattern checkForMinutes = Pattern.compile(mPattern);
        Matcher matchMinutes = checkForMinutes.matcher(aString);
        matchMinutes.find();
        return matchMinutes.group(2);
    }

    public String getCivilianMinutes(String aString) {
        Pattern checkForMinutes = Pattern.compile(cPattern);
        Matcher matchMinutes = checkForMinutes.matcher(aString);
        matchMinutes.find();
        return matchMinutes.group(3);
    }


    public void convertMilitaryToCivilian(Time aTime) {
        Integer militaryHours = Integer.parseInt(aTime.getMilitaryHours());
        if (lessThanTen(aTime.getMilitaryHours())) {
            aTime.setCivilianHours(paddedZeroHour(militaryHours.toString()));
            aTime.setAM(true);
        } else {
            Integer military = militaryHours % 12;
            aTime.setCivilianHours(military.toString());
            aTime.setAM(false);
        }
    }

    public void convertCivilianToMilitary(Time aTime) {
        Integer civilianHours = Integer.parseInt(aTime.getCivilianHours());
        if (aTime.isAM()) {
            aTime.setMilitaryHours(paddedZeroHour(civilianHours.toString()));
        } else if (civilianHours == (Integer) 12) {
            aTime.setMilitaryHours(convertCivilianToMilitaryMidnightAndNoon(aTime));
        } else {
            Integer hours = civilianHours + 12;
            aTime.setMilitaryHours(hours.toString());
        }
    }

    public Time createTime(String aString) {
        if (isMilitary(aString)) {
            Time aTime = new Time(getMilitaryHours(aString), getMilitaryMinutes(aString));
            convertMilitaryToCivilian(aTime);
            return aTime;
        } else {
            Time aTime = new Time(paddedZeroHour(getCivilianHours(aString)), getCivilianMinutes(aString), isAM(aString));
            convertCivilianToMilitary(aTime);
            return aTime;
        }
    }

    public boolean lessThanTen(String aString) {
        return (Integer.parseInt(aString) < 10);
    }

    public String paddedZeroHour(String aString) {
        if (lessThanTen( aString)) {
            String answer = "0" + aString;
            return answer;
        } else {
            return aString;
        }
    }

    public String convertCivilianToMilitaryMidnightAndNoon(Time aTime) {
        if (aTime.isAM()) {
            return "00";
        } else {
            return "12";
        }
    }

}
