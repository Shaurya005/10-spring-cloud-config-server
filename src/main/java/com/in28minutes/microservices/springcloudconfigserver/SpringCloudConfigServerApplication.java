package com.in28minutes.microservices.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/*
In the previous steps, we set up the limits service. Now we want to set up the Spring Cloud Config Server and connect it to a Git repository.
In this step, let's focus on the Spring Cloud Config server and create an application for it. Following dependencies we've added while creating this project:-

1. Spring Boot DevTools
2. Config Server - It's Spring Cloud Config server. Central management for configuration via Git, SVN, and HashiCorp Vault. So you can actually store
				   your configuration either in Git or Subversion or even in HashiCorp Vault. In this course, we'll be using Git as our example.

We want to run the Spring Cloud Config server on port 8888. So we've assigned a standardized port 8888 for running this application using server.port property
in our application.properties. This is kind of the standard port on which this is run.

The other important best practice that we would typically follow with all microservices is to give it a good name.

So I would want to call this application as spring-cloud-config-server. That's the name we've given to this application using spring.application.name in application.properties.
So we now have the application name and the server.port configured for the cloud config server.

There is one more annotation we need to add to it to make it a real config server. But before that, we'll get to our GitHub repository.
In the next step, let's create the GitHub repository and in the subsequent steps, we'll integrate all these three together.

We've created a local git repository under directory git-localconfig-repo where we've initialized our git repository.
We would want to store all our configuration files in here in this git-localconfig-repo so we've created a new file named limits-service.properties.
So we would store the limits-service properties in this repository. So now that I have a limits-service.properties file created in our repo
and after that we commit the changes in. To add this file to the git repository, run command - git add * and then we commit it using - git commit -m "message".
So that is now committed to our local repository. So right now we have our limits-service, the spring cloud config server and git repository individually present.
In the subsequent step, lets see how to connect all of them.

The way we can connect Spring Cloud config server to the git repository is actually to go to the application.properties of the spring-cloud-config-server
and configure the git repo location. So we'll add folder location of our git repo i.e. the location where we configured our repository at?
And the property name that we want to configure is - spring.cloud.config.server.git.uri.

The thing that we need to do before we actually make this application a Spring Cloud Config server is to add @EnableConfigServer annotation.

Now we go to url - localhost:8888/<file-name in git repo>/default

That is we would want to pick up name of the file in git repository which in our case is limits-service.
In the git repo we have a file called limits-service so that's the name - limits-service/default.

That is our exact url becomes - localhost:8888/limits-service/default which will return the JSON back.

From the response on running the url, we can see that the name is limits-service. The profile that is being used is default
and you can see the property sources. You can see that the property source limits-service.properties and the values which are present in here.
So that's cool. Now we have connected this Spring Cloud Config server to the git repo.

We should be careful in the url that the file-name in URL should match with the file name in our git repo. And also make sure that the path which you have configured
in application.properties is right. Make sure that you're creating the local git repository in a path which does not have any spaces in it.
*/

@EnableConfigServer // To make this application a Spring Cloud Config server
@SpringBootApplication
public class SpringCloudConfigServerApplication
{
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
}