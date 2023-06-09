package application;

import model.entities.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println();
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            LocalDate checkin = LocalDate.parse(sc.next(), dtf1);
            System.out.print("Check-out date (dd/mm/yyyy): ");
            LocalDate checkout = LocalDate.parse(sc.next(), dtf1);

            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkin = LocalDate.parse(sc.next(), dtf1);
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkout = LocalDate.parse(sc.next(), dtf1);

            reservation.updateDate(checkin,checkout);
            System.out.println(reservation);

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
        } catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
