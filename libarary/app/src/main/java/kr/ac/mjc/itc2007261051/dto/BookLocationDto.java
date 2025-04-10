package kr.ac.mjc.itc2007261051.dto;

public class BookLocationDto {

    private String callNo;
    private LocationDto location;
    private CirculationStateDto circulationState;

    public String getCallNo() {
        return callNo;
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public CirculationStateDto getCirculationState() {
        return circulationState;
    }

    public void setCirculationState(CirculationStateDto circulationState) {
        this.circulationState = circulationState;
    }
}
