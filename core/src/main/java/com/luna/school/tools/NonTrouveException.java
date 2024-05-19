package com.luna.school.tools;

/**
 * @author BOUA YVES 2024-03-19
 */
public class NonTrouveException extends RuntimeException {
  private String information;

  public NonTrouveException() {
  }

  public NonTrouveException(String message) {
    super(message);
  }

  public NonTrouveException(String message, String information) {
    super(message);
    this.information = information;
  }

  public String getInformation() {
    return this.information;
  }

  public void setInformation(String information) {
    this.information = information;
  }
}
