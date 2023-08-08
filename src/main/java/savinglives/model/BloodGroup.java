package savinglives.model;

public class BloodGroup {
	private int id;
	 private String name;
	 private int active;
	 
	 public BloodGroup (int id, String name, int active) {
		 this.id = id;
		 this.name =name;
		 this.active = active;
	 }
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	// toString method
		@Override
		public String toString() {
			return "BloodGroup [id=" + id + ", name=" + name + ", active=" + active
					+ ",]";
		}
}
