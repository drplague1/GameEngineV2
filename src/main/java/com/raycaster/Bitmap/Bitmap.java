package com.raycaster.Bitmap;

import com.raycaster.utils.IType;
import com.raycaster.utils.Tuple;

/**
 * A Vertical First Bitmap
 * 
 * @author Squareys
 * 
 */

public class Bitmap<T> extends AbstractBitmap<T> {

	private int m_width;
	private int m_height;
	private int m_length;

	public T m_pixels[];

	public Bitmap(int width, int height, IType<T> t) {
		m_width = width;
		m_height = height;
		m_length = m_height * m_width;

		m_pixels = t.createArray(m_width * m_height);
	}

	@Override
	public IBitmap<T> loadFromFile(String filename) {
		return null;
	}

	@Override
	public int pointToIndex(int x, int y) {
		return (x * m_height + y);
	}

	@Override
	public Tuple<Integer, Integer> indexToPoint(int index) {
		int y = index % m_height;
		int x = (index - y) / m_height;

		return new Tuple<Integer, Integer>(x, y);
	}

	@Override
	public int getWidth() {
		return m_width;
	}

	@Override
	public int getHeight() {
		return m_height;
	}

	@Override
	public T getPixel(int x, int y) {
		return m_pixels[pointToIndex(x, y)];
	}

	@Override
	public T getPixel(int index) {
		return m_pixels[index];
	}

	@Override
	public void putPixel(int x, int y, T color) {
		m_pixels[pointToIndex(x, y)] = color;
	}

	@Override
	public void putPixel(int index, T color) {
		m_pixels[index] = color;
	}

	@Override
	public void clear(T col) {
		for (int i = 0; i < m_width * m_height; i++) {
			m_pixels[i] = col;
		}
	}

	@Override
	public BitmapCursor<T> getCursor() {
		return new VerticalFirstBitmapCursor<T>(this);
	}

	@Override
	public int getLength() {
		return m_length;
	}
}
