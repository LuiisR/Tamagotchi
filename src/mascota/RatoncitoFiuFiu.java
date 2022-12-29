package mascota;

public class RatoncitoFiuFiu {
    private String nombre;
    private int edad;
    private int peso;
    private byte hambre;
    private byte suciedad;
    private int salud;
    private int energia;

    public RatoncitoFiuFiu(String nombre, int peso, byte hambre, byte suciedad, byte salud, byte energia) {
        // Un objeto mascota.RatoncitoFiuFiu debería informar cuando nace...
        this.edad = 0;
        this.nombre = nombre;
        this.peso = peso;
        this.hambre = hambre;
        this.suciedad = suciedad;
        this.salud = salud;
        this.energia = energia;
    }


    public String estadisticas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Peso: ").append(this.peso).append("\n");
        sb.append("Hambre: ").append(this.hambre).append("\n");
        sb.append("Suciedad: ").append(this.suciedad).append("\n");
        sb.append("Salud: ").append(this.salud).append("\n");
        sb.append("Energia: ").append(this.energia).append("\n");
        return sb.toString();
    }

    public void limpiar(float esfuerzoHigienico) {
        this.suciedad -= esfuerzoHigienico;
    }

    public int queTramoEdad() {
        return 0;
    }

    public boolean estasDormido() {
        return false;
    }

    public boolean estasEnfermo() {
        return false;
    }

    public boolean estasSucio() {
        return false;
    }

    public boolean estasMuerto() {
        return false;
    }

    public void envejecer(int segundos) {

    }

    public boolean tienesQuejas() {
        return false;
    }

    public void alimentar(float cantidadAlimento) {
        this.hambre -= cantidadAlimento;
        ganarPeso(cantidadAlimento);
    }

    public void curar(float cantidadMedicina) {
        this.salud += cantidadMedicina;
    }
    private void ganarPeso(float cantidad){
        this.peso += cantidad;
    }
    private void aumentarEnergia(float cantidad){
        this.energia += cantidad;
    }
    private void aumentarSalud(float cantidad){
        this.salud += cantidad;
    }
}