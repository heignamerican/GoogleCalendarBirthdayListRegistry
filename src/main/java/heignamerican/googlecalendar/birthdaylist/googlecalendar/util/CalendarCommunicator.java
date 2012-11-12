package heignamerican.googlecalendar.birthdaylist.googlecalendar.util;

import heignamerican.googlecalendar.birthdaylist.util.Result;
import heignamerican.myutils.Callback;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gdata.client.Query;
import com.google.gdata.client.batch.BatchInterruptedException;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.Link;
import com.google.gdata.data.batch.BatchOperationType;
import com.google.gdata.data.batch.BatchStatus;
import com.google.gdata.data.batch.BatchUtils;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.calendar.CalendarEventFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class CalendarCommunicator {
	final private GoogleCalendarInfo mInfo;
	private final URL mUrl;
	private final CalendarService mCalendarService;

	public CalendarCommunicator(final GoogleCalendarInfo aInfo) throws MalformedURLException, AuthenticationException {
		mInfo = aInfo;
		mUrl = new URL(mInfo.getCalendarUrl());
		mCalendarService = new CalendarService("my-calendar-util");
		mCalendarService.setUserCredentials(mInfo.getUserAccount(), mInfo.getPassword());
	}

	public void queryAllEvent(Callback<CalendarEventEntry> aCallback) throws IOException, ServiceException {
		List<CalendarEventEntry> tSelectAllEntries = selectAllEntries();
		for (CalendarEventEntry tEntry : tSelectAllEntries) {
			aCallback.notify(tEntry);
		}
	}

	public Result<String> insert(List<CalendarEventEntry> aEntries) throws MalformedURLException, BatchInterruptedException, IOException, ServiceException {
		return execInEntries(BatchOperationType.INSERT, aEntries);
	}

	public Result<String> deleteAllEvent() throws IOException, ServiceException {
		return execInAllEvent(BatchOperationType.DELETE);
	}

	private Result<String> execInAllEvent(final BatchOperationType aOperationType) throws IOException, ServiceException {
		return execInEntries(aOperationType, selectAllEntries());
	}

	private Result<String> execInEntries(final BatchOperationType aOperationType, final List<CalendarEventEntry> aEntries) throws IOException, ServiceException, MalformedURLException, BatchInterruptedException {
		final CalendarEventFeed tBatchRequest = new CalendarEventFeed();
		for (int i = 0; i < aEntries.size(); i++) {
			final CalendarEventEntry tEntry = aEntries.get(i);
			BatchUtils.setBatchId(tEntry, String.valueOf(i));
			BatchUtils.setBatchOperationType(tEntry, aOperationType);
			tBatchRequest.getEntries().add(tEntry);
		}

		Result<String> tResult = new Result<>(aOperationType.name());

		final CalendarEventFeed tBatchFeed = mCalendarService.getFeed(mUrl, CalendarEventFeed.class);
		final URL tBatchUrl = new URL(tBatchFeed.getLink(Link.Rel.FEED_BATCH, Link.Type.ATOM).getHref());
		final CalendarEventFeed tBatchResult = mCalendarService.batch(tBatchUrl, tBatchRequest);
		for (CalendarEventEntry tEntry : tBatchResult.getEntries()) {
			String tBatchId = BatchUtils.getBatchId(tEntry);
			if (BatchUtils.isSuccess(tEntry)) {
				tResult.success(tBatchId);
			} else {
				BatchStatus tBatchStatus = BatchUtils.getBatchStatus(tEntry);
				tResult.failure(String.format("%s failed(%s)", tBatchId, tBatchStatus.toString()));
			}
		}
		return tResult;
	}

	private List<CalendarEventEntry> selectAllEntries() throws IOException, ServiceException {
		final int tTotalResults = mCalendarService.getFeed(mUrl, CalendarEventFeed.class).getTotalResults();

		final Query tQuery = new Query(mUrl);
		tQuery.setMaxResults(tTotalResults);
		return mCalendarService.query(tQuery, CalendarEventFeed.class).getEntries();
	}
}
