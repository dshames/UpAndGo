package model.course;

/**
 * 
 * @author Nikita Dizhur
 * @since 11-01-17
 * 
 * A small class for storing course name and number, without specifying all other details.
 * 
 */
public class CourseId implements Comparable<CourseId> {

	@Override
	public int hashCode() {
		return 31 * ((name == null ? 0 : name.hashCode()) + 31) + (number == null ? 0 : number.hashCode());
	}

	@Override
	public boolean equals(final Object o) {
		if (o == this)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final CourseId other = (CourseId) o;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	public final String name;
	public final String number;

	public CourseId(final String cNum, final String cName) {
		name = cName;
		number = cNum;
	}

	@Override
	public int compareTo(final CourseId ¢) {
		return number.compareTo(¢.number);
	}

}
