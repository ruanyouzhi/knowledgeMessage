package com.km.knowledgemessage.Model;

public class PublicCard {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public_card.card_id
     *
     * @mbg.generated Sun Jun 28 10:05:26 CST 2020
     */
    private Long cardId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public_card.gmt_create
     *
     * @mbg.generated Sun Jun 28 10:05:26 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public_card.gmt_modified
     *
     * @mbg.generated Sun Jun 28 10:05:26 CST 2020
     */
    private Long gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public_card.card_id
     *
     * @return the value of public_card.card_id
     *
     * @mbg.generated Sun Jun 28 10:05:26 CST 2020
     */
    public Long getCardId() {
        return cardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public_card.card_id
     *
     * @param cardId the value for public_card.card_id
     *
     * @mbg.generated Sun Jun 28 10:05:26 CST 2020
     */
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public_card.gmt_create
     *
     * @return the value of public_card.gmt_create
     *
     * @mbg.generated Sun Jun 28 10:05:26 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public_card.gmt_create
     *
     * @param gmtCreate the value for public_card.gmt_create
     *
     * @mbg.generated Sun Jun 28 10:05:26 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public_card.gmt_modified
     *
     * @return the value of public_card.gmt_modified
     *
     * @mbg.generated Sun Jun 28 10:05:26 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public_card.gmt_modified
     *
     * @param gmtModified the value for public_card.gmt_modified
     *
     * @mbg.generated Sun Jun 28 10:05:26 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}