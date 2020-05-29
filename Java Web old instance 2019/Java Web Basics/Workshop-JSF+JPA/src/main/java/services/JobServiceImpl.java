package services;

import domain.binding.JobAddBindingModel;
import domain.entities.Job;
import domain.entities.User;
import domain.view.JobDetailsViewModel;
import domain.view.JobOffersViewModel;
import org.modelmapper.ModelMapper;
import repositories.JobRepositoryImpl;
import services.interfaces.JobService;
import services.interfaces.UserService;
import utils.ValidationUtilImpl;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class JobServiceImpl implements JobService, Serializable {
    private ModelMapper modelMapper;
    private JobRepositoryImpl jobRepository;
    private ValidationUtilImpl validationUtil;
    private UserService userService;

    @Inject
    public JobServiceImpl(ModelMapper modelMapper, JobRepositoryImpl jobRepository, ValidationUtilImpl validationUtil, UserService userService) {
        this.modelMapper = modelMapper;
        this.jobRepository = jobRepository;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void addJob(JobAddBindingModel jobAddBindingModel) {
        User currentUser = this.userService.getUserById(jobAddBindingModel.getUserIdentity());
        Job job = this.modelMapper.map(jobAddBindingModel, Job.class);
        job.setUser(currentUser);
        jobRepository.save(job);
    }

    @Override
    public List<JobOffersViewModel> getAllJobs() {
        return this.jobRepository.getAllJobs().stream()
                .map(e -> this.modelMapper.map(e, JobOffersViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public JobDetailsViewModel getJobById(String id) {
        Job job = this.jobRepository.getById(id);

        return this.modelMapper.map(job, JobDetailsViewModel.class);
    }

    @Override
    public void delete(String id) {
        this.jobRepository.delete(id);
    }
}
