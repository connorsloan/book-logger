# Book Logger

- A JSP application that allows the user to create entries of books they have read.
- User can enter the title, author, and notes, and they can delete entries.
- The app also displays the time at which an entry was created.

# Installation/Setup:

1. Clone the repository
'''bash
git clone https://github.com/connorsloan/book-logger
'''

1. Navigate to the repository

3. Build project
'''bash
mvn clean install
'''

4. Copy .war file to Tomcat /webapps folder
'''bash
# Change Tomcat version if necessary
cp target/BookLogger-1.0-SNAPSHOT.war .../apache-tomcat-10.1.31/webapps
'''

5. Navigate to Tomcat /bin directory

7. Start Tomcat
Windows
'''bash
./startup.bat
'''

Mac
'''bash
./startup.sh
'''

8. Open your browser and go to http://localhost:8080/BookLogger-1.0-SNAPSHOT/index.jsp
