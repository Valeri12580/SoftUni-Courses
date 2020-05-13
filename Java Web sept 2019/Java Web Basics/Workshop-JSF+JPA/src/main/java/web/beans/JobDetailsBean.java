package web.beans;

import domain.view.JobDetailsViewModel;
import services.interfaces.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobDetailsBean  {
    private JobDetailsViewModel jobDetailsViewModel;
    private JobService jobService;

    public JobDetailsBean() {
    }

    @Inject
    public JobDetailsBean( JobService jobService) {
        this.jobService = jobService;
    }

    @PostConstruct
    private void init(){
        String id =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.jobDetailsViewModel=this.jobService.getJobById(id);

    }

    public JobDetailsViewModel getJobDetailsViewModel() {
        return jobDetailsViewModel;
    }
}
