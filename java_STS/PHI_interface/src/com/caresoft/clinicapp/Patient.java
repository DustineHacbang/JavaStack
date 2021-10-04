package com.caresoft.clinicapp;


	public class Patient extends User {
	    
	    private String firstName;
	    private String lastName;
	    // .. other personal identifying information .. //
	    
	    Physician primaryCarePhysician;
	    ArrayList<Integer> currentPrescriptionsByRX;
	    int providerCode;
	    int memberNumber;
	    PatientRecord medicalHistory;
	    
	    // TO DO: Constructor
	    
	    public boolean requestAppointment(Date date, Physician doctor) {
	        boolean successfullyAdded = false;
	        // you see existing code to find and schedule an appointment
	    	// (Leave as is for the assignment, no need to implement anything here.)
	        return successfullyAdded;
	    }
	    void addChartNotes(String notes) {
	        this.medicalHistory.getCharts().add(notes);
	    }
	    
	    // TO DO: Setters & Getters
	

}
