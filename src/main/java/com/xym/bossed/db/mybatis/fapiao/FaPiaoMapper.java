package com.xym.bossed.db.mybatis.fapiao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.xym.bossed.db.mybatis.fapiao.FaPiao;
import com.xym.bossed.db.mybatis.fapiao.FaPiaoExample;

public interface FaPiaoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    int countByExample(FaPiaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    int deleteByExample(FaPiaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    int deleteByPrimaryKey(Long recoNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    int insert(FaPiao record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    int insertSelective(FaPiao record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    List<FaPiao> selectByExample(FaPiaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    FaPiao selectByPrimaryKey(Long recoNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    int updateByExampleSelective(@Param("record") FaPiao record, @Param("example") FaPiaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    int updateByExample(@Param("record") FaPiao record, @Param("example") FaPiaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    int updateByPrimaryKeySelective(FaPiao record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fapiao_kp_pz
     *
     * @mbggenerated Wed May 29 15:33:28 CST 2013
     */
    int updateByPrimaryKey(FaPiao record);
}