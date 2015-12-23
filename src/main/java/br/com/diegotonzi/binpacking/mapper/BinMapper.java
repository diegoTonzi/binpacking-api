package br.com.diegotonzi.binpacking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.diegotonzi.binpacking.model.Bin;
import br.com.diegotonzi.binpacking.resource.BinResource;
import br.com.diegotonzi.binpacking.resource.ItemResource;

@Component
public class BinMapper {
	
	@Autowired
	ItemMapper itemMapper;

	public BinResource toResource(Bin bin){
		List<ItemResource> itemResources = itemMapper.toResource(bin.getItems());
		BinResource binResource = new BinResource(bin.getMeasures().getWidth(), bin.getMeasures().getLength(), bin.getMeasures().getHeight(), bin.getMeasures().getWeight(), itemResources);
		return binResource;
	}
	
	public List<BinResource> toResource(List<Bin> bins){
		List<BinResource> binResources = new ArrayList<>();
		for (Bin bin : bins) {
			binResources.add(toResource(bin));
		}
		return binResources;
	}
	
}
