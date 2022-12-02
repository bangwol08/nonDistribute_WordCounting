package Operation;

import DB.DBcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InsertRawData
{
    public void insertRawData() throws IOException {
        DBcontroller dbcontroller = new DBcontroller("localhost","localhost","3306","distribute_database","tempuser","qwe123!@#");

        if(dbcontroller.conn == null)
        {
            System.out.println("can't connect localhost DB");
            return;
        }

        System.out.println("Progress...");

        //insert전 모든 데이터 삭제
        dbcontroller.deleteDataAll();

        //AUTO_INCREMENT 1로 초기화
        dbcontroller.initIncrement();

        //DB INSERT 수행.
        //파일불러오기
        InputStream in = getClass().getResourceAsStream("/resource/rawData.txt");
        BufferedReader countFile = new BufferedReader(new InputStreamReader(in));

        //txt파일에서 한줄씩 읽어오면서 INSERT수행
        InputStream inin = getClass().getResourceAsStream("/resource/rawData.txt");
        BufferedReader inFile = new BufferedReader(new InputStreamReader(inin));
        String lineString;

        while((lineString = inFile.readLine()) != null)
        {
            //sql에서 '를 인식하지 못하는 문제때문에 ''으로 문자열 재배치 후 INSERT 수행
            lineString = lineString.replace("\'", "\'\'").replace("\"", "\"\"");
            dbcontroller.insertData(lineString);
        }
    }
}
