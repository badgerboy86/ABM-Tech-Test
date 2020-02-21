# ABM Tech Test

## Contains 3 projects

## ExtractXmlValuesTest / ParseEDIFACTTest:
- these are stand alone java applications with main method. To run just import into Eclipse or another IDE and run as a standard Java application.

## WebServiceTest:

 - Maven Web App. To run import into eclipse > right click on  > maven > update project. Configured to run on java 1.8.
 - Click on the servers tab in eclipse and create a new localhost Apache Tomcat 9.0 server to host on.
 - Once server is configured - right click on project folder WebServiceTest > run as > run on server.
 
 - Now go to your browser e.g.  (http://localhost:8080/WebServiceTest/) (tested on Chrome)
 - Click the "payload.xml" link to test the web service status tests.
 - payload.xml file is located in - "/WebServiceTest/src/main/resources/payload.xml"
 
 just edit payload.xml file and click the link again  to test that Command and SiteID status messages appear correctly.