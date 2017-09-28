package com.cn.hand.bean;

import java.io.Serializable;

public class SubChannelData implements Serializable {
    private static final long serialVersionUID = 3120115379801111149L;
    private String sequenceId;
    private String cycle;
    private String stepId;
    private String stepName;
    private String testTimeDuration;
    private String voltage;
    private String current;
    private String ir;
    private String temperature;
    private String chargeCapacity;
    private String dischargeCapacity;
    private String chargeEnergy;
    private String dischargeEnergy;
    private String timestamp;
    private String dataFlag;
    private String workType;

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

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getIr() {
        return ir;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getChargeCapacity() {
        return chargeCapacity;
    }

    public void setChargeCapacity(String chargeCapacity) {
        this.chargeCapacity = chargeCapacity;
    }

    public String getDischargeCapacity() {
        return dischargeCapacity;
    }

    public void setDischargeCapacity(String dischargeCapacity) {
        this.dischargeCapacity = dischargeCapacity;
    }

    public String getChargeEnergy() {
        return chargeEnergy;
    }

    public void setChargeEnergy(String chargeEnergy) {
        this.chargeEnergy = chargeEnergy;
    }

    public String getDischargeEnergy() {
        return dischargeEnergy;
    }

    public void setDischargeEnergy(String dischargeEnergy) {
        this.dischargeEnergy = dischargeEnergy;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    @Override
    public String toString() {
        return "{" + sequenceId +
                ", " + cycle +
                ", " + stepId +
                ", " + stepName +
                ", " + testTimeDuration +
                ", " + voltage +
                ", " + current +
                ", " + ir +
                ", " + temperature +
                ", " + chargeCapacity +
                ", " + dischargeCapacity +
                ", " + chargeEnergy +
                ", " + dischargeEnergy +
                ", " + timestamp +
                ", " + dataFlag +
                ", " + workType +
                "}";
    }
}
