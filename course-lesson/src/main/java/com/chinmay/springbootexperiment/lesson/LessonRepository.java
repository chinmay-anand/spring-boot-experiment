package com.chinmay.springbootexperiment.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, String> {
	List<Lesson> findByCourseId(String selected_course_id);
}
