package com.railway.dataobject;

public enum Ticket {
    VALID_TICKET("7/16/2025","Nha Trang", "Đà Nẵng", "Soft bed with air conditioner", "1");

    private String departDate;
    private String departStation;
    private String arriveStation;
    private String seatType;
    private String ticketAmount;

    Ticket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        this.departDate = departDate;
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;

    }

    public String getDepartDate() {
        return departDate;
    }

    public String getDepartStation() {
        return departStation;
    }

    public String getArriveStation() {
        return arriveStation;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getTicketAmount() {
        return ticketAmount;
    }


}
