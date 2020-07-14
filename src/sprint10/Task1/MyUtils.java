package sprint10.Task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/test", "sa", "");
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        statement.execute("CREATE SCHEMA " + schemaName + ";");
        this.schemaName = schemaName;
    }

    public void dropSchema() throws SQLException {
        statement.execute("DROP SCHEMA " + schemaName + ";");
    }

    public void useSchema() throws SQLException {
        statement.execute("USE " + schemaName + ";");
    }

    public void createTableRoles() throws SQLException {
        statement.execute("CREATE TABLE Roles (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "roleName varchar(255) NOT NULL," +
                "PRIMARY KEY (id));"
        );
    }

    public void createTableDirections() throws SQLException {
        statement.execute("CREATE TABLE Directions (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "directionName varchar(255) NOT NULL," +
                "PRIMARY KEY (id));"
        );
    }

    public void createTableProjects() throws SQLException {
        statement.execute("CREATE TABLE Projects (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "projectName varchar(255) NOT NULL," +
                "directionId int NOT NULL," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (directionId) REFERENCES Directions(id));"
        );
    }

    public void createTableEmployee() throws SQLException {
        statement.execute("CREATE TABLE Employee (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "firstName varchar(255) NOT NULL," +
                "roleId int NOT NULL," +
                "projectId int NOT NULL," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (roleId) REFERENCES Roles(id)," +
                "FOREIGN KEY (projectId) REFERENCES Projects(id));"
        );
    }

    public void dropTable(String tableName) throws SQLException {
        statement.execute("DROP TABLE " + tableName + ";");
    }

    public void insertTableRoles(String roleName) throws SQLException {
        statement.execute(
                "INSERT INTO Roles(roleName) VALUES('" + roleName + "');"
        );
    }

    public void insertTableDirections(String directionName) throws SQLException {
        statement.execute(
                "INSERT INTO Directions(directionName) VALUES('" + directionName + "');"
        );
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        statement.execute(
                "INSERT INTO Projects(projectName, directionId) VALUES('" + projectName +
                        "," + directionName + "');" //TODO getDirectionName?
        );
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        statement.execute(
                "INSERT INTO Employee(firstName, roleId, projectId) VALUES('" + firstName +
                        "," + roleName +
                        "," + projectName + "');" //TODO getRoleId getProjectId?
        );
    }

    public int getRoleId(String roleName) throws SQLException {
        // code
    }

    public int getDirectionId(String directionName) throws SQLException {
        // code
    }

    public int getProjectId(String projectName) throws SQLException {
        // code
    }

    public int getEmployeeId(String firstName) throws SQLException {
        // code
    }

    public List<String> getAllRoles() throws SQLException {
        // code
    }

    public List<String> getAllDirestion() throws SQLException {
        // code
    }

    public List<String> getAllProjects() throws SQLException {
        // code
    }

    public List<String> getAllEmployee() throws SQLException {
        // code
    }

    public List<String> getAllDevelopers() throws SQLException {
        // code
    }

    public List<String> getAllJavaProjects() throws SQLException {
        // code
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
        // code
    }

}
