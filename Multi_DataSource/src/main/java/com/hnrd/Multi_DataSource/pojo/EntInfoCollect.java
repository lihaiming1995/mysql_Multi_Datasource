package com.hnrd.Multi_DataSource.pojo;

public class EntInfoCollect {
    @Override
	public String toString() {
		return "EntInfoCollect [administrativeDivision1=" + administrativeDivision1 + ", enterprise=" + enterprise
				+ ", socialCreditCode=" + socialCreditCode + ", administrativeDivision2=" + administrativeDivision2
				+ ", address=" + address + ", contacts=" + contacts + ", contactNum=" + contactNum
				+ ", wasteProductionInformation=" + wasteProductionInformation + ", creatAt=" + creatAt + ", updateAt="
				+ updateAt + ", id=" + id + "]";
	}

	/**
     * 行政区划1
     */
    private String administrativeDivision1;

    /**
     * 企业名称
     */
    private String enterprise;

    /**
     * 统一信用代码
     */
    private String socialCreditCode;

    /**
     * 行政区划2
     */
    private String administrativeDivision2;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String contactNum;

    /**
     * 产废信息
     */
    private String wasteProductionInformation;

    /**
     * 收集时间
     */
    private String creatAt;

    /**
     * 更新时间
     */
    private String updateAt;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 行政区划1
     * @return administrative division1 行政区划1
     */
    public String getAdministrativeDivision1() {
        return administrativeDivision1;
    }

    /**
     * 行政区划1
     * @param administrativeDivision1 行政区划1
     */
    public void setAdministrativeDivision1(String administrativeDivision1) {
        this.administrativeDivision1 = administrativeDivision1;
    }

    /**
     * 企业名称
     * @return enterprise 企业名称
     */
    public String getEnterprise() {
        return enterprise;
    }

    /**
     * 企业名称
     * @param enterprise 企业名称
     */
    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    /**
     * 统一信用代码
     * @return social_credit_code 统一信用代码
     */
    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    /**
     * 统一信用代码
     * @param socialCreditCode 统一信用代码
     */
    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    /**
     * 行政区划2
     * @return administrative_division2 行政区划2
     */
    public String getAdministrativeDivision2() {
        return administrativeDivision2;
    }

    /**
     * 行政区划2
     * @param administrativeDivision2 行政区划2
     */
    public void setAdministrativeDivision2(String administrativeDivision2) {
        this.administrativeDivision2 = administrativeDivision2;
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 联系人
     * @return contacts 联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 联系人
     * @param contacts 联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    /**
     * 联系电话
     * @return contact_num 联系电话
     */
    public String getContactNum() {
        return contactNum;
    }

    /**
     * 联系电话
     * @param contactNum 联系电话
     */
    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    /**
     * 产废信息
     * @return waste_production_information 产废信息
     */
    public String getWasteProductionInformation() {
        return wasteProductionInformation;
    }

    /**
     * 产废信息
     * @param wasteProductionInformation 产废信息
     */
    public void setWasteProductionInformation(String wasteProductionInformation) {
        this.wasteProductionInformation = wasteProductionInformation;
    }

    /**
     * 收集时间
     * @return creat_at 收集时间
     */
    public String getCreatAt() {
        return creatAt;
    }

    /**
     * 收集时间
     * @param creatAt 收集时间
     */
    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    /**
     * 更新时间
     * @return update_at 更新时间
     */
    public String getUpdateAt() {
        return updateAt;
    }

    /**
     * 更新时间
     * @param updateAt 更新时间
     */
    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }
}