package model.logic;
/**
 * @author kobybs
 * @since 2-1-17
 */

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import logic.Scheduler;
import model.constraint.TimeConstraint;
import model.course.Course;
import model.course.Day;
import model.course.WeekTime;
import model.loader.CourseLoader;
import model.loader.XmlCourseLoader;
import model.schedule.Schedule;
import model.schedule.Timetable;

@SuppressWarnings({"static-method","deprecation"})
public class scheduleTimetablesTest {

	CourseLoader cr;

	@After
	public void after() {
		System.out.println("***");
	}

	@Test
	public void test_a() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final Schedule s = Scheduler.schedule(courses, new ArrayList<TimeConstraint>());
		System.out.println("Schedule: " + s);

		assert s.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)));
		assert s.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(13, 00)));
		assert s.getLessonGroups().get(2).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.TUESDAY, LocalTime.of(11, 00)));
		assert s.getLessonGroups().get(3).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.WEDNESDAY, LocalTime.of(14, 00)));

	}

	@Test
	public void test_scheduleTimetable1() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final List<Timetable> tl = Scheduler.getTimetablesList(courses, null);
		System.out.println(tl);

		assert tl.size() == 4;
		for (final Timetable ¢ : tl)
			System.out.println("rank: " + ¢.getRankOfDaysoff());
	}

}
