package com.example.inventory.service;

import com.example.inventory.model.Part;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PartService {
    private List<Part> parts;

    public PartService() {
        loadParts();
    }

    private void loadParts() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            parts = mapper.readValue(new File("src/main/resources/inventory.json"), new TypeReference<List<Part>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Part> getAllParts() {
        return parts;
    }

    public Part getPartById(String id) {
        return parts.stream().filter(part -> part.getId().equals(id)).findFirst().orElse(null);
    }

    public void addPart(Part part) {
        parts.add(part);
        saveParts();
    }

    public void updatePart(Part part) {
        Part existingPart = getPartById(part.getId());
        if (existingPart != null) {
            existingPart.setName(part.getName());
            existingPart.setDescription(part.getDescription());
            existingPart.setPrice(part.getPrice());
            saveParts();
        }
    }

    public void deletePart(String id) {
        parts.removeIf(part -> part.getId().equals(id));
        saveParts();
    }

    public void clearParts() {
        parts.clear();
        saveParts();
    }

    private void saveParts() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("src/main/resources/inventory.json"), parts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}