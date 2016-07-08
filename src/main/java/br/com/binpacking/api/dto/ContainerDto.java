package br.com.binpacking.api.dto;

public class ContainerDto {

	private Double minWidth;
	private Double maxWidth;

	private Double minLength;
	private Double maxLength;

	private Double minHeight;
	private Double maxHeight;

	private Double minWeight;
	private Double maxWeight;

	private Double maxTotalSize;

	public Double getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(Double minWidth) {
		this.minWidth = minWidth;
	}

	public Double getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(Double maxWidth) {
		this.maxWidth = maxWidth;
	}

	public Double getMinLength() {
		return minLength;
	}

	public void setMinLength(Double minLength) {
		this.minLength = minLength;
	}

	public Double getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Double maxLength) {
		this.maxLength = maxLength;
	}

	public Double getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(Double minHeight) {
		this.minHeight = minHeight;
	}

	public Double getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(Double maxHeight) {
		this.maxHeight = maxHeight;
	}

	public Double getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(Double minWeight) {
		this.minWeight = minWeight;
	}

	public Double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Double getMaxTotalSize() {
		return maxTotalSize;
	}

	public void setMaxTotalSize(Double maxTotalSize) {
		this.maxTotalSize = maxTotalSize;
	}

}
