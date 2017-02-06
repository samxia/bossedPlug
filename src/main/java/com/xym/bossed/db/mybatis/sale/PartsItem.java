package com.xym.bossed.db.mybatis.sale;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PartsItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7477470450780470723L;
	/**
	 * 编码，名称，英语，车型，品牌，备注，图号，仓库，通用车型，产地，通用件号，进口，条形码，单位
	 * 
	 * 不含税单价，原含税单价，含税金额，不含税金额，税额，含税金额，税率，参考价格，开单价格，开单金额，数量，本库现库存数
	 */
	private String  bianMa, mingCheng, english, cheXing, pinPai, beiZhu, tuHao,
			cangKu, tongYongCheXing, chanDi, tongYongJianHao, jinKou,
			tiaoXingMa,danWei,danHao,changKuDaiMa,yeWuDanHao,tiaoMa,huoWei;
	private BigDecimal buHanShuiDanJia, yuanHanShuiDanJia, hanShunJinE,
			buHanShuiJinE, shuiE, hanShuiJinE, shuiLv, canKaoJiaGe,
			kaiDanJiaGe, kaiDanJinE, shuLiang, benKuXianKuCunShu,dianHuoShuLiang,hanShuiDanJia;
    private BigDecimal flagShuLiang1,flagShuLiang,jinJia,jinHuoJinE,keYongLiang,tiaoMaSL;
	private Date dianHuoRiQi;
	
	
	
	public String getHuoWei() {
		return huoWei;
	}
	public void setHuoWei(String huoWei) {
		this.huoWei = huoWei;
	}
	public String getTiaoMa() {
		return tiaoMa;
	}
	public void setTiaoMa(String tiaoMa) {
		this.tiaoMa = tiaoMa;
	}
	public BigDecimal getHanShuiDanJia() {
		return hanShuiDanJia;
	}
	public void setHanShuiDanJia(BigDecimal hanShuiDanJia) {
		this.hanShuiDanJia = hanShuiDanJia;
	}
	public String getBianMa() {
		return bianMa;
	}
	public void setBianMa(String bianMa) {
		this.bianMa = bianMa;
	}
	public String getMingCheng() {
		return mingCheng;
	}
	public void setMingCheng(String mingCheng) {
		this.mingCheng = mingCheng;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getCheXing() {
		return cheXing;
	}
	public void setCheXing(String cheXing) {
		this.cheXing = cheXing;
	}
	public String getPinPai() {
		return pinPai;
	}
	public void setPinPai(String pinPai) {
		this.pinPai = pinPai;
	}
	public String getBeiZhu() {
		return beiZhu;
	}
	public void setBeiZhu(String beiZhu) {
		this.beiZhu = beiZhu;
	}
	public String getTuHao() {
		return tuHao;
	}
	public void setTuHao(String tuHao) {
		this.tuHao = tuHao;
	}
	public String getCangKu() {
		return cangKu;
	}
	public void setCangKu(String cangKu) {
		this.cangKu = cangKu;
	}
	public String getTongYongCheXing() {
		return tongYongCheXing;
	}
	public void setTongYongCheXing(String tongYongCheXing) {
		this.tongYongCheXing = tongYongCheXing;
	}
	public String getChanDi() {
		return chanDi;
	}
	public void setChanDi(String chanDi) {
		this.chanDi = chanDi;
	}
	public String getTongYongJianHao() {
		return tongYongJianHao;
	}
	public void setTongYongJianHao(String tongYongJianHao) {
		this.tongYongJianHao = tongYongJianHao;
	}
	public String getJinKou() {
		return jinKou;
	}
	public void setJinKou(String jinKou) {
		this.jinKou = jinKou;
	}
	public String getTiaoXingMa() {
		return tiaoXingMa;
	}
	public void setTiaoXingMa(String tiaoXingMa) {
		this.tiaoXingMa = tiaoXingMa;
	}
	public String getDanWei() {
		return danWei;
	}
	public void setDanWei(String danWei) {
		this.danWei = danWei;
	}
	public String getDanHao() {
		return danHao;
	}
	public void setDanHao(String danHao) {
		this.danHao = danHao;
	}
	public String getChangKuDaiMa() {
		return changKuDaiMa;
	}
	public void setChangKuDaiMa(String changKuDaiMa) {
		this.changKuDaiMa = changKuDaiMa;
	}
	public String getYeWuDanHao() {
		return yeWuDanHao;
	}
	public void setYeWuDanHao(String yeWuDanHao) {
		this.yeWuDanHao = yeWuDanHao;
	}
	public BigDecimal getBuHanShuiDanJia() {
		return buHanShuiDanJia;
	}
	public void setBuHanShuiDanJia(BigDecimal buHanShuiDanJia) {
		this.buHanShuiDanJia = buHanShuiDanJia;
	}
	public BigDecimal getYuanHanShuiDanJia() {
		return yuanHanShuiDanJia;
	}
	public void setYuanHanShuiDanJia(BigDecimal yuanHanShuiDanJia) {
		this.yuanHanShuiDanJia = yuanHanShuiDanJia;
	}
	public BigDecimal getHanShunJinE() {
		return hanShunJinE;
	}
	public void setHanShunJinE(BigDecimal hanShunJinE) {
		this.hanShunJinE = hanShunJinE;
	}
	public BigDecimal getBuHanShuiJinE() {
		return buHanShuiJinE;
	}
	public void setBuHanShuiJinE(BigDecimal buHanShuiJinE) {
		this.buHanShuiJinE = buHanShuiJinE;
	}
	public BigDecimal getShuiE() {
		return shuiE;
	}
	public void setShuiE(BigDecimal shuiE) {
		this.shuiE = shuiE;
	}
	public BigDecimal getHanShuiJinE() {
		return hanShuiJinE;
	}
	public void setHanShuiJinE(BigDecimal hanShuiJinE) {
		this.hanShuiJinE = hanShuiJinE;
	}
	public BigDecimal getShuiLv() {
		return shuiLv;
	}
	public void setShuiLv(BigDecimal shuiLv) {
		this.shuiLv = shuiLv;
	}
	public BigDecimal getCanKaoJiaGe() {
		return canKaoJiaGe;
	}
	public void setCanKaoJiaGe(BigDecimal canKaoJiaGe) {
		this.canKaoJiaGe = canKaoJiaGe;
	}
	public BigDecimal getKaiDanJiaGe() {
		return kaiDanJiaGe;
	}
	public void setKaiDanJiaGe(BigDecimal kaiDanJiaGe) {
		this.kaiDanJiaGe = kaiDanJiaGe;
	}
	public BigDecimal getKaiDanJinE() {
		return kaiDanJinE;
	}
	public void setKaiDanJinE(BigDecimal kaiDanJinE) {
		this.kaiDanJinE = kaiDanJinE;
	}
	public BigDecimal getShuLiang() {
		return shuLiang;
	}
	public void setShuLiang(BigDecimal shuLiang) {
		this.shuLiang = shuLiang;
	}
	public BigDecimal getBenKuXianKuCunShu() {
		return benKuXianKuCunShu;
	}
	public void setBenKuXianKuCunShu(BigDecimal benKuXianKuCunShu) {
		this.benKuXianKuCunShu = benKuXianKuCunShu;
	}
	public BigDecimal getDianHuoShuLiang() {
		return dianHuoShuLiang;
	}
	public void setDianHuoShuLiang(BigDecimal dianHuoShuLiang) {
		this.dianHuoShuLiang = dianHuoShuLiang;
	}
	public BigDecimal getFlagShuLiang1() {
		return flagShuLiang1;
	}
	public void setFlagShuLiang1(BigDecimal flagShuLiang1) {
		this.flagShuLiang1 = flagShuLiang1;
	}
	public BigDecimal getFlagShuLiang() {
		return flagShuLiang;
	}
	public void setFlagShuLiang(BigDecimal flagShuLiang) {
		this.flagShuLiang = flagShuLiang;
	}
	public BigDecimal getJinJia() {
		return jinJia;
	}
	public void setJinJia(BigDecimal jinJia) {
		this.jinJia = jinJia;
	}
	public BigDecimal getJinHuoJinE() {
		return jinHuoJinE;
	}
	public void setJinHuoJinE(BigDecimal jinHuoJinE) {
		this.jinHuoJinE = jinHuoJinE;
	}
	public BigDecimal getKeYongLiang() {
		return keYongLiang;
	}
	public void setKeYongLiang(BigDecimal keYongLiang) {
		this.keYongLiang = keYongLiang;
	}
	public BigDecimal getTiaoMaSL() {
		return tiaoMaSL;
	}
	public void setTiaoMaSL(BigDecimal tiaoMaSL) {
		this.tiaoMaSL = tiaoMaSL;
	}
	public Date getDianHuoRiQi() {
		return dianHuoRiQi;
	}
	public void setDianHuoRiQi(Date dianHuoRiQi) {
		this.dianHuoRiQi = dianHuoRiQi;
	}
	

}
