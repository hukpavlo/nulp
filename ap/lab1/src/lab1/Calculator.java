package lab1;

import java.util.Locale;
import java.util.Scanner;

enum Operation {
  SUM {
    public double action(double arg0, double arg1) { return arg0 + arg1; }
  },
  SUBTRACT {
    public double action(double arg0, double arg1) { return arg0 - arg1; }
  },
  MULTIPLY {
    public double action(double arg0, double arg1) { return arg0 * arg1; }
  },
  DIVIDE {
    public double action(double arg0, double arg1) {
      if (arg1 != 0.0) return arg0 / arg1;

      throw new ArithmeticException();
    }
  };

  public abstract double action(double arg0, double arg1) throws ArithmeticException;
}

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
      case "+": return Operation.SUM;
      case "-": return Operation.SUBTRACT;
      case "*": return Operation.MULTIPLY;
      case "/": return Operation.DIVIDE;

      default:
        System.out.println(errorMessage);

        return this.readOperation(question, errorMessage);
    }
  }

  public Calculator init() {
    try {
      final String numberQuestion = "Enter your number: ";
      final String numberErrorMessage = "Invalid number. Try again...";
      final String operationQuestion = "Enter your operation. Available is \"+\" \"-\" \"*\" \"/\": ";
      final String operationErrorMessage = "Invalid value. Try one of these: \"+\" \"-\" \"*\" \"/\"";

      final double firstValue = this.readNumber(numberQuestion, numberErrorMessage);
      final Operation operation = this.readOperation(operationQuestion, operationErrorMessage);
      final double secondValue = this.readNumber(numberQuestion, numberErrorMessage);

      this.result = operation.action(firstValue, secondValue);

    } catch(ArithmeticException ex) {
      System.out.println("You cannot divide by 0");
      System.exit(0);
    }

    return this;
  }

  public double getResult() {
    return this.result;
  }
}
