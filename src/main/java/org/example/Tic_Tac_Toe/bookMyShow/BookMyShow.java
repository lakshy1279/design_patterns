package org.example.Tic_Tac_Toe.bookMyShow;

import java.util.*;

class City {
    int id;
    String name;
    City(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Threatre {
    int id;
    String name;
    City city;
    Threatre(int id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}

class Audi {
    int id;
    String name;
    Threatre threatre;
    Audi(int id, String name, Threatre threatre) {
        this.id = id;
        this.name = name;
        this.threatre = threatre;
    }
}

class Movie {
    int id;
    String name;
    Date startTime;
    Date endTime;
    int duration;
    Movie(int id, String name, Date startTime, Date endTime, int duration) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }
}

class Show {
    int id;
    String name;
    Movie movie;
    Audi audi;
    Map<Integer, Seat> seats;
    Show(int id, String name, Movie movie, Audi audi) {
        this.id = id;
        this.name = name;
        this.movie = movie;
        this.audi = audi;
    }

    public void setSeats(Map<Integer, Seat> seats) {
        this.seats = seats;
    }

    public boolean checkSeatAvailability(List<Seat> seats) {
        for(Seat seat : seats) {
            if(seat.status != SeatStatus.AVAILABLE)
                return false;
        }
        return true;
    }

    public void lockSeat(List<Seat> seats) {
        for(Seat seat : seats) {
            seat.status = SeatStatus.LOCKED;
        }
    }

    public void markSeatBooked(List<Seat> seats) {
        for(Seat seat : seats) {
            seat.status = SeatStatus.BOOKED;
        }
    }
}

enum SeatStatus{
    BOOKED,
    AVAILABLE,
    LOCKED
}

enum SeatType{
    DIAMOND,
    GOLD,
    PLATINUM
}

class Seat {
    int id;
    String name;
    SeatStatus status;
    SeatType type;
    int price;

    Seat(int id, String name, SeatStatus status, int price, SeatType type) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.type = type;
        this.price = price;
    }
}

enum BookingStatus {
    BOOKED,
    CANCELLED,
    INPROGRESS
}

class User {
    int id;
    String name;
    String email;
    String phone;
    User(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}

class Booking {
    int id;
    List<Seat> seats;
    double amount;
    BookingStatus status;
    User User;
    Show show;
}

class BookingController {
    List<Movie> movies;
    Map<Integer, Show> shows;
    List<Threatre> threatres;
    List<City> cities;

    BookingController(){
        movies = new ArrayList<>();
        shows = new HashMap<>();
        threatres = new ArrayList<>();
        cities = new ArrayList<>();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    public void setShows(Map<Integer, Show> shows) {
        this.shows = shows;
    }
    public void setThreatres(List<Threatre> threatres) {
        this.threatres = threatres;
    }
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public double calculateBookingPrice(List<Seat> seats){
        double amount = 0;
        for(Seat seat : seats) {
            amount += seat.price;
        }
        return amount;
    }

    public synchronized Booking lockSeats(User user, List<Seat> seats, Show show) {
        if(show.checkSeatAvailability(seats)){
            show.lockSeat(seats);
            Booking booking = new Booking();
            booking.seats = seats;
            booking.amount = calculateBookingPrice(seats);
            booking.status = BookingStatus.INPROGRESS;
            booking.User = user;
            booking.show = show;
            System.out.println("Seats Gets Locked");
            return booking;
        }
        return null;
    }

    public void makeBookingConfirmed(Booking booking) {
        List<Seat> seats = booking.seats;
        Show show = booking.show;
        show.markSeatBooked(seats);
        booking.status = BookingStatus.BOOKED;
    }
}

public class BookMyShow {
    public static void main(String[] args) {
        User user = new User(1, "lk", "a@gmail.com", "123");
        City city = new City(1, "Aligarh");
        Threatre threatre = new Threatre(1, "grand", city);
        Audi audi = new Audi(1, "Audi-1", threatre);
        Movie movie = new Movie(1,"kal", new Date(), new Date(), 120);
        Show show = new Show(1, "kal", movie, audi);
        BookingController bookingcontroller = new BookingController();
        Map<Integer,Seat> seats = new HashMap<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Seat seat = new Seat(i + j, "A1", SeatStatus.AVAILABLE, 120, SeatType.DIAMOND);
                seats.put(i + j, seat);
            }
        }
        List<Seat> seat = new ArrayList<>();
        seat.addAll(seats.values());
        bookingcontroller.lockSeats(user, seat, show);
    }
}
