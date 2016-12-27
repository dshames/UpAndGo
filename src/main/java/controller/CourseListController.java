package controller;

import java.awt.event.ActionEvent;

import command.CourseCommand;
import model.CourseModel;
import view.CourseListView;

/*
 * Corresponds to the View that shows list of available courses, lets to pick/drop them and peep inside them.
 * 
 */
public class CourseListController implements Controller{

	protected CourseModel model;
	protected CourseListView view;
	
	public CourseListController(CourseModel model, CourseListView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent ¢) {
		if (¢.getActionCommand().equals(CourseCommand.DETAILS))
			model.getCourseByName(view.getHighlightedCourse());
		else {
			if (!¢.getActionCommand().equals(CourseCommand.GET_QUERY))
				throw new IllegalArgumentException();
			model.loadQuery(view.getQuery());
		}
	}
}
