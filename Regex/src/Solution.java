import java.io.*; 
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		String str = "1+2+3+34+5";
		String[] strs = str.split("([ab]){2,5}");
		System.out.println(new Solution().isNumber("432e3"));
		
		
		String pattern = "[+-]";
		Pattern patternObject = Pattern.compile(pattern);
		Matcher m = patternObject.matcher(str);		
		while (m.find()) {
			if (m.group().length()!=0) {
				System.out.println(m.group());
			}
		}
		System.out.println(m.replaceAll(" + "));
		
	}
	public boolean isNumber(String s) {
        //s = s.trim();
		String s1 = "(\\d+)((\\.\\d{0,})?)";
		String s2 = "(\\d{0,})((\\.\\d{1,}))";
        String pattern = "^(((\\s){0,})?)(([+-])?)("+s1+"|"+s2+")(((e([+-]?)\\d{1,}))?)((\\s){0,})?$";
        Pattern patternObject = Pattern.compile(pattern);
        Matcher m = patternObject.matcher(s);
        return m.find();
	}
	
}
