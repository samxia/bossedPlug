package com.xym.bossed.interfaces;

import java.util.List;

import com.xym.bossed.db.mybatis.parts.Parts;

public interface IPartsService {

	public abstract List<Parts> getPartsByCriteria(Parts parts);

}