package com.residentevil.services;

import com.residentevil.entities.Capital;
import com.residentevil.entities.Virus;
import com.residentevil.repositories.VirusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.StringJoiner;

@Service
public class VirusServiceImpl implements VirusService {

    private final VirusRepository virusRepository;

    @Autowired
    public VirusServiceImpl(VirusRepository virusRepository) {
        this.virusRepository = virusRepository;
    }

    @Override
    public String findAllMapViruses() {
        StringBuilder geoJson = new StringBuilder();
        geoJson.append("{\n" +
                "        \"type\": \"FeatureCollection\",\n" +
                "        \"features\": [");
        List<Virus> viruses = this.virusRepository.findAll();
        StringJoiner stringJoiner = new StringJoiner(",");
        for (Virus virus : viruses) {
            int magnitude = 0;
            switch (virus.getMagnitude()) {
                case LOW:
                    magnitude = 3;
                    break;
                case MEDIUM:
                    magnitude = 5;
                    break;
                case HIGH:
                    magnitude = 7;
                    break;
            }

            for (Capital capital : virus.getCapitals()) {
                String data = String.format("{\n" +
                        "                \"type\": \"Feature\",\n" +
                        "                \"properties\": {\n" +
                        "                    \"mag\" : %d,\n" +
                        "                    \"color\" : \"#f00\"\n" +
                        "                },\n" +
                        "                \"geometry\": {\n" +
                        "                    \"type\": \"Point\",\n" +
                        "                    \"coordinates\": [\n" +
                        "                        %f,\n" +
                        "                        %f\n" +
                        "                    ]\n" +
                        "                }\n" +
                        "            }", magnitude, capital.getLatitude(), capital.getLongitude());
                stringJoiner.add(data);
            }
        }

        geoJson.append(stringJoiner);
        geoJson.append("]\n" +
                "    }");

        return geoJson.toString();
    }
}
