package reciclabackend.model.bean;

public class Colaborador {
	private int id;
	private int funcional;
	
	public Colaborador(int id) {
		this.id = id;
	}
	
	public Colaborador(int id, int funcional) {
		this.id = id;
		this.funcional = funcional;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setFuncional(int funcional) {
		this.funcional = funcional;
	}

	public int getFuncional() {
		return funcional;
	}
	
	@Override
	public String toString() {
		return "Colaborador{id = " + this.id + ", funcional = " + this.funcional;
	}
	
	
}
