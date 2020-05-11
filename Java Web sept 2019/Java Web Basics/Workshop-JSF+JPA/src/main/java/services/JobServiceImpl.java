package services;

import domain.binding.JobAddBindingModel;
import domain.entities.Job;
import domain.entities.User;
import org.modelmapper.ModelMapper;
import repositories.JobRepositoryImpl;
import services.interfaces.JobService;
import services.interfaces.UserService;
import utils.ValidationUtilImpl;

import javax.inject.Inject;

public class JobServiceImpl implements JobService {
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
        User currentUser = this.userService.getUserById(jobAddBindingModel.getUserId());
        Job job = this.modelMapper.map(jobAddBindingModel, Job.class);
        job.setUser(currentUser);
        jobRepository.save(job);
    }
}
