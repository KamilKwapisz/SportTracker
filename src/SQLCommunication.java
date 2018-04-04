
import java.io.*;
import java.sql.*;

public class SQLCommunication {

    private static String address;
    private static String port;
    private static String connectionUrl;
    private static String user;
    private static String password;

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) {
        try {
            SQLCommunication serv = new SQLCommunication();
            String[][] result = serv.getFromTable("users", "name", "surname");
            printStringMatrix(result);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLCommunication error: " + ex.getMessage());
        } catch (IOException ex){
            System.out.println("SQLCommunication error: " + ex.getMessage());
        }
    }

    public SQLCommunication() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        readConfigurationFile("SQLConfig.txt");
        con = DriverManager.getConnection(connectionUrl, user, password);
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public String[][] getFromTable(String... args) {
        /* Use samples: 
    * getFromTableWhere( "users", "name");
    * getFromTableWhere("users", "name", "surname");
         */
        try {
            String query = buildSelectQuery(args);
            rs = stmt.executeQuery(query);
            String result[][] = rsToStringMatrix(rs, args);

            return result;

        } catch (SQLException ex) {
            System.out.println("SQLCommunication error at getFromTable: " + ex.getMessage());
            return null;
        } catch (NullPointerException ex) {
            System.out.println("SQLCommunication error at getFromTable: " + "too few arguments!");
            return null;
        }
    }

    public String[][] getFromTableWhere(String... args) {
        /* Use samples: 
    * getFromTableWhere( "users", "name", "Daniel");
    * getFromTableWhere("users", "name", "Daniel", "age", "14");
    * getFromTableWhere("users", "name", "Daniel", "age", "14", '+', "surname");
         */
        return null;
    }

    public int addToTable(String[] args) {
        //rs.moveToInsertRow();
        //rs.updateString( "imie", "Java");
        //rs.updateString( "nazwisko", "Oracle");
        //rs.insertRow();
        return 0;
    }

    public int deleteRowsWhere(String... args) {
        return 0;
    }

    private static String buildSelectQuery(String... args) {
        if (args.length < 2) {
            return null;
        }

        String query = "Select ";
        StringBuilder sb = new StringBuilder(query);

        sb.append(args[1]);
        for (int i = 2; i < args.length; i++) {
            sb.append(", ").append(args[i]);
        }
        sb.append(" from ").append(args[0]);
        query = sb.toString();

        return query;
    }

    private static String[][] rsToStringMatrix(ResultSet rs, String... args) {
        try {
            rs.last();
            int rowNumber = rs.getRow();
            rs.first();

            String matrix[][] = new String[rowNumber][args.length - 1];
            for (int i = 0; i < rowNumber; i++) {
                for (int j = 0; j < args.length - 1; j++) {
                    matrix[i][j] = (rs.getString(args[j + 1])); // j + 1 -> skipping first agument as it's the table name
                }
                rs.next();
            }
            return matrix;
        } catch (SQLException ex) {
            System.out.println("SQLCommunication error at rsToStringMatrix: " + ex.getMessage());
            return null;
        }
    }

    private static void printStringMatrix(String[][] matrix) {
        try {
            for (String[] m : matrix) {
                for (String s : m) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        } catch (NullPointerException ex) {
            System.out.println("SQLCommunication error at printStringMatrix: recieved pointer to null!");
        }
    }

    private static void readConfigurationFile(String path) throws IOException {
        FileReader fr = new FileReader(new File(path));
        BufferedReader br = new BufferedReader(fr);
        String line;
        int lines = 0;
        while ((line = br.readLine()) != null) {
            if (lines++ == 4) {
                break;
            }
            String[] p = line.split("\\s+");

            switch (p[0]) {
                case "user":
                    user = p[1];
                    break;
                case "password":
                    password = p[1];
                    break;
                case "ip":
                    address = p[1];
                    break;
                case "port":
                    port = p[1];
                    break;
                default:
                    throw new IOException("Unrecognizable parameter '" + p[0] + "' in file" + path);
            }
        }
        connectionUrl = "jdbc:sqlserver://" + address + ":" + port + ";integrateSecurity=true";
    }

}
