package com.yedam.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter, toString, @RequiredArgsConstructor@EqualsAndHashCode 모두 합친거
@Builder
@NoArgsConstructor //
@AllArgsConstructor //모든 필드 초기화 생성자
public class Member {
	public String id;
	public String pw;
	public String name;

}
