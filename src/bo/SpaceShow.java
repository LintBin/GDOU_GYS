package bo;

import vo.Space;

public class SpaceShow {
	private int spaceTypeFee;
	private Space space = null;
	

	public Space getSpace() {
		return space;
	}
	public int getSpaceTypeFee() {
		return spaceTypeFee;
	}
	public void setSpaceTypeFee(int spaceTypeFee) {
		this.spaceTypeFee = spaceTypeFee;
	}
	public void setSpace(Space space) {
		this.space = space;
	}
}
