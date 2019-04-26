import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine().toLowerCase();
        checker(password);


    }

    static void checker(String password) {
        boolean failed = false;
        if (!(length(password))) {
            System.out.println("Password must be between 6 and 10 characters");
            failed = true;
        }
        if (!onlyLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
            failed = true;
        }
        if (!(isDigit(password))) {
            System.out.println("Password must have at least 2 digits");
            failed = true;
        }

        if (!failed) {
            System.out.println("Password is valid");
        }


    }

    static boolean length(String passord) {
        boolean isValid = false;
        if (passord.length() >= 6 && passord.length() <= 10) {
            isValid = true;
        }
        return isValid;

    }

    static boolean isDigit(String password) {
        boolean isValid = false;
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                counter++;
            }
        }

        if (counter >= 2) {
            isValid = true;
        }

        return isValid;
    }

    static boolean onlyLettersAndDigits(String password) {
        boolean isValidLettersAndValidDigits = true;
        for (int i = 0; i < password.length(); i++) {
            if (!(Character.isDigit(password.charAt(i)) ||Character.isAlphabetic(password.charAt(i)))) {
                isValidLettersAndValidDigits = false;
                break;
            }
        }
        if (isValidLettersAndValidDigits) {
            return true;
        } else {
            return false;
        }


    }

}
