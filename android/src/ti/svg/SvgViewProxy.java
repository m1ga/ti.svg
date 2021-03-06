/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2017 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.svg;

import android.app.Activity;
import android.content.Context;

import com.pixplicity.sharp.Sharp;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;

@Kroll.proxy(creatableInModule=TiSvgModule.class)
public class SvgViewProxy extends TiViewProxy
{
	// Standard Debugging variables
	private static final String LCAT = "SvgViewProxy";
	private static final boolean DBG = TiConfig.LOGD;
	private String img;
	private TiUIView view;

	private class SvgView extends TiUIView
	{
		public SvgView(TiViewProxy proxy) {
			super(proxy);
			LayoutArrangement arrangement = LayoutArrangement.DEFAULT;

			if (proxy.hasProperty(TiC.PROPERTY_LAYOUT)) {
				String layoutProperty = TiConvert.toString(proxy.getProperty(TiC.PROPERTY_LAYOUT));
				if (layoutProperty.equals(TiC.LAYOUT_HORIZONTAL)) {
					arrangement = LayoutArrangement.HORIZONTAL;
				} else if (layoutProperty.equals(TiC.LAYOUT_VERTICAL)) {
					arrangement = LayoutArrangement.VERTICAL;
				}
			}
			setNativeView(new TiCompositeLayout(proxy.getActivity(), arrangement));
		}

		@Override
		public void processProperties(KrollDict d)
		{
			super.processProperties(d);
		}
	}


	// Constructor
	public SvgViewProxy()
	{
		super();
	}

	@Override
	public TiUIView createView(Activity activity)
	{
		view = new SvgView(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;

		if (img != ""){
			setImage(img);
		}

		return view;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options)
	{
		super.handleCreationDict(options);

		if (options.containsKey("image")) {
			img  = TiConvert.toString(options.get("image"),"");
		}
	}


	@Kroll.getProperty @Kroll.method
	public String getImage()
	{
        return img;
	}

	@Kroll.setProperty @Kroll.method
	public void setImage(String _img)
	{
		if (view != null && _img != "") {
			Context context = TiApplication.getInstance();
			Sharp.loadAsset(context.getAssets(), "Resources" + _img).into(view.getNativeView());
			img = _img;
		}
	}
}
