package model.constraint;

import java.util.List;

import model.course.Course;
import model.course.Lesson;
import model.course.LessonGroup;
import model.course.WeekTime;

public class TimeConstraint extends Constraint {
	private WeekTime startTime;
	private WeekTime endTime;
	
	public TimeConstraint(WeekTime startTime, WeekTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	
	@Override
	public boolean canMeetConstraint(Course c) {
		for(LessonGroup ¢ : c.getLectures())
			if (!clashWithLessonGroup(¢))
				return true;
		return false;
	}

	@Override
	public List<LessonGroup> groupsMeetsConstraint(Course c) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean clashWithLessonGroup(LessonGroup lg){
		for(Lesson l : lg.getLessons()){
			if(clashWithLesson(l))
				return false;
		}
		return true;
	}
	
	private boolean clashWithLesson(Lesson l){
		if(  (startTime.compareTo(l.getStartTime()) == 0 ||
				startTime.compareTo(l.getStartTime()) == 1) 
			&& 
			startTime.compareTo(l.getEndTime()) == -1)
			return false;
		
		if(  (
				endTime.compareTo(l.getStartTime()) == 1) 
			&& 
			endTime.compareTo(l.getEndTime()) == -1 ||
			endTime.compareTo(l.getEndTime()) == 0)
			return false;
		
		return true;

	}

	public WeekTime getStartTime() {
		return startTime;
	}

	public WeekTime getEndTime() {
		return endTime;
	}

}
