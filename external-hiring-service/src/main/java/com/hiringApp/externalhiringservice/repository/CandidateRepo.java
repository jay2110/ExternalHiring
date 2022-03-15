package com.hiringApp.externalhiringservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hiringApp.externalhiringservice.entity.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Integer> {

	

}
