package com.example.inventory.controller;

import com.example.inventory.model.Part;
import com.example.inventory.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
public class PartController {

    @Autowired
    private PartService partService;

    @GetMapping
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }

    @GetMapping("/{id}")
    public Part getPartById(@PathVariable String id) {
        return partService.getPartById(id);
    }

    @PostMapping
    public void addPart(@RequestBody Part part) {
        partService.addPart(part);
    }

    @PutMapping("/{id}")
    public void updatePart(@PathVariable String id, @RequestBody Part part) {
        part.setId(id);
        partService.updatePart(part);
    }

    @DeleteMapping("/{id}")
    public void deletePart(@PathVariable String id) {
        partService.deletePart(id);
    }
}