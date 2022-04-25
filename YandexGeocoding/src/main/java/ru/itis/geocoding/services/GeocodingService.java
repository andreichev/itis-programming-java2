package ru.itis.geocoding.services;

import ru.itis.geocoding.exceptions.GeocodingException;
import ru.itis.geocoding.model.Point;

public interface GeocodingService {
    String geocode(Point location) throws GeocodingException;
}
