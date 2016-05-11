package com.bsu.bely.medical.entity;

import com.bsu.bely.medical.entity.type.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "health_status")
public class HealthStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "overall_health")
    @Enumerated(EnumType.STRING)
    private OverallHealthType overallHealth;

    @Column(name = "feeling")
    @Enumerated(EnumType.STRING)
    private FeelingType feeling;

    @Column(name = "body_type")
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;

    @Column(name = "skin_covering")
    @Enumerated(EnumType.STRING)
    private SkinType skinCovering;

    @Column(name = "lymph_nodes")
    @Enumerated(EnumType.STRING)
    private LymphNodesType lymphNodes;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "pulse")
    private Integer pulse;

    @Column(name = "arterial_pressure")
    private String arterialPressure;

    @Column(name = "breathing_rate")
    private Integer breathingRate;

    @Column(name = "liver")
    @Enumerated(EnumType.STRING)
    private LiverType liver;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Long getId() {
        return id;
    }

    public LymphNodesType getLymphNodes() {
        return lymphNodes;
    }

    public void setLymphNodes(LymphNodesType lymphNodes) {
        this.lymphNodes = lymphNodes;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getBreathingRate() {
        return breathingRate;
    }

    public void setBreathingRate(Integer breathingRate) {
        this.breathingRate = breathingRate;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public OverallHealthType getOverallHealth() {
        return overallHealth;
    }

    public void setOverallHealth(OverallHealthType overallHealth) {
        this.overallHealth = overallHealth;
    }

    public FeelingType getFeeling() {
        return feeling;
    }

    public void setFeeling(FeelingType feeling) {
        this.feeling = feeling;
    }

    public SkinType getSkinCovering() {
        return skinCovering;
    }

    public void setSkinCovering(SkinType skinCovering) {
        this.skinCovering = skinCovering;
    }

    public LiverType getLiver() {
        return liver;
    }

    public void setLiver(LiverType liver) {
        this.liver = liver;
    }

    public String getArterialPressure() {
        return arterialPressure;
    }

    public void setArterialPressure(String arterialPressure) {
        this.arterialPressure = arterialPressure;
    }
}
