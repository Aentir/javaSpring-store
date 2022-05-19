package com.kreitek.store.application.service.impl;

import com.kreitek.store.application.dto.ItemDTO;
import com.kreitek.store.application.mapper.ItemMapper;
import com.kreitek.store.application.service.ItemService;
import com.kreitek.store.domain.entity.Item;
import com.kreitek.store.domain.persistence.ItemPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItemServiceImpl implements ItemService {

    private final ItemPersistence itemPersistence;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemPersistence itemPersistence, ItemMapper itemMapper) {
        this.itemPersistence = itemPersistence;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemPersistence.getAllItems();
        return itemMapper.toDto(items);
    }

    @Override
    public List<ItemDTO> getAllItemsByCategory(Long itemId) {
        List<Item> items = itemPersistence.getAllItemsByCategory(itemId);
        return itemMapper.toDto(items);
    }

    @Override
    public Optional<ItemDTO> getItemById(Long itemId) {
        return itemPersistence.getItemById(itemId).map(itemMapper::toDto);
    }

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        Item itemSaved = itemPersistence.saveItem(itemMapper.toEntity(itemDTO));
        return itemMapper.toDto(itemSaved);
    }

    @Override
    public void deleteItem(Long itemId) {
        itemPersistence.deleteItem(itemId);
    }
}
