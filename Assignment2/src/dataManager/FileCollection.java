package dataManager;

import java.util.ArrayList;
import java.util.List;

/*
 * collection of all files absoulute path
 */
public class FileCollection {

	
	
	
	private static List<String> listFileName = new ArrayList<String>();

	
	
	public static List<String> getListFileName() {
		return listFileName;
	}



	public static void setListFileName(List<String> listFileName) {
		FileCollection.listFileName = listFileName;
	}



	public static void addFileName(String fileName){
		listFileName.add(fileName);
	}

	
	
}
