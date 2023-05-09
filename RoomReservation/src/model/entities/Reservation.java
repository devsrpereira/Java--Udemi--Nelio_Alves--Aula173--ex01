package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(){}
    public Reservation(int roomNumber, LocalDate checkin, LocalDate checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }


    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public LocalDate getChecin() {
        return checkin;
    }
    public void setChecin(LocalDate checin) {
        this.checkin = checin;
    }
    public LocalDate getCheckout() {
        return checkout;
    }
    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }


    public long duration(){
        Duration t1 = Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay());
        return t1.toDays();
    }

    @Override
    public String toString() {
        return "Reservation: "
                + "Room " + roomNumber
                + ", check-in: " + String.format(dtf1.format(checkin))
                + ", check-out: " + String.format(dtf1.format(checkout))
                + ", " + duration() + " nights.";
    }
}

