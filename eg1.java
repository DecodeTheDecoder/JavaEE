import java.sql.*;
class psp{
public static void main(String gg[]){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/tmdb","tmdbuser","tmdbuser");
Statement s= c.createStatement();
s.executeUpdate("insert into designation (title) values ('Supervisor')");
s.close();
c.close();
System.out.println("Supervisor inserted");
}catch(Exception e){

}
}


}