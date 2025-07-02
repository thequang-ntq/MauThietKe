package strategy_demo.strategy;

public class SapXepChen implements StrategySapXep{
	@Override
	public void sapXep(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			// Di chuyển các phần tử của arr[0..i-1], lớn hơn key, đến một vị trí phía sau
			// so với vị trí hiện tại của chúng
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		System.out.println("Sắp xếp chèn:");
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
