/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cammesa_comb_energ.IO;

/**
 *
 * @author Gherni
 */

import estruct.energia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class conectarAccess {
 
    public List getData(String grupo) {
 
        // variables
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        // Step 1: Loading or 
        // registering Oracle JDBC driver class
        try {
 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {
 
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
 
        // Step 2: Opening database connection
        try {
 
//            String msAccDB = "D:/WORKSPACE/TEST_WORKSPACE"
//                    + "/Java-JDBC/Player.accdb";
            String msAccDB = "D:\\Users\\hgomez.OLIMPUS\\Documents\\SSEE\\BD Electrica\\post Operatorio\\2019\\Originales\\PO190201.MDB";
            String dbURL = "jdbc:ucanaccess://"
                    + msAccDB; 
 
            // Step 2.A: Create and 
            // get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL); 
 
            // Step 2.B: Creating JDBC Statement 
            statement = connection.createStatement();
 
            // Step 2.C: Executing SQL and 
            // retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM VALORES_GENERADORES WHERE GRUPO = '"+grupo+"'");
 
           
           //Map<String,List> m = new HashMap<String, List>();
 
            // processing returned data and printing into console
            List data = new ArrayList();
            while(resultSet.next()) {
                int time = (int)(resultSet.getDate("FECHA").getTime()/1000);
                double t = time+((resultSet.getInt("HORA")*1.0)/24);
                double en=resultSet.getDouble("ENERGIA");
                double eb=resultSet.getDouble("ENERG_OPERADA");
                energia e = new energia(t,en,eb);
                data.add(e);
//                double rela=0;
//                double rela2=0;
//                if(en!=0){
//                   rela=eb/en; 
//                   rela2=en/eb;
//                }
//                
//                System.out.println(resultSet.getString("GRUPO") + "\t" +
//                        resultSet.getDate("FECHA")+"\t"+
//                        time+"\t"+
//                        t+"\t"+
//                        resultSet.getInt("HORA")+"\t"+
//                        
//                        en + "\t" + 
//                        eb+"\t"+
//                        rela+"\t"+
//                        rela2
//                );
//                
                
            }
            return data;
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
        finally {
            // Step 3: Closing database connection
            try {
                if(null != connection) {
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();
 
                    // and then finally close connection
                    connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        return null;
    }
}