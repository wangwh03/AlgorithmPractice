package com.weihua.general;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * convert infix into postfix(not considering () )
 * calculate postfix
 */
public class PostfixExpression {

	public static void main(String[] args) {
		PostfixExpression test = new PostfixExpression();
		System.out.println(test.calculate("10+2*3-4"));
		System.out.println(test.recursion("1+2-1*40"));
	}
	
	public int calculate(String expression) {
		if (expression == null || expression.length() == 0) {
			throw new IllegalArgumentException("wrong expression");
		}
		// convert into a postfix expression
		Queue<String> queue = new LinkedList<String>();
		Stack<Character> operator = new Stack<Character>();
		
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);
			if (isNumber(current)) {
				int index = parseNumber(expression, i);
				queue.offer(expression.substring(i, index));
				i = index-1;
			} else {
				if (isOperator(current)) {
					while (!operator.isEmpty() 
							&& getPriority(operator.peek()) > getPriority(current)) {
						queue.offer(String.valueOf(operator.pop()));
					}
					operator.push(current);
				}
			}
		}
		
		while (!operator.isEmpty()) {
			queue.offer(String.valueOf(operator.pop()));
		}
		
		// calculate 
		Stack<Integer> results = new Stack<Integer>();
		while(!queue.isEmpty()) {
			String current = queue.remove();
			if (isNumber(current.charAt(0))) {
				results.push(Integer.parseInt(current));
			} else {
				int number2 = results.pop();
				int number1 = results.pop();
				int result = calculate(number1, number2, current);
				results.push(result);
			}
		}
		
		return results.pop();
	}
	
	private boolean isNumber(char input) {
		return input >= '0' && input <= '9';
	}
	
	private int parseNumber(String expression, int startIndex) {
		while(startIndex < expression.length() && isNumber(expression.charAt(startIndex))) {
			startIndex++;
		}
		return startIndex;
	}
	
	private boolean isOperator(char input) {
		return input == '+' || input == '-' || input == '*' || input == '/';
	}
	
	/*
	 * Priority definition:
	 *  +   1
	 *  -   1
	 *  *   2
	 *  /   2
	 */
	private int getPriority(char input) {
		if (input == '+' || input == '-') {
			return 1;
		} else if (input == '*' || input == '/') {
			return 2;
		}
		throw new IllegalArgumentException("unsupported operator!");
	}

	private int calculate(int number1, int number2, String operator) {
		if (operator.equals("+")) {
			return number1 + number2;
		} else if (operator.equals("-")) {
			return number1 - number2;
		} else if (operator.equals("*")) {
			return number1 * number2;
		} else if (operator.equals("/")) {
			return number1 / number2;
		}
		throw new IllegalArgumentException("unsupported operator : " + operator);
	}
	
	
	public int recursion(String expression) {
		if (expression == null) {
			throw new IllegalArgumentException();
		}
		int index = parseNumber(expression, 0);
		if (index == expression.length()) {
			return Integer.parseInt(expression);
		}
		
		char operator = expression.charAt(index);
		if (operator == '+' || operator == '-') {
			int result = recursion(expression.substring(2));
			if (operator == '+') {
				return Integer.parseInt(expression.substring(0, index)) + result;
			} else if (operator == '-') {
				return Integer.parseInt(expression.substring(0, index)) - result;
			}
		} else {
			int number1 = Integer.parseInt(expression.substring(0, index));
			int index2 = parseNumber(expression, index+1);
			int number2 = Integer.parseInt(expression.substring(index+1, index2));
			int result = 0;
			if (operator == '*') {
				result = number1 * number2;
			} else if (operator == '/') {
				result = number1 / number2;
			}
			if (index2 == expression.length()) {
				return result;
			}
			return recursion(String.valueOf(result) + expression.substring(index2));
		}
		throw new IllegalArgumentException();
	}
}
