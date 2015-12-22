package br.com.diegotonzi.binpacking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegotonzi.binpacking.dto.ItemDto;
import br.com.diegotonzi.binpacking.mapper.ItemMapper;
import br.com.diegotonzi.binpacking.model.Bin;
import br.com.diegotonzi.binpacking.model.Item;
import br.com.diegotonzi.binpacking.restrictions.CorreiosPac;

@RestController("/pack")
public class BinpackingController {
	
	@Autowired
	ItemMapper itemMapper;

	@ResponseBody
	@RequestMapping(value = "/correios", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Bin> pack(@RequestBody List<ItemDto> items){
		List<Item> ItemsModel = itemMapper.toModel(items);
		PackingController controller = new PackingController(ItemsModel, new CorreiosPac());
		controller.arrangeItens();
		return controller.getBins();
	}
	
}
