package com.bhashasetu.dto;
import java.util.*;
public final class EligibilityDtos { private EligibilityDtos(){}
 public record EligibilityRequest(Map<String,Object> attributes){}
 public record RuleCheck(String field,String operator,Object expected,Object actual,Boolean passed){}
 public record EligibilityResult(Long schemeId,String schemeName,String status,List<RuleCheck> checks,List<String> missingFields,List<String> manualConditions,String reason){}
 public record ConversationRequest(String text,String sessionId,String answerField,List<String> skippedFields,boolean skip){}
 public record SessionResponse(Map<String,Object> profile,int attempts,boolean finalized){}
}
