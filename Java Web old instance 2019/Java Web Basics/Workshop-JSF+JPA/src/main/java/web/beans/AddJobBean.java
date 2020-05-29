package web.beans;

import domain.binding.JobAddBindingModel;
import domain.view.UserViewModel;
import services.interfaces.JobService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class AddJobBean {
    private JobAddBindingModel jobAddBindingModel;
    private JobService jobService;

    public AddJobBean() {

    }

    @Inject
    public AddJobBean(JobAddBindingModel jobAddBindingModel, JobService jobService) {
        this.jobAddBindingModel = jobAddBindingModel;
        this.jobService = jobService;
    }

    public JobAddBindingModel getJobAddBindingModel() {
        return jobAddBindingModel;
    }


    public String createJobOffer(){
        UserViewModel currentUser=(UserViewModel) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        String id=currentUser.getId();

        jobAddBindingModel.setUserIdentity(id);
        jobService.addJob(jobAddBindingModel);

        return "home.xhtml?faces-redirect=true";
    }
}
