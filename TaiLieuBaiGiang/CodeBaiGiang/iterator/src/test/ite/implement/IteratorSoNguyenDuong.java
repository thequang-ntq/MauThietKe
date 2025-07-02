package test.ite.implement;

import java.util.ArrayList;
import java.util.List;

import test.ite.IteratorSoNguyen;

public class IteratorSoNguyenDuong implements IteratorSoNguyen {
	private List<Integer> lst;
	private int pos;

	public IteratorSoNguyenDuong(List<Integer> lst) {
		this.lst = new ArrayList<>();
		lst.forEach(x -> {
			if (x > 0)
				this.lst.add(x);
		});
	}

	public IteratorSoNguyenDuong(Integer... integers) {
		lst = new ArrayList<>();
		for (var x: integers)
			if (x > 0)
				lst.add(x);
	}
	
	@Override
	public void start() {
		this.pos = 0;
	}

	@Override
	public boolean hasNext() {
		return this.pos <= this.lst.size() - 1;
	}

	@Override
	public int next() {
		var x = this.lst.get(this.pos);
		this.pos++;
		return x;
	}

}
