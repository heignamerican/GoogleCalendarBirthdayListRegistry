package heignamerican.googlecalendar.birthdaylist.googlecalendar.util;

import java.text.ParseException;

import heignamerican.googlecalendar.birthdaylist.util.DateUtil;
import heignamerican.myutils.Tuple2;

import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.extensions.Recurrence;

public class CalendarUtil {
	/**
	 * @param aTitle
	 * @param aDate
	 *            yyyy/MM/dd
	 * @return
	 * @throws ParseException
	 */
	public static CalendarEventEntry createYearlyEvent(final String aTitle, final String aDate) throws ParseException {
		Tuple2<String, String> tRange = DateUtil.getOneDayRange(aDate);
		final String tRecurrenceValue = "DTSTART;VALUE=DATE:" + tRange.get1() + "\nDTEND;VALUE=DATE:" + tRange.get2() + "\nRRULE:FREQ=YEARLY\nBEGIN:VTIMEZONE\nTZID:Asia/Tokyo\nX-LIC-LOCATION:Asia/Tokyo\nBEGIN:STANDARD\nTZOFFSETFROM:+0900\nTZOFFSETTO:+0900\nTZNAME:JST\nDTSTART:19700101T000000\nEND:STANDARD\nEND:VTIMEZONE";
		final Recurrence tRecurrence = new Recurrence();
		tRecurrence.setValue(tRecurrenceValue);

		CalendarEventEntry tNewEventEntry = new CalendarEventEntry();
		tNewEventEntry.setTitle(new PlainTextConstruct(aTitle));
		tNewEventEntry.setContent(new PlainTextConstruct(""));
		tNewEventEntry.setRecurrence(tRecurrence);
		return tNewEventEntry;
	}
}
