package com.gring12.collections;

public class MemberArrayListTest {

	public static void main(String[] args) {
		MemberArrayList memberArrayList = new MemberArrayList();
		
		Member member1 = new Member(1001, "이다인");
		Member member2 = new Member(1002, "홍의");
		Member member3 = new Member(1003, "이태영");
		Member member4 = new Member(1004, "김한샘");
		Member member5 = new Member(1005, "정윤주");
		
		memberArrayList.addMember(member1);
		memberArrayList.addMember(member2);
		memberArrayList.addMember(member3);
		memberArrayList.addMember(member4);
		memberArrayList.addMember(member5);
		
		memberArrayList.showAllMember();
		
		memberArrayList.removeMember(member1.getMemberID());
		memberArrayList.showAllMember();
		
		memberArrayList.removeMember(1007);
	}

}
