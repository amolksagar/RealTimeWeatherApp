Real Time Weather Application.

Weather Source: OpenWeatherMap API

1)To download/clone this project onto your local machine, run the below command in git bash(command line utility to download git projects)

 git clone https://github.com/amolksagar/techRepository.git
 
 Also you can download it as a zip file from https://github.com/amolksagar/techRepository directly

2) use  cd realTimeWeatherApp  command and navigate into folder "realTimeWeatherApp" (directory containing pom.xml)

3) use  mvn clean package to compile the project (you can run this command from command prompt)

4) You will find the war file in the above mentioned project folder(realTimeWeatherApp) under target\realTimeWeatherApp-1.0.war

4) Deploy this war file on application server (testing has been done on tomcat)

5) Use the below URL to access the home page of the project.
	http://localhost:8080/realTimeWeatherApp-1.0/
