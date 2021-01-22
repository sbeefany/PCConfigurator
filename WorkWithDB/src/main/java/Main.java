import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            InputStreamReader fileReader = new InputStreamReader(new FileInputStream("C:\\Users\\leksi\\GITS\\Diploma\\PCConfigurator\\WorkWithDB\\Price_list.xls"),"Cp1251");
            int i=-1;
            while((i=fileReader.read())!=-1){

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public static HSSFWorkbook readWorkbook(String filename) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filename));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            return wb;
        }
        catch (Exception e) {
            return null;
        }
    }
}
