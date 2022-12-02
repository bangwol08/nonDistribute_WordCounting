import Operation.CountingWordprocess;
import Operation.InsertRawData;
import dao.rawDataDao;
import dto.rawDataDto;
import dto.resultDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        InsertRawData insertRawData = new InsertRawData();
        CountingWordprocess process = new CountingWordprocess();

        //프로그램 시작전 물어보기
        System.out.println("This Program is Non-distribute WordCountig Program");
        System.out.println("Client try to connect to the localhost.");
        System.out.println("If you want to start Press Enter");
        scan.nextLine();

        long beforeTime = System.currentTimeMillis(); //코드 시작전 시간 받아오기

        //File 읽어서 DB에 INSERT
        System.out.println("INSERT Progress!");
        try
        {
            insertRawData.insertRawData();
        }
        catch(IOException e)
        {
            System.out.println("can't find rawdata.txt");
            System.exit(1);
        }
        System.out.println("INSERT Complete!");

        System.out.println("WordCounting Strat!");
        //Filetring 및 WordCounting 및 결과값 DB저장
        process.startWordCouning();
        System.out.println("WordCounting Complete!");

        //종료후 시간 측정
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        long mDiffTime = (afterTime - beforeTime)%1000;
        System.out.println("All process Complete!");
        System.out.println("분산 워드카운팅 소요시간 : " + secDiffTime + "." + mDiffTime + "초");
    }
}
