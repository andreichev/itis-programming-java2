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
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class GeocodeServiceYandexSocketImpl implements GeocodingService {
    public String geocode(Point location) throws GeocodingException {
        String host = "geocode-maps.yandex.ru";
        // 1.x?geocode=%f,%f&apikey=f929bb23-4471-42b8-a34e-13f2b18da04d&format=xml
        Socket socket;
        String result = null;
        try {
            socket = new Socket(host, 80);
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)
            );

            String path = String.format(
                    "/1.x?geocode=%f,%f&apikey=f929bb23-4471-42b8-a34e-13f2b18da04d&format=xml",
                    location.getLatitude(), location.getLongitude()
            );

            writer.write("GET " + path + " HTTP/1.1\n");
            writer.write("HOST: geocode-maps.yandex.ru\n");
            writer.write("User-Agent: PostmanRuntime/7.29.0\n");
            writer.write("Accept: */*\n");
            writer.write("Connection: close\n");
            writer.write("\n\n");
            writer.flush();

            boolean bodyStarted = false;
            StringBuilder xmlFile = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (bodyStarted) {
                    xmlFile.append(line);
                } else if(line.isEmpty()) {
                    bodyStarted = true;
                }
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new InputSource(new StringReader(xmlFile.toString())));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("ymaps/GeoObjectCollection/featureMember/GeoObject/metaDataProperty/GeocoderMetaData/Address/formatted");
            result = (String) expr.evaluate(doc, XPathConstants.STRING);
            socket.close();
        } catch (IOException | ParserConfigurationException | SAXException | XPathExpressionException e) {
            throw new GeocodingException(e.getMessage());
        }
        return result;
    }
}
