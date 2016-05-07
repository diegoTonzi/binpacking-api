package br.com.diegotonzi.binpacking.api.resource;

import java.util.Calendar;
import java.util.List;

public class Resource {

	private Calendar startPacking;
	private Calendar endPacking;
	private List<ContainerResource> containers;

	public Calendar getStartPacking() {
		return startPacking;
	}

	public void setStartPacking(Calendar startPacking) {
		this.startPacking = startPacking;
	}

	public Calendar getEndPacking() {
		return endPacking;
	}

	public void setEndPacking(Calendar endPacking) {
		this.endPacking = endPacking;
	}

	public List<ContainerResource> getContainers() {
		return containers;
	}

	public void setContainers(List<ContainerResource> containers) {
		this.containers = containers;
	}

}
