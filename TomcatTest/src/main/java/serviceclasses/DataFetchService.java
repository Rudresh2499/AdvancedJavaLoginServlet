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
public class DataFetchService {
    public ResultSet getLoginData(Connection dbConnection)
            throws SQLException
    {
        Statement stmt=dbConnection.createStatement();
        ResultSet dbData=stmt.executeQuery("select * from login_details");
        return dbData;
    }
}
