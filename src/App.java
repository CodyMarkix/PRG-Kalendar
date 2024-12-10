class Calendar {
    int year;
    boolean isLeapYear;
    int[] monthDays = new int[12];

    public Calendar(int year) {
        this.year = year;
        this.isLeapYear = Calendar.isLeapYear(year);

        int monthIndex[] = {
            31,
            this.isLeapYear ? 29 : 28,
            31,
            30,
            31,
            30,
            31,
            31,
            30,
            31,
            30,
            31
        };
        this.monthDays = monthIndex; 
    }

    static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return false;
            } else if (year % 400 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    int poradiDne(int mesic, int den) {
        int dayCount = 0;
        
        for (int i = 0; i < mesic; i++) {
            dayCount = dayCount + this.monthDays[i];
        }
        dayCount = dayCount + den;

        return dayCount;
    }

    int[] denVPoradi(int poradi) {
        int monthCount = 0;
        int dayCount = 0;

        for (int i = 0; i < poradi; i++) {
            if (this.monthDays[i] >= 30 && this.monthDays[i] >= 31 && (this.monthDays[i] >= (this.isLeapYear ? 28 : 29) || this.monthDays[i] >= (this.isLeapYear ? 29 : 28))) {
                monthCount = monthCount + 1;
                poradi = poradi - this.monthDays[i];
            } else {
                break;
            }
        }

        dayCount = poradi;
        int toReturn[] = {dayCount, monthCount};
        return toReturn;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Calendar cl = new Calendar(2024);
        
        int[] var = cl.denVPoradi(35);
        System.out.print(var[0] + ". ");
        System.out.println(var[1] + ".");
    }
}
