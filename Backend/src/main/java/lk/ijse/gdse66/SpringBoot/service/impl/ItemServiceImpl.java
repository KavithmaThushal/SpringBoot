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
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDTO add(ItemDTO dto) {
        Item item = modelMapper.map(dto, Item.class);
        Item addedData = itemRepository.save(item);
        return modelMapper.map(addedData, ItemDTO.class);
    }
}