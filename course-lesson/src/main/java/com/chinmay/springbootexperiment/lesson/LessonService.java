package com.chinmay.springbootexperiment.lesson;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String courseId){
		List<Lesson> lesson_list = new ArrayList<Lesson>();
		lessonRepository.findByCourseId(courseId).forEach(lesson_list::add);
		return lesson_list;
	}
	
	public Lesson getLesson(String id) {
		return lessonRepository.findById(id).get();
	}

	public void addLesson(Lesson course) {
		lessonRepository.save(course);
	}

	public void updateLesson(Lesson course) {
		lessonRepository.save(course);
	}

	public void deleteLesson(String id) {
		lessonRepository.deleteById(id);
	}

}
