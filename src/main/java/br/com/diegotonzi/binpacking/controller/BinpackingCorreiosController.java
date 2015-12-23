package br.com.diegotonzi.binpacking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegotonzi.binpacking.dto.ItemDto;
import br.com.diegotonzi.binpacking.mapper.BinMapper;
import br.com.diegotonzi.binpacking.mapper.ItemMapper;
import br.com.diegotonzi.binpacking.model.Item;
import br.com.diegotonzi.binpacking.resource.BinResource;
import br.com.diegotonzi.binpacking.restrictions.CorreiosPac;
import br.com.diegotonzi.binpacking.util.ItemHelper;

@RestController("/packing/correios")
public class BinpackingCorreiosController {
	
	@Autowired
	ItemMapper itemMapper;
	@Autowired
	BinMapper binMapper;

	@ResponseBody
	@RequestMapping(value = "/pac", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<BinResource> pack(@RequestBody List<ItemDto> items){
		List<Item> ItemsModel = itemMapper.toModel(items);
		PackingController controller = new PackingController(ItemsModel, new CorreiosPac());
		controller.arrangeItens();
		return binMapper.toResource(controller.getBins());
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public List<BinResource> packTest(){
		List<Item> ItemsModel = ItemHelper.getRandomItens(1000);
		PackingController controller = new PackingController(ItemsModel, new CorreiosPac());
		controller.arrangeItens();
		return binMapper.toResource(controller.getBins());
	}
	
}
