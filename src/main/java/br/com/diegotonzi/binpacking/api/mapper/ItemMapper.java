package br.com.diegotonzi.binpacking.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.diegotonzi.binpacking.api.dto.ItemDto;
import br.com.diegotonzi.binpacking.api.dto.MeasuresDto;
import br.com.diegotonzi.binpacking.api.resource.ItemResource;
import br.com.diegotonzi.binpacking.model.Item;
import br.com.diegotonzi.binpacking.model.Measures;

@Component
public class ItemMapper {

	public Item toModel(ItemDto dto) {
		MeasuresDto measuresDto = dto.getMeasures();
		Measures measures = new Measures(measuresDto.getWidth(), measuresDto.getLength(), measuresDto.getHeight(), measuresDto.getWeight());
		Item item = new Item(measures, dto.getId(), dto.isRotateVerticaly());
		item.setDescription(dto.getDescription());
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
		ItemResource resource = new ItemResource();
		resource.setId(item.getId());
		resource.setDescription(item.getDescription());
		resource.setRotateVerticaly(item.isRotateVerticaly());
		resource.setWidth(item.getWidth());
		resource.setLength(item.getLength());
		resource.setHeight(item.getHeight());
		resource.setWeight(item.getWeight());
		resource.setPoitWidth(item.getPoint().getWidth().getBegin());
		resource.setPoitLength(item.getPoint().getLength().getBegin());
		resource.setPoitHeight(item.getPoint().getHeight().getBegin());
		return resource;
	}

	public List<ItemResource> toResource(List<Item> items) {
		List<ItemResource> resources = new ArrayList<>();
		for (Item item : items) {
			resources.add(toResource(item));
		}
		return resources;
	}

}
