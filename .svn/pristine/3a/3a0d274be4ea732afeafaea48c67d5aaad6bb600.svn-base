package com.xym.bossed.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONArray;

import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibie;
import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibieDAO;
import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibieExample;
import com.xym.bossed.web.jeasyui.TreeData;

public class KehuLeibieService {
	public JSONArray makeTreeData(List<KehuLeibie> list) {
		JSONArray ja = new JSONArray();

		// put the list to Map.
		Map<String, TreeData> map = new TreeMap();
		for (int i = 0; i < list.size(); i++) {
			TreeData td = new TreeData();
			KehuLeibie kl = list.get(i);

			td.setId(kl.getKehulbDm());
			td.setText(kl.getKehulbMc());
			td.setParent_id(kl.getKehulbTop());

			map.put(kl.getKehulbDm(), td);

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

	public List<KehuLeibie> getAllLeibie() {
		KehuLeibieDAO dao = new KehuLeibieDAO();
		return dao.selectByExample(new KehuLeibieExample());
	}
}
