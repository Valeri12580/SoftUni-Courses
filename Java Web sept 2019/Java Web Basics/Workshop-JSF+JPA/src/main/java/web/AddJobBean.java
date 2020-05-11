package web;

import domain.binding.JobAddBindingModel;
import domain.view.UserViewModel;
import services.interfaces.JobService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;


@Named
@RequestScoped
public class AddJobBean {
    private JobAddBindingModel jobAddBindingModel;
    private JobService jobService;

    public AddJobBean() {
    }


    public JobAddBindingModel getJobAddBindingModel() {
        return jobAddBindingModel;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    @Inject
    public AddJobBean(JobAddBindingModel jobAddBindingModel, JobService jobService) {
        this.jobAddBindingModel = jobAddBindingModel;
        this.jobService = jobService;
    }

    //change the uuid to int
    public String createJobOffer(){
        UserViewModel currentUser=(UserViewModel) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        String id=currentUser.getId();

        jobAddBindingModel.setUserId(id);
        jobService.addJob(jobAddBindingModel);

        return "home.xhtml?faces-redirect=true";
    }
}
