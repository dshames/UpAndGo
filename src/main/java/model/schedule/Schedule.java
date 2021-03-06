package model.schedule;

import java.util.ArrayList;
import java.util.List;

import model.constraint.TimeConstraint;
import model.course.LessonGroup;

/**
 * @author kobybs
 * @author Nikita Dizhur	/ probably here by mistake?
 * @since 12-12-16
 * 
 * Class that represents study schedule.
 * 
 */
public class Schedule {
	private final List<LessonGroup> lessons;
	private final List<TimeConstraint> constraints;

	public Schedule() {
		lessons = new ArrayList<>();
		constraints = new ArrayList<>();
	}
	
	public boolean addConstraintsList(final List<TimeConstraint> constraintsList) {
		if(constraintsList == null)
			return true;
		
		for(final TimeConstraint newc : constraintsList){
			if (constraints.isEmpty()) {
				constraints.add(newc);
				continue;
			}
			for (final TimeConstraint oldc : constraints)
				if (oldc.isClashWith(newc))
					return false;
			constraints.add(newc);
		}
		return true;
	}
	/**
	 * 
	 * @param ¢
	 * @return true if lessonGroup can be added to lessond without causing a
	 *         collision
	 */
	public boolean addLesson(final LessonGroup ¢) {
		/*
		 * if(!lessons.contains(¢)) // add equals to lessonsgroup
		 * lessons.add(¢);
		 */
		/*if (lessons.isEmpty()) {
			lessons.add(¢);
			return true;
		}*/
		
		
		for (final TimeConstraint c : constraints)
			if (c.isClashWith(¢))
				return false;
		
		for (final LessonGroup l : lessons)
			if (l.isClashWith(¢))
				return false;
		lessons.add(¢);
		return true;
	}
	
	public Timetable getTimetable() {
		return new Timetable(lessons);

	}
	
	
	@Deprecated		// get it from the TimeTable not from here!
	public List<LessonGroup> getLessonGroups() {
		return lessons;
	}

	// to be removed after some progress on the project assures that there is no
	// need for that functionality
	/*public void removeLesson(final LessonGroup ¢) {
		lessons.remove(¢);
	}

	public void addConstraint(final TimeConstraint ¢) {
		if (!constraints.contains(¢))
			constraints.add(¢);
	}

	public void removeConstraint(final TimeConstraint ¢) {
		constraints.remove(¢);
	}

	public List<TimeConstraint> getConstraints() {
		return constraints;
	}

	public List<LessonGroup> getLessonGroups() {
		return lessons;
	}

	

	public boolean hasLesson(final LessonGroup ¢) {
		return lessons.contains(¢);
	}

	public boolean hasConstraint(final TimeConstraint ¢) {
		return constraints.contains(¢);
	}

	public boolean isLegalSchedule() {
		for (int i = 0; i < lessons.size(); ++i) {
			for (int j = i + 1; j < lessons.size(); ++j)
				if (lessons.get(i).isCLashWIth(lessons.get(j)))
					return false;
			for (final TimeConstraint ¢ : constraints)
				if (lessons.get(i).isCLashWIth(¢))
					return false;
		}
		return true;
	}*/

	@Override
	public String toString() {
		return lessons + "";
	}
	

}
