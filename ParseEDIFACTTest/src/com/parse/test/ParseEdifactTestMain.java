package com.parse.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseEdifactTestMain {

	public static void main(String[] args) {
		final String EDIFACT = "UNA:+.? '" + 
				"UNB+UNOC:3+2021000969+4441963198+180525:1225+3VAL2MJV6EH9IX+KMSV7HMD+CUSDECU-IE++1++1'" + 
				"UNH+EDIFACT+CUSDEC:D:96B:UN:145050'" + 
				"BGM+ZEM:::EX+09SEE7JPUV5HC06IC6+Z'" + 
				"LOC+17+IT044100'" + 
				"LOC+18+SOL'" + 
				"LOC+35+SE'" + 
				"LOC+36+TZ'" + 
				"LOC+116+SE003033'" + 
				"DTM+9:20090527:102'" + 
				"DTM+268:20090626:102'" + 
				"DTM+182:20090527:102'";


		// Regular Expression
		// "LOC" followed by any character - followed by one occurrence of "'"		 
		Pattern pattern = Pattern.compile("LOC.*?'");
		Matcher matcher = pattern.matcher(EDIFACT);
		List<String> locs = new ArrayList<>();

		// Matcher finds each LOC line
		while (matcher.find()) {
			//	Split LOC line at "+"
			String[] locNumsArray = matcher.group().split("\\+");

			// Loop array and add 2nd and 3rd element to the list
			for (int i = 1; i < locNumsArray.length; i++) {
				locs.add(locNumsArray[i]);
			}
		}
		// Print List
		System.out.println(locs.toString());
	}
}
