package ourbox.common.vo;

public class NoticeVO {
	
	private int notice_seq          ;
	private String notice_title     ;
	private String notice_content   ;
	private String notice_date      ;
	private String manager_id       ;
	
	public NoticeVO() {
		
	}
	
	public NoticeVO(String notice_title, String notice_content) {
		this.notice_title = notice_title;
		this.notice_content = notice_content;
	}
	
	
	public NoticeVO(int notice_seq, String notice_title, String notice_content, String notice_date, String manager_id) {
		this.notice_seq = notice_seq;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_date = notice_date;
		this.manager_id = manager_id;
	}


	
	public NoticeVO(String notice_title, String notice_content, String notice_date, String manager_id) {
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_date = notice_date;
		this.manager_id = manager_id;
	}


	public int getNotice_seq() {
		return notice_seq;
	}


	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}


	public String getNotice_title() {
		return notice_title;
	}


	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}


	public String getNotice_content() {
		return notice_content;
	}


	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}


	public String getNotice_date() {
		return notice_date;
	}


	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}


	public String getManager_id() {
		return manager_id;
	}


	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notice_content == null) ? 0 : notice_content.hashCode());
		result = prime * result + notice_seq;
		result = prime * result + ((notice_title == null) ? 0 : notice_title.hashCode());
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
		NoticeVO other = (NoticeVO) obj;
		if (notice_content == null) {
			if (other.notice_content != null)
				return false;
		} else if (!notice_content.equals(other.notice_content))
			return false;
		if (notice_seq != other.notice_seq)
			return false;
		if (notice_title == null) {
			if (other.notice_title != null)
				return false;
		} else if (!notice_title.equals(other.notice_title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "NoticeVO [notice_seq=" + notice_seq + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_date=" + notice_date + ", manager_id=" + manager_id + "]";
	}
	
	

}
