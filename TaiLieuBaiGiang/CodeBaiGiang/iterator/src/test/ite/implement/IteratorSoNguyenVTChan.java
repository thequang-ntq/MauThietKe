package test.ite.implement;

import java.util.ArrayList;
import java.util.List;

import test.ite.IteratorSoNguyen;

public class IteratorSoNguyenVTChan implements IteratorSoNguyen{
	private int vt;
	private List<Integer> lst;
	
	public IteratorSoNguyenVTChan(List<Integer> lst) {
		this.lst = new ArrayList<>();
		for (int i = 0; i < lst.size(); i = i+2)
			this.lst.add(lst.get(i));		
	}
	
	@Override
	public void start() {
		this.vt = 0;		
	}

	@Override
	public boolean hasNext() {
		return this.vt < this.lst.size();
	}

	@Override
	public int next() {
		var x = this.lst.get(vt);
		vt++;
		return x;
	}

}
