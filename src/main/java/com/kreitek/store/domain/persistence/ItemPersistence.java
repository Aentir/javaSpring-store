package com.kreitek.store.domain.persistence;

import com.kreitek.store.domain.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemPersistence {
    List<Item> getAllItems();
    List<Item> getAllItemsByCategory(Long itemId);
    Optional<Item> getItemById(Long itemId);
    Item saveItem(Item itemId);
    void deleteItem(Long itemId);
}
