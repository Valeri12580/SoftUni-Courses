package services.interfaces;

import domain.binding.JobAddBindingModel;
import domain.view.JobDetailsViewModel;
import domain.view.JobOffersViewModel;

import java.util.List;

public interface JobService {
    void addJob(JobAddBindingModel jobAddBindingModel);

    List<JobOffersViewModel>getAllJobs();

    JobDetailsViewModel getJobById(String id);


    void delete(String id);

}
