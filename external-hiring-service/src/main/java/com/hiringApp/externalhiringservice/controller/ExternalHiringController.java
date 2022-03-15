package com.hiringApp.externalhiringservice.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.hiringApp.externalhiringservice.entity.Candidate;
import com.hiringApp.externalhiringservice.exception.InvalidFieldException;
import com.hiringApp.externalhiringservice.exception.NoSuchCandidateRecordException;
import com.hiringApp.externalhiringservice.service.CandidateService;
import com.hiringApp.externalhiringservice.vo.InternalRequirement;
import com.hiringApp.externalhiringservice.vo.Requirement;
import io.swagger.annotations.Api;


@RestController
@CrossOrigin
@Api
@RequestMapping(path = "/candidate")
public class ExternalHiringController {

	Logger logger= LoggerFactory.getLogger(ExternalHiringController.class);
	
	@Autowired
	private CandidateService candidateService; 


	// http://localhost:9009/candidate/{requirement}
	@PostMapping(path = "/{requirement}")
	public ResponseEntity<List<Candidate>> getMatchedCandidates(@RequestBody Requirement requirement)  {
		try{
			List<Candidate> result = candidateService.matchCandidates(requirement);
		ResponseEntity<List<Candidate>> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
		}catch(InvalidFieldException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMsg());
		}catch(NoSuchCandidateRecordException n) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, n.getMsg());
		}
		
	}

	// http://localhost:9009/candidate/addCandidate/{candidate}
	@PostMapping(path = "/addCandidate")
	public ResponseEntity<String> addcandidate(@RequestBody Candidate candidate)  {
		ResponseEntity<String> response = null;
		try{
			if (candidateService.addCandidate(candidate)) 
				response = new ResponseEntity<String>(
						"candidate with id " + candidate.getId() + " is added", HttpStatus.CREATED);
			return response;
		}catch(InvalidFieldException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMsg());
		}
	}

	// http://localhost:9009/candidate/InternalRequest/{internalRequirement}
	@PostMapping(path = "/InternalRequest")
	public ResponseEntity<List<Candidate>> getMatchedCandidatesInternal(@RequestBody InternalRequirement requirement) throws InvalidFieldException {
		List<Candidate> result = candidateService.matchCandidatesInternal(requirement);
		ResponseEntity<List<Candidate>> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}



}
