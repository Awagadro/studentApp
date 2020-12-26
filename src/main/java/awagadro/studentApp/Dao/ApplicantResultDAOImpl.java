package awagadro.studentApp.dao;

import java.util.List;

import awagadro.studentApp.entity.Applicant;
import awagadro.studentApp.entity.ApplicantResult;

public class ApplicantResultDAOImpl extends BaseStudentDAO implements ApplicantResultDAO {

	@Override
	public Long addApplicantResult(ApplicantResult ar) {
		return (Long) template.save(ar);
	}

	@Override
	public void updateApplicantResult(ApplicantResult ar) {
		template.saveOrUpdate(ar);

	}

	@Override
	public void deleteApplicantResult(ApplicantResult ar) {
		template.delete(ar);

	}

	@Override
	public ApplicantResult getApplicantResult(Long applicantResultId) {
		return (ApplicantResult) template.load(ApplicantResult.class, applicantResultId);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<ApplicantResult> findApplicantResult(Applicant a) {
		return (List<ApplicantResult>) template.findByNamedParam(
				"FROM ApplicantResult a WHERE a.applicant=:applicant " + "ORDER BY subject.subjectName", "applicant",
				a);
	}

}
