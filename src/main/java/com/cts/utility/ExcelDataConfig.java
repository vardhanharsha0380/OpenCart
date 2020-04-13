package com.cts.utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * @author GALI.HARSHA VARDHAN (853482),NARAHARI.DINESH(853480),KOTHURI.MANJUSHA(853483),CHEBROLU.PRASANNA(853447)
 *
 */
public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet s;

	public ExcelDataConfig(String excelpath) throws Exception {
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}
	}

	public String getData(int sheetname, int row, int col) {
		s = wb.getSheetAt(0);
		String data = s.getRow(row).getCell(col).getStringCellValue();
		return data;

	}

}