package id.ekky.myanimelist.utility;

public class FormatHelper {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static Double toDouble(String strNum) {
        if (strNum == null) {
            return 0.0;
        }
        try {
            return Double.parseDouble(strNum);

        } catch (NumberFormatException nfe) {
            return 0.0;
        }
    }

    public static Integer toInt(String strNum) {
        if (strNum == null) {
            return 0;
        }
        try {
            return Integer.parseInt(strNum);

        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
