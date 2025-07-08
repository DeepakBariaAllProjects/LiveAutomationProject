package experiment;

import java.util.Date;

public class generateTimeStramp {

	public static void main(String[] args) {
		Date date = new Date();
		String TimeStramp = date.toString();
		String noSpace = TimeStramp.replaceAll(" ", "");
		String noSpaceColon = noSpace.replaceAll("\\:", "");
		
		
		System.out.println(noSpaceColon);
//		TimeStramp.replaceAll("\\:","");
		
	}

}
