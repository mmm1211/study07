package com.user.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * @author myl
 *
 */
public class DBUtil {
	/* public static void main(String[] args) throws Exception {
	        // TODO Auto-generated method stub
	        Class.forName("com.mysql.cj.jdbc.Driver");
	         
	        Connection conn = DriverManager.getConnection(
	                "jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
	                "root","");
	        Statement stmt =  conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from test_user");
	         
	        while (rs.next()) {
	            System.out.println(rs.getInt(1) + "\t"
	                    +rs.getString(2) + "\t"
	                    +rs.getString(3) );
	            }
	         
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();   
	        }
	        if (conn != null) {
	            conn.close();   
	        }
	    }
}*/
	
	

	/* 
    // JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT uid, uname, age FROM test_user";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int uid  = rs.getInt("uid");
                String uname = rs.getString("uname");
                String age = rs.getString("age");
    
                // �������
                System.out.print("ID: " + uid);
                System.out.print(", ����: " + uname);
                System.out.print(", ����: " + age);
                System.out.print("\n");
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }*/
	
	//��װ
	 private static String DRIVER_CLASS;
	      private static String URL;
	      private static String USERRNAME;
	      private static String PASSWORD;
	      private static Properties p=new Properties();
	      private static Connection conn=null;
	      static{
	          try {
	              FileInputStream fis=new FileInputStream("db.properties");
	              p.load(fis);
	              DRIVER_CLASS=p.getProperty("driver");
	               URL=p.getProperty("url");
	               USERRNAME=p.getProperty("user");
	               PASSWORD=p.getProperty("pass");
	               Class.forName(DRIVER_CLASS);
	               fis.close();
	           } catch (IOException e) {
	               e.printStackTrace();
	           } catch (ClassNotFoundException e) {
	               e.printStackTrace();
	           }
	        }
	     public static Connection getConection(){
	         
	         try{
	         conn=DriverManager.getConnection(URL, USERRNAME, PASSWORD);
	         }
	         catch (Exception e) {
	                 e.printStackTrace();
	             }
	          return conn;
	        }
	     
	     public static void close(Connection conn) {
	           try {
	               if (conn != null)
	                    conn.close();
	              } catch (Exception e) {
	                e.printStackTrace();
	              }
	          }
	     
	     // insert records
	     public boolean insert(String sql, Object... args) throws Exception{
	         PreparedStatement pstmt = (PreparedStatement) getConection().prepareStatement(sql);
	         for(int i = 0; i < args.length; i++) {
	             pstmt.setObject(i + 1, args[i]); 
	         }
	         if(pstmt.executeUpdate() != 1)
	             return false;
	         return true;
	     }
	     
	     // execute query
	     public ResultSet query(String sql, Object...args) throws Exception{
	         PreparedStatement pstmt = (PreparedStatement) getConection().prepareStatement(sql);
	         for(int i=0; i< args.length; i++) {
	             pstmt.setObject(i+1, args[i]);
	         }
	         return pstmt.executeQuery();
	     }
	     
	     public void modify(String sql, Object...args) throws Exception{
	         PreparedStatement pstmt = (PreparedStatement)getConection().prepareStatement(sql);
	         for(int i = 0; i< args.length; i++) {
	             pstmt.setObject(i+1, args[i]);
	         }
	         pstmt.executeUpdate();
	         pstmt.close();
	     }
	     
	     public void closeConn() throws Exception{
	         if(conn != null && !conn.isClosed())
	             conn.close();
	     }
}
