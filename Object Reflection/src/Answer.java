import java.io.*; 
import java.util.*; 
import java.lang.*;
import java.lang.reflect.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


class ClassDemo {
	public ClassDemo() {}
	public int value = 111;
	public String function() {
		System.out.println("ppppppppp");
		return "function return";
	}

}


public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class klass = ClassDemo.class;
		ClassDemo cd = new ClassDemo();
		Method[] methods = klass.getMethods();
		System.out.println(methods[0]);
		Method m = methods[0];
		m.setAccessible(true);
		try {
			Method mm = klass.getDeclaredMethod("function", null);
			try {
				String str = (String)mm.invoke(cd, null);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String s = (String)m.invoke(cd, null);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Field FFF = klass.getDeclaredField("value");
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
