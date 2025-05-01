package lk.ijse.gdse66.SpringBoot.service;

import lk.ijse.gdse66.SpringBoot.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO add(ItemDTO dto);

    ItemDTO getById(Integer id);

    List<ItemDTO> getAll();
}