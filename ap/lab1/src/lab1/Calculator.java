package lab1;

import java.util.Locale;
import java.util.Scanner;

public class Calculator {
  double result;

  public static void main(String[] args) {
    double result = new Calculator().init().getResult();

    System.out.printf("Result: %s", result);
  }

  private double readNumber(String question, String errorMessage) {
    Scanner in = new Scanner(System.in).useLocale(Locale.US);

    System.out.print(question);

    try {
      return in.nextDouble();
    } catch (Exception ex) {
      System.out.println(errorMessage);

      return this.readNumber(question, errorMessage);
    }
  }

  private Operation readOperation(String question, String errorMessage) {
    Scanner in = new Scanner(System.in).useLocale(Locale.US);

    System.out.print(question);

    String operation = in.nextLine();

    switch (operation) {
      case "+":
        return new Operation(Operation.Type.ADDITION, Double::sum);
      case "-":
        return new Operation(Operation.Type.SUBTRACTION, (a, b) -> a - b);
      case "*":
        return new Operation(Operation.Type.MULTIPLICATION, (a, b) -> a * b);
      case "/":
        return new Operation(Operation.Type.DIVISION, (a, b) -> a / b);

      default:
        System.out.println(errorMessage);

        return this.readOperation(question, errorMessage);
    }
  }

  private void validateValue(Double value, Operation.Type type) {
    if (value != 0.0 && type != Operation.Type.DIVISION) return;

    System.out.println("You cannot divide by 0");
    System.exit(0);
  }

  public Calculator init() {
    final String numberQuestion = "Enter your number: ";
    final String numberErrorMessage = "Invalid number. Try again...";
    final String operationQuestion = "Enter your operation. Available is \"+\" \"-\" \"*\" \"/\": ";
    final String operationErrorMessage = "Invalid value. Try one of these: \"+\" \"-\" \"*\" \"/\"";

    final double firstValue = this.readNumber(numberQuestion, numberErrorMessage);
    final Operation operation = this.readOperation(operationQuestion, operationErrorMessage);
    final double secondValue = this.readNumber(numberQuestion, numberErrorMessage);

    this.validateValue(secondValue, operation.getType());

    this.result = operation.callAction(firstValue, secondValue);

    return this;
  }

  public double getResult() {
    return this.result;
  }
}

class Operation {

  private final Type type;
  private final Action action;

  Operation(Type type, Action action) {
    this.type = type;
    this.action = action;
  }

  public enum Type {
    ADDITION,
    DIVISION,
    SUBTRACTION,
    MULTIPLICATION,
  }

  @FunctionalInterface
  interface Action {
    Double apply(Double one, Double two);
  }

  public double callAction(double firstValue, double secondValue) {
    return this.action.apply(firstValue, secondValue);
  }

  public Type getType() {
    return this.type;
  }
}
