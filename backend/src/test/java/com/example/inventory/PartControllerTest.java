package com.example.inventory;

import com.example.inventory.model.Part;
import com.example.inventory.service.PartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PartControllerTest {

    @Autowired
    private PartService partService;

    @BeforeEach
    public void setUp() {
        partService.clearParts();
        partService.addPart(new Part("1", "Part1", "Description1", 100.0));
        partService.addPart(new Part("2", "Part2", "Description2", 200.0));
    }

    @Test
    public void testGetAllParts() {
        List<Part> parts = partService.getAllParts();
        assertEquals(2, parts.size());
    }

    @Test
    public void testGetPartById() {
        Part part = partService.getPartById("1");
        assertNotNull(part);
        assertEquals("Part1", part.getName());
    }

    @Test
    public void testAddPart() {
        partService.addPart(new Part("3", "Part3", "Description3", 300.0));
        Part part = partService.getPartById("3");
        assertNotNull(part);
        assertEquals("Part3", part.getName());
    }

    @Test
    public void testUpdatePart() {
        Part part = new Part("1", "UpdatedPart1", "UpdatedDescription1", 150.0);
        partService.updatePart(part);
        Part updatedPart = partService.getPartById("1");
        assertNotNull(updatedPart);
        assertEquals("UpdatedPart1", updatedPart.getName());
    }

    @Test
    public void testDeletePart() {
        partService.deletePart("1");
        Part part = partService.getPartById("1");
        assertNull(part);
    }
}