package br.com.diegotonzi.binpacking.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegotonzi.binpacking.api.dto.ItemDto;
import br.com.diegotonzi.binpacking.api.mapper.ContainerMapper;
import br.com.diegotonzi.binpacking.api.mapper.ItemMapper;
import br.com.diegotonzi.binpacking.api.resource.ContainerResource;
import br.com.diegotonzi.binpacking.controller.PackingController;
import br.com.diegotonzi.binpacking.model.Item;
import br.com.diegotonzi.binpacking.restrictions.UnlimitedContainer;
import br.com.diegotonzi.binpacking.util.ItemHelper;

@RestController("/packing/correios")
public class Controller {
	
	@Autowired
	ItemMapper itemMapper;
	@Autowired
	ContainerMapper binMapper;

	@ResponseBody
	@RequestMapping(value = "/pac", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<ContainerResource> pack(@RequestBody List<ItemDto> items){
		List<Item> ItemsModel = itemMapper.toModel(items);
		PackingController controller = new PackingController(ItemsModel, new UnlimitedContainer());
		controller.arrangeItens();
		return binMapper.toResource(controller.getContainers());
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public List<ContainerResource> packTest(){
		List<Item> ItemsModel = ItemHelper.getRandomItens(1000);
		PackingController controller = new PackingController(ItemsModel, new UnlimitedContainer());
		controller.arrangeItens();
		return binMapper.toResource(controller.getContainers());
	}
	
}
