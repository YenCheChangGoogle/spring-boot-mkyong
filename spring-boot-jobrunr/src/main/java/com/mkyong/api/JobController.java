package com.mkyong.api;

import com.mkyong.job.SampleJobService;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

@RestController
public class JobController {

    @Autowired
    private JobScheduler jobScheduler;

    @Autowired
    private SampleJobService sampleJobService;

    //即發即忘的工作
    @GetMapping("/run-job")
    public String runJob( @RequestParam(value = "name", defaultValue = "YenCheChang Hello World") String name) {
    	
    	//即發即忘的工作
    	//jobScheduler.enqueue(()-> sampleJobService.execute());
    	
    	//即發即忘的工作
        jobScheduler.enqueue(() -> sampleJobService.execute(name));
        return "Job is enqueued.";

    }
    
    //預定排程工作
    @GetMapping("/schedule-job")
    public String scheduleJob(
            @RequestParam(value = "name", defaultValue = "YenCheChang Hello World") String name,
            @RequestParam(value = "when", defaultValue = "PT3H") String when) {

        //舊版 old API, job first followed by time
        //jobScheduler.schedule(() -> sampleJobService.execute(name), Instant.now().plus(Duration.parse(when)));
    	
    	//未來會執行的工作
    	//jobScheduler.schedule(LocalDateTime.now().plusHours(5), ()-> sampleJobService.execute(name));
    	
    	//每小時執行一次的工作
    	//jobScheduler.scheduleRecurrently(Cron.hourly(), () -> sampleJobService.execute(name));
    	
        // new API, time first followed by job
        jobScheduler.schedule(
        		Instant.now().plus(Duration.parse(when)),
                () -> sampleJobService.execute(name)
        );

        return "Job is scheduled.";
    }

}
