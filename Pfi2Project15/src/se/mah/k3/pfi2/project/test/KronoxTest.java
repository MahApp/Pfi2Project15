package se.mah.k3.pfi2.project.test; // 

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class KronoxTest {
	public static void main(String[] args) {
		callJavaScript();
	}

	private static void callJavaScript() {
		try {
			String s = KronoxAJAXGetFriendlyNames.getTeacherName("K3lara");
			System.out.println("JSON to parse for teachername: "+ s);
			String s2 = KronoxAJAXGetFriendlyNames.getCourseName("KD322B");
			System.out.println("JSON to parse for courseName: "+ s2);
			String s3 = KronoxAJAXGetFriendlyNames.getProgramName("TGIND");
			System.out.println("JSON to parse for programName: "+ s3);
<<<<<<< HEAD
			String s4 = KronoxAJAXGetFriendlyNames.getLocationName("A134");
			System.out.println("JSON to parse for locationName: "+ s4);
			String s5 = KronoxAJAXGetFriendlyNames.getSupport("dator");
			System.out.println("JSON to parse for support: "+ s5);
		
=======
			
		
>>>>>>> TeamViktor
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
