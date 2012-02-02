package com.ks.code.core.type.dbunit;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class XlsDataImportTest {

	private Connection con;
	private DatabaseMetaData metadata;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	private IDatabaseConnection connection;
	private String XLS_FILE_DIR = "D:/PROJECT/Korra/korra-code/DOC/country.xls";
	
	
	@Before
	public void init() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/korra_code?useUnicode=true&characterEncoding=utf-8", "root", "1212");
		metadata = con.getMetaData();
		connection = new DatabaseConnection(con, "korra_code");
	}

	@After
	public void clear() throws Exception {
		if (connection != null)	connection.close();
		if (rs != null)rs.close();
		if (con != null) con.close();
	}   
	
    @Test
    public void importDataTest()  throws Exception {    
    	System.out.println("==========================================================");
    	System.out.println("                         Import 시작                           ");
    	System.out.println("==========================================================");
    	FileInputStream fileInputStream = new FileInputStream(new File(XLS_FILE_DIR));
    	IDataSet dataSet = new XlsDataSet(fileInputStream);
		System.out.println("==========================================================");
		System.out.println("                         Import 완료                          ");
		System.out.println("==========================================================");
    }
    
//	@Test
//	public void exportDToXlsTest() throws Exception {
//
//		rs = metadata.getTables("max", null, null, null);
//		rsmd = rs.getMetaData();
//		List<String> tableList = new ArrayList<String>();
//		while (rs.next()) {
//			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//				if ("TABLE_NAME".equals(rsmd.getColumnName(i))) {
//					tableList.add(rs.getString(i));
//				}
//			}
//		}
//		String[] tables = new String[tableList.size()];
//		Iterator<String> iter = tableList.iterator();
//		int index = 0;
//		while (iter.hasNext()) {
//			tables[index++] = iter.next();
//		}
//		IDataSet dataSet = connection.createDataSet(tables);
//		XlsDataSet.write(dataSet, new FileOutputStream(new File(XLS_FILE_DIR)));
//		assertTrue(new File(XLS_FILE_DIR).exists());
//	}    
}
