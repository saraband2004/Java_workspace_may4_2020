import java.io.*; 
import java.util.*; 
import java.lang.*;

enum Operation{
	ADD, SUBTRACT, MULTIPLY, DIVIDE;
}

class Solution {
	public boolean compare(char a, char b) {
		if (a >= '0' && a <= '9') {
			if (b >= '0' && b <= '9') {
				return true;
			}
		}
		return false;
	}
	
	
	public List<String> parse(String s) {
		char[] c = s.toCharArray();
		List<String> result = new ArrayList<>();
		int prev = 0;
		for (int i = 1; i < c.length ; i++) {
			if (!compare(c[i-1], c[i])) {
				result.add(s.substring(prev, i));
				prev = i;
			}			
		}
		result.add(s.substring(prev));
		System.out.println(result);
		return result;
	}
	
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
//        while (i < sb.length()) {
//        	if (sb.charAt(i) < '0' || sb.charAt(i) > '9') {
//        		sb.insert(i, ' ');
//        		sb.insert(i+2, ' ');
//        		i = i + 3;
//        	}
//        	else i ++;
//        }
        String[] strs = new String(sb).split("\\s+");
        strs = parse(s).toArray(new String[0]);
        List<String> list = new ArrayList<>();
        
        for (String str: strs) {
        	if (str!=null && str.length()!=0 && !str.matches("\\s+")) {
        		list.add(str);
        	}        	
        }
        
        String[] inputs = list.toArray(new String[0]);
        
        int [] next = new int[inputs.length];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>();
        for (i = 0; i < inputs.length ; i ++ ) {
        	if (inputs[i].compareTo("(") == 0) {
        		stack.push(i);
        	}
        	else if (inputs[i].compareTo(")") == 0) {
        		next[stack.pop()] = i;
        	}
        }
        
        return (int)help(inputs, next, 0, inputs.length - 1);
    }
    
    public long help(String[] inputs, int[] next, int start, int end) {
    	Operation sign = Operation.ADD;
    	Operation status = Operation.MULTIPLY;
    	int index = start;
    	long addTemp = 0;
    	long mulTemp = 1;
    	while (index <= end + 1) {
    		long temp = 0;

    		if (index == end+1 || inputs[index].compareTo("+") == 0) {
    			if (index!=start)addTemp += ((sign == Operation.ADD)?1:-1) * mulTemp;
    			status = Operation.ADD;
    			sign = Operation.ADD;
    		}
    		else if (inputs[index].compareTo("-") == 0) {
    			if (index!=start)addTemp += ((sign == Operation.ADD)?1:-1) * mulTemp;
    			status = Operation.SUBTRACT;
    			sign = Operation.SUBTRACT;
    		}
    		else if (inputs[index].compareTo("*") == 0) {
    			status = Operation.MULTIPLY;
    		}
    		else if (inputs[index].compareTo("/") == 0) {
    			status = Operation.DIVIDE;
    		}
    		else {
        		if (inputs[index].compareTo("(") == 0) {
        			temp = help(inputs, next, index+1, next[index] - 1);
        			index = next[index];
        		}
        		else {
        			temp = Long.valueOf(inputs[index]);
        		}
        		
        		if (status == Operation.MULTIPLY) {
        			mulTemp *= temp;
        		}
        		else if (status == Operation.DIVIDE) {
        			mulTemp /= temp;
        		}
        		else if (status == Operation.ADD || status == Operation.SUBTRACT) {
        			mulTemp = temp;
        		}
    		}
    		index ++ ;
    	}
    	return addTemp;
    }
}


 
public class Answer {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println( s.calculate("1 + 1") );
	}
}
