package com.xym.bossed.interfaces;

import java.util.List;

import com.xym.bossed.db.mybatis.parts.fenlu.PartsFenLu;

public interface IPartsFenLuService {

	public abstract List<PartsFenLu> getFenLuByPartsNo(String partsNo);

}