package heignamerican.googlecalendar.birthdaylist.googlecalendar.util;

import heignamerican.myutils.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GoogleCalendarInfoUtil {
	public static GoogleCalendarInfo loadFromProperties(String aPath) throws IOException {
		return loadFromProperties(new File(aPath));
	}

	public static GoogleCalendarInfo loadFromProperties(File aFile) throws IOException {
		Properties tProperties = new Properties();
		FileInputStream tInputStream = new FileInputStream(aFile);
		try {
			tProperties.load(tInputStream);

			String tUserAccount = tProperties.getProperty("UserAccount");
			String tPassword = tProperties.getProperty("Password");
			String tCalendarUrl = tProperties.getProperty("CalendarUrl");

			return new GoogleCalendarInfo(tUserAccount, tPassword, tCalendarUrl);
		} finally {
			IOUtil.closeQuietly(tInputStream);
		}
	}
}
