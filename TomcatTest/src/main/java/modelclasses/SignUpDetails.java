/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelclasses;

/**
 *
 * @author Lenovo
 */
public class SignUpDetails {
    private String username;
    private String password;
    private String checkPassword;
    
    public SignUpDetails(String username,String password,String checkPassword)
    {
        this.username=username;
        this.password=password;
        this.checkPassword=checkPassword;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getCheckPassword()
    {
        return checkPassword;
    }
    
    public void setUsername(String username)
    {
        this.username=username;
    }
    
    public void setPassword(String password)
    {
        this.password=password;
    }
    
    public void setCheckPassword(String checkPassword)
    {
        this.checkPassword=checkPassword;
    }
}