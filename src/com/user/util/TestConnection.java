package com.user.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	    public static void main(String[] args) throws Exception {
	       Connection conn=DBUtil.getConection();//���÷�װ�õ��������������ӷ������
	       System.out.println(conn+",�ɹ��������ݿ�");
	       DBUtil.close( conn);//ͬ�������������ùرշ�������
	    }
}
