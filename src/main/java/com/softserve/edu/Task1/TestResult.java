package sprint10.Task1;

import java.sql.SQLException;
import java.util.List;

public class TestResult {
    public static void main(String[] args) throws SQLException {
        MyUtils myUtils = new MyUtils();
        try {
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema("TestSchema");
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableRoles("DevOps");
            myUtils.insertTableRoles("QC");
            List<String> roles = myUtils.getAllRoles();
            System.out.println(roles.toString());

            myUtils.createTableDirections();
            myUtils.insertTableDirections("Java");
            myUtils.insertTableDirections("Python");
            myUtils.insertTableDirections(".Net");
            List<String> directions = myUtils.getAllDirestion();
            System.out.println(directions.toString());

            myUtils.createTableProjects();
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableProjects("Sun", "Java");
            myUtils.insertTableProjects("Mars", "Python");
            List<String> projects = myUtils.getAllProjects();
            System.out.println(projects.toString());

            myUtils.createTableEmployee();
            myUtils.insertTableEmployee("Ivan", "Developer", "MoonLight");
            myUtils.insertTableEmployee("Petro", "Developer","Sun");
            myUtils.insertTableEmployee("Stepan", "Developer","Mars");
            myUtils.insertTableEmployee("Andriy", "DevOps","Mars");
            myUtils.insertTableEmployee("Vasyl", "DevOps","Mars");
            myUtils.insertTableEmployee("Ira", "Developer","MoonLight");
            myUtils.insertTableEmployee("Anna", "QC","MoonLight");
            myUtils.insertTableEmployee("Olya", "QC","Sun");
            myUtils.insertTableEmployee("Maria", "QC","Mars");
            List<String> employees = myUtils.getAllEmployee();
            System.out.println(employees.toString());

            List<String> developers = myUtils.getAllDevelopers();
            System.out.println(developers.toString());

            List<String> javaProjects = myUtils.getAllJavaProjects();
            System.out.println(javaProjects.toString());

            List<String> javaDevelopers = myUtils.getAllJavaDevelopers();
            System.out.println(javaDevelopers.toString());

            myUtils.dropSchema();
            myUtils.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
