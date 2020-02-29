/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceclasses;

import modelclasses.LoginDetails;

/**
 *
 * @author Lenovo
 */
public class LoginService {
    public boolean loginCheck(LoginDetails formDetails,LoginDetails dbDetails)
    {
        boolean usernameFlag=false,passwordFlag=false;
        
        if(!formDetails.getUsername().equals("")&&formDetails.getUsername().equals(dbDetails.getUsername()))
        {
            usernameFlag=true;
        }
        
        if(!formDetails.getPassword().equals("")&&formDetails.getPassword().equals(dbDetails.getPassword()))
        {
            passwordFlag=true;
        }
        
        return usernameFlag&&passwordFlag;
    }
}
