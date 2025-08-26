import java.util.EnumSet;
import java.util.Set;

/**
 * This file demonstrates the usage of EnumSet, a specialized, high-performance
 * Set implementation for enum types.
 * Note: The class is not public to avoid conflict with java.util.EnumSet.
 */

// First, let's define an enum for the days of the week.
// Munduga, manam vaaram rojulaki oka enum ni define cheddam.
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

class EnumSetDemo {
    public static void main(String[] args) {
        // Create an EnumSet containing all days of the week.
        // Anni rojulu unna oka EnumSet ni create cheddam.
        Set<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All Days: " + allDays);

        // Create an EnumSet for just the weekend.
        // Kevalam weekend kosam oka EnumSet create cheddam.
        Set<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend);

        // Create an EnumSet for weekdays.
        // Weekdays kosam oka EnumSet create cheddam.
        Set<Day> weekdays = EnumSet.complementOf((EnumSet<Day>) weekend);
        System.out.println("Weekdays: " + weekdays);

        // Check if a day is a weekday
        boolean isMondayWeekday = weekdays.contains(Day.MONDAY);
        System.out.println("Is Monday a weekday? " + isMondayWeekday);
    }
}
