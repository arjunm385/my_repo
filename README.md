import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {

    public void generateExcel() throws IOException {
        // Initialize variables
        long startTime = System.currentTimeMillis();
        int numRows = 1000000;
        int numCols = 15;
        Random rand = new Random();
        
        // Create new workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
        
        // Generate data
        for (int i = 0; i < numRows; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < numCols; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(rand.nextInt(1000));
            }
        }
        
        // Save workbook to local file
        String filename = "data.xlsx";
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.close();
        workbook.close();

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Excel generated successfully. Time taken: " + timeElapsed + " ms");
    }
}
