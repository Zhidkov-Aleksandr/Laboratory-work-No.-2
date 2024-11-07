import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class UserProcessor {

    public static void printUsersSortedByLastName(List<User> users) {
        users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(System.out::println);
    }

    public static void printUsersSortedByAge(List<User> users) {
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .forEach(System.out::println);
    }

    public static boolean allUsersAgeAboveSeven(List<User> users) {
        return users.stream()
                .allMatch(user -> user.getAge() > 7);
    }

    public static double averageAge(List<User> users) {
        OptionalDouble average = users.stream()
                .mapToInt(User::getAge)
                .average();
        return average.orElse(0.0);
    }

    public static long countUniqueCountries(List<User> users) {
        return users.stream()
                .map(User::getCountry)
                .distinct()
                .count();
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice", "Johnson", 25, "USA"));
        users.add(new User(2, "Bob", "Brown", 30, "UK"));
        users.add(new User(3, "Charlie", "Davis", 22, "USA"));
        users.add(new User(4, "David", "Smith", 18, "Canada"));
        users.add(new User(5, "Eva", "Williams", 5, "USA"));

        System.out.println("Users sorted by last name:");
        printUsersSortedByLastName(users);

        System.out.println("\nUsers sorted by age:");
        printUsersSortedByAge(users);

        boolean allAboveSeven = allUsersAgeAboveSeven(users);
        System.out.println("\nAll users age > 7: " + allAboveSeven);

        double averageAge = averageAge(users);
        System.out.println("\nAverage age: " + averageAge);

        long uniqueCountries = countUniqueCountries(users);
        System.out.println("\nNumber of unique countries: " + uniqueCountries);
    }
}
