/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceclasses;

import javax.servlet.http.Cookie;

/**
 *
 * @author Lenovo
 */
public class CookieService {
    public Cookie makeCookie(String cookieName,String cookieValue,int age)
    {
        Cookie tempCookie = new Cookie(cookieName,cookieValue);
        tempCookie.setMaxAge(age);
        return tempCookie;
    }
}
