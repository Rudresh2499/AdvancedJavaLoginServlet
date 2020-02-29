/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceclasses;

import java.sql.*;
import modelclasses.SignUpDetails;

/**
 *
 * @author Lenovo
 */
public class DataInsertService {
    public int insertCredentials(Connection dbConnection,SignUpDetails formDetails)
            throws SQLException
    {
        PreparedStatement pst = dbConnection.prepareStatement("insert into login_details (username,password) values(?,?)");
        pst.setString(1,formDetails.getUsername());
        pst.setString(2,formDetails.getPassword());
        return pst.executeUpdate(); 
    }
}
