package org.lecture;

import java.util.List;
import java.util.Scanner;


/**
 * Class for starting the user menu and performing the stack sort
 */
public class StackSort {
    private final Scanner sc = new Scanner(System.in);
    private List<Integer> numbers;
    private final MyStack stack = new MyStackImpl();

    /**
     * Start user menu
     */
    public void startMenu() {
        boolean isContinue = true;
        String menu = """
                    ┌───────────────────────────────────────────────────────────┐
                                      Welcome to our ADT solution!
                                         Group C - Exercise 2
                                             ADT: Stack
                    └───────────────────────────────────────────────────────────┘
                                     
                    ┌───────────────────────────────────────────────────────────┐
                      1 - 📜 Input numbers, then sort & output
                      2 - 📜 Input numbers with immediate sorting & output
                      0 - ❌ Exit
                    └───────────────────────────────────────────────────────────┘
                    \n
                """;


        while (isContinue) {
            numbers = FileReader.readNumbersFromFile();
            stack.init();

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(menu);
            String userInput = sc.nextLine();
            int choice;

            if (isInteger(userInput)) {
                choice = Integer.parseInt(userInput);
            } else {
                System.out.println("Input not recognized");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("1 - 📜 Input numbers, then sort & output");
                    inputThenSortAndOutput();
                }
                case 2 -> {
                    System.out.println("2 - 📜 Input numbers with immediate sorting & output");
                    inputWithImmediateSortThenOutput();
                }
                case 0 -> isContinue = false;
                default -> System.out.println("Input not recognized");
            }
        }
        System.out.println("Bye!");
    }

    public void inputThenSortAndOutput() {
        for (int number : numbers) {
            stack.push(number);
        }

        MyStack sortedStack = new MyStackImpl();
        sortedStack.init();

        while (!stack.empty()) {
            int currentNumber = stack.pop();
            while (!sortedStack.empty() && sortedStack.top() < currentNumber) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(currentNumber);
        }

        System.out.println("Sorted Stack:");
        sortedStack.print();
    }


    public void inputWithImmediateSortThenOutput() {
        MyStack tempStack = new MyStackImpl();
        tempStack.init();

        for (int number : numbers) {
            if (stack.empty() || number <= stack.top()) {
                stack.push(number);
            } else {
                while (!stack.empty() && number > stack.top()) {
                    tempStack.push(stack.pop());
                }
                stack.push(number);
                while (!tempStack.empty()) {
                    stack.push(tempStack.pop());
                }
            }
        }

        System.out.println("Sorted Stack:");
        stack.print();
    }

    public boolean isInteger(String toCheck) {
        String regex = "^-?\\d+$";
        return toCheck.matches(regex);
    }

    public static void main(String[] args) {
        StackSort stackSort = new StackSort();
        stackSort.startMenu();
    }
}
