package com.km.knowledgemessage.Mapper;

import com.km.knowledgemessage.Model.LabelBase;
import com.km.knowledgemessage.Model.LabelBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LabelBaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    long countByExample(LabelBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int deleteByExample(LabelBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int insert(LabelBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int insertSelective(LabelBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    List<LabelBase> selectByExampleWithRowbounds(LabelBaseExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    List<LabelBase> selectByExample(LabelBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    LabelBase selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int updateByExampleSelective(@Param("record") LabelBase record, @Param("example") LabelBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int updateByExample(@Param("record") LabelBase record, @Param("example") LabelBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int updateByPrimaryKeySelective(LabelBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table label_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int updateByPrimaryKey(LabelBase record);
}