package mascota;

public class RatoncitoFiuFiu {
    private String nombre;
    private int edad;
    private int peso;
    private byte hambre;
    private byte suciedad;
    private int salud;
    private int energia;
    private int tiempo;

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
        if (tiempo <= 2500) {
            return 0;
        } else if (tiempo <= 8000) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean estasDormido() {

        return false;
    }

    public boolean estasFeliz() {
        return (!tienesHambre() && !estasEnfermo() && !estasSucio());
    }

    public boolean tienesHambre() {
        return this.hambre > 6;
    }

    public boolean estasEnfermo() {
        return (this.salud <= 30 && this.salud != 0);
    }

    public boolean estasSucio() {
        return this.suciedad >= 60;
    }

    public boolean estasMuerto() {
        return this.salud == 0;
    }

    public void envejecer(int segundos) {
        this.edad += segundos;
        tiempo += segundos;
        if (tiempo > 15) {
            if (this.hambre == 10) {
                tienesHambre();
                estasEnfermo();
            } else {
                this.hambre++;
            }
            if (this.suciedad == 100) {
                estasSucio();
            } else {
                this.suciedad += 10;
            }
            if (this.salud == 0) {
                estasMuerto();
            } else if (this.salud <= 30) {
                estasEnfermo();
            } else {
                this.salud -= 10;
            }
            if (this.energia == 0) {
                estasDormido();
            } else {
                this.energia -= 10;
            }
            tiempo = 0;
        }
    }

    public boolean tienesQuejas() {
        return !estasFeliz();
    }

    public void alimentar(float cantidadAlimento) {
        this.hambre -= cantidadAlimento;
        ganarPeso(cantidadAlimento);
    }

    public void curar(float cantidadMedicina) {
        aumentarEnergia(cantidadMedicina);
        aumentarSalud(cantidadMedicina);
    }

    private void ganarPeso(float cantidad) {
        this.peso += cantidad;
    }

    private void aumentarEnergia(float cantidad) {
        this.energia += cantidad;
    }

    private void aumentarSalud(float cantidad) {
        this.salud += cantidad;
    }
}