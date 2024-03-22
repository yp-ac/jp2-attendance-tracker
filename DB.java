import java.sql.*;
import java.util.Vector;

public class DB {
    Connection con;
    static private DB _in = null;
    private DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/attendancetracker", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public static DB getDB() {
        if (_in == null) {
            _in = new DB();
        }

        return _in;
    }

    Vector<String> getClasss() {
        Vector<String> classes = new Vector<>();
        try {
            Statement stmt = con.createStatement();
            
            ResultSet rs;
            rs = stmt.executeQuery("select * from classes");
            
            while (rs.next())
                classes.add(rs.getString("class"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }

    Vector<String> getStudents(String cls) {
        Vector<String> classes = new Vector<>();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from students where section = ?");
            stmt.setString(1, cls);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
                classes.add(rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }

    Vector<Object[]> getAttendance(String cls) {
        Vector<Object[]> classes = new Vector<>();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from students where section = ?");
            stmt.setString(1, cls);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
                classes.add(new Object[] {rs.getInt("id"), rs.getString("name"), rs.getInt("status")});
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classes;
    }

    void updateAttendance(String cls, String name, boolean isPresent) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE students SET status = ? WHERE section = ? and name = ?");
            stmt.setInt(1, isPresent ? 1 : 0);
            stmt.setString(2, cls);
            stmt.setString(3, name);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    boolean isValidUser(String username, String password) {
        boolean result = false;
        try {
            PreparedStatement stmt = con.prepareStatement("select * from users where uname = ? and password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet rs;
            rs = stmt.executeQuery();
            
            result = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected void finalize() throws Throwable {
        con.close();
    }
}
