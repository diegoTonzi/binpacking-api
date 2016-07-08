package br.com.binpacking.api.resource;

public class ItemResource {

	private String id;
	private String description;
	private boolean rotateVerticaly;

	private Double width;
	private Double length;
	private Double height;
	private Double weight;

	private Double poitWidth;
	private Double poitLength;
	private Double poitHeight;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRotateVerticaly() {
		return rotateVerticaly;
	}

	public void setRotateVerticaly(boolean rotateVerticaly) {
		this.rotateVerticaly = rotateVerticaly;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getPoitWidth() {
		return poitWidth;
	}

	public void setPoitWidth(Double poitWidth) {
		this.poitWidth = poitWidth;
	}

	public Double getPoitLength() {
		return poitLength;
	}

	public void setPoitLength(Double poitLength) {
		this.poitLength = poitLength;
	}

	public Double getPoitHeight() {
		return poitHeight;
	}

	public void setPoitHeight(Double poitHeight) {
		this.poitHeight = poitHeight;
	}

}
