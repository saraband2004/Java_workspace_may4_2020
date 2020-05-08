import java.io.*; 
import java.util.*; 
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

 

public class Answer {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
	    byte[] buffer= new byte[8192];
	    System.out.println(Arrays.toString(buffer));
	    int count;
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\FZ\\Dropbox\\desktop\\f"));
	    while ((count = bis.read(buffer)) > 0) {
	        digest.update(buffer, 0, count);
	    }
	    bis.close();
	    System.out.println(count);
 
		
	}
}
