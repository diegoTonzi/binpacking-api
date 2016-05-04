package br.com.diegotonzi.binpacking.api.dto;

public class ItemDto {

	private String id;
	private String description;
	private boolean rotateVerticaly;
	private int quantity;
	private MeasuresDto measures = new MeasuresDto();

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MeasuresDto getMeasures() {
		return measures;
	}

	public void setMeasures(MeasuresDto measures) {
		this.measures = measures;
	}

}
