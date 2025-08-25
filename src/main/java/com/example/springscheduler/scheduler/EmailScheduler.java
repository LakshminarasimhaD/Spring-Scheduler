package com.example.springscheduler.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.springscheduler.entity.User;
import com.example.springscheduler.repository.UserRepository;
import com.example.springscheduler.servie.EmailService;

@Component
public class EmailScheduler {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailService emailService;

	// Schedule the task to run every minute
	@Async("customTaskExecutor")
	@Scheduled(fixedRate = 60000) // 1 minute = 60000 milliseconds
	public void sendWelcomeEmails() {
		System.out.println("Scheduler is running. Sending emails...");
		List<User> users = userRepository.findAll();
		for (User user : users) {
			String subject = "Welcome to Our Service!";
			String body = "Hello " + user.getUserName() + ", Welcome! "+LocalDateTime.now();
			emailService.sendEmail(user.getEmail(), subject, body);
			System.out.println("Welcome Email sent to: " + user.getEmail() + " at " + LocalDateTime.now());

		}
		System.out.println("Welcome Emails sent to all registered users.");
	}

	// You give the name "customTaskExecutor" to the @Async annotation to explicitly
	// tell Spring which specific TaskExecutor bean to use for that method's
	// execution. It's a way of specifying a custom thread pool instead of relying
	// on Spring's default one.
	@Async("customTaskExecutor")
	@Scheduled(fixedRate = 120000) // 2 minutes
	public void advertiseEmail() {
		System.out.println("Advertise Email method called at " + LocalDateTime.now());
		List<User> users = userRepository.findAll();
		for (User user : users) {
			String subject = "Special Offer Just for You!";
			String body = "Hello " + user.getUserName() + ", Check out our special offers! "+LocalDateTime.now();
			emailService.sendEmail(user.getEmail(), subject, body);
			System.out.println("Advertise Email sent to: " + user.getEmail() + " at " + LocalDateTime.now());

		}
		System.out.println("Advertise Emails sent to all registered users.");
	}

}


//
//@Scheduled(fixedDelay = 120000);
//@Scheduled(cron = "0 0/2 * * * ?"); -> sec, min, hour,day_of_month, month,day_of_week
//@Scheduled(cron = "0 0 10 1/3 JAN,APR,AUG,OCT ?"); -> the scheduled method will run at 10:00 AM on the 1st, 4th, 7th, ..., 28th, and 31st of January, April, August, and October.