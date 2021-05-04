package lapr.project.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Fuel;
import lapr.project.model.Motorization;
import lapr.project.model.Type;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author vdjol
 */
public class DataBase {
    
    private final String jdbcUrl;
    private final String username;
    private final String psswrd;
    private Connection connection;
    private CallableStatement callStmt;
    private ResultSet rSet;

    /**
     * Constructs an instance of the "Database", receiving, by parameters, the URL
     * of the BD and user credentials.
     * "jdbc:@oracle:thin://@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl"
     * username = "LAPR3_G01"
     * "grupo01"
     *
     * @param jdbcUrl the URL of the DB.
     * @param username the name of the user.
     * @param password the password of the user.
     */
    public DataBase() {
        this.jdbcUrl = "jdbc:oracle:thin://@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl";
        this.username = "LAPR3_G01";
        this.psswrd = "grupo01";
        connection = null;
        callStmt = null;
        rSet = null;
    }
    
        public DataBase(String username, String password) {
        this.jdbcUrl = "";
        this.username = username;
        this.psswrd = password;
        connection = null;
        callStmt = null;
        rSet = null;
    }

    /**
     * connects to database
     * @throws java.sql.SQLException
     */
    public void openConnection(){
        try {
            OracleDataSource ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            connection = ds.getConnection(username, psswrd);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Closes the objects "ResultSet", "CallableStatement" and "Connection", and
     * returns the error message of some operations if not
     * succeeded. Else returns the empty "string".
     * @return 
     */
    public String closeAll() {

        StringBuilder message = new StringBuilder("");

        if (rSet != null) {
            try {
                rSet.close();
            } catch (SQLException ex) {
                message.append(ex.getMessage());
                message.append("\n");
            }
            rSet = null;
        }

        if (callStmt != null) {
            try {
                callStmt.close();
            } catch (SQLException ex) {
                message.append(ex.getMessage());
                message.append("\n");
            }
            callStmt = null;
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                message.append(ex.getMessage());
                message.append("\n");
            }
            connection = null;
        }
        return message.toString();
    }
    
    /**
     * Stored procedure for Junction.
     *
     * Add a specific junction to a table "Junction".
     *
     * @param nodeID
     */
    public void insertJunction(String nodeID) {

        try {
            callStmt = connection.prepareCall("{ call INSERT_JUNCTION(?) }");

            callStmt.setString(1, nodeID);

            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Stored procedure for Project.
     *
     * Add a specific project to a table "project".
     *
     * @param projectName
     * @param Description
     */
    public void insertProject(String projectName, String Description) {

        try {
            callStmt = connection.prepareCall("{ call INSERTPROJECT(?,?) }");
            callStmt.setString(1, projectName);
            callStmt.setString(2, Description);
            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param project
     * @param travelTime
     * @param energy
     * @param tollCost 
     */
    public void saveResults(String project, String travelTime, double energy, double tollCost) {
        try {
          
            callStmt = connection.prepareCall("{ call INSERTRESULTS(?,?,?,?) }");
            callStmt.setString(1, travelTime);
            callStmt.setDouble(2, energy);
            callStmt.setDouble(3, tollCost);
            callStmt.setString(4, project);
            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * 
     * @param name
     * @param projName 
     */
    public void insertRoad(String name, String projName) {
        
        try {
            callStmt = connection.prepareCall("{ call INSERTROAD(?,?) }");
            callStmt.setString(1, name);
            callStmt.setString(2, projName);
            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void insertSection(Boolean direction, String name, String id, String id0) {
        try {
            callStmt = connection.prepareCall("{ call INSERTSECTION(?,?,?,?) }");
            callStmt.setBoolean(1, direction);
            callStmt.setString(2, name);
            callStmt.setString(3, id);
            callStmt.setString(4, id0);
            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertTollFare(String name, Double get, Double get0, Double get1) {
        try {
            callStmt = connection.prepareCall("{ call INSERTTOLLFARE(?,?,?,?) }");
            callStmt.setString(1, name);
            callStmt.setDouble(2, get);
            callStmt.setDouble(3, get0);
            callStmt.setDouble(4, get1);
            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertGantryFare(Double get, Double get0, Double get1) {
        try {
            callStmt = connection.prepareCall("{ call INSERTGANTRYFARE(?,?,?) }");
            callStmt.setDouble(1, get);
            callStmt.setDouble(2, get0);
            callStmt.setDouble(3, get1);
            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertSegment(int id, double initialHeight, double finalHeight, double length, int maxSpeed, int minSpeed, double windDirection, double windSpeed) {
        try {
            callStmt = connection.prepareCall("{ call INSERTSEGMENT(?,?,?,?,?,?,?,?) }");
            callStmt.setInt(1, id);
            callStmt.setDouble(2, initialHeight);
            callStmt.setDouble(3, finalHeight);
            callStmt.setDouble(4, length);
            callStmt.setInt(5, maxSpeed);
            callStmt.setInt(6, minSpeed);
            callStmt.setDouble(7, finalHeight);
            callStmt.setDouble(8, length);
            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertVehicle(String name, String description, double mass, double load, double frontalArea, double frontalArea0, double dragCoefficient, 
            double resistanceCoefficient, double energyRatio, double wheelSize, int min_rpm, int max_rpm, double finalDriveRatio, String motorization, 
            String name0, int tollClass, String type, String fuel) {
        try {
            callStmt = connection.prepareCall("{ call INSERTSEGMENT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            callStmt.setString(1, name);
            callStmt.setString(2, description);
            callStmt.setDouble(3, mass);
            callStmt.setDouble(4, load);
            callStmt.setDouble(5, frontalArea);
            callStmt.setDouble(6, frontalArea0);
            callStmt.setDouble(7, dragCoefficient);
            callStmt.setDouble(8, resistanceCoefficient);
            callStmt.setDouble(9, energyRatio);
            callStmt.setDouble(10, wheelSize);
            callStmt.setDouble(11, min_rpm);
            callStmt.setInt(12, max_rpm);
            callStmt.setDouble(13, finalDriveRatio);
            callStmt.setString(14, motorization);
            callStmt.setString(15, name0);
            callStmt.setInt(16, tollClass);
            callStmt.setString(17, type);
            callStmt.setString(18, fuel);
            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
