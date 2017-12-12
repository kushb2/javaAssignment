package com.nagarro.java.training.data;

import java.util.ArrayList;
import java.util.List;

public class FileNameCollection {
	private static List<String> fileName = new ArrayList<String>();

	public static List<String> getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		FileNameCollection.fileName.add(fileName);
	}

}
