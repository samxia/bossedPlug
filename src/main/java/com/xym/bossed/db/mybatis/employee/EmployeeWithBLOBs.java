package com.xym.bossed.db.mybatis.employee;

public class EmployeeWithBLOBs extends Employee {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gongzry.reny_bz
     *
     * @mbggenerated Tue Apr 08 20:09:00 CST 2014
     */
    private String renyBz;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gongzry.reny_pic
     *
     * @mbggenerated Tue Apr 08 20:09:00 CST 2014
     */
    private byte[] renyPic;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gongzry.reny_bz
     *
     * @return the value of gongzry.reny_bz
     *
     * @mbggenerated Tue Apr 08 20:09:00 CST 2014
     */
    public String getRenyBz() {
        return renyBz;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gongzry.reny_bz
     *
     * @param renyBz the value for gongzry.reny_bz
     *
     * @mbggenerated Tue Apr 08 20:09:00 CST 2014
     */
    public void setRenyBz(String renyBz) {
        this.renyBz = renyBz == null ? null : renyBz.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gongzry.reny_pic
     *
     * @return the value of gongzry.reny_pic
     *
     * @mbggenerated Tue Apr 08 20:09:00 CST 2014
     */
    public byte[] getRenyPic() {
        return renyPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gongzry.reny_pic
     *
     * @param renyPic the value for gongzry.reny_pic
     *
     * @mbggenerated Tue Apr 08 20:09:00 CST 2014
     */
    public void setRenyPic(byte[] renyPic) {
        this.renyPic = renyPic;
    }
}