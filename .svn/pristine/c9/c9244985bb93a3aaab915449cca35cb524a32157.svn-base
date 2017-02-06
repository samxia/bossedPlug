package com.xym.bossed.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONArray;

import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibie;
import com.xym.bossed.db.mybatis.parts.category.PartsCategory;
import com.xym.bossed.db.mybatis.parts.category.PartsCategoryDAO;
import com.xym.bossed.db.mybatis.parts.category.PartsCategoryExample;
import com.xym.bossed.web.jeasyui.TreeData;

public class PartsCategoryService {
	public JSONArray makeTreeData(List<PartsCategory> list) {
		JSONArray ja = new JSONArray();

		// put the list to Map.
		Map<String, TreeData> map = new TreeMap();
		for (int i = 0; i < list.size(); i++) {
			TreeData td = new TreeData();
			PartsCategory pc = list.get(i);

			td.setId(pc.getPeijlbDm());
			td.setText(pc.getPeijlbMc());
			td.setParent_id(pc.getPeijlbTop());

			map.put(pc.getPeijlbDm(), td);

		}
		// set child
		Collection<TreeData> c_td_1 = map.values();
		Iterator<TreeData> it_1 = c_td_1.iterator();

		while (it_1.hasNext()) {
			TreeData td = it_1.next();
			String parent_id = td.getParent_id();
			if (parent_id != null && parent_id.trim().isEmpty() == false) {
				TreeData parent = map.get(parent_id);
				List<TreeData> list_td = parent.getChildren();
				if (list_td == null) {
					list_td = new ArrayList<TreeData>();
				}
				list_td.add(td);
				parent.setChildren(list_td);
			}
		
		}
		
		// put the top leibie to jsonarray
		Collection<TreeData> c_td = map.values();
		Iterator<TreeData> it = c_td.iterator();

		while (it.hasNext()) {
			TreeData td = it.next();
			if (td.getParent_id() == null || td.getParent_id().trim().isEmpty()) {
				ja.add(td);
			}
		}
		return ja;

	}
	public List<PartsCategory> getAllCategory() {
		return new PartsCategoryDAO()
				.selectByExample(new PartsCategoryExample());
	}
	public static void main(String[] args)
	{
		PartsCategoryService pcs=new PartsCategoryService();
		System.out.println(pcs.getAllCategory().size());
	}
}
