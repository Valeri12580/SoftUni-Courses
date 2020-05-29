package web.beans;

import domain.view.JobDetailsViewModel;
import services.interfaces.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class DeleteJobBean implements Serializable {
    private JobDetailsViewModel jobDetailsViewModel;
    private JobService jobService;
    private String id;

    public DeleteJobBean() {
    }

    @Inject
    public DeleteJobBean( JobService jobService) {
        this.jobService = jobService;
    }

    @PostConstruct
    private void init() {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.jobDetailsViewModel = this.jobService.getJobById(id);

    }

    public JobDetailsViewModel getJobDetailsViewModel() {
        return jobDetailsViewModel;
    }
    public String delete(){
        System.out.println();
        this.jobService.delete(id);
        return "/views/authenticated/home.xhtml?faces-redirect=true";
    }
}
