package RecursiveStringTools;

public class RecursiveStringTools {

	
	
	public boolean match(String s1, String s2) {
		System.out.println(s1);
		System.out.println(s2);
		return match(s1, s2, 0);
	}
	
	public boolean match(String s1, String s2, int i) {
		
		if(s1.length() != s2.length()) {
			return false;
		}
		if(i >= s1.length()) {
			return true;
		}
		if(s1.charAt(i) == s2.charAt(i) || s1.charAt(i) == '?' || s2.charAt(i) == '?') {
			i++;
			return match(s1, s2, i);
		}
		return false;
	}
	
	public boolean palindrome(String str) {
		String s = "";
		for(int e = 0; e < str.length(); e++) {
			if(Character.isLetter(str.charAt(e)) || Character.isDigit(str.charAt(e))) {
				s += str.charAt(e);
			}
		}
		s = s.toLowerCase();
		System.out.println(s);
		return palindrome(s, 0);
	}
	
	private boolean palindrome(String s, int i) {
		if(i == s.length() / 2) {
			return true;
		}
		if(s.charAt(i) == s.charAt(s.length() - 1 - i)) {
			i++;
			return palindrome(s, i);
		}
		return false;
	}
	
	public void anagram(String s) {
		anagram(s, 0, s.length() - 1);
	}
	
	private void anagram(String s, int i, int j) {
		if(i == j) {
			System.out.println(s);
			return;
		}
		else
        { 
            for (int e = i; e <= j; e++) 
            { 
                s = swap(s, i, e); 
                anagram(s, i + 1, j); 
                s = swap(s, i, e); 
            } 
        } 
    } 
  
    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
}
