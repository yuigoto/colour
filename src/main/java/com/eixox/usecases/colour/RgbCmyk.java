package com.eixox.usecases.colour;

import java.util.HashMap;

import com.eixox.colour.ColourConverters;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

/**
 * Converts RGB color values to the CMYK colorspace.
 * 
 * RGB values must range from 0 ~ 255.
 * 
 * @author Fabio Y. Goto
 */
public class RgbCmyk extends UsecaseImplementation<RgbCmyk.Parameters, HashMap<String, Integer>> {
	public static class Parameters {
		@Required 
		public int r;

		@Required 
		public int g;
		
		@Required 
		public int b;
	}
	
	@Override
	protected void mainFlow(UsecaseExecution<Parameters, HashMap<String, Integer>> execution) throws Exception {
		HashMap<String, Float> rgb = ColourConverters.RgbToPercent(
				execution.params.r,
				execution.params.g,
				execution.params.b
		);
		
		HashMap<String, Integer> cmyk = ColourConverters.RgbCmyk(rgb.get("r"), rgb.get("g"), rgb.get("b"));
		
		execution.result = cmyk;
		execution.result_type = UsecaseResultType.SUCCESS;
	}
}
