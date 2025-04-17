package kr.ac.mjc.itc2007261051.dto;

import java.util.HashMap;
import java.util.List;

public class ResponseDto2 {

    private HashMap<String, List<BookLocationDto>> data;

    public HashMap<String, List<BookLocationDto>> getData() {
        return data;
    }

    public void setData(HashMap<String, List<BookLocationDto>> data) {
        this.data = data;
    }
}
