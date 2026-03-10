import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+<>?/{}[]";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.println("=====================================");
        System.out.println("      ADVANCED PASSWORD GENERATOR    ");
        System.out.println("=====================================");

        System.out.print("Enter password length: ");
        int length = sc.nextInt();

        System.out.print("Include Uppercase letters? (true/false): ");
        boolean useUpper = sc.nextBoolean();

        System.out.print("Include Lowercase letters? (true/false): ");
        boolean useLower = sc.nextBoolean();

        System.out.print("Include Numbers? (true/false): ");
        boolean useNumbers = sc.nextBoolean();

        System.out.print("Include Symbols? (true/false): ");
        boolean useSymbols = sc.nextBoolean();

        String characterPool = "";

        if (useUpper) {
            characterPool += UPPERCASE;
        }

        if (useLower) {
            characterPool += LOWERCASE;
        }

        if (useNumbers) {
            characterPool += NUMBERS;
        }

        if (useSymbols) {
            characterPool += SYMBOLS;
        }

        if (characterPool.isEmpty()) {
            System.out.println("Error: No character types selected!");
            return;
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));

        }

        String generatedPassword = password.toString();

        System.out.println("\nGenerated Password: " + generatedPassword);

        checkPasswordStrength(generatedPassword);
    }

    public static void checkPasswordStrength(String password) {

        int strengthScore = 0;

        if (password.matches(".*[A-Z].*")) {
            strengthScore++;
        }

        if (password.matches(".*[a-z].*")) {
            strengthScore++;
        }

        if (password.matches(".*[0-9].*")) {
            strengthScore++;
        }

        if (password.matches(".*[!@#$%^&*()\\-_=+<>?/{}\\[\\]].*")) {
            strengthScore++;
        }

        if (password.length() >= 12) {
            strengthScore++;
        }

        System.out.print("Password Strength: ");

        switch (strengthScore) {

            case 1:
            case 2:
                System.out.println("Weak");
                break;

            case 3:
                System.out.println("Medium");
                break;

            case 4:
                System.out.println("Strong");
                break;

            case 5:
                System.out.println("Very Strong");
                break;

            default:
                System.out.println("Unknown");
        }
    }
}