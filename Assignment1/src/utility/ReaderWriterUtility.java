package utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import shared.EnumReader;

public class ReaderWriterUtility {

	private static StringBuilder builder;
	public static BufferedReader br;

	private ReaderWriterUtility() {
	}

	public static Object getInstance(EnumReader enumReader) {

		Object val = null;
		if (enumReader.equals(EnumReader.BUFFER_READER)) {

			if (br == null) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
			val = br;
		}
		if (enumReader.equals(EnumReader.STRING_BUILDRR)) {

			if (builder == null) {
				builder = new StringBuilder();
			}
			val = builder;
		}
		return val;

	}
}
