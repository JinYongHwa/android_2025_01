package kr.ac.mjc.itc2007261051.dto;

import java.util.ArrayList;

public class DataDto {

    private ArrayList<BookDto> list=new ArrayList<>();

    public ArrayList<BookDto> getList() {
        return list;
    }

    public void setList(ArrayList<BookDto> list) {
        this.list = list;
    }
}
