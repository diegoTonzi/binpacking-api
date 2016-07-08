package br.com.binpacking.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.binpacking.api.dto.ContainerDto;
import br.com.binpacking.api.resource.ContainerResource;
import br.com.binpacking.model.Container;
import br.com.binpacking.restrictions.LimitedContainer;

@Component
public class ContainerMapper {
	
	@Autowired
	ItemMapper itemMapper;
	
	public Container toModel(ContainerDto dto){
		LimitedContainer restrictions = new LimitedContainer(dto.getMaxWidth(), dto.getMaxLength(), dto.getMaxHeight(), dto.getMaxWeight());
		restrictions.setMinWidth(dto.getMinWidth());
		restrictions.setMinLength(dto.getMinLength());
		restrictions.setMinHeight(dto.getMinHeight());
		restrictions.setMinWeight(dto.getMinWeight());
		restrictions.setMaxTotalSize(dto.getMaxTotalSize());
		return new Container(restrictions);
	}
	
	public List<Container> toModel(List<ContainerDto> dtos){
		List<Container> containers = new ArrayList<>();
		for (ContainerDto containerDto : dtos) {
			containers.add(toModel(containerDto));
		}
		return containers;
	}

	public ContainerResource toResource(Container container){
		ContainerResource containerResource = new ContainerResource(container.getMeasures().getWidth(), container.getMeasures().getLength(), container.getMeasures().getHeight(), container.getMeasures().getWeight());
		containerResource.setItems(itemMapper.toResource(container.getItems()));
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
