package com.xym.bossed.db.mybatis.kehu.leibie;

import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibie;
import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KehuLeibieMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    int countByExample(KehuLeibieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    int deleteByExample(KehuLeibieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    int deleteByPrimaryKey(String kehulbDm);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    int insert(KehuLeibie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    int insertSelective(KehuLeibie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    List<KehuLeibie> selectByExample(KehuLeibieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    KehuLeibie selectByPrimaryKey(String kehulbDm);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    int updateByExampleSelective(@Param("record") KehuLeibie record, @Param("example") KehuLeibieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    int updateByExample(@Param("record") KehuLeibie record, @Param("example") KehuLeibieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    int updateByPrimaryKeySelective(KehuLeibie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_kehulb
     *
     * @mbggenerated Mon Jul 08 15:47:40 CST 2013
     */
    int updateByPrimaryKey(KehuLeibie record);
}