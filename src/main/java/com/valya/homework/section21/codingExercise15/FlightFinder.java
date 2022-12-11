package com.valya.homework.section21.codingExercise15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

import static java.time.temporal.ChronoUnit.MINUTES;


public class FlightFinder {

    private Map<String, List<Flight>> allFlights = new HashMap<>();

    public FlightFinder(Map<String, List<Flight>> allFlights) {
        this.allFlights = allFlights;
    }



    public List<NavigableSet<Flight>>  findFlights(int dayOfMonth, int month, int year,
                                                  int preferredDepartureStartHour, int preferredDepartureEndHour,
                                                  String departureCity, String arrivalCity, String finalArrivalCity,
                                                  String departureCityTimeZone, String arrivalCityTimeZone) {

        List<NavigableSet<Flight>> result = new ArrayList<>();

       //время

        LocalDate startDate = LocalDate.of(year, Month.of(month), dayOfMonth);

        LocalTime timeStartHour = LocalTime.of(preferredDepartureStartHour, 00, 00);
        LocalTime timeEndHour = LocalTime.of(preferredDepartureEndHour, 00, 00);

        LocalDateTime startDateTime = LocalDateTime.of(startDate, timeStartHour);
        LocalDateTime endDateTime = LocalDateTime.of(startDate, timeEndHour);

        //ZonedDateTime zonedDepartureCity = ZonedDateTime.of(startDateTime, ZoneId.of(departureCityTimeZone));
        //ZonedDateTime zonedArrivalCity = zonedDepartureCity.withZoneSameInstant(ZoneId.of(arrivalCityTimeZone));

        //рейсы к отправлению
        List<Flight> allDepartingFlights = allFlights.get(departureCity);//San Francisco

        NavigableSet<Flight> departingflights = new TreeSet<>();

        for (Flight flight : allDepartingFlights) {
            if (( flight.getDepartureTime().isAfter(startDateTime))
                    && ( flight.getDepartureTime().isBefore(endDateTime))
                    && Objects.equals(flight.getArrivalCity(), arrivalCity)) {

                departingflights.add(flight);
            }
        }
        //рейсы для пересадки
        List<Flight> allConnectingFlights = allFlights.get(arrivalCity); //Dubai

        NavigableSet<Flight> connectingflights = new TreeSet<>();

        for (Flight flightCon : allConnectingFlights) {

            if ((MINUTES.between(departingflights.first().getArrivalTime(), flightCon.getArrivalTime())) >= 120
                    && (Objects.equals(flightCon.getArrivalCity(), finalArrivalCity))) {

                connectingflights.add(flightCon);
            }
        }

        //удаляем рейсы для которых нет подходящих пересадок
        for (Flight flight : departingflights) {

            if( MINUTES.between( flight.getArrivalTime(), connectingflights.last().getArrivalTime()) < 120) {
                departingflights.remove(flight);
            }
        }

        result.add(departingflights);
        result.add(connectingflights);

        return result;
    }


    public static void main(String[] args) {

        Flight f1 = new Flight(1, "1", "Emirates", "New York", "Dubai",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f2 = new Flight(2, "2", "Delta", "San Francisco", "Paris",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f3 = new Flight(3, "3", "Delta", "San Francisco", "Rome",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f4 = new Flight(4, "4", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 8, 0), LocalDateTime.of(2017, 12, 20, 8, 0));
        Flight f5 = new Flight(5, "5", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 9, 30), LocalDateTime.of(2017, 12, 20, 9, 30));
        Flight f6 = new Flight(6, "6", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 11, 30), LocalDateTime.of(2017, 12, 20, 11, 30));
        Flight f7 = new Flight(7, "7", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 12, 30), LocalDateTime.of(2017, 12, 20, 12, 30));


        Flight f11 = new Flight(11, "11", "Emirates", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 9, 30), LocalDateTime.of(2017, 12, 20, 9, 30));
        Flight f12 = new Flight(12, "12", "Emirates", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 10, 30), LocalDateTime.of(2017, 12, 20, 10, 30));
        Flight f13 = new Flight(13, "13", "Delta", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 12, 0), LocalDateTime.of(2017, 12, 20, 12, 0));
        Flight f14 = new Flight(14, "14", "Delta", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 14, 0), LocalDateTime.of(2017, 12, 20, 14, 0));


        Map<String, List<Flight>> allFlights = new HashMap<>();

        allFlights.put("New York", Arrays.asList(f1));
        allFlights.put("San Francisco", Arrays.asList(f2, f3, f4, f5, f6, f7));
        allFlights.put("Dubai", Arrays.asList(f11, f12, f13, f14));


        List<NavigableSet<Flight>> result = new FlightFinder(allFlights).findFlights(20, 12, 2017, 9, 13,
                                                                            "San Francisco", "Dubai", "Mumbai",
                                                                            "America/Los_Angeles", "Asia/Dubai");
        //System.out.println(result.toString());

        System.out.println("departingflights" + " : " + result.get(0).toString());
        System.out.println("connectingflights" + " : " + result.get(1).toString());

    }
}

