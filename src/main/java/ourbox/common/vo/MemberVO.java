package ourbox.common.vo;

public class MemberVO {
	private String mem_id;
	private String mem_pass;
	private String mem_nickname;
	private String mem_name;
	private String mem_bir;
	private String mem_tel;
	private String mem_zip;
	private String mem_addr1;
	private String mem_addr2;
	private String mem_status;
	private String mem_profile;
	
	public MemberVO (){
		
	}
	
	public MemberVO(String mem_id, String mem_pass) {
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
	}

	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(String mem_bir) {
		this.mem_bir = mem_bir;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_zip() {
		return mem_zip;
	}
	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_status() {
		return mem_status;
	}
	public void setMem_status(String mem_status) {
		this.mem_status = mem_status;
	}
	public String getMem_profile() {
		return mem_profile;
	}
	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_nickname=" + mem_nickname
				+ ", mem_name=" + mem_name + ", mem_bir=" + mem_bir + ", mem_tel=" + mem_tel + ", mem_zip=" + mem_zip
				+ ", mem_addr1=" + mem_addr1 + ", mem_addr2=" + mem_addr2 + ", mem_status=" + mem_status
				+ ", mem_profile=" + mem_profile + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mem_addr1 == null) ? 0 : mem_addr1.hashCode());
		result = prime * result + ((mem_addr2 == null) ? 0 : mem_addr2.hashCode());
		result = prime * result + ((mem_bir == null) ? 0 : mem_bir.hashCode());
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result + ((mem_name == null) ? 0 : mem_name.hashCode());
		result = prime * result + ((mem_nickname == null) ? 0 : mem_nickname.hashCode());
		result = prime * result + ((mem_pass == null) ? 0 : mem_pass.hashCode());
		result = prime * result + ((mem_profile == null) ? 0 : mem_profile.hashCode());
		result = prime * result + ((mem_status == null) ? 0 : mem_status.hashCode());
		result = prime * result + ((mem_tel == null) ? 0 : mem_tel.hashCode());
		result = prime * result + ((mem_zip == null) ? 0 : mem_zip.hashCode());
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
		MemberVO other = (MemberVO) obj;
		if (mem_addr1 == null) {
			if (other.mem_addr1 != null)
				return false;
		} else if (!mem_addr1.equals(other.mem_addr1))
			return false;
		if (mem_addr2 == null) {
			if (other.mem_addr2 != null)
				return false;
		} else if (!mem_addr2.equals(other.mem_addr2))
			return false;
		if (mem_bir == null) {
			if (other.mem_bir != null)
				return false;
		} else if (!mem_bir.equals(other.mem_bir))
			return false;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (mem_name == null) {
			if (other.mem_name != null)
				return false;
		} else if (!mem_name.equals(other.mem_name))
			return false;
		if (mem_nickname == null) {
			if (other.mem_nickname != null)
				return false;
		} else if (!mem_nickname.equals(other.mem_nickname))
			return false;
		if (mem_pass == null) {
			if (other.mem_pass != null)
				return false;
		} else if (!mem_pass.equals(other.mem_pass))
			return false;
		if (mem_profile == null) {
			if (other.mem_profile != null)
				return false;
		} else if (!mem_profile.equals(other.mem_profile))
			return false;
		if (mem_status == null) {
			if (other.mem_status != null)
				return false;
		} else if (!mem_status.equals(other.mem_status))
			return false;
		if (mem_tel == null) {
			if (other.mem_tel != null)
				return false;
		} else if (!mem_tel.equals(other.mem_tel))
			return false;
		if (mem_zip == null) {
			if (other.mem_zip != null)
				return false;
		} else if (!mem_zip.equals(other.mem_zip))
			return false;
		return true;
	}
}
