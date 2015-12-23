package br.com.diegotonzi.binpacking.resource;

import java.util.List;

public class BinResource {

	private Double width;
	private Double length;
	private Double height;
	private Double weight;
	private List<ItemResource> items;

	
	
	public BinResource(Double width, Double length, Double height, Double weight, List<ItemResource> items) {
		this.width = width;
		this.length = length;
		this.height = height;
		this.weight = weight;
		this.items = items;
	}

	public Double getWidth() {
		return width;
	}

	public Double getLength() {
		return length;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}

	public List<ItemResource> getItems() {
		return items;
	}

}
