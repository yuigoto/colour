package com.eixox.colour;

import java.util.HashMap;

/**
 * Simple color conversion methods, based on my Zero (_0) PHP library.
 * 
 * Most methods I found over the internet.
 * 
 * @author Fabio Y. Goto 
 */
public class ColourConverters {
	/**
	 * Converts a color from the HSV colorspace to the RGB colorspace.
	 * 
	 * @param h {Integer}
	 * @param s {Integer} 
	 * @param v {Integer}
	 * @return {HashMap<String, Integer>}
	 */
	public static HashMap<String, Integer> HsvRgb(int h, int s, int v) {
		float _h, _s, _v;
		int i;
		float f, p, q, t, r, g, b;
		HashMap<String, Integer> rgb = new HashMap<String, Integer>();
		
		if (h > 360) h -= 360;
		if (h < 0) h += 360;

		_h = (float) h / 360;
		_s = (float) s / 100;
		_v = (float) v / 100;
		
		// Saturation == 0 means grayscale
		if (_s == 0) {
			int val = Math.round(_v * 255);
			
			rgb.put("r", val);
			rgb.put("g", val);
			rgb.put("b", val);
			
			return rgb;
		}

		i = (int) (_h * 6);
		f = (_h * 6) - i;
		p = _v * (1 - _s);
		q = _v * (1 - f * _s);
		t = _v * (1 - (1 - f) * _s);
		
		switch (Math.round(i % 6)) {
			case 1:
				r = q;
				g = _v;
				b = p;
				break;
			case 2:
				r = p;
				g = _v;
				b = t;
				break;
			case 3:
				r = p;
				g = q;
				b = _v;
				break;
			case 4:
				r = t;
				g = p;
				b = _v;
				break;
			case 5:
				r = _v;
				g = p;
				b = q;
				break;
			default:
				r = _v;
				g = t;
				b = p;
				break;
		}
		
		rgb.put("r", Math.round(r * 255));
		rgb.put("g", Math.round(g * 255));
		rgb.put("b", Math.round(b * 255));
		
		return rgb;
	}
	
	/**
	 * Converts a color from the RGB colorspace to the HSV colorspace.
	 * 
	 * @param r {Integer} 
	 * @param g {Integer} 
	 * @param b {Integer} 
	 * @return {HashMap<String, Integer>} 
	 */
	public static HashMap<String, Integer> RgbHsv(int r, int g, int b) {
		float _r, _g, _b, min, max, dif, _h, _s, _v;
		
		_r = (float) r / 255;
		_g = (float) g / 255;
		_b = (float) b / 255;
		
		max = maxOf(_r, _g, _b);
		min = minOf(_r, _g, _b);
		dif = max - min;
		
		_v = max * 100;
		
		if (dif == 0) {
			_h = 0;
			_s = 0;
		} else {
			_s = 100 * (dif / max);
			
			_h = 3 - ((_g - _b) / dif);
			
			if (min == _g) {
				_h = 3 - ((_b - _r) / dif);
			} else if (min == _b) {
				_h = 3 - ((_r - _g) / dif);
			}
			
			_h = 60 * _h;
			if (_h >= 360) _h -= 360;
		}
		
		HashMap<String, Integer> hsv = new HashMap<String, Integer>();
		
		hsv.put("h", Math.round(_h));
		hsv.put("s", Math.round(_s));
		hsv.put("v", Math.round(_v));
		
		return hsv;
	}
	
	/**
	 * Converts RGB color values from decimal (0 ~ 255) to percentual 
	 * values (0 ~ 100).
	 * 
	 * @param r {Integer} 
	 * @param g {Integer} 
	 * @param b {Integer} 
	 * @return {HashMap<String, Float>} 
	 */
	public static HashMap<String, Float> RgbToPercent(int r, int g, int b) {
		HashMap<String, Float> rgb = new HashMap<String, Float>();

		rgb.put("r", (float) r / 255);
		rgb.put("g", (float) g / 255);
		rgb.put("b", (float) b / 255);
		
		return rgb;
	}
	
	/**
	 * Converts a color from the RGB colorspace to the CMYK colorspace.
	 * 
	 * @param r {Float} 
	 * @param g {Float} 
	 * @param b {Float} 
	 * @return {HashMap<String,Integer>} 
	 */
	public static HashMap<String, Integer> RgbCmyk(float r, float g, float b) {
		float _c, _m, _y, _k;
		
		_k = minOf( 1 - r, 1 - g, 1 - b );
		_c = (1 - r - _k) / (1 - _k);
		_m = (1 - g - _k) / (1 - _k);
		_y = (1 - b - _k) / (1 - _k);
		
		HashMap<String, Integer> cmyk = new HashMap<String, Integer>();
		cmyk.put("c", Math.round(_c * 100));
		cmyk.put("m", Math.round(_m * 100));
		cmyk.put("y", Math.round(_y * 100));
		cmyk.put("k", Math.round(_k * 100));
		return cmyk;
	}
	
	/**
	 * Converts a color from the CMYK colorspace to the RGB colorspace.
	 * 
	 * @param c {Float} 
	 * @param m {Float} 
	 * @param y {Float} 
	 * @param k {Float} 
	 * @return {HashMap<String,Integer>} 
	 */
	public static HashMap<String, Integer> CmykRgb(float c, float m, float y, float k) {
		float _c, _m, _y, _k;
		HashMap<String, Integer> rgb = new HashMap<String, Integer>();
		
		_c = c / 100;
		_m = m / 100;
		_y = y / 100;
		_k = k / 100;

		rgb.put("r", Math.round(255 * (1 - _c) * (1 - _k)));
		rgb.put("g", Math.round(255 * (1 - _m) * (1 - _k)));
		rgb.put("b", Math.round(255 * (1 - _y) * (1 - _k)));
		
		return rgb;
	}
	
	/**
	 * Returns the minimum value from a, b and c.
	 * 
	 * @param a {Float} 
	 * @param b {Float} 
	 * @param c {Float} 
	 * @return {Float}
	 */
	public static float minOf(float a, float b, float c) {
		float min = a;
		if (b < min) min = b;
		if (c < min) min = c;
		return min;
	}
	
	/**
	 * Returns the maximum value from a, b and c.
	 * 
	 * @param a {Float} 
	 * @param b {Float} 
	 * @param c {Float} 
	 * @return {Float}
	 */
	public static float maxOf(float a, float b, float c) {
		float max = a;
		if (b > max) max = b;
		if (c > max) max = c;
		return max;
	}
}
