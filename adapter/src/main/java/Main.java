public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();
        date.setDay(15);
        date.setMonth(11);
        date.setYear(2023);
        System.out.println("Original date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(10);
        System.out.println("Date after advancing 10 days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(20);
        System.out.println("Date after advancing 20 more days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

    }
}
