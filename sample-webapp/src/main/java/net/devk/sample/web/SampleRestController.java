package net.devk.sample.web;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import net.devk.sample.service.SampleService;

@Path("/sample")
public class SampleRestController {

	@Inject
	private SampleService sampleService;

	@Path("/add")
	@GET
	public String saveSample() {
		String randomName = UUID.randomUUID().toString();
		sampleService.saveSample(randomName);
		return String.format("sample %s saved", randomName);
	}
}
