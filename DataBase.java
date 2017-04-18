package DBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Pawan on 08-04-2017.
 */
public class DataBase {

    private Connection connection;
    private ResultSet result;
    private Statement statement;

    DataBase()
    {
        connection=null;
        createConnection();
    }

    private void createConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            statement=connection.createStatement();
        }
        catch (Exception e){e.printStackTrace();}
    }

    public void insertAirport(String A_id, String A_name, String A_add)
    {
        try{statement.executeUpdate("INSERT INTO Airport values (" + A_id + ", '" + A_name + "', '" + A_add + "')");}
        catch (Exception e){e.printStackTrace();}
    }

    public void insertEmployee(String E_id, String E_Name, String E_Add, String E_Salary, String E_Airport)
    {
        try{statement.executeUpdate("INSERT INTO Employees VALUES(" + E_id + ", '" + E_Name + "', '" + E_Add + "', '" + E_Salary + "', '" + E_Airport + "')");}
        catch (Exception e){e.printStackTrace();}
    }

    public void insertTicket(String T_TID, String T_RID, String T_PID, String T_Price)
    {
        try{statement.executeUpdate("INSERT INTO Tickets VALUES(" + T_TID + ", " + T_RID + ", " + T_PID + ", " + T_Price + ")");}
        catch (Exception e){e.printStackTrace();}
    }

    public void insertFlight(String F_ID, String Capacity, String Rating)
    {
        try{statement.executeUpdate("INSERT INTO Flights VALUES(" + F_ID + "," + Capacity + ", " + Rating + ")");}
        catch (Exception e){e.printStackTrace();}
    }

    public void insertPassenger(String P_ID, String P_Name, String P_Add, String P_FID)
    {
        try{statement.executeUpdate("INSERT INTO Passengers VALUES (" + P_ID + ", '" + P_Name + "', '" + P_Add + "', " + P_FID  + ")");}
        catch (Exception e){e.printStackTrace();}
    }

    public void insertRoute(String R_ID, String R_Source, String R_Destination, String Direct)
    {
        try{statement.executeUpdate("INSERT INTO Routes VALUES(" + R_ID + ", '" + R_Source + "', '" + R_Destination + "', '" + Direct + "')");}
        catch (Exception e){e.printStackTrace();}
    }

    public void insertFollows(String RID, String FID, String Time, String Date)
    {
        try{statement.executeUpdate("INSERT INTO Follows VALUES(" + RID + ", " + FID + ", '" + Time + "', '" + Date + "')");}
        catch (Exception e){e.printStackTrace();}
    }

    public void insertServe(String EID, String PID, String Rating)
    {
        try{statement.executeUpdate("INSERT INTO Serve VALUES(" + EID + ", " + PID + ", '" + Rating + "');");}
        catch (Exception e){e.printStackTrace();}
    }

    public void insertHas(String AID, String FID)
    {
        try{statement.executeUpdate("INSERT INTO Has VALUES(" + AID + ", " + FID + ")");}
        catch (Exception e){e.printStackTrace();}
    }

    public void insertManager(String username, String Password)
    {
        try{statement.executeUpdate("INSERT INTO Manager VALUES('" + username + "', '" + Password + "');");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deleteAirport(String AID)
    {
        try{statement.executeUpdate("DELETE FROM Airport WHERE A_ID = " + AID + ";");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deleteEmployee(String EID)
    {
        try{statement.executeUpdate("DELETE FROM Employees WHERE EID = " + EID + ";");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deleteTicket(String TID)
    {
        try{statement.executeUpdate("DELETE FROM Tickets WHERE TID = " + TID + ";");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deleteFlight(String FID)
    {
        try{statement.executeUpdate("DELETE FROM Flights WHERE FID = " + FID + ";");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deleteRoute(String RID)
    {
        try{statement.executeUpdate("DELETE FROM Routes WHERE RID = " + RID + ";");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deletePassenger(String PID)
    {
        try{statement.executeUpdate("DELETE FROM Passengers WHERE PID = " + PID + ";");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deleteFollows(String RID, String FID)
    {
        try{statement.executeUpdate("DELETE FROM Follows WHERE RID = " + RID + " and FID = " + FID + ";");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deleteHas(String AID, String FID)
    {
        try{statement.executeUpdate("DELETE FROM Has WHERE AID = " + AID + " and FID = " + FID + ";");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deleteServe(String EID, String PID)
    {
        try{statement.executeUpdate("DELETE FROM Serve WHERE EID = " + EID + " and PID = " + PID + ";");}
        catch (Exception e){e.printStackTrace();}
    }

    public void deleteManager(String username)
    {
        try{statement.executeUpdate("DELETE FROM Manager WHERE Username = '" + username + "';");}
        catch (Exception e){e.printStackTrace();}
    }

    public int login(String user, String password)
    {
        try{
            result=statement.executeQuery("SELECT Password FROM Manager WHERE Username = '" + user + "';");
            while(result.next())
            {
                if(password.equals(result.getString(1))) return 1;
            }
        }
        catch (Exception e){e.printStackTrace();}
        return 0;
    }

    public ResultSet cheapFlight(String src, String des)
    {
        try{result = statement.executeQuery("SELECT F.FID, F.Date, F.Time, min(Price) from Follows F, Routes R WHERE F.RID = R.RID and R.Source = '" + src + "' and R.Destination = '" + des + "';");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery0()
    {
        try {result = statement.executeQuery("SELECT *FROM Airport");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery1()
    {
        try {result = statement.executeQuery("SELECT *FROM Employees");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery2()
    {
        try {result = statement.executeQuery("SELECT *FROM Tickets");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery3()
    {
        try {result = statement.executeQuery("SELECT *FROM Flights");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery4()
    {
        try {result = statement.executeQuery("SELECT *FROM Passengers");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery5()
    {
        try {result = statement.executeQuery("SELECT *FROM Routes");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery6()
    {
        try {result = statement.executeQuery("SELECT *FROM Follows");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery7()
    {
        try {result = statement.executeQuery("SELECT *FROM Has");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery8()
    {
        try {result = statement.executeQuery("SELECT *FROM Serve");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery10(String src, String des)
    {
        try{result = statement.executeQuery("SELECT P.PID, P.Name from Passengers P, Tickets T, Routes R WHERE P.PID = T.PID and T.RID = R.RID and R.Source = '" + src + "' and R.Destination = '" + des + "';");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery11(String src, String des)
    {
        try{result=statement.executeQuery("SELECT F.FID, R.Source, R.Destination FROM Routes R, Follows F WHERE R.RID=F.RID and R.Direct='Yes' and F.FID IN (SELECT F.FID FROM Follows F,Routes R WHERE F.RID=R.RID and Source='" + src + "' and Destination='" + des + "');");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery12()
    {
        try{result=statement.executeQuery("SELECT E.AID, E.EID, E.Name, S.Rating FROM Employees E, Serve S WHERE E.EID=S.EID and S.Rating = (SELECT max(Rating) FROM Serve) GROUP BY E.AID;");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery13(String Per)
    {
        try{result=statement.executeQuery("SELECT F.FID FROM Flights F, (SELECT FID, COUNT(*) as t FROM Tickets GROUP BY FID) T WHERE F.FID=T.FID AND T.t > ((F.Capacity/100)*" + Integer.parseInt(Per) + ");");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery14()
    {
        try{result=statement.executeQuery("SELECT F.FID, MAX(T.t) FROM Flights F, (SELECT Te.FID, SUM(Price) as t FROM Tickets Te GROUP BY Te.FID) AS T WHERE F.FID=T.FID;");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery15(String AID)
    {
        try{result=statement.executeQuery("SELECT EID, Name FROM Employees WHERE AID = " + AID + ";");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery16(String EID)
    {
        try{result=statement.executeQuery("SELECT S.EID, P.PID, P.Name, S.Rating FROM Passengers P, Serve S WHERE P.PID=S.PID AND S.EID = " + EID + ";");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery17(String PID, String name)
    {
        try{result=statement.executeQuery("SELECT T.TID, T.FID, F.Date, F.Time FROM Tickets T,Routes R, Follows F, Passengers P WHERE R.RID = T.RID AND R.RID=F.RID AND T.PID = " + PID + " AND P.Name = '" + name + "';");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery18(String AID, String Src, String Des)
    {
        try{result=statement.executeQuery("SELECT H.AID, F.FID, F.Date, F.Time, F.Price from Routes R, Follows F, Has H WHERE R.RID = F.RID AND F.FID = H.FID AND R.Source = '" + Src + "' AND R.Destination = '" + Des + "' AND H.AID = " + AID + ";");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery19(String AID, String Src, String Des)
    {
        try{result=statement.executeQuery("SELECT H.AID, F.FID, F.Date, F.Time, F.Price from Routes R, Follows F, Has H WHERE R.RID = F.RID AND F.FID = H.FID AND R.Direct = 'Yes' AND R.Source = '" + Src + "' AND R.Destination = '" + Des + "' AND H.AID = " + AID + ";");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }

    public ResultSet getQuery20()
    {
        try{result=statement.executeQuery("SELECT FID, COUNT(*) FROM Tickets GROUP BY FID");}
        catch (Exception e){e.printStackTrace();}
        return result;
    }
    // serve  ,  follows
}