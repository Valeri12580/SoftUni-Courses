package web.beans;

import domain.view.JobOffersViewModel;
import services.interfaces.JobService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
public class JobOffersBean {
    private JobService jobService;
    private List<JobOffersViewModel> offers;

    public JobOffersBean() {
    }

    @Inject
    public JobOffersBean(JobService jobService) {
        this.jobService = jobService;
        this.offers = jobService.getAllJobs();

    }

    public List<JobOffersViewModel>getOffers(){
        return this.jobService.getAllJobs();
    }


}
