package quizserver;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectionJDBC {

    public static String DB_URL = "jdbc:mysql://localhost:3306/new_quiz?useSSL=false";
//    public static String url="jdbc:mysql://127.0.0.1:3306/quiz";
    public static String USER_NAME = "root";
    public static String PASSWORD = "142857SONlun@@";


    public static Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connnect to database 'quiz'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connection to DB successfull");
            return conn;
        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
        
    }

    public static Connection getConnection(String dbURL, String userName,
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("connect failure!");
        }
        return conn;
    }
    
    public static void main(String[] args) {
        String result = "";
        String[] datas = new String[6];
        int mark = 0;

            try{
                Connection conn=ConnectionJDBC.getConn();
                Statement st=conn.createStatement();
                ResultSet  rs = st.executeQuery("SELECT AI.Name, AI.MSSV, AI.LSH, R.Mark, R.Number_Error, R.Detecting_Error\n" +
                                            "FROM Account_Info AI\n" +
                                            "JOIN Result R ON AI.ID_Account = R.ID_Account\n" +
                                            "WHERE R.Mark >=" + mark + " ");
                // Number of Students
                ArrayList<String[]> resultSetCopy = new ArrayList<String[]>();

                while (rs.next()) {
                    String[] rowData = new String[Server.StudentInfoNum];
                    for (int i = 0; i < Server.StudentInfoNum; i++) {
                        rowData[i] = rs.getString(i + 1);
                    }
                    resultSetCopy.add(rowData);
                }

                System.out.println("Count: " + resultSetCopy.size());
                for(int j = 0; j< resultSetCopy.size(); j++){
                    for (int i = 0; i < Server.StudentInfoNum; i++) {
                        System.out.println(resultSetCopy.get(j)[i]); 
                    }
                }
                
               conn.close();
               st.close();
               rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    
    
}
