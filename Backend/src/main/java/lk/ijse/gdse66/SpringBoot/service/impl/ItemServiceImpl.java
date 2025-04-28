package lk.ijse.gdse66.SpringBoot.service.impl;

import lk.ijse.gdse66.SpringBoot.dto.ItemDTO;
import lk.ijse.gdse66.SpringBoot.entity.Item;
import lk.ijse.gdse66.SpringBoot.repository.ItemRepository;
import lk.ijse.gdse66.SpringBoot.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ItemRepository repository;

    public ItemDTO add(ItemDTO dto) {
        Item item = mapper.map(dto, Item.class);
        Item addedData = repository.save(item);
        return mapper.map(addedData, ItemDTO.class);
    }
}