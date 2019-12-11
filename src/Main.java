import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<String> set = new HashSet<>();
        set.add("abrakovem@mail.ru");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("\nADD <email> - добавить в список <email>\n" +
                        "LIST - вывести весь список на жкран");
                System.out.print("Введите команду: ");
                String command = reader.readLine();
                String[] array = command.split(" ", 2);

                switch (array[0]) {
                    case "ADD":
                        if (validate(array[1])) {
                            set.add(array[1]);
                        } else {
                            System.out.println("Ошибка! Некорректно введен email");
                        }
                        break;

                    case "LIST":
                        for (String str : set) {
                            System.out.println(str);
                        }
                        break;

                    default:
                        System.out.println("default");
                        break;
                }
                }
            }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("[/.+@.+\\..+/i]");

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
        }

