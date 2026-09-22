package com.bhashasetu.service; import java.util.*;
/** External boundary: this service may extract facts but never decides eligibility. */
public interface ProfileExtractionService { Map<String,Object> extract(String text,Map<String,Object> currentProfile,String question); }
