package br.com.diegotonzi.binpacking.resource;

public class ItemResource {

	private Double width;
	private Double length;
	private Double height;
	private Double weight;

	private Double poitWidth;
	private Double poitLength;
	private Double poitHeight;

	public ItemResource(Double width, Double length, Double height,
			Double weight, Double poitWidth, Double poitLength,
			Double poitHeight) {
		this.width = width;
		this.length = length;
		this.height = height;
		this.weight = weight;
		this.poitWidth = poitWidth;
		this.poitLength = poitLength;
		this.poitHeight = poitHeight;
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

	public Double getPoitWidth() {
		return poitWidth;
	}

	public Double getPoitLength() {
		return poitLength;
	}

	public Double getPoitHeight() {
		return poitHeight;
	}

}
