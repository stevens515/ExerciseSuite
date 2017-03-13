package com.tarena.elts.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String url;
	private static String dbUser;
	private static String dbpassword;
	private static String driver;
	
	/**
	 * �������ļ��н������� ����
	 * url dbUser dbPassword ��ֵ
	 */
	static {
		Properties table = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("db.properties");
			table.load(file);
			url = table.getProperty("url");
			dbUser = table.getProperty("dbUser");
			dbpassword = table.getProperty("dbPassword");
			driver = table.getProperty("driver");
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡ���ݿ������
	 * @return
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try {
			/*
			 * ��oracle.jdbc.OracleDriver �� װ���ڴ�
			 * OracleDriver �� static ������漴����
			 * static ��������DriverManger ע�� oracle �������� 
			 * JDBC �� API ͨ�� �������� �ҵ�����ʵ�� 
			 */
			connection = DriverManager.getConnection(url,dbUser,dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * �ر�����
	 * @param connection
	 */
	public static void close(Connection connection){
		if(connection != null){
			try {
				connection.close();
				System.out.println("���ӹر�");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �ر�������
	 * @param statement
	 */
	public static void close(Statement statement){
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �رս����
	 * @param resultSet
	 */
	public static void close(ResultSet resultSet){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ���������Ƿ��Զ��ύ
	 * @param connection
	 * @param autoCommit
	 */
	public static void setAutoCommit(Connection connection ,boolean autoCommit){
		try {
			connection.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �ֶ��ύ����
	 * @param connection
	 */
	public static void commit(Connection connection){
		try {
			if(connection.getAutoCommit()){
				return;
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ����ع�
	 * @param connection
	 */
	public static void rollBack(Connection connection){
		try {
			if(connection.getAutoCommit()){
				return;
			}
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}