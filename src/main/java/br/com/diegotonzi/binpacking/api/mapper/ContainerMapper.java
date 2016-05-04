package br.com.diegotonzi.binpacking.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.diegotonzi.binpacking.api.resource.ContainerResource;
import br.com.diegotonzi.binpacking.api.resource.ItemResource;
import br.com.diegotonzi.binpacking.model.Container;

@Component
public class ContainerMapper {
	
	@Autowired
	ItemMapper itemMapper;

	public ContainerResource toResource(Container container){
		List<ItemResource> itemResources = itemMapper.toResource(container.getItems());
		ContainerResource containerResource = new ContainerResource(container.getMeasures().getWidth(), container.getMeasures().getLength(), container.getMeasures().getHeight(), container.getMeasures().getWeight(), itemResources);
		return containerResource;
	}
	
	public List<ContainerResource> toResource(List<Container> containers){
		List<ContainerResource> containerResources = new ArrayList<>();
		for (Container container : containers) {
			containerResources.add(toResource(container));
		}
		return containerResources;
	}
	
}
