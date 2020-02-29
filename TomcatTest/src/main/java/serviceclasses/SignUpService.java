/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceclasses;

import modelclasses.SignUpDetails;
import modelclasses.LoginDetails;

/**
 *
 * @author Lenovo
 */
public class SignUpService {
    public boolean passwordCheck(SignUpDetails formDetails)
    {
        boolean passwordFlag=false;
        
        if(!formDetails.getPassword().equals("")&&!formDetails.getCheckPassword().equals("")&&formDetails.getPassword().equals(formDetails.getCheckPassword()))
        {
            passwordFlag=true;
        }
        
        return passwordFlag;
    }
    
    public boolean usernameCheck(SignUpDetails formDetails,String dbUsername)
    {
        boolean usernameFlag=false;
        
        if(!formDetails.getUsername().equals("")&&!formDetails.getUsername().equals(dbUsername))
        {
            usernameFlag=true;
        }
        
        return usernameFlag;
    }
}
