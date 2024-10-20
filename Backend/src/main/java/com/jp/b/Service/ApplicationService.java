package com.jp.b.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.b.Entity.Application;
import com.jp.b.Entity.JobPost;
import com.jp.b.Entity.User;
import com.jp.b.Repository.ApplicationRepository;
import com.jp.b.Repository.JobPostRepository;
import com.jp.b.Repository.UserRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    private UserRepository userRepository;

    public Application applyToJob(Long id, Long userId, String coverLetter, String resume) {
        JobPost jobPost = jobPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Application application = new Application();
        application.setId(id);
        application.setJobPost(jobPost);
        application.setUser(user);
        application.setCoverLetter(coverLetter);
        application.setResumeUrl(resume);

        return applicationRepository.save(application);
    }
}

