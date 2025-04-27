package lk.ijse.gdse66.demo.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse66.demo.dto.ItemDTO;
import lk.ijse.gdse66.demo.service.ItemService;
import lk.ijse.gdse66.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping
    public ResponseUtil add(@Valid @RequestBody ItemDTO dto) {
        ItemDTO data = service.add(dto);
        return new ResponseUtil("Item added successfully!", data);
    }
}