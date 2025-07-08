package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class CommonUtils {

	public static String generateNewEmail() {
		return new Date().toString().replaceAll(" ", "").replaceAll("\\:", "") + "@gmail.com";
	}

	public static Properties loadProperties() {
		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\projectdata.properties");

			prop.load(fr);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}

	public static Object[][] getTestDataFromExcel(String SheetName) throws IOException {
		File excelFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TutorialsNinja.xlsx");
		FileInputStream fixExcel;
		XSSFWorkbook workBook = null;
		try {
			fixExcel = new FileInputStream(excelFile);
			workBook = new XSSFWorkbook(fixExcel);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		XSSFSheet sheet = workBook.getSheet(SheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][cols];
		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;

				}
			}
		}
		return data;
	}

	public static ExtentReports getExtentReports() {

		ExtentReports extentReport = new ExtentReports();

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\Reports\\ExtentReport.html");
		ExtentSparkReporterConfig sparkReporterConfig = sparkReporter.config();
		sparkReporterConfig.setReportName("Live Automation report");
		sparkReporterConfig.setDocumentTitle("LA Report");

		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("Seleium Version", "4.27.0");
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentReport;

	}

}
