package POJO_Libraries;

public class Project_Library 
{
	//step:1 declare all variables globally
		String createdBy;
		String projectName;
		String status;
		int teamSize;
		
		//step:2 create constructor to initialize the varible
		public Project_Library(String createdBy, String projectName, String status, int teamSize) 
		{
			
			this.createdBy = createdBy;
			this.projectName = projectName;
			this.status = status;
			this.teamSize = teamSize;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getTeamSize() {
			return teamSize;
		}

		public void setTeamSize(int teamSize) {
			this.teamSize = teamSize;
		}
		
		
		

}
