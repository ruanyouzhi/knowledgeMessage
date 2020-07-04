package com.km.knowledgemessage.Mapper;

import com.km.knowledgemessage.Model.KnowledgeBase;
import com.km.knowledgemessage.Model.KnowledgeBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface KnowledgeBaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    long countByExample(KnowledgeBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int deleteByExample(KnowledgeBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int insert(KnowledgeBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int insertSelective(KnowledgeBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    List<KnowledgeBase> selectByExampleWithRowbounds(KnowledgeBaseExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    List<KnowledgeBase> selectByExample(KnowledgeBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    KnowledgeBase selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int updateByExampleSelective(@Param("record") KnowledgeBase record, @Param("example") KnowledgeBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int updateByExample(@Param("record") KnowledgeBase record, @Param("example") KnowledgeBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int updateByPrimaryKeySelective(KnowledgeBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge_base
     *
     * @mbg.generated Sat Jul 04 22:11:30 CST 2020
     */
    int updateByPrimaryKey(KnowledgeBase record);
}