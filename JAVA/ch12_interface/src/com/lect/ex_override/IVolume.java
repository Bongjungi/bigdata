package com.lect.ex_override;
//Speaker, TV, Radio
public interface IVolume {
	public void volumeUp(); //�߻�޼ҵ�(�޼ҵ� ���Ǹ� �ϰ� �����δ� ���� �޼ҵ�) //��ü ������ �ȵ�.
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
//	public default void mute() {       //--�Ϲݸ޼ҵ� ��밡��...
//		System.out.println("����ó���մϴ�.");
//	}
}
	
	
