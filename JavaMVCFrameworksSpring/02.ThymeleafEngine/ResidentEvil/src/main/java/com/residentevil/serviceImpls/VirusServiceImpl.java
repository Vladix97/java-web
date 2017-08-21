package com.residentevil.serviceImpls;

import com.residentevil.entities.Capital;
import com.residentevil.entities.Virus;
import com.residentevil.models.VirusBindingModel;
import com.residentevil.repositories.VirusRepository;
import com.residentevil.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.StringJoiner;

@Service
public class VirusServiceImpl implements VirusService {

    private final VirusRepository virusRepository;

    @Autowired
    public VirusServiceImpl(VirusRepository repository) {
        this.virusRepository = repository;
    }

    @Override
    public void create(VirusBindingModel virusBindingModel) {

    }

    @Override
    public String getGeoData() {
            List<Virus> viruses = this.virusRepository.getAllViruses();
            StringBuilder geoJson = new StringBuilder();
            String header = "{\n" +
                    "    \"type\": \"FeatureCollection\",\n" +
                    "    \"features\": [\n";
            String footer = "]\n" +
                    "}\n";

            geoJson.append(header);
            StringJoiner joiner = new StringJoiner(",");
            for (Virus virus : viruses) {
                String color = "#f00";
                int magnitude = 0;
                switch (virus.getMagnitude()){
                    case LOW:
                        magnitude = 4;
                        break;
                    case MEDIUM:
                        magnitude = 5;
                        break;
                    case HIGH:
                        magnitude = 6;
                        break;
                }

                for (Capital capital : virus.getCapitals()) {
                    String body = String.format("{\n" +
                            "        \"type\": \"Feature\",\n" +
                            "        \"properties\": {\n" +
                            "            \"mag\": %d,\n" +
                            "            \"color\": \"%s\"\n" +
                            "        },\n" +
                            "        \"geometry\": {\n" +
                            "            \"type\": \"Point\",\n" +
                            "            \"coordinates\": [\n" +
                            "                %f,\n" +
                            "                %f\n" +
                            "            ]\n" +
                            "        }\n" +
                            "    }\n", magnitude, color, capital.getLatitude(), capital.getLongitude());
                    joiner.add(body);
                }
            }

            geoJson.append(joiner);
            geoJson.append(footer);

            return geoJson.toString();
    }
}
