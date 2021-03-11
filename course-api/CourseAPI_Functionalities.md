* There will be 3 types of resources: Topic, Course, Lesson 
* A Topic will have multiple courses, each course can have more than one lesson.
* For "Topic" Below are standard rest API end-point conventions (resource url and http methods):
	* GET	/topics		Gets all topics (root url should be resource name in plural)
	* GET	/topics/id	Gets the specific topic
	* POST	/topics		Creates a new topic (post body will have the new topic details)
	* PUT	/topics/id	Updates the topic (put body tells details to be updated)
	* DELETE	/topics/id	Deletes the topic
	