package dataManager;

import java.util.ArrayList;
import java.util.List;

/*
 * collection of all files  path
 */
public class FileCollection {

	 static FileCollection fileCollection = null;
		
		
		
		private FileCollection() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public static FileCollection getInstance() {
			if(fileCollection == null){
				fileCollection = new FileCollection();
			}
			return fileCollection;
		}


	
	
	
	private  List<String> listFileName = new ArrayList<String>();

	public  List<String> getListFileName() {
		return listFileName;
	}

	public  void setListFileName(List<String> listFileName) {
		this.listFileName = listFileName;
	}

	public  void addFileName(String fileName) {
		listFileName.add(fileName);
	}
}
