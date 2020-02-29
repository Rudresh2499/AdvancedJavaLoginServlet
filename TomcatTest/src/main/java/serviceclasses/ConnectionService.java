/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceclasses;

import java.sql.*;
/**
 *
 * @author Lenovo
 */
public class ConnectionService {
    public Connection getDbConnection(String driver,String url,String username,String password)
            throws ClassNotFoundException,SQLException
    {
        Class.forName(driver);
        Connection dbConnection = DriverManager.getConnection(url,username,password);
        return dbConnection;
    }
}
