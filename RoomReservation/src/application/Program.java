package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        LocalDate checkin = LocalDate.parse(sc.next(),dtf1);
        System.out.print("Check-out date (dd/mm/yyyy): ");
        LocalDate checkout = LocalDate.parse(sc.next(),dtf1);

        if (!checkout.isAfter(checkin)){
            System.out.println("Error in reservation: Check-out date must be  after  check-in date.");
        } else {
            Reservation reservation = new Reservation(roomNumber,checkin,checkout);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkin = LocalDate.parse(sc.next(),dtf1);
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkout = LocalDate.parse(sc.next(),dtf1);

            LocalDate now = LocalDate.now();

            if (checkin.isBefore(now) || checkout.isBefore(now)){
                System.out.println("Error in reservation: Reservation date for update must be future dates.");
            } else if (!checkout.isAfter(checkin)){
                System.out.println("Error in reservation: Check-out date must be  after  check-in date.");
            } else {
                reservation.updateDate(checkin,checkout);
                System.out.println(reservation);
            }
        }







        sc.close();
    }
}
