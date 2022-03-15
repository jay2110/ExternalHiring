package com.hiringApp.externalhiringservice;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.hiringApp.externalhiringservice.entity.Candidate;
import com.hiringApp.externalhiringservice.repository.CandidateRepo;
import com.hiringApp.externalhiringservice.service.CandidateService;
import com.hiringApp.externalhiringservice.vo.Requirement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateServiceImplTest {

	@MockBean
	private CandidateRepo candidateRepo;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CandidateService candidateService;

	//candidate Service Testing
	@Test
	void testToAddCandidate() {
		Candidate expected = new Candidate();
		expected.setId(1);
		expected.setName("Ajay");
		expected.getSkillSets().add("java");
		expected.getSkillSets().add("microService");
		expected.getSkillSets().add("Aws");
		expected.getSkillSets().add("Mysql");

		boolean result = candidateService.addCandidate(expected);
		assertTrue(result);
	}

	@Test
	void testToMatchcandidate() {

		Candidate c1=new Candidate();
		c1.setId(21);
		c1.setName("Ajay");
		c1.getSkillSets().add("java");
		c1.getSkillSets().add("microservice");
		c1.getSkillSets().add("Aws");
		c1.getSkillSets().add("postgres");
		Candidate c2=new Candidate();
		c2.setId(23);
		c2.setName("pranav");
		c2.getSkillSets().add("python");
		c2.getSkillSets().add("django");
		c2.getSkillSets().add("sqllite");
		c2.getSkillSets().add("Aws");
		List<Candidate> candidatelist=new ArrayList();
		candidatelist.add(c1);
		candidatelist.add(c2);
		Requirement expected =new Requirement();
		expected.setDesignation("Tester");
		expected.getRequiredSkills().add("java");
		expected.getRequiredSkills().add("microservice");
		expected.getRequiredSkills().add("Aws");
		expected.getRequiredSkills().add("postgres");
		//candidateService.addCandidate(expected);
		List<Candidate> doctor=candidateService.matchCandidates(expected);
		assertNotNull(doctor);

	}

}
