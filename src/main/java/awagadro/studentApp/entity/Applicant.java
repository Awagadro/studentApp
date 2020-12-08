package awagadro.studentApp.entity;

import java.util.List;

public class Applicant {
	 private Long applicantId;
	    private Profession profession;
	    private List<ApplicantResult> applicantResultList;
	    private String firstName;
	    private String lastName;
	    private String middleName;
	    private Integer entranceYear;
	 
	    public Long getApplicantId() {
	        return applicantId;
	    }
	 
	    public void setApplicantId(Long applicantId) {
	        this.applicantId = applicantId;
	    }
	 
	    public List<ApplicantResult> getApplicantResultList() {
	        return applicantResultList;
	    }
	 
	    public void setApplicantResultList(List<ApplicantResult> applicantResultList) {
	        this.applicantResultList = applicantResultList;
	    }
	 
	    public Integer getEntranceYear() {
	        return entranceYear;
	    }
	 
	    public void setEntranceYear(Integer entranceYear) {
	        this.entranceYear = entranceYear;
	    }
	 
	    public String getFirstName() {
	        return firstName;
	    }
	 
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	 
	    public String getLastName() {
	        return lastName;
	    }
	 
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	 
	    public String getMiddleName() {
	        return middleName;
	    }
	 
	    public void setMiddleName(String middleName) {
	        this.middleName = middleName;
	    }
	 
	    public Profession getProfession() {
	        return profession;
	    }
	 
	    public void setProfession(Profession profession) {
	        this.profession = profession;
	    }
}
