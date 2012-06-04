package com.lateblindcat.sid.demo;

import java.util.ArrayList;
import java.util.List;

import com.lateblindcat.sid.core.framework.ModuleConfig;
import com.lateblindcat.sid.snapins.DemoSnapin;
import com.lateblindcat.sid.snapins.DemoSnapin2;
import com.lateblindcat.sid.snapins.Snapin;
import com.lateblindcat.sid.snapins.TwitterSearchFormSnapin;
import com.lateblindcat.sid.snapins.TwitterSearchSnapin;

public class Config implements ModuleConfig {

	@Override
	public String name() {
		return "Demo and Documentation";
	}

	@Override
	public String prefix() {
		return "demo";
	}

	@Override
	public List<Snapin> snapins() {

		List<Snapin> snapins = new ArrayList<Snapin>();
		snapins.add(new DemoSnapin());
		snapins.add(new DemoSnapin2());
		snapins.add(new TwitterSearchFormSnapin());
		snapins.add(new TwitterSearchSnapin());
		return snapins;
	}

}
