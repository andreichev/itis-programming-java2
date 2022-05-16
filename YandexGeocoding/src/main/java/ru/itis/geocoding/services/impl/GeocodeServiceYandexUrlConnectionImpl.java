package ru.itis.geocoding.services.impl;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.itis.geocoding.exceptions.GeocodingException;
import ru.itis.geocoding.model.Point;
import ru.itis.geocoding.services.GeocodingService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class GeocodeServiceYandexUrlConnectionImpl implements GeocodingService {
    public String geocode(Point location) throws GeocodingException {
        String host = "https://geocode-maps.yandex.ru";
        String path = String.format(
                "/1.x?geocode=%f,%f&apikey=f929bb23-4471-42b8-a34e-13f2b18da04d&format=xml",
                location.getLatitude(), location.getLongitude()
        );
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(host + path).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            // Раскомментировать, если нужно передавать тело запроса
            // connection.setDoOutput(true);

            // OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            // writer.write(requestBody);

            if (connection.getResponseCode() != 200) {
                System.err.println("connection failed");
                return "";
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String response = reader.lines().collect(Collectors.joining(System.lineSeparator()));

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new InputSource(new StringReader(response)));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("ymaps/GeoObjectCollection/featureMember/GeoObject/metaDataProperty/GeocoderMetaData/Address/formatted");
            return (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (IOException | ParserConfigurationException | SAXException | XPathExpressionException e) {
            throw new GeocodingException(e.getMessage());
        }
    }
}
