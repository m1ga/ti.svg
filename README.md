# Appcelerator Titanium - SVG Module (Android)

<span class="badge-patreon"><a href="https://www.patreon.com/michaelgangolf" title="Donate to this project using Patreon"><img src="https://img.shields.io/badge/patreon-donate-yellow.svg" alt="Patreon donate button" /></a></span>

Basic module for loading SVG files on Android using Sharp (https://github.com/Pixplicity/sharp).

## Requirements

* Titanium SDK 9+


## Example

tiapp.xml
```xml
<modules>
	<module>ti.svg</module>
</modules>
```

Classic version:
```javascript
const Svg = require("ti.svg");

var win = Ti.UI.createWindow({backgroundColor: "#fff"});

var svg = Svg.createSvgView({
	image: "/test.svg",
	width: 200,
	height: 200,
	borderColor: "#000",
	borderWidth: 1
})
win.add(svg);
win.open();
```

Alloy version:
```xml
<SvgView module="ti.svg" image="/test.svg" width="200" height="200"/>

```
**Keep in mind**

The image will be stretched into the view. So set the correct height/width!



## Hyperloop version

You can **use Hyperloop instead of this module** to load an SVG like this:

build.gradle
```
dependencies {
    implementation 'com.pixplicity.sharp:library:1.1.2'
}
```
index.js
```javascript
import Activity from 'android.app.Activity';
import Sharp from "com.pixplicity.sharp.Sharp";

const activity = new Activity(Ti.Android.currentActivity);
const Context = activity.getApplicationContext();
const AssetManager = Context.getAssets();

function onClickShow(e) {
	var fname = "/images/test.svg";
	Sharp.loadAsset(AssetManager, "Resources" + fname).into($.img);
}

$.index.open();
```
index.xml
```xml
<Alloy>
	<Window>
		<ImageView id="img" width="200" height="200"/>
		<Button onClick="onClickShow" title="show" bottom="10"/>
	</Window>
</Alloy>

```


## Author

- Michael Gangolf ([@MichaelGangolf](https://twitter.com/MichaelGangolf) / [Web](http://migaweb.de))
