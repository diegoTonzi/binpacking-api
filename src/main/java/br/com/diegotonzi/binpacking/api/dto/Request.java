package br.com.diegotonzi.binpacking.api.dto;

import java.util.List;

public class Request {

	private ContainerDto container;
	private List<ItemDto> items;

	public ContainerDto getContainer() {
		return container;
	}

	public void setContainer(ContainerDto container){
		this.container = container;
	}

	public List<ItemDto> getItems() {
		return items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

}
