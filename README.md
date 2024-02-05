SEARCH-ENGINE-FEATURE-TEST

REPO CREATION:
mvn archetype:generate -DgroupId=com.demo -DartifactId=search-infinite -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Repo Build:
mvn clean install -DskipTests

Command Line Test Execution:
Maven Test Execution:
mvn clean test -Dtest=<TestClassName>
mvn clean test -DsuiteXmlFile=<TestNG_XML_FILE>

Report:
allure serve allure-results
