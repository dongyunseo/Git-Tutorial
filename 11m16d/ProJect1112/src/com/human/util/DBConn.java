package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

public class DBConn {
	//.getInstance()
	private DBConn() {}
	private static Connection dbConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static Scanner sc = new Scanner(System.in);
	
	public static ResultSet statementQuery(String sql) {
		try {
			if(st == null) {
				st = dbConn.createStatement();
			}
			rs = st.executeQuery(sql);
	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
//	public static int statementUpdate(String sql) {
//		int resultValue=0;
//		//DBConn.getInstance(); 
//		try {
//			if(st == null) {
//				st = dbConn.createStatement();
//			}
//			resultValue = st.executeUpdate(sql);
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			//DBconn.dbClose();
//		}
//		
//		return resultValue;
//	}
	public static int statementUpdate(String sql) {
		int resultValue=0;
		try {
			if(st==null) {
				st=dbConn.createStatement();
			}
			resultValue=st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {}
		System.out.println("statementUpdate : "+resultValue);
		return resultValue;
	}
	
	
	
	public static Connection getInstance() {
		if(dbConn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("DB 연결 중");
				String url = "jdbc:oracle:thin:@localhost:1521/xe";
				String user = "myproj";
				String pw ="myproj";
				dbConn = DriverManager.getConnection(url,user,pw);
				System.out.println("DB 연결 완료");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dbConn;
	}
	public static void dbClose() {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close(); 
				if(dbConn != null) dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				rs = null;
				st = null;
				dbConn = null;
			}

			
	}
	//
	public static int inputInt() {
		System.out.println("�뜝�럩�젧�뜝�럥�빢�뜝�럩肉��뜝�럩�졑>>");
		return Integer.parseInt(sc.nextLine());
	}
	public static double inputDouble() {
		System.out.println("�뜝�럥堉꾢뜝�럥�빢�뜝�럩肉��뜝�럩�졑>>");
		return Double.parseDouble(sc.nextLine());
	}
	public static String inputString() {
		System.out.println("占쎈닱筌뤾쑴�겱�뜝�럥�� �뜝�럩肉��뜝�럩�졑>>");
		return sc.nextLine();
	}
	//=================================1�댖怨ㅼ삕================================================
	// insert delete update
		public static void close(Statement st) {
			stClose(st);
			dbClose();
		}

		// select
		public static void close(Statement st, ResultSet rs) {
			rsClose(rs);
			stClose(st);
			dbClose();
		}

		public static void close(Connection conn, PreparedStatement pstmt) {
			try {
				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
				st = null;
				dbConn = null;
			}
		}
		
		

		public static void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
			try {
				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstm = null;
				rs = null;
				st=null;
				dbConn = null;
			}
		}

		// resultset
		public static void rsClose(ResultSet st) {
			if (st != null) {
				try {
					st.close();
					st = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// statement
		public static void stClose(Statement st) {
			if (st != null) {
				try {
					st.close();
					st = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public static Connection getConnection() {
			// null�뜝�럥�맶�뜝�럥堉볡춯琉우뒩占쎄뎡 �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援� �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿴턁占쏙쭚�룂�굲 �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援� null�뜝�럥�맶�뜝�럥吏쀥뜝�럩援� �뜝�럥�맶�뜝�럥堉껃뜝�럥鍮띸춯琉우뒩占쎄뎡 �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援� �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援�
			if (dbConn == null) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521/XE";
					String user = "myproj";
					String pw = "myproj";

					dbConn = DriverManager.getConnection(url, user, pw);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {

			}
			return dbConn;
		}
		public static String OdateToString(Date d) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(d);
		}
//	public static Date inputDate() {
//		Date returnValue = null;
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println("�뜝�럡�뀏嶺뚯쉻�삕 �뜝�럩肉��뜝�럩�졑  (yyyy-MM-dd HH:mm:ss)>>");
//		String inputString = sc.nextLine();
//		try {
//			returnValue = transFormat.parse(inputString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return returnValue;
//	}
//	
//	public static String dateToString(Date d) {
//		DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//		return df.format(d);
//	}

}
