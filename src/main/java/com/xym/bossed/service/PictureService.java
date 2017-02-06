package com.xym.bossed.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;

import com.xym.bossed.db.mybatis.picture.Picture;
import com.xym.bossed.db.mybatis.picture.PictureDAO;
import com.xym.bossed.db.mybatis.picture.PictureExample;

public class PictureService {

	public static void main(String[] args) {
		List<Picture> pics=new PictureService().getPicturesByOwnerIdInDB("kgrkh");
		for(int i=0;i<pics.size();i++)
		{
			System.out.println(pics.get(i).getPath());
		}
		
	}

	public void uploadPicture() {

	}

	/**
	 * save base64 string to png file
	 */
	public String base64String2File(String base64Str) {
		if (!base64Str.contains("base64")) {
			return "Fail:do not contain [base64] string";
		}
		// get base64 string from the args
		String str_base64 = base64Str
				.substring(base64Str.indexOf("base64") + 7);
		String str_tmp_folder = System.getProperty("user.home");
		// if the user.home folder can not written,return fail
		if (!new File(str_tmp_folder).canWrite()) {
			return "Fail:check the tmp folder whether can be writeen.";
		}
		String fileName = str_tmp_folder + "\\tmp_"
				+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
				+ new Random(10).nextInt() + ".png";
		// System.out.println(fileName);
		try {
			FileOutputStream fw = new FileOutputStream(fileName);
			fw.write(new Base64().decodeBase64(str_base64));
			fw.close();
		} catch (IOException e) {
			return "Fail:"+e.getMessage();
		}

		return fileName;
	}

	public int createPictureInDB(Picture picture) {
		PictureDAO dao = new PictureDAO();
		picture.setUpdateDate(new Date());
		return dao.insertSelective(picture);
	}

	public int deletePictureByIdInDB(int id) {
		PictureDAO dao = new PictureDAO();
		PictureExample e = new PictureExample();
		e.or().andIdEqualTo(id);
		return dao.deleteByExample(e);
	}
	public int deletePictureByPathInDB(String path)
	{
		PictureDAO dao = new PictureDAO();
		PictureExample e = new PictureExample();
		e.or().andPathEqualTo(path);
		return dao.deleteByExample(e);
	}
	public int updatePictureInDB(Picture picture) {
		PictureDAO dao = new PictureDAO();
		picture.setUpdateDate(new Date());
		return dao.updateByPrimaryKeySelective(picture);
	}

	public List<Picture> getAllPicturesInDB() {
		PictureDAO dao = new PictureDAO();
		return dao.selectByExample(new PictureExample());
	}

	public List<Picture> getPicturesByOwnerIdInDB(String owner_id) {
		PictureDAO dao = new PictureDAO();
		PictureExample pe = new PictureExample();
		pe.or().andOwnerIdEqualTo(owner_id);
		return dao.selectByExample(pe);
	}
	public List<Picture> queryDistinctPicturesByOwnerIdInDB(String owner_id)
	{
		PictureDAO dao = new PictureDAO();
		PictureExample pe = new PictureExample();
		pe.setDistinct(true);
		pe.or().andOwnerIdLike("%"+owner_id+"%");
		return dao.selectDistinctPictureByOwnerId(pe);
	}
	public List<Picture> getPicturesByPathInDB(String path) {
		PictureDAO dao = new PictureDAO();
		PictureExample pe = new PictureExample();
		pe.or().andPathEqualTo(path);
		return dao.selectByExample(pe);
	}
}
