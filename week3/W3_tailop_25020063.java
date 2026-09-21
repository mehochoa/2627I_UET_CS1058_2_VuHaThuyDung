import java.util.Stack;

public class W3_tailop_25020063 {
  private static int getPrecedence(char op) {
    switch (op) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      default:
        return -1;
    }
  }

  public static String convertInfixToPostfix(String expression) {
    StringBuilder postfix = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);

      if (Character.isWhitespace(c)) {
        continue;
      }

      if (Character.isLetterOrDigit(c)) {
        StringBuilder operand = new StringBuilder();
        while (i < expression.length() && Character.isLetterOrDigit(expression.charAt(i))) {
          operand.append(expression.charAt(i));
          i++;
        }
        i--;
        postfix.append(operand).append(" ");
      } else if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          postfix.append(stack.pop()).append(" ");
        }
        if (!stack.isEmpty() && stack.peek() == '(') {
          stack.pop();
        }
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
          postfix.append(stack.pop()).append(" ");
        }
        stack.push(c);
      }
    }

    while (!stack.isEmpty()) {
      if (stack.peek() == '(') {
        return "Lỗi: Dấu ngoặc không hợp lệ!";
      }
      postfix.append(stack.pop()).append(" ");
    }

    return postfix.toString().trim();
  }

  public static void main(String[] args) {
    String expression = "20 - (5 + 2) * 1 * 3 - 2 * (3 + 1)";
    System.out.println("Biểu thức trung tố: " + expression);
    String result = convertInfixToPostfix(expression);
    System.out.println("Biểu thức hậu tố  : " + result);
  }
}
