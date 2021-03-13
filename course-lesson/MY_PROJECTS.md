
# MY EXPERIMENTAL PROJECTS

#### Changing Spring Behavior through properties (applicaiotn.properties/yml/yaml)
##### When the spring boot server starts it looks for the properties file in the following order.
* First priority:  application.properties
* Second priority: application.yml
* Third priority:  application.yamn
* Last priority:   default value of 8080 for server port
* 
* We can use "application.proeprties" or "application.yml/yaml" in src/main/resources folder to change spring behavior like:
* Refer [list of application properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html) to tweak here at doc.spring.io
* Another list of a [older list (v 2.1.x) of properties](https://docs.spring.io/spring-boot/docs/2.1.x/reference/html/common-application-properties.html)
	* To change the servlet container port to 9999 for spring put
		* "server.port=9999" in "application.properties"
		* OR put the follwoing two lines in "application.yml"
		*	server:
			* port:  9999
		* Priority order: application.proeprties-->applicaiotn.yml
		* You may need to do a Maven-->Update Project to make the changes reflected before starting the application.
#### List of My Spring Boot Projects at GitHub
* For configuring **Kafka with Spring** check project "spring-kafka-1" under "workspace-spring-tool-suite"
* For using **external database like "postgress" with Spring** check project "linkedin_learning\learning-spring" under "workspace-spring-tool-suite"
* For using **self generated SSL cert with spring** app check "linkedin_learning\SpringBoot2\initial-boot-app" under "workspace-spring-tool-suite"
* In how to **generate SSL self signed certificate** Check the file "how_to_jks_to_pkcs2.txt" in project "linkedin_learning\SpringBoot2\initial-boot-app" - how to generate SSL self signed certificate.
* For **switching execution profile from "dev" to "prod" at runtime** (while starting the spring boot server - check "linkedin_learning\SpringBoot2\initial-boot-app" project 
* For **switching from external db to internal db in Spring** check "linkedin_learning\SpringBoot2\room-web-app"
* For using **DB fields differently named from the POJO model attributes** refer "linkedin_learning\SpringBoot2\room-web-app"
