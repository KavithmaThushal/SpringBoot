package lk.ijse.gdse66.SpringBoot.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse66.SpringBoot.dto.ItemDTO;
import lk.ijse.gdse66.SpringBoot.service.ItemService;
import lk.ijse.gdse66.SpringBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseUtil add(@Valid @RequestBody ItemDTO dto) {
        ItemDTO data = itemService.add(dto);
        return new ResponseUtil("Item added successfully!", data);
    }
}