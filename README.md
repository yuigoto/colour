Colour Converters
=================

Color conversion methods (+ a random Hex color generator) built on top of **[Eixo X's Jetfuel](https://github.com/EixoX/jetfuel)** as proof-of-concept on how easy and fast it is to build API endpoints using Jetfuel's programming paradigm.

And by easy and fast I **totally** mean it, since I barely know a few things about Java. :wink:

Most of these color conversion methods were found all over the internet, I just don't remember where! :sweat_smile:

-----

#### Testing

Just add the project to your local copy of Jetfuel (follow the instructions on the project's repository) and access any of the following endpoints:

- **`/colour/CmykRgb`**: converts a color from the CMYK color space to RGB values, ranging from 0 ~ 255;
	- _This endpoint accepts CMYK values ranging from 0 ~ 100_;
- **`/colour/HsvRgb`**: converts a color from the HSV color space to RGB values, ranging from 0 ~ 255;
	- _This endpoint accepts a H value ranging from 0 ~ 360 and S/V values ranging from 0 ~ 100_;
- **`/colour/RandomHexColorList`**;
- **`/colour/RgbCmyk`**: converts a color from the RGB color space to CMYK values, ranging from 0 ~ 100;
	- _This endpoint accepts RGB values ranging from 0 ~ 255_;
- **`/colour/RgbHex`**: converts a color from the RGB color space to a RGB Hex string;
	- _This endpoint accepts RGB values ranging from 0 ~ 255_;
- **`/colour/RgbHsv`**: converts a color from the RGB color space to HSV values, with H ranging from 0 ~ 360 and S/V ranging from 0 ~ 100;
	- _This endpoint accepts RGB values ranging from 0 ~ 255_;