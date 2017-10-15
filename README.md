### Build Requirements

  - Java 8 and up.
  - Maven 
  

### Steps to BUILD and RUN
  1. Clone the project using git clone command or download project using direct link
  2. Get into <PROJECT_ROOT_FOLDER>(RestClient)
  3. Run below command to build executable jar
  ```sh
  mvn clean install assembly:single
  ```
  4. To run client, get into target directory and run below command:
  ```sh
  java -jar restclient-0.0.1-jar-with-dependencies.jar
  ```
  
  Note: By default, for uploading, client uses seeded_excel_for_java_test.xlsx present in target directory
