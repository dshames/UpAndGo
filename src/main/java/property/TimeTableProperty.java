package property;

/**
 * 
 * @author Nikita Dizhur
 * @since 12-01-2017
 * 
 * Class that represents all types of properties that {@link #TimeTableController} can ask to load from {@link #TimeTableModel}.
 * 
 */
public class TimeTableProperty {

	public static final String SCHEDULE = "current_schedule";
	public static final String SCHEDULE_INDEX = "schedule_index_out_of_number_of_schedules";
	public static final String NO_SCHEDULE = "no_schedule_was_found";
	public static final String NO_COURSES = "no_courses_were_selected";
}
