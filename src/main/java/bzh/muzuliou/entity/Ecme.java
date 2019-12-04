package bzh.muzuliou.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name="Ecme")
public class Ecme {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    @NonNull
    private String inventoryNumbre;
    
    @NonNull
    private String brand;
    
    @NonNull
    private String Designation;
    
    @NonNull
    private String model;
      
    @NonNull
    private String serialNumber;
    @NonNull
    private String associatedDevice;
    @NonNull
    private String dateReceip;
    @NonNull
    private String dateMES;
    @NonNull
    private String stateReception;
    @NonNull
    private String complianceCriterion;
    @NonNull
    private String periodicity;
    @NonNull
    private String documentation;
    
    @NonNull
    private String additionalProperties;

	public String getInventoryNumbre() {
		return inventoryNumbre;
	}

	public void setInventoryNumbre(String inventoryNumbre) {
		this.inventoryNumbre = inventoryNumbre;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getAssociatedDevice() {
		return associatedDevice;
	}

	public void setAssociatedDevice(String associatedDevice) {
		this.associatedDevice = associatedDevice;
	}

	public String getDateReceip() {
		return dateReceip;
	}

	public void setDateReceip(String dateReceip) {
		this.dateReceip = dateReceip;
	}

	public String getDateMES() {
		return dateMES;
	}

	public void setDateMES(String dateMES) {
		this.dateMES = dateMES;
	}

	public String getStateReception() {
		return stateReception;
	}

	public void setStateReception(String stateReception) {
		this.stateReception = stateReception;
	}

	public String getComplianceCriterion() {
		return complianceCriterion;
	}

	public void setComplianceCriterion(String complianceCriterion) {
		this.complianceCriterion = complianceCriterion;
	}

	public String getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public String getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(String additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Ecme [id=" + id + ", inventoryNumbre=" + inventoryNumbre + ", brand=" + brand + ", Designation="
				+ Designation + ", model=" + model + ", serialNumber=" + serialNumber + ", associatedDevice="
				+ associatedDevice + ", dateReceip=" + dateReceip + ", dateMES=" + dateMES + ", stateReception="
				+ stateReception + ", complianceCriterion=" + complianceCriterion + ", periodicity=" + periodicity
				+ ", documentation=" + documentation + ", additionalProperties=" + additionalProperties + "]";
	}
	

	public Ecme(@NonNull String inventoryNumbre, @NonNull String brand, @NonNull String designation,
			@NonNull String model, @NonNull String serialNumber, @NonNull String associatedDevice,
			@NonNull String dateReceip, @NonNull String dateMES, @NonNull String stateReception,
			@NonNull String complianceCriterion, @NonNull String periodicity, @NonNull String documentation,
			@NonNull String additionalProperties) {
		super();
		this.inventoryNumbre = inventoryNumbre;
		this.brand = brand;
		Designation = designation;
		this.model = model;
		this.serialNumber = serialNumber;
		this.associatedDevice = associatedDevice;
		this.dateReceip = dateReceip;
		this.dateMES = dateMES;
		this.stateReception = stateReception;
		this.complianceCriterion = complianceCriterion;
		this.periodicity = periodicity;
		this.documentation = documentation;
		this.additionalProperties = additionalProperties;
	}
 
    

}
