package com.hiringApp.externalhiringservice.service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hiringApp.externalhiringservice.entity.Candidate;
import com.hiringApp.externalhiringservice.exception.InvalidFieldException;
import com.hiringApp.externalhiringservice.exception.NoSuchCandidateRecordException;
import com.hiringApp.externalhiringservice.repository.CandidateRepo;
import com.hiringApp.externalhiringservice.vo.InternalRequirement;
import com.hiringApp.externalhiringservice.vo.Requirement;

@Service
public class CandidateServiceImpl implements CandidateService{

	Logger logger= LoggerFactory.getLogger(CandidateServiceImpl.class);

	@Autowired
	private CandidateRepo candidateRepo;



	@Override
	public boolean addCandidate(Candidate candidate)
			throws InvalidFieldException {
		boolean result=false;
		if ( candidate.getId() !=0 && !candidate.getName().isEmpty() && !candidate.getSkillSets().isEmpty() ) {
			candidateRepo.save(candidate);
			logger.info("Saving the Candidate to database");
			result=true;
			return result;
		}
		logger.info("invalid field");
		throw new InvalidFieldException("Invalid field");

	}

	@Override
	public List<Candidate> matchCandidates(Requirement requirement) throws InvalidFieldException,NoSuchCandidateRecordException{
		List<Candidate> shortListed=new ArrayList<Candidate>();
		List<Candidate> allCandidate=candidateRepo.findAll();
		if(!requirement.getDesignation().isEmpty() && requirement.getId() != 0 && !requirement.getRequiredSkills().isEmpty() ) {
			for(Candidate c: allCandidate) {
				if(c.getSkillSets().equals(requirement.getRequiredSkills())){
					shortListed.add(c);
				}
			}
			if(!shortListed.isEmpty()) {
            logger.info("matching candidates external-Hiring ");
			return shortListed ;
			}throw new NoSuchCandidateRecordException("No eligible candidate found");
		}
		logger.info("invalid field");
		throw new InvalidFieldException("Invalid field");



	}

	@Override
	public List<Candidate> matchCandidatesInternal(InternalRequirement requirement) {
		List<Candidate> allcandidate=candidateRepo.findAll();
		List<Candidate> shortListed=new ArrayList<Candidate>();
		for(Candidate c:allcandidate) {
			if(c.getSkillSets().containsAll(requirement.getRequiredSkills()) && c.getSkillSets().containsAll(requirement.getOptionalSkills())) {
				shortListed.add(c);
			}
		}
        logger.info("matching candidates for internal-Hiring");
		return shortListed;
	}
}

