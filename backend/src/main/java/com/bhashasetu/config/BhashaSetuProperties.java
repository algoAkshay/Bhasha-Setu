package com.bhashasetu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bhashasetu")
public class BhashaSetuProperties {
  private long sessionTtlSeconds = 1800; private String sessionPrefix = "bhasha_setu:session";
  private String geminiApiKey = ""; private String geminiModel = "gemini-2.0-flash";
  private boolean importOnStartup; private boolean importOverwrite; private String datasetDirectory = "../database";
  public long getSessionTtlSeconds(){return sessionTtlSeconds;} public void setSessionTtlSeconds(long v){sessionTtlSeconds=v;}
  public String getSessionPrefix(){return sessionPrefix;} public void setSessionPrefix(String v){sessionPrefix=v;}
  public String getGeminiApiKey(){return geminiApiKey;} public void setGeminiApiKey(String v){geminiApiKey=v;}
  public String getGeminiModel(){return geminiModel;} public void setGeminiModel(String v){geminiModel=v;}
  public boolean isImportOnStartup(){return importOnStartup;} public void setImportOnStartup(boolean v){importOnStartup=v;}
  public boolean isImportOverwrite(){return importOverwrite;} public void setImportOverwrite(boolean v){importOverwrite=v;}
  public String getDatasetDirectory(){return datasetDirectory;} public void setDatasetDirectory(String v){datasetDirectory=v;}
}
