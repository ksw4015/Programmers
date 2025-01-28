import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Holidays {
    public int solution(String join_date, String resign_date, String[] holidays) {
        int answer = 0;
        String[] join = join_date.split(" ")[0].split("/");
        String[] resign = resign_date.split("/");

        LocalDate joinDate = LocalDate.of(Integer.parseInt(join[0]), Integer.parseInt(join[1]), Integer.parseInt(join[2]));
        LocalDate resignDate = LocalDate.of(Integer.parseInt(resign[0]), Integer.parseInt(resign[1]), Integer.parseInt(resign[2]));

        int joinE = (int) joinDate.toEpochDay();
        int resignE = (int) resignDate.toEpochDay();

        if(joinE == resignE)
            return 1;

        for(int i = joinE ; i <= resignE ; i++) {
            LocalDate curr = LocalDate.ofEpochDay(i);
            if(checkWeekEnd(curr) || checkHolidays(curr, holidays)) {
                continue;
            }
            answer++;
        }
        return answer;
    }

    private boolean checkWeekEnd(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7;
    }

    private boolean checkHolidays(LocalDate date, String[] holidays) {
        String d = date.format(DateTimeFormatter.ofPattern("MM/dd"));
        for(String h : holidays) {
            if(h.equals(d)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Holidays T = new Holidays();
//        System.out.println(T.solution("2019/12/01 SUN", "2019/12/31", new String[]{"12/25"}));
//        System.out.println(T.solution("2019/12/01 SUN", "2020/03/02", new String[]{"01/02", "12/24", "03/01"}));
//        System.out.println(T.solution("2019/11/21 SUN", "2019/11/21", new String[]{"12/23"}));

        LocalDate d = LocalDate.of(1, 1, 1);
        System.out.println(d.toEpochDay());
        LocalDate d2 = LocalDate.of(Integer.parseInt("0001"), Integer.parseInt("01"), Integer.parseInt("02"));
        System.out.println(d2.toEpochDay());
    }
}
