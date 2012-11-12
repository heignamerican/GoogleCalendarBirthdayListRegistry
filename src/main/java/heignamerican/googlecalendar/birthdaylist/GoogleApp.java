package heignamerican.googlecalendar.birthdaylist;

import heignamerican.googlecalendar.birthdaylist.googlecalendar.util.CalendarCommunicator;
import heignamerican.googlecalendar.birthdaylist.googlecalendar.util.CalendarUtil;
import heignamerican.googlecalendar.birthdaylist.googlecalendar.util.GoogleCalendarInfoUtil;
import heignamerican.googlecalendar.birthdaylist.util.Result;
import heignamerican.myutils.Callback;
import heignamerican.myutils.collection.CollectionUtil;
import heignamerican.myutils.collection.ConvertException;
import heignamerican.myutils.collection.ConverterBase;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.util.ServiceException;

public class GoogleApp {
	public static void main(String[] args) throws IOException, ServiceException, ParseException, ConvertException {
		String tSettingPath = "res/google_calendar_info/forTest.properties";
		// String tSettingPath = "res/google_calendar_info/forProduction.properties";
		String tPersonsSourcePath = GoogleApp.class.getResource("source.csv").getPath();
		CalendarCommunicator tCalendarCommunicator = new CalendarCommunicator(GoogleCalendarInfoUtil.loadFromProperties(tSettingPath));

		show(tCalendarCommunicator.deleteAllEvent());
		System.out.println("===============================");
		show(tCalendarCommunicator.insert(convertPersonEventList(PersonCsvUtil.getPersonsFrom(new File(tPersonsSourcePath)))));
		System.out.println("===============================");

		tCalendarCommunicator.queryAllEvent(new Callback<CalendarEventEntry>() {
			@Override
			public <_CalendarEventEntry extends CalendarEventEntry> void notify(_CalendarEventEntry aEntry) {
				System.out.println(aEntry.getTitle().getPlainText());
				// System.out.println(aEntry.getRecurrence().getValue());
			}
		});
	}

	private static List<CalendarEventEntry> convertPersonEventList(List<Person> aPersons) throws ParseException, ConvertException {
		return CollectionUtil.mapping(aPersons, new ConverterBase<Person, CalendarEventEntry>() {
			@Override
			public CalendarEventEntry convertReal(Person aPerson) throws Exception {
				return CalendarUtil.createYearlyEvent(aPerson.getName() + " 誕生日", aPerson.getBirthday());
			}
		});
	}

	private static void show(Result<String> aResult) {
		System.out.println(aResult.getTitle() + " success=" + aResult.getSuccessResult().size() + "  failure=" + aResult.getFailureResult().size());
		for (String tString : aResult.getFailureResult()) {
			System.out.println(tString);
		}
	}
}
