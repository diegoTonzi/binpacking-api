package br.com.diegotonzi.binpacking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.diegotonzi.binpacking.dto.ItemDto;
import br.com.diegotonzi.binpacking.model.Item;
import br.com.diegotonzi.binpacking.model.Measures;
import br.com.diegotonzi.binpacking.resource.ItemResource;

@Component
public class ItemMapper {

	public Item toModel(ItemDto dto) {
		Measures measures = new Measures(dto.getWidth(), dto.getLength(),
				dto.getHeight(), dto.getWeight());
		Item item = new Item(measures);
		return item;
	}

	public List<Item> toModel(List<ItemDto> dtos) {
		List<Item> items = new ArrayList<>();
		for (ItemDto dto : dtos) {
			items.add(toModel(dto));
		}
		return items;
	}

	public ItemResource toResource(Item item) {
		return new ItemResource(item.width(), item.length(), item.height() , item.weight(), item.getPoint().getWidth().getBegin(), item.getPoint().getLength().getBegin(), item.getPoint().getHeight().getBegin());
	}

	public List<ItemResource> toResource(List<Item> items) {
		List<ItemResource> resources = new ArrayList<>();
		for (Item item : items) {
			resources.add(toResource(item));
		}
		return resources;
	}

}
