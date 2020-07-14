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
        connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
//        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
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
        this.schemaName = schemaName;
        statement.execute("CREATE SCHEMA " + schemaName + ";");
    }

    public void dropSchema() throws SQLException {
        statement.execute("DROP SCHEMA " + this.schemaName + " CASCADE;");
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
                        "','" + getDirectionId(directionName) + "');"
        );
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        statement.execute(
                "INSERT INTO Employee(firstName, roleId, projectId) VALUES('" + firstName +
                        "','" + getRoleId(roleName) +
                        "','" + getProjectId(projectName) + "');"
        );
    }

    public int getRoleId(String roleName) throws SQLException {
        int result = -1;
        statement.execute("SELECT ID from ROLES WHERE ROLENAME = '" + roleName + "';");
        if (statement.getResultSet().next()) {
            result = statement.getResultSet().getInt("id");
        }
        return result;
    }

    public int getDirectionId(String directionName) throws SQLException {
        int result = -1;
        statement.execute("SELECT ID from DIRECTIONS WHERE DIRECTIONNAME = '" + directionName + "';");
        if (statement.getResultSet().next()) {
            result = statement.getResultSet().getInt("id");
        }
        return result;
    }

    public int getProjectId(String projectName) throws SQLException {
        int result = -1;
        statement.execute("SELECT ID from PROJECTS WHERE PROJECTNAME = '" + projectName + "';");
        if (statement.getResultSet().next()) {
            result = statement.getResultSet().getInt("id");
        }
        return result;
    }

    public int getEmployeeId(String firstName) throws SQLException {
        int result = -1;
        statement.execute("SELECT ID from EMPLOYEE WHERE firstName = '" + firstName + "';");
        if (statement.getResultSet().next()) {
            result = statement.getResultSet().getInt("id");
        }
        return result;
    }

    public List<String> getAllRoles() throws SQLException {
        List<String> rolesList = new ArrayList<>();
        statement.execute("SELECT DISTINCT roleName from ROLES;");
        while (statement.getResultSet().next()) {
            rolesList.add(statement.getResultSet().getString("roleName"));
        }
        return rolesList;
    }

    public List<String> getAllDirestion() throws SQLException {
        List<String> directionList = new ArrayList<>();
        statement.execute("SELECT DISTINCT directionName from Directions;");
        while (statement.getResultSet().next()) {
            directionList.add(statement.getResultSet().getString("directionName"));
        }
        return directionList;
    }

    public List<String> getAllProjects() throws SQLException {
        List<String> projectList = new ArrayList<>();
        statement.execute("SELECT DISTINCT projectName from Projects;");
        while (statement.getResultSet().next()) {
            projectList.add(statement.getResultSet().getString("projectName"));
        }
        return projectList;
    }

    public List<String> getAllEmployee() throws SQLException {
        List<String> employeeList = new ArrayList<>();
        statement.execute("SELECT DISTINCT firstName from Employee;");
        while (statement.getResultSet().next()) {
            employeeList.add(statement.getResultSet().getString("firstName"));
        }
        return employeeList;
    }

    public List<String> getAllDevelopers() throws SQLException {
        List<String> developersList = new ArrayList<>();
        statement.execute(
                "SELECT firstName from Employee WHERE roleId =" + getRoleId("Developer") + ";"
        );
        while (statement.getResultSet().next()) {
            developersList.add(statement.getResultSet().getString("firstName"));
        }
        return developersList;
    }

    public List<String> getAllJavaProjects() throws SQLException {
        List<String> projectsList = new ArrayList<>();
        statement.execute(
                "SELECT  projectName from Projects WHERE directionId =" + getDirectionId("Java") + ";"
        );
        while (statement.getResultSet().next()) {
            projectsList.add(statement.getResultSet().getString("projectName"));
        }
        return projectsList;
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
        List<String> javaDevelopersList = new ArrayList<>();
        statement.execute(
                "SELECT firstName from Employee WHERE roleId = " +
                        getRoleId("Developer") +
                        " AND projectId IN (SELECT id FROM Projects WHERE directionId = " +
                        getDirectionId("Java") + ");"
        );
        while (statement.getResultSet().next()) {
            javaDevelopersList.add(statement.getResultSet().getString("firstName"));
        }
        return javaDevelopersList;
    }
}
