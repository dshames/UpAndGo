package model.logic;
/**
 * @author kobybs
 * @since 2-1-17
 */


import static org.junit.Assert.*;

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
public class SchedulerTest {

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
		System.out.println(s);

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
	public void test_a111() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final Schedule s = Scheduler.schedule(courses, new ArrayList<TimeConstraint>());
		System.out.println(s);

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
	public void test_a2() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		// List<Timetable> tl = Scheduler.getTimetablesList(courses);
		// System.out.println(tl.size());
		final Timetable t = Scheduler.getTimetablesList(courses, null).get(0);

		assert t.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)));
		assert t.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(13, 00)));
		assert t.getLessonGroups().get(2).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.TUESDAY, LocalTime.of(11, 00)));
		assert t.getLessonGroups().get(3).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.WEDNESDAY, LocalTime.of(14, 00)));

	}

	@Test
	public void test_b() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest2.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final Schedule s = Scheduler.schedule(courses, new ArrayList<TimeConstraint>());
		System.out.println(s);

		assert s.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)));
		assert s.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(12, 00)));

	}

	@Test
	public void test_b2() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest2.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final Timetable t = Scheduler.getTimetablesList(courses, null).get(0);

		assert t.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)));
		assert t.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(12, 00)));

	}

	@Test
	public void test_c() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest3.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final Schedule s = Scheduler.schedule(courses, new ArrayList<TimeConstraint>());
		System.out.println(s);

		assert s.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(14, 00)));
		assert s.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(12, 00)));

	}

	@Test
	public void test_c2() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest3.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final Timetable t = Scheduler.getTimetablesList(courses, null).get(0);

		assert t.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(14, 00)));
		assert t.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(12, 00)));

	}

	@Test
	public void test_d() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest4.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final Schedule s = Scheduler.schedule(courses, new ArrayList<TimeConstraint>());
		System.out.println(s);

		assertNull(s);
	}

	@Test
	public void test_d2() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest4.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		assert Scheduler.getTimetablesList(courses, null).isEmpty();

	}

	@Test
	public void test_e() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest7.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final Schedule s = Scheduler.schedule(courses, new ArrayList<TimeConstraint>());
		System.out.println(s);

		assert s.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)));
		assert s.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.WEDNESDAY, LocalTime.of(13, 00)));
		assert s.getLessonGroups().get(2).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.TUESDAY, LocalTime.of(11, 00)));
		assert s.getLessonGroups().get(3).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(14, 00)));

		// assertNull(s);
	}

	@Test
	public void test_e2() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest7.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final Timetable t = Scheduler.getTimetablesList(courses, null).get(0);

		assert t.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)));
		assert t.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.WEDNESDAY, LocalTime.of(13, 00)));
		assert t.getLessonGroups().get(2).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.TUESDAY, LocalTime.of(11, 00)));
		assert t.getLessonGroups().get(3).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(14, 00)));

		// assertNull(s);
	}
	
	@Test
	public void test_constraints1() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest7.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final List<TimeConstraint> constraints = new ArrayList<>();
		constraints.add(new TimeConstraint(
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)),
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 30))));
		final Timetable t = Scheduler.getTimetablesList(courses, null).get(0);

		assert t.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)));
		assert t.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.WEDNESDAY, LocalTime.of(13, 00)));
		assert t.getLessonGroups().get(2).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.TUESDAY, LocalTime.of(11, 00)));
		assert t.getLessonGroups().get(3).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(14, 00)));

		// assertNull(s);
	}
	
	@Test
	public void test_constraints2() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest7.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final List<TimeConstraint> constraints = new ArrayList<>();
		constraints.add(new TimeConstraint(
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)),
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 30))));
		final Timetable t = Scheduler.getTimetablesList(courses, constraints).get(0);

		assert t.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.TUESDAY, LocalTime.of(10, 00)));
		assert t.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.WEDNESDAY, LocalTime.of(13, 00)));
		assert t.getLessonGroups().get(2).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(11, 00)));
		assert t.getLessonGroups().get(3).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(14, 00)));

		// assertNull(s);
	}
	
	@Test
	public void test_constraints3() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest7.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final List<TimeConstraint> constraints = new ArrayList<>();
		constraints.add(new TimeConstraint(
				new WeekTime(Day.SUNDAY, LocalTime.of(9, 00)),
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 00))));
		final Timetable t = Scheduler.getTimetablesList(courses, constraints).get(0);

		assert t.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)));
		assert t.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.WEDNESDAY, LocalTime.of(13, 00)));
		assert t.getLessonGroups().get(2).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.TUESDAY, LocalTime.of(11, 00)));
		assert t.getLessonGroups().get(3).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(14, 00)));

		// assertNull(s);
	}
	
	@Test
	public void test_constraints4() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest7.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final List<TimeConstraint> constraints = new ArrayList<>();
		constraints.add(new TimeConstraint(
				new WeekTime(Day.SUNDAY, LocalTime.of(9, 00)),
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 01))));
		final Timetable t = Scheduler.getTimetablesList(courses, constraints).get(0);

		assertTrue( t.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.TUESDAY, LocalTime.of(10, 00))) );
		assert t.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.WEDNESDAY, LocalTime.of(13, 00)));
		assert t.getLessonGroups().get(2).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(11, 00)));
		assert t.getLessonGroups().get(3).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(14, 00)));


		// assertNull(s);
	}
	
	@Test
	public void test_constraints5() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest7.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final List<TimeConstraint> constraints = new ArrayList<>();
		constraints.add(new TimeConstraint(
				new WeekTime(Day.SUNDAY, LocalTime.of(9, 00)),
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 01))));
		constraints.add(new TimeConstraint(
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 00)),
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 05))));
		
		assertTrue ( Scheduler.getTimetablesList(courses, constraints).isEmpty() );
		

		// assertNull(s);
	}
	
	@Test
	public void test_constraints6() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest7.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		final List<TimeConstraint> constraints = new ArrayList<>();
		constraints.add(new TimeConstraint(
				new WeekTime(Day.SUNDAY, LocalTime.of(9, 00)),
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 01))));
		constraints.add(new TimeConstraint(
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 05)),
				new WeekTime(Day.SUNDAY, LocalTime.of(10, 50))));
		final Timetable t = Scheduler.getTimetablesList(courses, constraints).get(0);

		assertTrue( t.getLessonGroups().get(0).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.TUESDAY, LocalTime.of(10, 00))) );
		assert t.getLessonGroups().get(1).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.WEDNESDAY, LocalTime.of(13, 00)));
		assert t.getLessonGroups().get(2).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(11, 00)));
		assert t.getLessonGroups().get(3).getLessons().get(0).getStartTime()
				.equals(new WeekTime(Day.SUNDAY, LocalTime.of(14, 00)));


		// assertNull(s);
	}


	@Test
	public void test_scheduleTimetable1() {
		cr = new XmlCourseLoader("resources/testXML/schedulerTest.XML");

		final List<Course> courses = new ArrayList<>(cr.loadAllCoursesById().values());
		System.out.println(courses);

		System.out.println(Scheduler.getTimetablesList(courses, null));
	}

}
