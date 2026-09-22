package com.bhashasetu.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDate; import java.util.*;

@Entity @Table(name="schemes")
public class Scheme {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="source_key", unique=true, length=100) private String sourceKey;
 @Column(nullable=false, columnDefinition="text") private String name;
 @Column(columnDefinition="text") private String description; private String category; private String state;
 @Column(name="official_url", columnDefinition="text") private String officialUrl; @Column(name="government_level") private String governmentLevel;
 @Column(name="ministry_or_department", columnDefinition="text") private String ministryOrDepartment; @Column(name="raw_category", columnDefinition="text") private String rawCategory;
 @Column(name="status_confidence") private String statusConfidence; @Column(name="secondary_source_url", columnDefinition="text") private String secondarySourceUrl;
 @Column(name="last_checked_date") private LocalDate lastCheckedDate; @Column(name="benefit_type", columnDefinition="text") private String benefitType;
 @Column(name="benefit_summary", columnDefinition="text") private String benefitSummary; @Column(name="benefit_amount", columnDefinition="text") private String benefitAmount;
 @Column(name="application_method", columnDefinition="text") private String applicationMethod; @Column(name="official_application_url", columnDefinition="text") private String officialApplicationUrl;
 @Column(name="confidence_notes", columnDefinition="text") private String confidenceNotes; @Column(name="other_eligibility_conditions", columnDefinition="text") private String otherEligibilityConditions;
 @JdbcTypeCode(SqlTypes.JSON) @Column(name="manual_conditions", columnDefinition="jsonb") private List<String> manualConditions = new ArrayList<>();
 @JdbcTypeCode(SqlTypes.JSON) @Column(name="source_metadata", columnDefinition="jsonb") private Map<String,Object> sourceMetadata = new LinkedHashMap<>();
 @Column(name="is_active", nullable=false) private boolean active = true;
 @OneToMany(mappedBy="scheme", cascade=CascadeType.ALL, orphanRemoval=true) @OrderBy("id") private List<EligibilityRule> rules = new ArrayList<>();
 public Long getId(){return id;} public String getSourceKey(){return sourceKey;} public void setSourceKey(String v){sourceKey=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public String getState(){return state;} public void setState(String v){state=v;} public String getOfficialUrl(){return officialUrl;} public void setOfficialUrl(String v){officialUrl=v;} public String getGovernmentLevel(){return governmentLevel;} public void setGovernmentLevel(String v){governmentLevel=v;} public String getMinistryOrDepartment(){return ministryOrDepartment;} public void setMinistryOrDepartment(String v){ministryOrDepartment=v;} public String getRawCategory(){return rawCategory;} public void setRawCategory(String v){rawCategory=v;} public String getStatusConfidence(){return statusConfidence;} public void setStatusConfidence(String v){statusConfidence=v;} public String getSecondarySourceUrl(){return secondarySourceUrl;} public void setSecondarySourceUrl(String v){secondarySourceUrl=v;} public LocalDate getLastCheckedDate(){return lastCheckedDate;} public void setLastCheckedDate(LocalDate v){lastCheckedDate=v;} public String getBenefitType(){return benefitType;} public void setBenefitType(String v){benefitType=v;} public String getBenefitSummary(){return benefitSummary;} public void setBenefitSummary(String v){benefitSummary=v;} public String getBenefitAmount(){return benefitAmount;} public void setBenefitAmount(String v){benefitAmount=v;} public String getApplicationMethod(){return applicationMethod;} public void setApplicationMethod(String v){applicationMethod=v;} public String getOfficialApplicationUrl(){return officialApplicationUrl;} public void setOfficialApplicationUrl(String v){officialApplicationUrl=v;} public String getConfidenceNotes(){return confidenceNotes;} public void setConfidenceNotes(String v){confidenceNotes=v;} public String getOtherEligibilityConditions(){return otherEligibilityConditions;} public void setOtherEligibilityConditions(String v){otherEligibilityConditions=v;} public List<String> getManualConditions(){return manualConditions;} public void setManualConditions(List<String> v){manualConditions=v==null?new ArrayList<>():v;} public Map<String,Object> getSourceMetadata(){return sourceMetadata;} public void setSourceMetadata(Map<String,Object> v){sourceMetadata=v==null?new LinkedHashMap<>():v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;} public List<EligibilityRule> getRules(){return rules;}
}
