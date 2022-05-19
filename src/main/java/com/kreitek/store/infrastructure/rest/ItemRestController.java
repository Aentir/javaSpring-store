package com.kreitek.store.infrastructure.rest;


import com.kreitek.store.application.dto.ItemDTO;
import com.kreitek.store.application.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
public class ItemRestController {

    private ItemService itemService;

    @Autowired
    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }


    @CrossOrigin
    @GetMapping(value = "/items-old", produces = "application/json")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/categories/{idCategory}/items", produces = "application/json")
    public ResponseEntity<List<ItemDTO>> getAllItems(@PathVariable Long idCategory) {
        List<ItemDTO> items = itemService.getAllItemsByCategory(idCategory);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/items", produces = "application/json")
    public ResponseEntity<Page<ItemDTO>> getItemsByCriteriaPaged(@RequestParam(value = "filter", required = false) String filter, Pageable pageable) {

        Page<ItemDTO> items = this.itemService.getItemsByCriteriaStringPaged(pageable, filter);
        return new ResponseEntity<Page<ItemDTO>>(items, HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping(value = "/items", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ItemDTO> insertItem(@RequestBody ItemDTO itemDTO) {
        itemDTO = itemService.saveItem(itemDTO);
        return new ResponseEntity<>(itemDTO, HttpStatus.CREATED);
    }

}
