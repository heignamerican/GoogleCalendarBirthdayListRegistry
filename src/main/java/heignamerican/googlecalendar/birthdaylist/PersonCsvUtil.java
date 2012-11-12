package heignamerican.googlecalendar.birthdaylist;

import heignamerican.myutils.IOUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PersonCsvUtil {
	static List<Person> getPersonsFrom(File aFile) throws IOException {
		List<Person> tList = new ArrayList<Person>();

		final BufferedReader tBufferedReader = IOUtil.createBufferedReader(aFile, "UTF-8");
		try {
			for (String tLine = tBufferedReader.readLine(); tLine != null; tLine = tBufferedReader.readLine()) {
				String[] tSplit = tLine.split(",");
				tList.add(new Person(tSplit[0], tSplit[1]));
			}
		} finally {
			IOUtil.closeQuietly(tBufferedReader);
		}

		return tList;
	}
}
