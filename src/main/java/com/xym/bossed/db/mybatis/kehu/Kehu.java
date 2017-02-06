package com.xym.bossed.db.mybatis.kehu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;

import com.xym.bossed.annotation.Lable;
import com.xym.bossed.util.PinYin;

public class Kehu implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -3651020403809049468L;

	private int picCount;
	
	public int getPicCount() {
		return picCount;
	}


	public void setPicCount(int picCount) {
		this.picCount = picCount;
	}


	//�ͻ����
	@Lable(order = 1, value = "���")
    private String kehuNo;

    //���ݿ��¼��
    private Long recoNo;

    //������
    private String kehulbDm;

    //�������
    private String kehulbMc;

    //�ͻ�����
    private String kehuMc;

    //�ͻ���ƴ
    private String kehuDp;

    //�ͻ�����
    private String kehuXm;

    //�ͻ���ϵ��ƴ��
    private String kehuLp;

    //�ͻ��ʱ�
    private String kehuYb;

    //�ͻ�ʡ��
    private String kehuSs;

    //�ͻ���ַ
    private String kehuDz;

    //�ͻ��绰
    private String kehuDh;

    //�ͻ�����
    private String kehuCz;

    //�ͻ�ȫ��
    private String kehuQc;

    //�ͻ�˰��
    private String kehuSh;

    //�ͻ�����
    private String kehuYh;

    //
    private String kehuZh;

    //�ͻ�����
    private String kehuFr;

    
    private String kehuDx;

    //��ַ
    private String kehuHt;

    
    private String kehuEm;

    //�ͻ��Ǽ�����
    private Date kehuDj;

    //�ͻ���ע
    private String kehuBz;

    //�ͻ�����   �� ��ʿ����ʹ�ã� 1-�ͻ� 2-��Ӧ�̣���     3-׼�ͻ� 4-׼��Ӧ��  
    private Short kehuXz;

    
    private BigDecimal kehuXinyushangxian;

    
    private String kehuIsopen;

    
    private Integer kehuPriceCode;

    
    private Integer kehuPriceLv;

    
    private Integer kehuPriceCode1;

    
    private Integer kehuPriceLv1;

    
    private Integer kehuMemberkind;

    //�ͻ�����
    private Date kehubirthday;

    
    private String kehuzyday1mc;

    
    private Date kehuzyday1date;

    
    private String kehuzyday2mc;

    
    private Date kehuzyday2date;

    
    private String kehujb;

    //�ͻ��ֻ�
    private String kehuSj;

    //�ͻ��������
    private String kehuMcwb;

    //�ͻ��������
    private String kehuXmwb;

    
    public String getKehuNo() {
        return kehuNo;
    }

    
    public void setKehuNo(String kehuNo) {
        this.kehuNo = kehuNo == null ? null : kehuNo.trim();
    }

    
    public Long getRecoNo() {
        return recoNo;
    }

    
    public void setRecoNo(Long recoNo) {
        this.recoNo = recoNo;
    }

    
    public String getKehulbDm() {
        return kehulbDm;
    }

    
    public void setKehulbDm(String kehulbDm) {
        this.kehulbDm = kehulbDm == null ? null : kehulbDm.trim();
    }

    
    public String getKehulbMc() {
        return kehulbMc;
    }

    
    public void setKehulbMc(String kehulbMc) {
        this.kehulbMc = kehulbMc == null ? null : kehulbMc.trim();
    }

    
    public String getKehuMc() {
        return kehuMc;
    }

    
    public void setKehuMc(String kehuMc) {
        this.kehuMc = kehuMc == null ? null : kehuMc.trim();       
        
    }

    
    public String getKehuDp() {
        return kehuDp;
    }

    
    public void setKehuDp(String kehuDp) {
        this.kehuDp = kehuDp == null ? null : kehuDp.trim();
    }

    
    public String getKehuXm() {
        return kehuXm;
    }

    
    public void setKehuXm(String kehuXm) {
        this.kehuXm = kehuXm == null ? null : kehuXm.trim();
       
    }

    
    public String getKehuLp() {
        return kehuLp;
    }

    
    public void setKehuLp(String kehuLp) {
        this.kehuLp = kehuLp == null ? null : kehuLp.trim();
    }

    
    public String getKehuYb() {
        return kehuYb;
    }

    
    public void setKehuYb(String kehuYb) {
        this.kehuYb = kehuYb == null ? null : kehuYb.trim();
    }

    
    public String getKehuSs() {
        return kehuSs;
    }

    
    public void setKehuSs(String kehuSs) {
        this.kehuSs = kehuSs == null ? null : kehuSs.trim();
    }

    
    public String getKehuDz() {
        return kehuDz;
    }

    
    public void setKehuDz(String kehuDz) {
        this.kehuDz = kehuDz == null ? null : kehuDz.trim();
    }

    
    public String getKehuDh() {
        return kehuDh;
    }

    
    public void setKehuDh(String kehuDh) {
        this.kehuDh = kehuDh == null ? null : kehuDh.trim();
    }

    
    public String getKehuCz() {
        return kehuCz;
    }

    
    public void setKehuCz(String kehuCz) {
        this.kehuCz = kehuCz == null ? null : kehuCz.trim();
    }

    
    public String getKehuQc() {
        return kehuQc;
    }

    
    public void setKehuQc(String kehuQc) {
        this.kehuQc = kehuQc == null ? null : kehuQc.trim();
    }

    
    public String getKehuSh() {
        return kehuSh;
    }

    
    public void setKehuSh(String kehuSh) {
        this.kehuSh = kehuSh == null ? null : kehuSh.trim();
    }

    
    public String getKehuYh() {
        return kehuYh;
    }

    
    public void setKehuYh(String kehuYh) {
        this.kehuYh = kehuYh == null ? null : kehuYh.trim();
    }

    
    public String getKehuZh() {
        return kehuZh;
    }

    
    public void setKehuZh(String kehuZh) {
        this.kehuZh = kehuZh == null ? null : kehuZh.trim();
    }

    
    public String getKehuFr() {
        return kehuFr;
    }

    
    public void setKehuFr(String kehuFr) {
        this.kehuFr = kehuFr == null ? null : kehuFr.trim();
    }

    
    public String getKehuDx() {
        return kehuDx;
    }

    
    public void setKehuDx(String kehuDx) {
        this.kehuDx = kehuDx == null ? null : kehuDx.trim();
    }

    
    public String getKehuHt() {
        return kehuHt;
    }

    
    public void setKehuHt(String kehuHt) {
        this.kehuHt = kehuHt == null ? null : kehuHt.trim();
    }

    
    public String getKehuEm() {
        return kehuEm;
    }

    
    public void setKehuEm(String kehuEm) {
        this.kehuEm = kehuEm == null ? null : kehuEm.trim();
    }

    
    public Date getKehuDj() {
    	return kehuDj;
    }

    
    public void setKehuDj(Date kehuDj) {
        this.kehuDj = kehuDj;
    }

    
    public String getKehuBz() {
        return kehuBz;
    }

    
    public void setKehuBz(String kehuBz) {
        this.kehuBz = kehuBz == null ? null : kehuBz.trim();
    }

    
    public Short getKehuXz() {
        return kehuXz;
    }

    
    public void setKehuXz(Short kehuXz) {
        this.kehuXz = kehuXz;
    }

    
    public BigDecimal getKehuXinyushangxian() {
        return kehuXinyushangxian;
    }

    
    public void setKehuXinyushangxian(BigDecimal kehuXinyushangxian) {
        this.kehuXinyushangxian = kehuXinyushangxian;
    }

    
    public String getKehuIsopen() {
        return kehuIsopen;
    }

    
    public void setKehuIsopen(String kehuIsopen) {
        this.kehuIsopen = kehuIsopen == null ? null : kehuIsopen.trim();
    }

    
    public Integer getKehuPriceCode() {
        return kehuPriceCode;
    }

    
    public void setKehuPriceCode(Integer kehuPriceCode) {
        this.kehuPriceCode = kehuPriceCode;
    }

    
    public Integer getKehuPriceLv() {
        return kehuPriceLv;
    }

    
    public void setKehuPriceLv(Integer kehuPriceLv) {
        this.kehuPriceLv = kehuPriceLv;
    }

    
    public Integer getKehuPriceCode1() {
        return kehuPriceCode1;
    }

    
    public void setKehuPriceCode1(Integer kehuPriceCode1) {
        this.kehuPriceCode1 = kehuPriceCode1;
    }

    
    public Integer getKehuPriceLv1() {
        return kehuPriceLv1;
    }

    
    public void setKehuPriceLv1(Integer kehuPriceLv1) {
        this.kehuPriceLv1 = kehuPriceLv1;
    }

    
    public Integer getKehuMemberkind() {
        return kehuMemberkind;
    }

    
    public void setKehuMemberkind(Integer kehuMemberkind) {
        this.kehuMemberkind = kehuMemberkind;
    }

    
    public Date getKehubirthday() {
        return kehubirthday;
    }

    
    public void setKehubirthday(Date kehubirthday) {
        this.kehubirthday = kehubirthday;
    }

    
    public String getKehuzyday1mc() {
        return kehuzyday1mc;
    }

    
    public void setKehuzyday1mc(String kehuzyday1mc) {
        this.kehuzyday1mc = kehuzyday1mc == null ? null : kehuzyday1mc.trim();
    }

    
    public Date getKehuzyday1date() {
        return kehuzyday1date;
    }

    
    public void setKehuzyday1date(Date kehuzyday1date) {
        this.kehuzyday1date = kehuzyday1date;
    }

    
    public String getKehuzyday2mc() {
        return kehuzyday2mc;
    }

    
    public void setKehuzyday2mc(String kehuzyday2mc) {
        this.kehuzyday2mc = kehuzyday2mc == null ? null : kehuzyday2mc.trim();
    }

    
    public Date getKehuzyday2date() {
        return kehuzyday2date;
    }

    
    public void setKehuzyday2date(Date kehuzyday2date) {
        this.kehuzyday2date = kehuzyday2date;
    }

    
    public String getKehujb() {
        return kehujb;
    }

    
    public void setKehujb(String kehujb) {
        this.kehujb = kehujb == null ? null : kehujb.trim();
    }

    
    public String getKehuSj() {
        return kehuSj;
    }

    
    public void setKehuSj(String kehuSj) {
        this.kehuSj = kehuSj == null ? null : kehuSj.trim();
    }

    
    public String getKehuMcwb() {
        return kehuMcwb;
    }

    
    public void setKehuMcwb(String kehuMcwb) {
        this.kehuMcwb = kehuMcwb == null ? null : kehuMcwb.trim();
    }

    
    public String getKehuXmwb() {
        return kehuXmwb;
    }

    
    public void setKehuXmwb(String kehuXmwb) {
        this.kehuXmwb = kehuXmwb == null ? null : kehuXmwb.trim();
    }
}