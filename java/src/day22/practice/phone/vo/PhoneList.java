package day22.practice.phone.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneList {
	private String userName;
	private String phoneNum;
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneList other = (PhoneList) obj;
		return Objects.equals(phoneNum, other.phoneNum) && Objects.equals(userName, other.userName);
	}
	@Override
	public int hashCode() {
		return Objects.hash(phoneNum, userName);
	}
	
	public void update(String userName, String phoneNum) {
		this.userName = userName;
		this.phoneNum = phoneNum;
	}
	
	
}
