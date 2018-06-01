/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegularExp
{

	  private Pattern pattern;
	  private Matcher matcher;

	  private static final String PASSWORD_PATTERN =
              "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
          

	  public RegularExp()
          {
		  pattern = Pattern.compile(PASSWORD_PATTERN);
	  }
	  public boolean validate(final String password)
          {
        	  matcher = pattern.matcher(password);
    		  return matcher.matches();
	  }
}