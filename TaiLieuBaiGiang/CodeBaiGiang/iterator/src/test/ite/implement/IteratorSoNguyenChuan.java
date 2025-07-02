package test.ite.implement;

import java.util.List;

import test.ite.IteratorSoNguyen;

// Duyệt danh sách số nguyên theo kiểu chuẩn
public class IteratorSoNguyenChuan implements IteratorSoNguyen {
	private List<Integer> lst;
	private int pos;

	public IteratorSoNguyenChuan(List<Integer> lst) {
		this.lst = lst;
	}

	@Override
	public void start() {
		this.pos = 0;
	}

	@Override
	public boolean hasNext() {
		if (this.pos <= this.lst.size() - 1)
			return true;
		else
			return false;
	}

	@Override
	public int next() {
		var x = this.lst.get(this.pos);
		this.pos++;
		return x;
	}
}
