/**
 * Created by ryangross on 2/15/17.
 */
public class Time {
    private String militaryHours;
    private String civilianHours;
    private String minutes;
    private boolean isAM;

    public Time(String cHours, String aMinutes, boolean amPM) {
        civilianHours = cHours;
        minutes = aMinutes;
        isAM = amPM;
    }

    public Time(String mHours, String aminutes) {
        militaryHours = mHours;
        minutes = aminutes;
    }


    public String getMilitaryHours() {
        return militaryHours;
    }

    public void setMilitaryHours(String militaryHours) {
        this.militaryHours = militaryHours;
    }

    public String getCivilianHours() {
        return civilianHours;
    }

    public void setCivilianHours(String civilianHours) {
        this.civilianHours = civilianHours;
    }

    public String getMinutes() {
        return minutes;
    }

    public boolean isAM() {
        return isAM;
    }

    public void setAM(boolean AM) {
        isAM = AM;
    }
}
