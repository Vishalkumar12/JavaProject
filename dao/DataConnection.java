
package dao;
import java.sql.*;
public class DataConnection {
    static Connection  con=null;
    private DataConnection(){}
    static public Connection createConnection(){
        try{
            if(con==null){
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/money_management","root","rooted@1247");
                System.out.println("OK");
            }
            return con;
        }
        catch(Exception ex){
            System.out.println(ex);
            return con;
        }
    }
    
    public void closeConnection(){
        try{
            if(con!=null){
                con.close();
                con=null;
            }
        }
        catch(Exception ex){
            con=null;
        }
        
    }
    
    public static void main(String[] args){
        //DataConnection obj=new DataConnection();
        //obj.createConnection();
        DataConnection.createConnection();
    }
}
