/* This is a basic Stack class provided to me in one of my first
 * year computer science courses. This structure uses the ArrayList 
 * as its base and builds its methods off the methods of the ArrayList
 * it self*/

import java.util.ArrayList;

public class Stack {
	private ArrayList<Character> s;//attribute
	
	//constructor that creates and empty arraylist
	public Stack(){
		s = new ArrayList<Character>();
	}
	
	//returns true if stack is empty
	public boolean isEmpty(){
		return (s.size() == 0);
	}
	
	//adds a char to the top
	public void push(char c){
		s.add(c);
	}
	
	//removes the current element at the top
	public char pop(){
		char result = '0';
		if (isEmpty()){
			System.out.println("Stack is empty");
		}else{
			result = s.get(s.size()-1);
			s.remove(s.size()-1);
		}
		return result;
	}
	
	//views the current element at the top
		public char peek(){
			char result = '0';
			if (isEmpty()){
				System.out.println("Stack is empty");
			}else{
				result = s.get(s.size()-1);
			}
			return result;
		}
}