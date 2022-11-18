package Operation;

import dto.rawDataDto;

import java.util.ArrayList;

public class Filtering {

    // rawDataList 받아와서 필터링, String 배열로 반환
    public ArrayList<String> filter(ArrayList<rawDataDto> rawDataList) {
        System.out.println("1. Filtering rawData...");

        ArrayList<String> preprocessedDataList = new ArrayList<>();      // 전처리된 rawData 받을 List
        String read = null;

        try {
            for (rawDataDto rawData : rawDataList) {
                read = rawData.getTitle();
                read = read.replaceAll("<[^>]+>|:|''|\"\"|!|~|;|,|-|", "");
                read = read.toLowerCase();
                preprocessedDataList.add(read);
            }
            System.out.println("2. Succeeded to Filtering rawData!");
        } catch (NullPointerException e) {
            System.out.println("2. Failed to Filtering rawData!");
        }

        return preprocessedDataList; // 결과값 DB에 전송하기 위한 List 반환
    }
}
