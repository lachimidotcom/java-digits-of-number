import java.util.Scanner;
import java.util.Arrays;

public class DigitsOfNumber{
	
	// using MATHEMATICAL OPERATIONS and Loop
	public static int[] digitsOfNumberMathOpLoop(int n){
        int numDigits = (int) Math.log10(n) + 1; // double explicit typecasted to int
        int[] digits = new int[numDigits];

        for (int i = numDigits - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
	}
	
	// using MATHEMATICAL OPERATIONS and Recursion
	public static int[] digitsOfNumberMathOpRecursion(int n) {
		if (n == 0) {
			return new int[0];
		} else {
			int[] previousDigits = digitsOfNumberMathOpRecursion(n / 10);
			int[] digits = Arrays.copyOf(previousDigits, previousDigits.length + 1);
			digits[previousDigits.length] = n % 10;
			return digits;
		}
	}
	
	// using MATHEMATICAL OPERATIONS and String Builder
	public static int[] digitsOfNumberMathOpStringBuilder(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % 10);
			n /= 10;
		}
		sb.reverse();
		return sb.chars()
				.map(Character::getNumericValue)
				.toArray();
	}
	
	// Using CHARACTER ITERATION and Loop
	public static int[] digitsOfNumberCharLoop(int n) {
		char[] charArray = String.valueOf(n).toCharArray();
		int[] digits = new int[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			digits[i] = charArray[i] - '0';
		}
		return digits;
	}
	
	// Using CHARACTER ITERATION and Recursion
	// Using CHARACTER ITERATION and String Builder


	// Streams
	public static int[] digitsOfNumberStreams(int n){
		return Arrays.stream(String.valueOf(n).split(""))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
	
	public static void printArray(int[] arr, String str){
		System.out.print(str + " ");
		for(int i : arr){
			System.out.print(i + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Number: ");
		int number = scanner.nextInt();
		scanner.close();
		printArray(digitsOfNumberMathOpLoop(number), "Mathematical Operations Loop: ");
		printArray(digitsOfNumberMathOpRecursion(number), "Mathematical Operations Recursion:");
		printArray(digitsOfNumberMathOpStringBuilder(number), "Mathematical Operations String Builder:");
		printArray(digitsOfNumberCharLoop(number), "Char Loop: ");
		printArray(digitsOfNumberStreams(number), "Streams: ");		
	}
}