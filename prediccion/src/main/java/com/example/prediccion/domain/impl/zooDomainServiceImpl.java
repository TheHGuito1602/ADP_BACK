package com.example.prediccion.domain.impl;

import com.example.prediccion.domain.ZooDomainService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class zooDomainServiceImpl implements ZooDomainService {
    private String[] zooClasses = {"mamifero", "aves", "peces", "invertebrados", "insectos", "anfibios", "reptiles"};

    @Override
    public String filtrar(String prediccion) {
        try {
            // Extract predictions using regex
            Pattern pattern = Pattern.compile("Class: (\\d+), Probability: ([\\d.]+)%");
            Matcher matcher = pattern.matcher(prediccion);

            String bestClass = null;
            double highestPercentage = 0.0;

            while (matcher.find()) {
                int currentClassIndex = Integer.parseInt(matcher.group(1));
                double currentPercentage = Double.parseDouble(matcher.group(2));

                if (currentPercentage > highestPercentage) {
                    highestPercentage = currentPercentage;
                    bestClass = zooClasses[currentClassIndex];
                }
            }

            return String.format("{\"class\": \"%s\", \"percentage\": %.2f}", bestClass, highestPercentage);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing prediction";
        }
    }
}

