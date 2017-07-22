package net.jcip.thinkinjava.annotations.dbtable;

/**
 * Department entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {
	// Fields
	private Integer depId;
	private String depName;
	private String depFlag;
	// Constructors
	/** default constructor */
	public Department() {
	}
	/** full constructor */
	public Department(String depName, String depFlag) {
		this.depName = depName;
		this.depFlag = depFlag;
	}
	// Property accessors
	public Integer getDepId() {
		return this.depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return this.depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepFlag() {
		return this.depFlag;
	}
	public void setDepFlag(String depFlag) {
		this.depFlag = depFlag;
	}
}