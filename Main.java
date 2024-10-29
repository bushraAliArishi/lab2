public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Lab 2");

    System.out.println("********************************************************");
    System.out.println("Question 1 -Write a program to find all of the longest word in a given dictionary. to stop enter (StopIt)");
    System.out.println("********************************************************");
    boolean enter = true;
    ArrayList<String> mainlongWordArray = new ArrayList<>();
    ArrayList<String> mainWordArray = new ArrayList<>();
    while (enter) {
        System.out.println("Enter a Word ");
        String myWord = input.next();
        if (myWord.contains("StopIt")) {
            enter = false;
            break;
        } else mainWordArray.add(myWord);
    }

    mainlongWordArray = longestWords(mainWordArray);
    for (String a : mainlongWordArray) {
        System.out.printf(a + " ");

    }
    System.out.println();
    System.out.println();
    System.out.println("********************************************************");
    System.out.println("Question 2 - Display the number of occurrences of each element in the array.");
    System.out.println("********************************************************");

    int[] numArrayQuestion2 = {1, 1, 1, 3, 3, 5};

    countOccurrences(numArrayQuestion2);
    System.out.println();
    System.out.println();
    System.out.println("********************************************************");
    System.out.println("Question 3 - Find the k largest elements in a given array.");
    System.out.println("********************************************************");
    int[] numArrayQuestion3 = {1, 4, 17, 7, 25, 3, 100};
    System.out.println("enter the number of wanted numbers to be displayed");
    int k = input.nextInt();
    LargestNumbers(numArrayQuestion3, k);
    System.out.println();
    System.out.println();
    System.out.println("********************************************************");
    System.out.println("Question 4 - Reverse an array of integers in place.");
    System.out.println("********************************************************");
    System.out.println("array befor reverse");
    for (int v :numArrayQuestion3){
        System.out.printf(v+" ");
    }
    System.out.println("\narray after reverse");
    for (int v :reverseArray(numArrayQuestion3)){
        System.out.printf(v+" ");
    }

    System.out.println();
    System.out.println();
    System.out.println("********************************************************");
    System.out.println("Question 5 - Menu-driven program for array operations.");
    System.out.println("********************************************************");
    System.out.print("Enter the size of the array: ");
    int theLength = input.nextInt();
    menuDrivenArray(theLength);

    System.out.println();
    System.out.println();
    System.out.println("********************************************************");
    System.out.println("Question 6 - Generate random numbers within a given range.");
    System.out.println("********************************************************");
    generateRandomNumbers();
    System.out.println();
    System.out.println();
    System.out.println("********************************************************");
    System.out.println("Question 7 - Check password strength.");
    System.out.println("********************************************************");
    System.out.print("Enter a password: ");
    String passWord = input.next();
    evaluatePassword(passWord);
    System.out.println();
    System.out.println();
    System.out.println("********************************************************");
    System.out.println("Question 8 - Generate Fibonacci sequence up to specified terms.");
    System.out.println("********************************************************");

    System.out.print("Enter the number of Fibonacci terms to generate: ");
    int num = input.nextInt();
    FibonacciSequence(num);
}

public static ArrayList<String> longestWords(ArrayList<String> wrodsArray) {
    int longnum = 0;
    ArrayList<String> longWordArray = new ArrayList<>();

    for (String theWord : wrodsArray) {
        if (theWord.length() > longnum) {
            longnum = theWord.length();
        }
    }
    for (String theWord : wrodsArray) {
        if (theWord.length() == longnum) {
            longWordArray.add(theWord);
        }
    }


    return longWordArray;
}
public static void countOccurrences(int[] array) {
    Scanner input = new Scanner(System.in);
    while (true) {
        System.out.print("Enter a number to search for its occurrences (or 000 to exit): ");
       int target = input.nextInt();
        if (target == 000) {
            break;
        }
        int count = 0;
        for (int num : array) {
            if (num == target) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println(target + " occurs " + count + " times in the array.");
        } else {
            System.out.println(target + " does not occur in the array.");
        }
    }
}
public static void LargestNumbers(int[] array, int k) {
    Arrays.sort(array);
    System.out.print(k + " largest elements are: ");
    for (int i = array.length - 1; i >= array.length - k; i--) {
        System.out.print(array[i] + " ");
    }
    System.out.println();
}
public static int[] reverseArray(int[] array) {
    int firstElements = 0;
    int reverseElements = array.length - 1;
    while (firstElements < reverseElements) {
        int temp = array[firstElements];
        array[firstElements] = array[reverseElements];
        array[reverseElements] = temp;
        firstElements++;
        reverseElements--;

    }
    return array;
}
public static void menuDrivenArray(int size) {
    Scanner input = new Scanner(System.in);
    int[] array = new int[size];
    boolean stop = false;

    while (!stop) {
        System.out.println("\nMenu:");
        System.out.println("1. Accept elements of an array");
        System.out.println("2. Display elements of the array");
        System.out.println("3. Search an element in the array");
        System.out.println("4. Sort the array");
        System.out.println("5. Stop");

        System.out.print("Choose an option: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                for (int i = 0; i < array.length; i++) {
                    System.out.print("Enter element " + (i + 1) + ": ");
                    array[i] = input.nextInt();
                }
                break;
            case 2:
                System.out.println("Array elements: " + Arrays.toString(array));
                break;
            case 3:
                System.out.print("Enter element to search: ");
                int element = input.nextInt();
                boolean found = false;
                for (int num : array) {
                    if (num == element) {
                        found = true;
                        break;
                    }
                }
                System.out.println(found ? "Element found." : "Element not found.");
                break;
            case 4:
                Arrays.sort(array);
                System.out.println("Array sorted.");
                break;
            case 5:
                stop = true;
                break;
            default:
                System.out.println("choice are from  1 to 5 ");
        }
    }
}
public static void generateRandomNumbers() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the minimum value of the range: ");
    int min = input.nextInt();
    System.out.print("Enter the maximum value of the range: ");
    int max = input.nextInt();
    System.out.print("Enter the number of random numbers to generate: ");
    int count = input.nextInt();
    Random random = new Random();

    System.out.print("Random numbers: ");
    for (int i = 0; i < count; i++) {
        int randomNum = random.nextInt((max - min) + 1) + min;
        System.out.print(randomNum + " ");
    }
    System.out.println();
}
public static void evaluatePassword(String passWord) {

    int totalScore = checkLength(passWord) + specialCharacters(passWord) + upperCaseLowerCase(passWord);
    if (totalScore >= 8) {
        System.out.println("Password is strong.");
    } else if (totalScore >= 5) {
        System.out.println("Password is moderately strong.");
    } else {
        System.out.println("Password is weak.");
    }
}
public static int checkLength(String password) {
    if (password.length() >= 8) return 3;
    else if (password.length() >= 6) return 2;
    else
        return 0;
}
public static int specialCharacters(String password) {
    for (char c : password.toCharArray()) {
        if (!Character.isLetterOrDigit(c)) return 2;
    }
    return 0;
}
public static int upperCaseLowerCase(String password) {
    boolean hasUpper = false;
    boolean hasLower = false;
    for (char c : password.toCharArray()) {
        if (Character.isUpperCase(c)) hasUpper = true;
        if (Character.isLowerCase(c)) hasLower = true;
    }
    return (hasUpper && hasLower) ? 3 : 0;
}
public static void FibonacciSequence(int terms) {
    int a = 0, b = 1;
    System.out.print("Fibonacci sequence: " + a + " " + b);
    for (int i = 2; i < terms; i++) {
        int next = a + b;
        if (next%5==0&&next%10==0){
            System.out.print("\n " + next);
            a = b;
            b = next;

        }else {
        System.out.print(" " + next);
        a = b;
        b = next;}
    }
    System.out.println();
}
