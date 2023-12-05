package corso.ListaPlayer.modelli;

public abstract class Entity {
	
	private int id;

	@Override
	public String toString() {
		return "Entity [id=" + id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
