import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BirthdayCalculator {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter dashFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        System.out.println("BIRTHDAY CALCULATOR!\n");
        System.out.println("What's your birthday? (MM/DD/YYYY)");
        LocalDate birthday = LocalDate.parse(scnr.nextLine(), formatter);

        System.out.println("\nYour birthday was on a " + birthday.getDayOfWeek() + ".");

        LocalDate birthdayThisYear = birthday.withYear(LocalDate.now().getYear());

        System.out.println("This year it falls on a " + birthdayThisYear.getDayOfWeek() + "...");

        System.out.println("\nToday is " + LocalDate.now().format(dashFormatter) + " which means there's only " + daysUntilBirthday(birthdayThisYear) + " days until your birthday!");

        System.out.println("You'll be " + nextBirthdayAge(birthday, birthdayThisYear) + " years old!");

        System.out.println("\nCongrats and goodnight!");
    }

    public static long daysUntilBirthday(LocalDate birthday) {
        long birthdayDiff;
        LocalDate nextYearBirthday = birthday.withYear(LocalDate.now().getYear() + 1);

        if (LocalDate.now().isAfter(birthday)) {
            birthdayDiff = ChronoUnit.DAYS.between(LocalDate.now(), nextYearBirthday);
        } else {
            birthdayDiff = ChronoUnit.DAYS.between(LocalDate.now(), birthday);
        }

        return birthdayDiff;
    }

    public static long nextBirthdayAge(LocalDate birthday, LocalDate birthdayThisYear) {
        long age;
        LocalDate nextYearBirthday = birthdayThisYear.withYear(LocalDate.now().getYear() + 1);

        if (LocalDate.now().isAfter(birthday)) {
            age = ChronoUnit.YEARS.between(birthday, nextYearBirthday);
        } else {
            age = ChronoUnit.YEARS.between(birthday, birthdayThisYear);
        }

        return age;
    }
}
