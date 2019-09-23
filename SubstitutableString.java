package apcsa;
/** 
 * An interface supporting the two methods extractFirstParen(String a) and substituteAll(String a, String b, String c).
 * @author GinaBae
 */
interface SubstitutableString {
	/**
	* Given a string returns the earliest substring delimited by parenthesis that contains no parenthesis
	* @param a String
	* @return the earliest substring delimited by parenthesis that contains no parenthesis
	*/
	public static String extractFirstParen(String a) {
		/*
		Integer that stores the index of the first parenthesis.
		*/
		int i = 0;
		/*
		Integer that stores the index of the second parenthesis.
		*/
		int j = 0;
		/*
		String that is set to the substring that will be returned (since string are immutable).
		*/
		String d;
		// Returns an empty string if given an empty string
		if(a.length()==0) 
			d="";
		else 
		// checks if the given string contains parenthesis, and sets d to the substring between the first pair
			if ((a.contains("("))||(a.contains(")"))) {
				i=a.indexOf("(");
				j=a.indexOf(")");
				d=a.substring(i+1, j);}
		// if no parenthesis, return the given string
			else
				d=a;	
		
		return d;
	}

	/**
	* Substitutes every occurrence of b in a by c
	* @param a String given to search for b in
	* @param b String that you search for in a
	* @param c String that replaces instances of b in a
	* @return a string equal to a with every occurrence of b in a substituted by c
	*/
	public static String substituteAll(String a, String b, String c) {
		/*
		String that is set to the substring that will be returned (since string are immutable).
		*/
		String d;
		//checks if a contains b and replaces it with c
		if(a.contains(b))
			d=a.replace(b, c);
		//returns a if it doesn't contain b
		else
			d=a;
		return d;
	}
	public static void main(String[] args){
		/*
		Tests edge cases for the substituteAll(String a, String b, String c) method.
		*/
		System.out.println(extractFirstParen(substituteAll("", "b", "cd")));
		System.out.println(extractFirstParen(substituteAll("free", "b", "cd")));
		System.out.println(extractFirstParen(substituteAll("sad young man hours", "young man", "boi")));
		System.out.println(extractFirstParen(substituteAll(substituteAll("sad boi hours", "boi", "young man"),substituteAll("old man", "old", "young"),substituteAll("young man", "man", "woman"))));
		System.out.println(extractFirstParen(substituteAll("we are what we do.", "we", "you")));
		System.out.println(extractFirstParen(substituteAll("too too too too too", "too", "very")));
		/*
		Tests edge cases for the extractFirstParen(String a) method.
		*/
		System.out.println(extractFirstParen(""));
		System.out.println(extractFirstParen("I don't want to sleep."));
		System.out.println(extractFirstParen("(not) enough time"));
		System.out.println(extractFirstParen(extractFirstParen("(not) enough time")));
		System.out.println(extractFirstParen("I (don't) want to (sleep)."));
		System.out.println(extractFirstParen("()()()()"));
		
	}
}
