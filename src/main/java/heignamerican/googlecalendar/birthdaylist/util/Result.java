package heignamerican.googlecalendar.birthdaylist.util;

import java.util.ArrayList;
import java.util.List;

public class Result<TLog> {
	private final String mTitle;
	private final List<TLog> mSuccessResult;
	private final List<TLog> mFailureResult;

	public Result(String aTitle) {
		mTitle = aTitle;

		mSuccessResult = new ArrayList<>();
		mFailureResult = new ArrayList<>();
	}

	public String getTitle() {
		return mTitle;
	}

	/**
	 * mutable object
	 */
	public List<TLog> getSuccessResult() {
		return mSuccessResult;
	}

	/**
	 * mutable object
	 */
	public List<TLog> getFailureResult() {
		return mFailureResult;
	}

	public <_TLog extends TLog> void success(_TLog aLog) {
		mSuccessResult.add(aLog);
	}

	public <_TLog extends TLog> void failure(_TLog aLog) {
		mFailureResult.add(aLog);
	}
}
