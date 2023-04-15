/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log
get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
You should be as efficient with time and space as possible.
*/

public class OrderLog {

	private int[] buffer;
	private int head;
	private boolean full;

	public OrderLog(int size) {
		buffer = new int[size];
		head = 0;
		full = false;
	}

	public void record(int order_id) {
		buffer[head] = order_id;
		head = (head + 1) % buffer.length;
		if (head == 0) {
			full = true;
		}
	}

	public int get_last(int i) {
		if (i < 1 || i > buffer.length || (!full && i > head) || (full && i > buffer.length)) {
			throw new IllegalArgumentException("Invalid index i");
		}
		int index = head - i;
		if (index < 0) {
			index += buffer.length;
		}
		return buffer[index];
	}

	public static void main(String[] args) {
		OrderLog registro = new OrderLog(5);
		registro.record(1);
		registro.record(2);
		registro.record(3);
		registro.record(4);
		registro.record(5);

		// Obtener el último elemento
		System.out.println(registro.get_last(1)); // Debería imprimir 5
		System.out.println(registro.get_last(2)); // Debería imprimir 4
		System.out.println(registro.get_last(3)); // Debería imprimir 3

		// Registrar un nuevo pedido
		registro.record(6);

		// Obtener el último elemento después de registrar un nuevo pedido
		System.out.println(registro.get_last(1)); // Debería imprimir 6
	}
}
