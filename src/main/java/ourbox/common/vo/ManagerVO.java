package ourbox.common.vo;

public class ManagerVO {
	private String manager_id;
	private String manager_pass;
	
	public ManagerVO() {
	}
	
	public ManagerVO(String manager_id, String manager_pass) {
		this.manager_id = manager_id;
		this.manager_pass = manager_pass;
	}
	
	@Override
	public String toString() {
		return "ManagerVO [manager_id=" + manager_id + ", manager_pass=" + manager_pass + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manager_id == null) ? 0 : manager_id.hashCode());
		result = prime * result + ((manager_pass == null) ? 0 : manager_pass.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManagerVO other = (ManagerVO) obj;
		if (manager_id == null) {
			if (other.manager_id != null)
				return false;
		} else if (!manager_id.equals(other.manager_id))
			return false;
		if (manager_pass == null) {
			if (other.manager_pass != null)
				return false;
		} else if (!manager_pass.equals(other.manager_pass))
			return false;
		return true;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_pass() {
		return manager_pass;
	}
	public void setManager_pass(String manager_pass) {
		this.manager_pass = manager_pass;
	}
	
	
}