package heignamerican.googlecalendar.birthdaylist.googlecalendar.util;

public class GoogleCalendarInfo {
	private final String mUserAccount;
	private final String mPassword;
	private final String mCalUrl;

	public GoogleCalendarInfo(String aUserAccount, String aPassword, String aCalUrl) {
		mUserAccount = aUserAccount;
		mPassword = aPassword;
		mCalUrl = aCalUrl;
	}

	public String getUserAccount() {
		return mUserAccount;
	}

	public String getPassword() {
		return mPassword;
	}

	public String getCalendarUrl() {
		return mCalUrl;
	}
}

