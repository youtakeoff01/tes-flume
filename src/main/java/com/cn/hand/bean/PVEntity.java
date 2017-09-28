package com.cn.hand.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PVEntity implements Serializable {
    private static final long serialVersionUID = -1307334791933171502L;
    private String remark;
    private String sfc;
    private String resourceId;
    private String channelId;
    private String sequenceId;
    private String cycle;
    private String stepId;
    private String stepName;
    private String testTimeDuration;
    private String timeStamp;
    private String svIcRange;
    private String svIvRange;
    private String pvVoltage;
    private String pvCurrent;
    private String pvIr;
    private String pvTemperature;
    private String pvChargeCapacity;
    private String pvDischargeCapacity;
    private String pvChargeEnergy;
    private String pvDischargeEnergy;
    private String pvDataFlag;
    private String pvWorkType;
    private Map<String,String> pvSubChannelDataMap;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getTestTimeDuration() {
        return testTimeDuration;
    }

    public void setTestTimeDuration(String testTimeDuration) {
        this.testTimeDuration = testTimeDuration;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSvIcRange() {
        return svIcRange;
    }

    public void setSvIcRange(String svIcRange) {
        this.svIcRange = svIcRange;
    }

    public String getSvIvRange() {
        return svIvRange;
    }

    public void setSvIvRange(String svIvRange) {
        this.svIvRange = svIvRange;
    }

    public String getPvVoltage() {
        return pvVoltage;
    }

    public void setPvVoltage(String pvVoltage) {
        this.pvVoltage = pvVoltage;
    }

    public String getPvCurrent() {
        return pvCurrent;
    }

    public void setPvCurrent(String pvCurrent) {
        this.pvCurrent = pvCurrent;
    }

    public String getPvIr() {
        return pvIr;
    }

    public void setPvIr(String pvIr) {
        this.pvIr = pvIr;
    }

    public String getPvTemperature() {
        return pvTemperature;
    }

    public void setPvTemperature(String pvTemperature) {
        this.pvTemperature = pvTemperature;
    }

    public String getPvChargeCapacity() {
        return pvChargeCapacity;
    }

    public void setPvChargeCapacity(String pvChargeCapacity) {
        this.pvChargeCapacity = pvChargeCapacity;
    }

    public String getPvDischargeCapacity() {
        return pvDischargeCapacity;
    }

    public void setPvDischargeCapacity(String pvDischargeCapacity) {
        this.pvDischargeCapacity = pvDischargeCapacity;
    }

    public String getPvChargeEnergy() {
        return pvChargeEnergy;
    }

    public void setPvChargeEnergy(String pvChargeEnergy) {
        this.pvChargeEnergy = pvChargeEnergy;
    }

    public String getPvDischargeEnergy() {
        return pvDischargeEnergy;
    }

    public void setPvDischargeEnergy(String pvDischargeEnergy) {
        this.pvDischargeEnergy = pvDischargeEnergy;
    }

    public String getPvDataFlag() {
        return pvDataFlag;
    }

    public void setPvDataFlag(String pvDataFlag) {
        this.pvDataFlag = pvDataFlag;
    }

    public String getPvWorkType() {
        return pvWorkType;
    }

    public void setPvWorkType(String pvWorkType) {
        this.pvWorkType = pvWorkType;
    }

    public Map<String, String> getPvSubChannelDataMap() {
        return pvSubChannelDataMap;
    }

    public void setPvSubChannelDataMap(Map<String, String> pvSubChannelDataMap) {
        this.pvSubChannelDataMap = pvSubChannelDataMap;
    }

    @Override
    public String toString() {
        return "PVEntity{" +
                "remark='" + remark + '\'' +
                ", sfc='" + sfc + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", channelId='" + channelId + '\'' +
                ", sequenceId='" + sequenceId + '\'' +
                ", cycle='" + cycle + '\'' +
                ", stepId='" + stepId + '\'' +
                ", stepName='" + stepName + '\'' +
                ", testTimeDuration='" + testTimeDuration + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", svIcRange='" + svIcRange + '\'' +
                ", svIvRange='" + svIvRange + '\'' +
                ", pvVoltage='" + pvVoltage + '\'' +
                ", pvCurrent='" + pvCurrent + '\'' +
                ", pvIr='" + pvIr + '\'' +
                ", pvTemperature='" + pvTemperature + '\'' +
                ", pvChargeCapacity='" + pvChargeCapacity + '\'' +
                ", pvDischargeCapacity='" + pvDischargeCapacity + '\'' +
                ", pvChargeEnergy='" + pvChargeEnergy + '\'' +
                ", pvDischargeEnergy='" + pvDischargeEnergy + '\'' +
                ", pvDataFlag='" + pvDataFlag + '\'' +
                ", pvWorkType='" + pvWorkType + '\'' +
                ", pvSubChannelData1=" + pvSubChannelDataMap.get("pvSubChannelData1") +
                ", pvSubChannelData2='" + pvSubChannelDataMap.get("pvSubChannelData2") + '\'' +
                ", pvSubChannelData3='" + pvSubChannelDataMap.get("pvSubChannelData3") + '\'' +
                ", pvSubChannelData4='" + pvSubChannelDataMap.get("pvSubChannelData4") + '\'' +
                ", pvSubChannelData5='" + pvSubChannelDataMap.get("pvSubChannelData5")+ '\'' +
                ", pvSubChannelData6='" + pvSubChannelDataMap.get("pvSubChannelData6") + '\'' +
                '}';
    }

    public static String getElementString() {
        return "remark" +
                "; sfc" +
                "; resourceId" +
                "; channelId" +
                "; sequenceId" +
                "; cycle" +
                "; stepId" +
                "; stepName" +
                "; testTimeDuration" +
                "; timeStamp" +
                "; svIcRange" +
                "; svIvRange" +
                "; pvVoltage" +
                "; pvCurrent" +
                "; pvIr" +
                "; pvTemperature" +
                "; pvChargeCapacity" +
                "; pvDischargeCapacity" +
                "; pvChargeEnergy" +
                "; pvDischargeEnergy" +
                "; pvDataFlag" +
                "; pvWorkType" +
                "; pvSubChannelData1" +
                "; pvSubChannelData2" +
                "; pvSubChannelData3" +
                "; pvSubChannelData4" +
                "; pvSubChannelData5" +
                "; pvSubChannelData6";
    }

    public String toReString() {
        return remark + "; " +
                sfc + "; " +
                resourceId + "; " +
                channelId + "; " +
                sequenceId + "; " +
                cycle + "; " +
                stepId + "; " +
                stepName + "; " +
                testTimeDuration + "; " +
                timeStamp + "; " +
                svIcRange + "; " +
                svIvRange + "; " +
                pvVoltage + "; " +
                pvCurrent + "; " +
                pvIr + "; " +
                pvTemperature + "; " +
                pvChargeCapacity + "; " +
                pvDischargeCapacity + "; " +
                pvChargeEnergy + "; " +
                pvDischargeEnergy + "; " +
                pvDataFlag + "; " +
                pvWorkType + "; " +
                pvSubChannelDataMap.get("pvSubChannelData1") + "; " +
                pvSubChannelDataMap.get("pvSubChannelData2") + "; " +
                pvSubChannelDataMap.get("pvSubChannelData3") + "; " +
                pvSubChannelDataMap.get("pvSubChannelData4") + "; " +
                pvSubChannelDataMap.get("pvSubChannelData5")+ "; " +
                pvSubChannelDataMap.get("pvSubChannelData6");
    }
}
