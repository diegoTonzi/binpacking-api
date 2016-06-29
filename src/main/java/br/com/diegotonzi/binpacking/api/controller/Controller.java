package br.com.diegotonzi.binpacking.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegotonzi.binpacking.api.dto.Request;
import br.com.diegotonzi.binpacking.api.mapper.ContainerMapper;
import br.com.diegotonzi.binpacking.api.mapper.ItemMapper;
import br.com.diegotonzi.binpacking.api.resource.ContainerResource;
import br.com.diegotonzi.binpacking.api.resource.Resource;
import br.com.diegotonzi.binpacking.controller.PackingController;
import br.com.diegotonzi.binpacking.model.Container;
import br.com.diegotonzi.binpacking.model.Item;
import br.com.diegotonzi.binpacking.restrictions.UnlimitedContainer;
import br.com.diegotonzi.binpacking.util.ItemHelper;

@RestController()
@RequestMapping("/container")
public class Controller {
	
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ContainerMapper containerMapper;

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces="application/json")
	public Resource packTest(){
		List<Item> modelItems = ItemHelper.getitems();
		PackingController controller = new PackingController(modelItems, new UnlimitedContainer());
		controller.arrangeItens();
		return getResult(controller);
	}
	
	@ResponseBody
	@RequestMapping(value = "/limited", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public Resource packLimitedContainer(@RequestBody Request request){
		List<Item> items = itemMapper.toModel(request.getItems());
		Container container = containerMapper.toModel(request.getContainer());
		PackingController controller = new PackingController(items, container.getRestrictions());
		controller.arrangeItens();
		return getResult(controller);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/unlimited", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public Resource packUnlimitedContainer(@RequestBody Request request){
		List<Item> modelItems = itemMapper.toModel(request.getItems());
		PackingController controller = new PackingController(modelItems, new UnlimitedContainer());
		controller.arrangeItens();
		return getResult(controller);
	}
	
	private Resource getResult(PackingController controller){
		List<ContainerResource> containers = new ArrayList<>();
		containers = containerMapper.toResource(controller.getContainers());

		Resource resource = new Resource();
		resource.setContainers(containers);
		resource.setStartPacking(controller.getStartPacking());
		resource.setEndPacking(controller.getEndPacking());
		
		return resource;
	}
	
}
