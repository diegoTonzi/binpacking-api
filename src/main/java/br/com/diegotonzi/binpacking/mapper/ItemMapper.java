package br.com.diegotonzi.binpacking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.diegotonzi.binpacking.dto.ItemDto;
import br.com.diegotonzi.binpacking.model.Item;
import br.com.diegotonzi.binpacking.model.Measures;

@Component
public class ItemMapper {

	public Item toModel(ItemDto dto){
		Measures measures = new Measures(dto.getWidth(), dto.getLength(), dto.getHeight(), dto.getWeight());
		Item item = new Item(measures);
		return item;
	}
	
	public List<Item> toModel(List<ItemDto> dtos){
		List<Item> items = new ArrayList<>();
		for (ItemDto dto : dtos) {
			items.add(toModel(dto));
		}
		return items;
	}

}
