/* The ASC (Arithmetic Sequence Checker) Class is where the main 
 * work is done. The program firsts ass whether you have a text 
 * file containing sequences or whether you would like to enter
 * them one-by-one via keyboard input */

/* File: ASC.java
 * Author: Zachery Spencer */

import java.io.*;
import java.util.Scanner;

public class ASC {

	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		
		/* asks for what kind of input the user wants to use */
		System.out.println("Enter how you would like to enter your arithmetic expressions, " +
				"enter <keyboard> for input by keyboard or <file> \nto read them from a file:");
		String option = kb.nextLine();
		
		if(option.equals("file")){
			System.out.println("Enter the file name:");
			File file = new File(kb.nextLine());
			
			/* Checks to see if the inputed file exists then opens it up
			 * and loops through the lines checking each sequences. If it 
			 * doesn't exist simply states the file does not exist and terminates. */
			if(file.exists()){
				String line;
				BufferedReader br = new BufferedReader(new FileReader(file));
				char[] input; 
				
				line = br.readLine();
				while(line != null){
					input = format(line);
					if(check(input)){
						System.out.println(line + " is correctly formated.");
					}else{
						System.out.println(line + " is not correctly formated.");
					}
					
					line = br.readLine();
				}
				br.close();
				System.out.println("File finished processing.");
				
			}else{
				System.out.println("invalid file name, does not exist.");
			}
		
		/* If keyboard input is selected then a while loop runs that
		 * accepts and checks sequences unless the user inputs quit which
		 * ends the loop. */	
		
		}else if(option.equals("keyboard")){
			String input;
			System.out.println("Enter an arithmetic expression enter quit to end");
			input = kb.nextLine();
			
			while(!input.equals("quit")){
				char[] inputa = format(input);
				
				if(check(inputa)){
					System.out.println(input + " is a correctly formatted expression");
				}else{
					System.out.println(input + " is not correctly formatted");
				}
				
				System.out.println("Enter another aritmetic expression, enter quit to end");
				input = kb.nextLine();
			}
			
			System.out.println("Thanks for using this program.");
		}else{
			System.out.print("Invalid input.");
		}
		
	
	}
	
	/* The check method takes the inputed and removes all the
	 * spaces and reduces any possible letters to lower case to
	 * prevent any bugs/ */
	
	public static char[] format(String expression){
		expression = expression.replaceAll(" ", "");
		expression = expression.toLowerCase();
		return expression.toCharArray();
	}
	
	/* The algorithm for checking each sequence is very simple. Each time one of
	 * the three possible opening brackets is found they are pushed into the stack.
	 * when an closing bracket is found it peeks at the stack top and if the closing 
	 * bracket matches the opening bracket then the stack pops the top and continues;
	 * if it doesn't then the sequence is not properly formatted. at the end of the loop
	 * the stack should be empty if the sequence is correctly formatted.*/
	
	public static boolean check(char[] expression){
		Stack stack = new Stack();
		
		for(int i =0; i < expression.length; i++){
			if(expression[i] == '(' || expression[i] == '{' || expression[i] == '['){
				stack.push(expression[i]);
			}
			
			if(expression[i] == ')' || expression[i] == '}' || expression[i] == ']'){
				if(stack.isEmpty()){
					return false;
				}
				
				if((expression[i] == ')' && stack.peek() == '(') || (expression[i] == '}' && stack.peek() == '{') || (expression[i] == ']' && stack.peek() == '[')){
					stack.pop();
				}else{
					return false;
				}
			}
			
		}
		
		return stack.isEmpty();
	}

}
