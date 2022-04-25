package ru.itis.geocoding;

import ru.itis.geocoding.exceptions.GeocodingException;
import ru.itis.geocoding.model.Point;
import ru.itis.geocoding.services.GeocodingService;
import ru.itis.geocoding.services.impl.GeocodeServiceYandexImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point point = new Point(
                scanner.nextDouble(),
                scanner.nextDouble()
        );

        GeocodingService geocodingService = new GeocodeServiceYandexImpl();

        System.out.println("Address:");
        try {
            System.out.println(geocodingService.geocode(point));
        } catch (GeocodingException e) {
            e.printStackTrace();
        }
    }
}
