package uk.org.downesward.utiliites;

import java.io.IOException;
import java.io.LineNumberReader;

public class StringUtilities {
	public static String getPropertyValue(LineNumberReader reader, String valueSeparator) throws IOException {
		String value = "";
		String line = reader.readLine();
		if (!line.contains(valueSeparator)) {
			return value;
		}
		String[] tokens = line.split(valueSeparator);
		if (tokens.length > 1) {
			return tokens[1];
		}
		return value;
	}
	
	public static String getPropertyValue(LineNumberReader reader) throws IOException {
		return getPropertyValue(reader, "=");
	}
}
