package test;

import java.io.File;

import ee.ut.converter.CPNProcess;
import ee.ut.model.bpmn.BPMNProcess;

public class TestCPNModel {

	public static void main(String[] args) {

		// XPDL process model file
		File xpdlFile = new File(
				"./files/models/Three tasks and a gateway.xpdl");

		// Simulation data to the corresponding XPDL simulation model
		File simDataFile = new File(
				"./files/models/Three tasks and a gateway (Simulation data with resources).xml");
		
		CPNProcess p = new BPMNProcess(xpdlFile,simDataFile);

		//OUTPUT FILE
		p.saveToCPN("./files/cpn/test.cpn");
	}
}
