//Program to convert a given string into camel case
import java.io.*;
public class Question18 {
	
	//Method to convert the string
	static String ConvertToCamelCase(String string) {
		string = string.toLowerCase();
		
		
		char[] characters = string.toCharArray();
		char[] convertedCharacters = new char[string.length()];
		int index = 0;
		int spaces = 0;
		
		for(int i = 0; i < string.length(); i++) {
			if(characters[i] == ' ') {
				spaces++;
				characters[i + 1] = Character.toUpperCase(characters[i + 1]);
			}
			else {
				convertedCharacters[index] = characters[i];
				index++;
			}
		}
		
		String convertedString = new String(convertedCharacters);
		
		return convertedString;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		//Taking input from the user
		System.out.println("Enter a String to convert into camel case");
		String string = br.readLine();
		String convertedString = ConvertToCamelCase(string);
		System.out.println("The String converted to Camel Case is " + convertedString);
	}
}

