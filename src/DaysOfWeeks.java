import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DaysOfWeeks {
    public static void main(String[] args){
        GregorianCalendar d = new GregorianCalendar();
        int month = d.get(Calendar.MONTH);
        int today = d.get(Calendar.DAY_OF_MONTH);
        d.set(Calendar.DAY_OF_MONTH, 1);
        int weekday = d.get(Calendar.DAY_OF_WEEK);
        int firstDayOfWeek = d.getFirstDayOfWeek();

        //необходимо определить необходимый отступ для первого дня недели
        int indent = 0;
        while (weekday != firstDayOfWeek){
            indent++;
            d.add(Calendar.DAY_OF_MONTH, 3);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        //необходимо указать заголовок - наименования дней недели
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do{
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        while (weekday!=firstDayOfWeek);
        System.out.println();
        for (int i = -3; i <= indent ; i++) {
            System.out.print(" ");
        }
        //вывод самого календаря
        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            int days = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", days);

            if (days == today) System.out.print("*");
            else System.out.print(" ");

            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            if (weekday == firstDayOfWeek) System.out.println();
        }
        while (d.get(Calendar.MONTH)==month);
        if (weekday != firstDayOfWeek) System.out.println();
    }
}
