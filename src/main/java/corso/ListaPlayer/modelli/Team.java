package corso.ListaPlayer.modelli;

public class Team extends Entity {
	
	private String nome;

	@Override
	public String toString() {
		return "Team [toString()=" + super.toString() + ", nome=" + nome + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
