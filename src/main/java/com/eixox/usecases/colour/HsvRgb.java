package com.eixox.usecases.colour;

import java.util.HashMap;

import com.eixox.colour.ColourConverters;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

/**
 * Converts HSV color values to the RGB colorspace.
 * 
 * - Hue (s) must be a value between 0 and 360;
 * - Saturation (v) and Brightness/Value (v)must be a value between 0 and 100;
 * 
 * @author Fabio Y. Goto
 */
public class HsvRgb extends UsecaseImplementation<HsvRgb.Parameters, HashMap<String, Integer>> {
	public static class Parameters {
		@Required
		public int h;
		
		@Required 
		public int s;
		
		@Required 
		public int v;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Parameters, HashMap<String, Integer>> execution) throws Exception {
		HashMap<String, Integer> rgb = ColourConverters.HsvRgb(
				execution.params.h, 
				execution.params.s,
				execution.params.v 
		);
		
		execution.result = rgb;
		execution.result_type = UsecaseResultType.SUCCESS;
	}
}
