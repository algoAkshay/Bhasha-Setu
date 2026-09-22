package com.bhashasetu.model;
import jakarta.persistence.*; import org.hibernate.annotations.JdbcTypeCode; import org.hibernate.type.SqlTypes; import java.util.*;
@Entity @Table(name="eligibility_rules") public class EligibilityRule {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="scheme_id", nullable=false) private Scheme scheme;
 @Column(nullable=false) private String field; @Column(nullable=false) private String operator; @JdbcTypeCode(SqlTypes.JSON) @Column(nullable=false,columnDefinition="jsonb") private Object value;
 @Column(name="value_type") private String valueType; @JdbcTypeCode(SqlTypes.JSON) @Column(name="source_metadata",columnDefinition="jsonb") private Map<String,Object> sourceMetadata=new LinkedHashMap<>();
 public Long getId(){return id;} public Scheme getScheme(){return scheme;} public void setScheme(Scheme v){scheme=v;} public String getField(){return field;} public void setField(String v){field=v;} public String getOperator(){return operator;} public void setOperator(String v){operator=v;} public Object getValue(){return value;} public void setValue(Object v){value=v;} public String getValueType(){return valueType;} public void setValueType(String v){valueType=v;} public Map<String,Object> getSourceMetadata(){return sourceMetadata;} public void setSourceMetadata(Map<String,Object> v){sourceMetadata=v;}
}
