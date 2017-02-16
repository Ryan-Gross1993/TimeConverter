/**
 * Created by ryangross on 2/15/17.
 */
public class TimeDisplay {

    public String printHours(Time aTime, String aString) {
        String answer = "";
        int hours;

        if (aString.equals("civilian")) {
            hours = Integer.parseInt(aTime.getCivilianHours());
        } else {
            hours = Integer.parseInt(aTime.getMilitaryHours());
        }

        if (aString.equals("military")) {
            if (hours == 0) {
                    answer += "zero zero";

            } else {
                answer += printToTwenty(hours);
                answer += "hundred ";
            }
        } else {
            answer += printToTwenty(hours);
        }
        return answer;
    }

    public String printMinutes(Time aTime, String aString) {
        String answer = "";
        int minutes = Integer.parseInt(aTime.getMinutes());

        if (aString.equals("military")) {
            if ((minutes == 0) && (Integer.parseInt(aTime.getMilitaryHours()) == 0)) {
                answer += "zero zero";
            }
        }

        if (minutes < 20) {
            answer += printToTwenty(minutes);
        } else {
            int tens = minutes / 10;
            int ones = minutes % 10;
            answer += printTensPlace(tens);
            if (ones != 0) {
                answer += printToTwenty(ones);
            }
        }
        return answer;
    }


    public String printToTwenty(int number) {
        String answer = "";
        if (number < 20) {
            switch (number) {
                case 1:
                    answer += "one ";
                    break;
                case 2:
                    answer += "two ";
                    break;
                case 3:
                    answer += "three ";
                    break;
                case 4:
                    answer += "four ";
                    break;
                case 5:
                    answer += "five ";
                    break;
                case 6:
                    answer += "six ";
                    break;
                case 7:
                    answer += "seven ";
                    break;
                case 8:
                    answer += "eight ";
                    break;
                case 9:
                    answer += "nine ";
                    break;
                case 10:
                    answer += "ten ";
                    break;
                case 11:
                    answer += "eleven ";
                    break;
                case 12:
                    answer += "twelve ";
                    break;
                case 13:
                    answer += "thirteen ";
                    break;
                case 14:
                    answer += "fourteen ";
                    break;
                case 15:
                    answer += "fifteen ";
                    break;
                case 16:
                    answer += "sixteen ";
                    break;
                case 17:
                    answer += "seventeen ";
                    break;
                case 18:
                    answer += "eighteen ";
                    break;
                case 19:
                    answer += "nineteen ";
                    break;
            }
        }
        return answer;
    }

    public String printTensPlace(int number) {
        String answer = "";
        switch (number) {
            case 2:
                answer += "twenty ";
                break;
            case 3:
                answer += "thirty ";
                break;
            case 4:
                answer += "forty ";
                break;
            case 5:
                answer += "fifty ";
                break;

        }
        return answer;
    }

    public String printTime(Time aTime, String aString) {
        String answer = "";
        answer += printHours(aTime, aString);
        answer += printMinutes(aTime, aString);
        if (aString.equals("military")) {
            if ((!answer.equals("zero zero zero zero")) && (aTime.getMilitaryHours().equals("00"))) {
                answer += "hours";
            }
        } else if (aTime.isAM()) {
            answer += "in the morning";

        } else {
            answer += "in the afternoon/evening";

        }
        return answer;
    }

    public String displayBothTimes(Time aTime) {
        String answer = printTime(aTime, "military") + "\n" + printTime(aTime, "civilian");
        return answer;
    }

}