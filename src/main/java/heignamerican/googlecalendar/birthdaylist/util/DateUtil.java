package heignamerican.googlecalendar.birthdaylist.util;

import heignamerican.myutils.Tuple2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	private static final String DEFAULT_TIMEZONE = "JST";

	static final Calendar mCalendar = Calendar.getInstance(TimeZone.getTimeZone(DEFAULT_TIMEZONE));
	static final DateFormat mDateSourceFormat = new SimpleDateFormat("yyyy/MM/dd");
	static final DateFormat mDateFormat = new SimpleDateFormat("yyyyMMdd");

	/**
	 * @param aDate
	 *            yyyy/MM/dd
	 * @return
	 * @throws ParseException
	 */
	public static Tuple2<String, String> getOneDayRange(final String aDate) throws ParseException {
		final Date tParse = mDateSourceFormat.parse(aDate);
		final String tStart = mDateFormat.format(tParse);
		mCalendar.setTime(tParse);
		mCalendar.add(Calendar.DATE, 1);
		final String tFinish = mDateFormat.format(mCalendar.getTime());
		return Tuple2.create(tStart, tFinish);
	}
}
