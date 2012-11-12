package heignamerican.googlecalendar.birthdaylist;

public class Person {
	private final String mName;
	private final String mBirthday;

	/**
	 * @param aName
	 * @param aBirthday
	 *            yyyy/MM/dd<br>
	 *            TODO require format check
	 */
	public Person(final String aName, final String aBirthday) {
		mName = aName;
		mBirthday = aBirthday;
	}

	public String getName() {
		return mName;
	}

	public String getBirthday() {
		return mBirthday;
	}

	@Override
	public String toString() {
		return "Person [Name=" + mName + ", Birthday=" + mBirthday + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mBirthday == null) ? 0 : mBirthday.hashCode());
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object aObject) {
		if (this == aObject)
			return true;
		if (aObject == null)
			return false;
		if (getClass() != aObject.getClass())
			return false;
		Person other = (Person) aObject;
		if (mBirthday == null) {
			if (other.mBirthday != null)
				return false;
		} else if (!mBirthday.equals(other.mBirthday))
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		return true;
	}

}
