package com.hiringApp.externalhiringservice.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.hiringApp.externalhiringservice.entity.Candidate;
import com.hiringApp.externalhiringservice.vo.InternalRequirement;
import com.hiringApp.externalhiringservice.vo.Requirement;

@Service
public interface CandidateService {


	boolean addCandidate(Candidate candidate) ;

	List<Candidate> matchCandidates(Requirement requirement);

	List<Candidate> matchCandidatesInternal(InternalRequirement requirement);

	
}
