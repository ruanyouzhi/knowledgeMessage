package com.km.knowledgemessage.Model;

public class Notice {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.id
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.notifier
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    private Long notifier;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.receiver
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    private Long receiver;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.card_id
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    private Long cardId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.card_name
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    private String cardName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.notifier_name
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    private String notifierName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.status
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.gmtCreate
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    private Long gmtcreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.type
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    private Integer type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.id
     *
     * @return the value of notice.id
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.id
     *
     * @param id the value for notice.id
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.notifier
     *
     * @return the value of notice.notifier
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public Long getNotifier() {
        return notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.notifier
     *
     * @param notifier the value for notice.notifier
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public void setNotifier(Long notifier) {
        this.notifier = notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.receiver
     *
     * @return the value of notice.receiver
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public Long getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.receiver
     *
     * @param receiver the value for notice.receiver
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.card_id
     *
     * @return the value of notice.card_id
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public Long getCardId() {
        return cardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.card_id
     *
     * @param cardId the value for notice.card_id
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.card_name
     *
     * @return the value of notice.card_name
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.card_name
     *
     * @param cardName the value for notice.card_name
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.notifier_name
     *
     * @return the value of notice.notifier_name
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public String getNotifierName() {
        return notifierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.notifier_name
     *
     * @param notifierName the value for notice.notifier_name
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public void setNotifierName(String notifierName) {
        this.notifierName = notifierName == null ? null : notifierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.status
     *
     * @return the value of notice.status
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.status
     *
     * @param status the value for notice.status
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.gmtCreate
     *
     * @return the value of notice.gmtCreate
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public Long getGmtcreate() {
        return gmtcreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.gmtCreate
     *
     * @param gmtcreate the value for notice.gmtCreate
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public void setGmtcreate(Long gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.type
     *
     * @return the value of notice.type
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.type
     *
     * @param type the value for notice.type
     *
     * @mbg.generated Tue Jun 30 09:12:39 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }
}