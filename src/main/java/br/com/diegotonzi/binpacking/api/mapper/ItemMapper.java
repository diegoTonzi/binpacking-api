package br.com.diegotonzi.binpacking.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.diegotonzi.binpacking.api.dto.ItemDto;
import br.com.diegotonzi.binpacking.api.dto.MeasuresDto;
import br.com.diegotonzi.binpacking.api.resource.ItemResource;
import br.com.diegotonzi.binpacking.model.Item;
import br.com.diegotonzi.binpacking.model.Measures;

@Component
public class ItemMapper {

	private long count = 0;
	
	public List<Item> toModel(ItemDto dto) {
		MeasuresDto measuresDto = dto.getMeasures();
		Measures measures = new Measures(measuresDto.getWidth(), measuresDto.getLength(), measuresDto.getHeight(), measuresDto.getWeight());
		
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < dto.getQuantity(); i++) {
			if(StringUtils.isBlank(dto.getId())){
				long id = count++;
				String idStr = StringUtils.leftPad(String.valueOf(id), 4, "0");
				dto.setId(idStr);
			}
			
			Item item = new Item(measures, dto.getId(), dto.isRotateVerticaly());
			item.setDescription(dto.getDescription());
			items.add(item);
		}
		
		return items;
	}

	public List<Item> toModel(List<ItemDto> dtos) {
		List<Item> items = new ArrayList<>();
		for (ItemDto dto : dtos) {
			items.addAll(toModel(dto));
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
	
	public void resetIds(){
		this.count = 0;
	}

}
