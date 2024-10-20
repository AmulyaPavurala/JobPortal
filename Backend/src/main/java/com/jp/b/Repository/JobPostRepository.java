package com.jp.b.Repository;

import java.util.List;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.b.Entity.JobPost;

public interface JobPostRepository extends JpaRepository<JobPost, Long>{
	
}
