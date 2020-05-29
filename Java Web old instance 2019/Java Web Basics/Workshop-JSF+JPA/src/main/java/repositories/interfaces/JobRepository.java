package repositories.interfaces;

import domain.entities.Job;

import java.util.List;

public interface JobRepository extends BaseRepository<Job,String> {
    List<Job> getAllJobs();
}
