package eg2;

public class Project {

	private int projectId;
	private String clientName;
	
	
	public Project(int projectId, String clientName) {
		super();
		this.projectId = projectId;
		this.clientName = clientName;
	}
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	

	public void print_project() {
		// TODO Auto-generated method stub
		System.out.println("project details");
		System.out.println("project id : "+projectId);
		System.out.println("client name : "+clientName);
	}


	
}
