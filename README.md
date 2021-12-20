**Introduction**
-------
Automation framework for regression testing of Hoge bank.

**Requirements:**
-------------
- Java JDK_1.8
- Maven version 3.6+


**How to run the framework**
-------------------
1. Please make sure that JAVA_HOME and MAVEN_HOME path are set in environment variables 
2. Add both paths in environment variable 'Path’.
3. Open the project using IDE (in my case I am using intelliJIDEA).
4. It should automatically resolve the maven dependency.
5. If dependency is not resolved, reload the project from maven.(right click the project in project window > click Maven > reload project.
6. After the dependency is resolved, Run the HogeBankTest.java  from src/test/java/Runner .
    1. HogeBankTest.java is the main runner file to run the whole framework.

**Report**
----------------
1. Html report would be found inside **~test-output\SparkReport**
2. Pdf report would be found inside **~test-output\PdfReport**
