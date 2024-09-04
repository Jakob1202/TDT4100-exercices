package oving5.debugging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

	private Iterator<String> first;
	private Iterator<String> second;
	private boolean turnSwitch;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second) {
		this.first = first;
		this.second = second;
		this.turnSwitch = true;
	}

	@Override
	public boolean hasNext() {
		return first.hasNext() || second.hasNext();
	}

	@Override
	public String next() {

		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		String result = null;

		if (!first.hasNext()) {
			result = first.next();
		} else if (!second.hasNext()) {
			result = second.next();
		} else {
			if (turnSwitch) {
				result = first.next();
				turnSwitch = false;
			}
			if (!turnSwitch) {
				result = second.next();
				turnSwitch = true;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Iterator<String> one = new ArrayList<String>(List.of("a", "b")).iterator();
		Iterator<String> two = new ArrayList<String>(List.of("c", "d", "e")).iterator();

		StringMergingIterator mergeIterator = new StringMergingIterator(one, two);

		List<String> values = new ArrayList<String>();

		while (mergeIterator.hasNext()) {
			System.out.println(mergeIterator.next());
			values.add(mergeIterator.next());
		}
	}
}
