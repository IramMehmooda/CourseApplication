package com.example.springSoapWS.SoapWebServices.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import soap.iramwebservices.course.CourseDetails;
import soap.iramwebservices.course.GetcourseDetailsRequest;
import soap.iramwebservices.course.GetcourseDetailsResponse;

@Endpoint
public class CourseDetailsEndPoint {
	
	@PayloadRoot(namespace="http://iramwebservices.soap/course",localPart="GetcourseDetailsRequest")
	@ResponsePayload//Java to XML
	public GetcourseDetailsResponse processcourseDetails(@RequestPayload GetcourseDetailsRequest request)//XML to Java
	{
		
		GetcourseDetailsResponse response=new GetcourseDetailsResponse();
		
		//dummy values
		CourseDetails course=new CourseDetails();
		course.setId(request.getId());
		course.setName("Spring 5");
		course.setDescription("First course");
		
		
		response.setCourseDetails(course);
		return response;
		
	}
	
	

}
